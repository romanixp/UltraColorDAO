/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.ICompraDAO;
import dao.design.IComprobanteDAO;
import dao.design.IContadorDAO;
import dao.design.IFormaPagoDAO;
import dao.design.IPedidoCompraDAO;
import dao.design.IProductoDAO;
import dao.ds.AccesoDB;

import dao.to.CompraTO;
import dao.to.ComprobanteTO;

import dao.to.PedidoCompraTO;
import dao.to.ProductoTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class CompraDAO implements ICompraDAO {

    @Override
    public float pedido(ArrayList<PedidoCompraTO> listaPedido, String provCodigo, String usuaCodigo) throws Exception {

        Connection cn = null;

        PreparedStatement ps = null;
        String sql = null;

        try {
            // Obtenemos la conexión con la base de datos
            cn = AccesoDB.getConnection();
            // Deshabilitamos el auto-commit //para iniciar la transaccion
            cn.setAutoCommit(false);
            
            CompraTO compraTO = new CompraTO();
            //llenar campos para la compra
            compraTO.setProvCodigo(provCodigo);
            compraTO.setUsuaCodigo(usuaCodigo);
            compraTO.setTotal((float) 0);

            //para conseguir la fecha y hora actual
            java.util.Date dt = new java.util.Date();
            java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String fechaHora = sdf.format(dt);

            compraTO.setFechaPedido(fechaHora);
            compraTO.setEstado("NOCANCELADO");

            this.insertar(compraTO);


            float total = 0;

            //insertamos en la bd la lista de pedidos
//            try{
            for (PedidoCompraTO pedido : listaPedido) {
                //Llenamos la lista con el codigo de la compra actual
                pedido.setCompCodigo(compraTO.getCodigo());

                //calcular el total del pedido (por cada item del pedido)
                String codProducto = pedido.getProdCodigo();
                IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
                ArrayList<ProductoTO> productoTO = productoDAO.consultarProducto("CHR_PRODCODIGO", codProducto);
                //Devuelve 1 solo elemento
                total += (float) productoTO.get(0).getPrecioCompra() * pedido.getCantidad();

                //Insertamos en la bd toda la lista
                IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();
                pedidoCompraDAO.insertar(pedido);
            }
//            }catch(Exception e){
//                throw new Exception("error en el for");
//            }

            // Preparamos la sentencia para grabar
            sql = "update compra "
                    + "set DEC_COMPTOTAL = ?"
                    + "where CHR_COMPCODIGO = ?";
            // Creamos el objeto PrepareStatement
            
            ps = cn.prepareStatement(sql);
            // Asignamos valores a los parámetros
            ps.setFloat(1, total);
            ps.setString(2, compraTO.getCodigo());
            ps.executeUpdate();

            // Confirmamos la transacción
            try{
                cn.commit();
            }
             catch(Exception e){ 
                 throw new Exception("error commit " + cn.getAutoCommit()); 
             }
            ps.close();
            
            return total;
        } catch (Exception e) {            
            try {
                // Cancelamos la transacción
                cn.rollback();
            } catch (SQLException ex) {
                //ex.getMessage();
            }
            throw e;
        }
    }

    @Override
    public void comprar(ArrayList<PedidoCompraTO> listaPedido,String formaPago, String comprobante, String numComprobante ) throws Exception{
        
        
        //Variables     
        Connection cn = AccesoDB.getConnection();
        
        IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();        
        IComprobanteDAO comprobanteDAO = DAOFactory.getInstance().getComprobanteDAO();
        ComprobanteTO comprobanteTO = new ComprobanteTO();
        
        ArrayList<CompraTO> compraTO = null;
        
        String codigoCompra = listaPedido.get(0).getCompCodigo();
        
        //Iniciamos la transaccion
        cn.setAutoCommit(false);
        //Proceso
        try{
            //Actualizar pedido
            float total = 0;
            String codProducto;
            for(int i=0; i<listaPedido.size();i++ ){
                pedidoCompraDAO.actualizar(listaPedido.get(i));  
                //calcular el total del pedido (por cada item del pedido)
                codProducto = listaPedido.get(i).getProdCodigo();
                IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
                ArrayList<ProductoTO> productoTO = productoDAO.consultarProducto("CHR_PRODCODIGO", codProducto);
                //Devuelve 1 solo elemento
                total += (float) productoTO.get(0).getPrecioCompra() * listaPedido.get(i).getCantidad();
            }
            //llenar-actualizar datos de compra
            compraTO = this.consultarCompra("CHR_COMPCODIGO", codigoCompra);
            compraTO.get(0).setFormCodigo(formaPago);
            compraTO.get(0).setEstado("CANCELADO");  
            compraTO.get(0).setTotal(total);
                //para conseguir la fecha y hora actual
                java.util.Date dt = new java.util.Date();
                java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String fechaHora = sdf.format(dt);
                compraTO.get(0).setFechaCompra(fechaHora);            
            this.actualizar(compraTO.get(0));
            //crear Comprobante            
            comprobanteTO.setVentCodigo(null);
            comprobanteTO.setCompCodigo(codigoCompra);            
            comprobanteTO.setNombre(comprobante);
            comprobanteTO.setNumero(numComprobante);
            comprobanteTO.setNoSerie("01");
            //Insertar comprobante
            comprobanteDAO.insertar(comprobanteTO);

            //confirmamos la transaccion
            cn.commit();
        } catch(Exception e){
            cn.rollback();
            throw  e;
        }
        
    }

    @Override
    public void insertar(CompraTO compraTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
       // cn.setAutoCommit(false);
        String sql = "call usp_inserta_datos_compra(?,?,?,?,?,?,?,?,?,?)";
        try {            
            IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
            String codigo = contadorDAO.generaCodigo("COMPRA");            
            CallableStatement cs = cn.prepareCall(sql);
            
            cs.registerOutParameter(1, java.sql.Types.VARCHAR);
            cs.setString(2, codigo);

            cs.setString(3, compraTO.getFormCodigo());
            cs.setString(4, compraTO.getCajacodigo());
            cs.setString(5, compraTO.getProvCodigo());
            cs.setString(6, compraTO.getUsuaCodigo());
            cs.setFloat(7, compraTO.getTotal());
            cs.setString(8, compraTO.getFechaPedido());
            cs.setString(9, compraTO.getFechaCompra());
            cs.setString(10, compraTO.getEstado());

            cs.executeUpdate();

            compraTO.setCodigo(codigo);

            String estado = cs.getString(1);
            cs.close();
            
            if (!estado.equals("OK")) {
                throw new Exception(estado);
            }
        } catch (Exception e) {
            throw e;
        }

    } // insertar

    @Override
    public ArrayList<CompraTO> consultarCompra(String campo,String valor) throws Exception {

                       
        String query = "select * from compra where "+ campo + " like '" + valor + "%'";
        
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<CompraTO> lista = new ArrayList<CompraTO>(); //se maneja con una lista de personal

        CompraTO compra = null;

        while (rs.next()) {
            compra = new CompraTO();

            compra.setCodigo(rs.getString("CHR_COMPCODIGO"));
            compra.setFormCodigo(rs.getString("CHR_FORMCODIGO"));
            compra.setCajacodigo(rs.getString("CHR_CAJACODIGO"));
            compra.setProvCodigo(rs.getString("CHR_PROVCODIGO"));            
            compra.setUsuaCodigo(rs.getString("CHR_USUACODIGO"));
            compra.setTotal(rs.getFloat("DEC_COMPTOTAL"));
            compra.setFechaCompra(rs.getString("DTT_COMPFECHACOMPRA"));
            compra.setFechaPedido(rs.getString("DTT_COMPFECHAPEDIDO"));
            compra.setEstado(rs.getString("VCH_COMPESTADO"));
            
            lista.add(compra);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal
    @Override
    public void actualizar(CompraTO compraTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_compra(?,?,?,?,?,?,?,?,?,?)";

        
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, compraTO.getCodigo());
        cs.setString(3, compraTO.getFormCodigo());
        cs.setString(4, compraTO.getCajacodigo());
        cs.setString(5, compraTO.getProvCodigo());
        cs.setString(6, compraTO.getUsuaCodigo());
        cs.setFloat(7, compraTO.getTotal());
        cs.setString(8, compraTO.getFechaPedido());
        cs.setString(9, compraTO.getFechaCompra());
        cs.setString(10, compraTO.getEstado());

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
        String sql = "call usp_elimina_datos_compra(?,?)";

        
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
