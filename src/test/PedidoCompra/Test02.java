/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.PedidoCompra;



import dao.DAOFactory;
import dao.design.IPedidoCompraDAO;
import dao.to.PedidoCompraTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        PedidoCompraTO pedidoCompraTO = new PedidoCompraTO();
        pedidoCompraTO.setCodigo("0000001");        
        pedidoCompraTO.setCompCodigo(null);        
        pedidoCompraTO.setProdCodigo(null);
        pedidoCompraTO.setCantidad(0);
        
        try {
            IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();
            pedidoCompraDAO.actualizar(pedidoCompraTO);
            //System.out.println("Código generado: " + pedidoCompraTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
