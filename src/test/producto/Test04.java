/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.producto;

import dao.DAOFactory;
import dao.design.IProductoDAO;
import dao.to.ProductoTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<ProductoTO> lista = null;

        try {
            IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
            lista = productoDAO.consultarProducto("VCH_PRODNOMBRE","");



            for (ProductoTO productoTO : lista) {
                System.out.println(productoTO.getCodigo());
                System.out.println(productoTO.getStock());
                productoTO.setUnidadCompra("unidad");
                productoTO.setUnidadVenta("unidad");
                System.out.println(productoTO.getPrecioCompra());
                System.out.println(productoTO.getPrecioVenta());
                System.out.println(productoTO.getMarca());
                System.out.println(productoTO.getFechaVencimiento());
                System.out.println(productoTO.getDescripcion());

                System.out.println("------------------------------------");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
