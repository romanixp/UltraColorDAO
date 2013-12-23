/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comprobante;


import dao.DAOFactory;
import dao.design.IComprobanteDAO;
import dao.to.ComprobanteTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        ComprobanteTO comprobanteTO = new ComprobanteTO();
        
        comprobanteTO.setCodigo("00000001");
        comprobanteTO.setVentCodigo(null);
        comprobanteTO.setCompCodigo(null);
        comprobanteTO.setNombre("FACTURA");
        
        comprobanteTO.setNumero("0312412");
        comprobanteTO.setNoSerie("01");
        
        try {
            IComprobanteDAO ComprobanteDAO = DAOFactory.getInstance().getComprobanteDAO();
            ComprobanteDAO.actualizar(comprobanteTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
