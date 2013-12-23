/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comprobante;


import dao.DAOFactory;
import dao.design.IComprobanteDAO;
import dao.to.ComprobanteTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        ComprobanteTO comprobanteTO = new ComprobanteTO();
        comprobanteTO.setCodigo("00000000");

        //ComprobanteTO.setObservaciones(null);
        try {
            IComprobanteDAO ComprobanteDAO = DAOFactory.getInstance().getComprobanteDAO();
            ComprobanteDAO.eliminar(comprobanteTO.getCodigo());
            System.out.println("Se ha eliminado: " + comprobanteTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
