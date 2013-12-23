/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.formaPago;



import dao.DAOFactory;
import dao.design.IFormaPagoDAO;

import dao.to.FormaPagoTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<FormaPagoTO> lista = null;

        try {
            IFormaPagoDAO formaPagoDAO = DAOFactory.getInstance().getFormaPagoDAO();
            lista = formaPagoDAO.consultarFormaPago("CHR_FORMCODIGO","");

            for (FormaPagoTO formaPagoTO : lista) {
                System.out.println(formaPagoTO.getCodigo());
                System.out.println(formaPagoTO.getNombre());
               
                System.out.println("");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
