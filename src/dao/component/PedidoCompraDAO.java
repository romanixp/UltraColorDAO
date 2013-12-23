/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IContadorDAO;
import dao.design.IPedidoCompraDAO;
import dao.ds.AccesoDB;
import dao.to.PedidoCompraTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;


/**
 *
 * @author Sistemas
 */
public class PedidoCompraDAO implements IPedidoCompraDAO {
    
    @Override
    public ArrayList<PedidoCompraTO> consultarPedidoCompra(String campo,String valor) throws Exception {
        
        String query = "select * from PEDIDOCOMPRA where "+ campo + " like '" + valor + "%'";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<PedidoCompraTO> lista = new ArrayList<PedidoCompraTO>(); //se maneja con una lista de personal

        PedidoCompraTO pedidoCompra = null;

        while (rs.next()) {
            pedidoCompra = new PedidoCompraTO();
   
            pedidoCompra.setCodigo(rs.getString("CHR_PEDICODIGO"));            
            pedidoCompra.setCompCodigo(rs.getString("CHR_COMPCODIGO"));            
            pedidoCompra.setProdCodigo(rs.getString("CHR_PRODCODIGO"));        
            pedidoCompra.setCantidad(rs.getInt("INT_PEDICANTIDAD"));
            

            lista.add(pedidoCompra);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal

    @Override
    public void insertar(PedidoCompraTO pedidoCompraTO) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_pedidoCompra(?,?,?,?,?)";

        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("PEDIDOCOMPRA");

       // cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);        
        cs.setString(3, pedidoCompraTO.getCompCodigo());        
        cs.setString(4, pedidoCompraTO.getProdCodigo());
        cs.setInt(5, pedidoCompraTO.getCantidad());        

        cs.executeUpdate();

        pedidoCompraTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(PedidoCompraTO pedidoCompraTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_pedidoCompra(?,?,?,?,?)";

        
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, pedidoCompraTO.getCodigo());        
        cs.setString(3, pedidoCompraTO.getCompCodigo());        
        cs.setString(4, pedidoCompraTO.getProdCodigo());
        cs.setInt(5, pedidoCompraTO.getCantidad());        


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
        String sql = "call usp_elimina_datos_pedidoCompra(?,?)";

        
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
