/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.PedidoCompra;


import dao.DAOFactory;
import dao.design.IPedidoCompraDAO;
import dao.to.PedidoCompraTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        PedidoCompraTO pedidoCompraTO = new PedidoCompraTO();
        pedidoCompraTO.setCodigo("0000002");
        
        try {
            IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();
            pedidoCompraDAO.eliminar(pedidoCompraTO.getCodigo());
            //System.out.println("Código generado: " + pedidoCompraTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
