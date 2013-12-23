/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.servicio;

import test.servicio.*;
import test.servicio.*;
import dao.DAOFactory;
import dao.design.IServicioDAO;
import dao.to.ServicioTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        ServicioTO servicioTO = new ServicioTO();
        servicioTO.setCodigo("02");
        
        try {
            IServicioDAO servicioDAO = DAOFactory.getInstance().getServicioDAO();
            servicioDAO.eliminar(servicioTO.getCodigo());
            //System.out.println("Código generado: " + servicioTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
