/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.compra;

import dao.DAOFactory;
import dao.design.ICompraDAO;



import dao.to.CompraTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            


        CompraTO compraTO = new CompraTO();
        //    personalTO.setCodigo("02");
        
        
        //call usp_inserta_datos_compra(@estado,"01",null,null,null,null,0,"1995-03-10","1995-03-10","NOCANCELADO");

//        compraTO.setFormCodigo(null);
//        compraTO.setCajacodigo(null);
//        compraTO.setProvCodigo(null);        
//        compraTO.setUsuaCodigo(null);
        compraTO.setTotal( (float)500.3193);
        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        compraTO.setFechaPedido(fechaHora);
        //compraTO.setFechaCompra("1995-03-10");
        compraTO.setEstado("CANCELADO");
        


        try {
            ICompraDAO compraDAO = DAOFactory.getInstance().getCompraDAO();
            compraDAO.insertar(compraTO);
            System.out.println("Código generado: " + compraTO.getCodigo());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    } // main
}
