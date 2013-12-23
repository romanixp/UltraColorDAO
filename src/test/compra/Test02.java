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
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        CompraTO compraTO = new CompraTO();
        
        
        
        
        compraTO.setCodigo("0000001");
        compraTO.setFormCodigo(null);
        compraTO.setCajacodigo(null);
        compraTO.setProvCodigo(null);        
        compraTO.setUsuaCodigo(null);
        compraTO.setTotal( (float)50);
        compraTO.setFechaPedido("1995-03-10");
        
        java.util.Date dt = new java.util.Date();
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String fechaHora = sdf.format(dt);
        
        System.out.println(fechaHora);
        compraTO.setFechaCompra(fechaHora);
        
        compraTO.setEstado("CANCELADO");
        
        try {
            ICompraDAO compraDAO = DAOFactory.getInstance().getCompraDAO();
            compraDAO.actualizar(compraTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
