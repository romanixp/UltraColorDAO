/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.servicio;



import dao.DAOFactory;
import dao.design.IServicioDAO;
import dao.to.ServicioTO;


/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        ServicioTO servicioTO = new ServicioTO();
        servicioTO.setCodigo("01");
        servicioTO.setNombre("Sello");
        servicioTO.setPrecio(Float.valueOf("13.00"));        
        servicioTO.setDescripcion("Con madera");
        try {
            IServicioDAO servicioDAO = DAOFactory.getInstance().getServicioDAO();
            servicioDAO.actualizar(servicioTO);
            //System.out.println("Código generado: " + servicioTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
