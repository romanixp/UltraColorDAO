/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IContadorDAO;
import dao.design.IFormaPagoDAO;
import dao.ds.AccesoDB;
import dao.to.FormaPagoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class FormaPagoDAO implements IFormaPagoDAO{
    
    
    
        @Override
    public ArrayList<FormaPagoTO> consultarFormaPago(String campo,String valor) throws Exception {

                       
        String query = "select * from formaPago where "+ campo + " like '" + valor + "%'";
        
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<FormaPagoTO> lista = new ArrayList<FormaPagoTO>(); //se maneja con una lista de personal

        FormaPagoTO formaPago = null;

        while (rs.next()) {
            formaPago = new FormaPagoTO();

            formaPago.setCodigo(rs.getString("CHR_FORMCODIGO"));
            formaPago.setNombre(rs.getString("VCH_FORMNOMBRE"));

            lista.add(formaPago);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal
    {

}
        @Override
    public void insertar(FormaPagoTO formaPagoTO) throws Exception {
            
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_formaPago(?,?)";
        
        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("FORMAPAGO");        
        
        CallableStatement cs = cn.prepareCall(sql);        
        
        cs.setString(1, codigo);       
        cs.setString(2, formaPagoTO.getNombre());       
        cs.executeUpdate();        
        formaPagoTO.setCodigo(codigo);

        
        cs.close();
        cs = null;
        

    } // insertar

    @Override
    public void actualizar(FormaPagoTO formaPagoTO) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_formaPago(?,?)";

        CallableStatement cs = cn.prepareCall(sql);        
        cs.setString(1, formaPagoTO.getCodigo());
        cs.setString(2, formaPagoTO.getNombre());
        cs.execute();
        
        cs.close();
        cs = null;
        
    }
    
    @Override
    public void eliminar(String codigo) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_elimina_datos_formaPago(?)";
        
        CallableStatement cs = cn.prepareCall(sql);        
        cs.setString(1, codigo);
        cs.execute();
        
        cs.close();
        cs = null;
        
    }
    
}
