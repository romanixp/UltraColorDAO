/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.servicio;


import dao.DAOFactory;
import dao.design.IServicioDAO;
import dao.to.ServicioTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<ServicioTO> lista = null;

        try {
            IServicioDAO servicioDAO = DAOFactory.getInstance().getServicioDAO();
            lista = servicioDAO.consultarServicio("VCH_SERVNOMBRE","");



            for (ServicioTO servicioTO : lista) {
                System.out.println(servicioTO.getCodigo());
                System.out.println(servicioTO.getNombre());
                System.out.println(servicioTO.getPrecio());
                System.out.println(servicioTO.getDescripcion());

                System.out.println("------------------------------------");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
