/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.producto;

import test.producto.*;
import dao.DAOFactory;
import dao.design.IProductoDAO;
import dao.to.ProductoTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        ProductoTO productoTO = new ProductoTO();
        productoTO.setCodigo("00003");
        
        try {
            IProductoDAO productoDAO = DAOFactory.getInstance().getProductoDAO();
            productoDAO.eliminar(productoTO.getCodigo());
            //System.out.println("Código generado: " + productoTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
