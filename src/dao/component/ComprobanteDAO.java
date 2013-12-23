/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IComprobanteDAO;
import dao.design.IContadorDAO;
import dao.ds.AccesoDB;
import dao.to.ComprobanteTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class ComprobanteDAO implements IComprobanteDAO{
 
    
        @Override
    public ArrayList<ComprobanteTO> consultarComprobante(String campo,String valor) throws Exception {

                       
        String query = "select * from comprobante where "+ campo + " like '" + valor + "%'";
        
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<ComprobanteTO> lista = new ArrayList<ComprobanteTO>(); //se maneja con una lista de personal

        ComprobanteTO comprobante = null;

        while (rs.next()) {
            comprobante = new ComprobanteTO();             
            comprobante.setCodigo(rs.getString("CHR_COMBCODIGO"));
            comprobante.setVentCodigo(rs.getString("CHR_VENTCODIGO"));
            comprobante.setCompCodigo(rs.getString("CHR_COMPCODIGO"));
            comprobante.setNombre(rs.getString("VCH_COMBNOMBRE"));
            comprobante.setNumero(rs.getString("CHR_COMBNUMERO"));
            comprobante.setNoSerie(rs.getString("CHR_COMBNOSERIE"));

            lista.add(comprobante);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal
    {

}
        @Override
    public void insertar(ComprobanteTO comprobanteTO) throws Exception {
            
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_comprobante(?,?,?,?,?,?,?)";
        
        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("comprobante");
        
        
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);               
        cs.setString(3, comprobanteTO.getVentCodigo());
        cs.setString(4, comprobanteTO.getCompCodigo());
        cs.setString(5, comprobanteTO.getNombre());
        cs.setString(6, comprobanteTO.getNumero());
        cs.setString(7, comprobanteTO.getNoSerie());

        cs.executeUpdate();
        
        comprobanteTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(ComprobanteTO comprobanteTO) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_comprobante(?,?,?,?,?,?,?)";

        
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, comprobanteTO.getCodigo());
        cs.setString(3, comprobanteTO.getVentCodigo());
        cs.setString(4, comprobanteTO.getCompCodigo());
        cs.setString(5, comprobanteTO.getNombre());
        cs.setString(6, comprobanteTO.getNumero());
        cs.setString(7, comprobanteTO.getNoSerie());

        cs.execute();

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }
    }
    
    @Override
    public void eliminar(String codigo) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_elimina_datos_comprobante(?,?)";

        
        CallableStatement cs = cn.prepareCall(sql);        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
        cs.execute();
        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }
    }
}
