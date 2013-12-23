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
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            

        ComprobanteTO comprobanteTO = new ComprobanteTO();
        //    personalTO.setCodigo("02");
        comprobanteTO.setVentCodigo(null);
        comprobanteTO.setCompCodigo(null);
        comprobanteTO.setNombre("BOLETA");
        
        comprobanteTO.setNumero("0312412");
        comprobanteTO.setNoSerie("01");



        try {
            IComprobanteDAO comprobanteDAO = DAOFactory.getInstance().getComprobanteDAO();
            comprobanteDAO.insertar(comprobanteTO);
            System.out.println("Código generado: " + comprobanteTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
