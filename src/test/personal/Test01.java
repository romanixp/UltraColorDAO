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
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            


        PersonalTO personalTO = new PersonalTO();
        //    personalTO.setCodigo("02");
        personalTO.setNombre("Raul");
        personalTO.setApellidos("Romani Flores");
        personalTO.setDni("47830494");
        personalTO.setFechaNacimiento("1990-03-10");
        personalTO.setDireccion("Av. 2 de Mayo 4576");
        personalTO.setCelular("");
        personalTO.setRp("");
        personalTO.setCorreo("romani@gmail.com");
        personalTO.setObservaciones(null);


        try {
            IPersonalDAO personalDAO = DAOFactory.getInstance().getPersonalDAO();
            personalDAO.insertar(personalTO);
            System.out.println("Código generado: " + personalTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
