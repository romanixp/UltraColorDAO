/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.proveedor;


import dao.DAOFactory;
import dao.design.IProveedorDAO;
import dao.to.ProveedorTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 { //Consultar

    public static void main(String[] args) {
                   
        ArrayList<ProveedorTO> lista = null;
        
        try {
            IProveedorDAO proveedorDAO = DAOFactory.getInstance().getProveedorDAO();
            lista = proveedorDAO.consultarProveedor("CHR_PROVCODIGO","");

            
            for (ProveedorTO proveedorTO : lista) {
            System.out.println(proveedorTO.getCodigo());
            System.out.println(proveedorTO.getNombre());
            System.out.println(proveedorTO.getRuc());
            System.out.println(proveedorTO.getDireccion());
            System.out.println(proveedorTO.getTelefono());
            System.out.println(proveedorTO.getRp());
            System.out.println(proveedorTO.getCorreo());
            System.out.println(proveedorTO.getPaginaweb());
            System.out.println(proveedorTO.getObservacion());
                System.out.println("");
                System.out.println("");
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
