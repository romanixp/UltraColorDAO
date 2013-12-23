/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.producto;

import dao.DAOFactory;
import dao.design.IProductoDAO;
import dao.to.ProductoTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            
        
        ProductoTO productoTO = new ProductoTO();
        //    productoTO.setCodigo("02");
        productoTO.setCateCodigo(null);
        productoTO.setNombre("Laptop");
        productoTO.setStock(5);
        productoTO.setUnidadCompra("unidad");
        productoTO.setUnidadVenta("unidad");
        productoTO.setPrecioCompra(Float.valueOf("1000.00"));
        productoTO.setPrecioVenta(Float.valueOf("1500.00"));
        productoTO.setMarca("Toshiba Satellite");
        productoTO.setFechaVencimiento(null);
        productoTO.setDescripcion(null);
        


        try {
            IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
            productoDAO.insertar(productoTO);
            System.out.println("Código generado: " + productoTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
