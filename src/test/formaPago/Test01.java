/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.formaPago;




import dao.DAOFactory;
import dao.design.IFormaPagoDAO;



import dao.to.FormaPagoTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            

//CHECK (VCH_FORMNOMBRE IN ('EFECTIVO', 'TARJETA','DEPOSITO','CREDITO'))
        FormaPagoTO formaPagoTO = new FormaPagoTO();
        //    personalTO.setCodigo("02");
        formaPagoTO.setNombre("XX");
        


        try {
            IFormaPagoDAO formaPagoDAO = DAOFactory.getInstance().getFormaPagoDAO();
            formaPagoDAO.insertar(formaPagoTO);
            System.out.println("Código generado: " + formaPagoTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
