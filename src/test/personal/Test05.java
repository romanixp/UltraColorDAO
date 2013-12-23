/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.personal;

import dao.DAOFactory;
import dao.design.IPersonalDAO;
import dao.to.PersonalTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test05 { // consultaPorUsuario
        public static void main(String[] args) {
                   
        PersonalTO personalTO = null;
        
        try {
            IPersonalDAO personalDAO = DAOFactory.getInstance().getPersonalDAO();
            personalTO = personalDAO.consultaPorUsuario("0000004");
            
            
            System.out.println(personalTO.getCodigo());
            System.out.println(personalTO.getNombre());
            System.out.println(personalTO.getApellidos());
            System.out.println(personalTO.getFechaNacimiento());
            System.out.println(personalTO.getDireccion());
            System.out.println(personalTO.getCelular());
            System.out.println(personalTO.getRp());
            System.out.println(personalTO.getCorreo());
            System.out.println(personalTO.getObservaciones());
                System.out.println("");
                System.out.println("");
        
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
} // fin consultaPorUsuario
