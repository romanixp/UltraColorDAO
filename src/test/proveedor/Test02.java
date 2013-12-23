/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.proveedor;


import dao.DAOFactory;
import dao.design.IProveedorDAO;
import dao.to.ProveedorTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        ProveedorTO proveedorTO = new ProveedorTO();
        proveedorTO.setCodigo("02");
        proveedorTO.setNombre("PrintTec SAC");
        proveedorTO.setRuc("10403945425");
        proveedorTO.setDireccion("Jr. Sucre 705");
        proveedorTO.setTelefono("935495358");
        proveedorTO.setRp("#935495358");
        proveedorTO.setCorreo("PrintTec@gmail.com");
        proveedorTO.setPaginaweb(null);
        proveedorTO.setObservacion(null);
        try {
            IProveedorDAO proveedorDAO = DAOFactory.getInstance().getProveedorDAO();
            proveedorDAO.actualizar(proveedorTO);
            //System.out.println("Código generado: " + proveedorTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
