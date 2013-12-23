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
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        ProductoTO productoTO = new ProductoTO();
        productoTO.setCodigo("00001");
        productoTO.setNombre("Camara");
        productoTO.setStock(5);
        productoTO.setUnidadCompra("unidad");
        productoTO.setUnidadVenta("unidad");
        productoTO.setPrecioCompra(Float.valueOf("1000.00"));
        productoTO.setPrecioVenta(Float.valueOf("1700.00"));
        productoTO.setMarca("Sony");
        productoTO.setFechaVencimiento("2017-03-10");
        productoTO.setDescripcion("Camara de 17 Mega pixeles");
        try {
            IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
            productoDAO.actualizar(productoTO);
            //System.out.println("Código generado: " + productoTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}

