/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.PedidoCompra;


import dao.DAOFactory;
import dao.design.IPedidoCompraDAO;
import dao.to.PedidoCompraTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<PedidoCompraTO> lista = null;

        try {
            IPedidoCompraDAO pedidoCompraDAO = DAOFactory.getInstance().getPedidoCompraDAO();
            lista = pedidoCompraDAO.consultarPedidoCompra("CHR_PEDICODIGO","");

            for (PedidoCompraTO pedidoCompraTO : lista) {
                System.out.println(pedidoCompraTO.getCodigo());                
                System.out.println(pedidoCompraTO.getCompCodigo());                
                System.out.println(pedidoCompraTO.getProdCodigo());
                System.out.println(pedidoCompraTO.getCantidad());
                
                System.out.println("------------------------------------");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
