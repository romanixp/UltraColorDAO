/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IContadorDAO;
import dao.design.IProductoDAO;
import dao.ds.AccesoDB;
import dao.to.ProductoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class ProductoDAO implements IProductoDAO{

        @Override
    public ArrayList<ProductoTO> consultarProducto(String campo,String valor) throws Exception {

                       
        String query = "select * from producto where "+ campo + " like '" + valor + "%'";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<ProductoTO> lista = new ArrayList<ProductoTO>(); //se maneja con una lista de producto

        ProductoTO producto = null;

        while (rs.next()) {
            producto = new ProductoTO();

            producto.setCodigo(rs.getString("CHR_PRODCODIGO"));
            producto.setNombre(rs.getString("VCH_PRODNOMBRE"));
            producto.setStock(rs.getInt("INT_PRODSTOCK"));
            producto.setUnidadCompra(rs.getString("VCH_PRODUNIDADCOMPRA"));
            producto.setUnidadVenta(rs.getString("VCH_PRODUNIDADVENTA"));
            producto.setPrecioCompra(rs.getFloat("DEC_PRODPRECIOCOMPRA"));
            producto.setPrecioVenta(rs.getFloat("DEC_PRODPRECIOVENTA"));
            producto.setMarca(rs.getString("VCH_PRODMARCA"));
            producto.setFechaVencimiento(rs.getString("DTT_PRODFECHAVENCIMIENTO"));
            producto.setDescripcion(rs.getString("VCH_PRODDESCRIPCION"));
            
            lista.add(producto);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarProducto
    
            @Override
    public void insertar(ProductoTO productoTO) throws Exception {
            
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_producto(?,?,?,?,?,?,?,?,?,?,?,?)";
        
        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("producto");
        
        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);

        cs.setString(2, codigo);
        cs.setString(3, productoTO.getCateCodigo());
        cs.setString(4, productoTO.getNombre());
        cs.setInt(5, productoTO.getStock());
        cs.setString(6, productoTO.getUnidadCompra());
        cs.setString(7, productoTO.getUnidadVenta());
        cs.setFloat(8, productoTO.getPrecioCompra());
        cs.setFloat(9, productoTO.getPrecioVenta());
        cs.setString(10, productoTO.getMarca());
        cs.setString(11, productoTO.getFechaVencimiento());
        cs.setString(12, productoTO.getDescripcion());
        

        cs.executeUpdate();
        
        productoTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(ProductoTO productoTO) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_producto(?,?,?,?,?,?,?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, productoTO.getCodigo());
        cs.setString(3, productoTO.getCateCodigo());
        cs.setString(4, productoTO.getNombre());
        cs.setInt(5, productoTO.getStock());
        cs.setString(6, productoTO.getUnidadCompra());
        cs.setString(7, productoTO.getUnidadVenta());
        cs.setFloat(8, productoTO.getPrecioCompra());
        cs.setFloat(9, productoTO.getPrecioVenta());
        cs.setString(10, productoTO.getMarca());
        cs.setString(11, productoTO.getFechaVencimiento());
        cs.setString(12, productoTO.getDescripcion());

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
        String sql = "call usp_elimina_datos_producto(?,?)";

        cn.setAutoCommit(true);
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
