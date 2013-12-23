/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.personal;

import dao.DAOFactory;
import dao.design.IPersonalDAO;
import dao.to.PersonalTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        PersonalTO personalTO = new PersonalTO();
        personalTO.setCodigo("18");

        personalTO.setObservaciones(null);
        try {
            IPersonalDAO personalDAO = DAOFactory.getInstance().getPersonalDAO();
            personalDAO.eliminar(personalTO.getCodigo());
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
