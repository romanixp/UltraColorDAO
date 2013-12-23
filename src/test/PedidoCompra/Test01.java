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
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            
        
        PedidoCompraTO pedidoCompraTO = new PedidoCompraTO();
        //    pedidoCompraTO.setCodigo("02");
        
        pedidoCompraTO.setCompCodigo(null);
        
        pedidoCompraTO.setProdCodigo(null);
        pedidoCompraTO.setCantidad(0);
        
        

        try {
            IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();
            pedidoCompraDAO.insertar(pedidoCompraTO);
            System.out.println("Código generado: " + pedidoCompraTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
