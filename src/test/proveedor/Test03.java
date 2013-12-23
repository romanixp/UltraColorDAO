/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.proveedor;

import dao.DAOFactory;
import dao.design.IProveedorDAO;
import dao.to.ProveedorTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        ProveedorTO proveedorTO = new ProveedorTO();
        proveedorTO.setCodigo("03");
        
        try {
            IProveedorDAO proveedorDAO = DAOFactory.getInstance().getProveedorDAO();
            proveedorDAO.eliminar(proveedorTO.getCodigo());
            System.out.println("Código eliminado: " + proveedorTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
