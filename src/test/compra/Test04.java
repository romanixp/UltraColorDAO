/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.compra;

import test.compra.*;
import dao.DAOFactory;
import dao.design.ICompraDAO;

import dao.to.CompraTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<CompraTO> lista = null;

        try {
            ICompraDAO compraDAO = DAOFactory.getInstance().getCompraDAO();
            lista = compraDAO.consultarCompra("CHR_COMPCODIGO","");

            for (CompraTO compraTO : lista) {
                System.out.println(compraTO.getCodigo());
                System.out.println(compraTO.getFormCodigo());
                System.out.println(compraTO.getCajacodigo());
                System.out.println(compraTO.getProvCodigo());

                System.out.println(compraTO.getUsuaCodigo());
                System.out.println(compraTO.getTotal());
                System.out.println(compraTO.getFechaPedido());
                System.out.println(compraTO.getFechaCompra());
                System.out.println(compraTO.getEstado());
                
                System.out.println("");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
