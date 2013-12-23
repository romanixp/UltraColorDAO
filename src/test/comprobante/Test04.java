/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.comprobante;

import dao.DAOFactory;
import dao.design.IComprobanteDAO;

import dao.to.ComprobanteTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<ComprobanteTO> lista = null;

        try {
            IComprobanteDAO ComprobanteDAO = DAOFactory.getInstance().getComprobanteDAO();
            lista = ComprobanteDAO.consultarComprobante("CHR_COMBCODIGO","");

            for (ComprobanteTO ComprobanteTO : lista) {
                System.out.println(ComprobanteTO.getCodigo());
                System.out.println(ComprobanteTO.getVentCodigo());
                System.out.println(ComprobanteTO.getCompCodigo());
                System.out.println(ComprobanteTO.getNombre());
                System.out.println(ComprobanteTO.getNumero());
                System.out.println(ComprobanteTO.getNoSerie());
                System.out.println("");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
