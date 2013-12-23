/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.personal;

import dao.DAOFactory;
import dao.design.IPersonalDAO;
import dao.to.PersonalTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        PersonalTO personalTO = new PersonalTO();
        personalTO.setCodigo("01");
        personalTO.setNombre("David");
        personalTO.setApellidos("Romani Flores");
        personalTO.setDni("38394542");
        personalTO.setFechaNacimiento("1990-03-10");
        personalTO.setDireccion("Av. 2 de Mayo 4576");
        personalTO.setCelular("979495358");
        personalTO.setRp("#979495358");
        personalTO.setCorreo("Ramos@gmail.com");
        personalTO.setObservaciones(null);
        try {
            IPersonalDAO personalDAO = DAOFactory.getInstance().getPersonalDAO();
            personalDAO.actualizar(personalTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
