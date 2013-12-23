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
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        FormaPagoTO formaPagoTO = new FormaPagoTO();
        
        formaPagoTO.setCodigo("05");
        formaPagoTO.setNombre("AAA");
        
        
        try {
            IFormaPagoDAO formaPagoDAO = DAOFactory.getInstance().getFormaPagoDAO();
            formaPagoDAO.actualizar(formaPagoTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
