/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.servicio;

import dao.DAOFactory;
import dao.design.IServicioDAO;
import dao.to.ServicioTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");
        
        ServicioTO servicioTO = new ServicioTO();
        //    servicioTO.setCodigo("02");
        servicioTO.setNombre("Sello");
        servicioTO.setPrecio(Float.valueOf("15.00"));        
        servicioTO.setDescripcion("Con madera");
        
        try {
            IServicioDAO servicioDAO = DAOFactory.getInstance().getServicioDAO();
            servicioDAO.insertar(servicioTO);
            System.out.println("Código generado: " + servicioTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
