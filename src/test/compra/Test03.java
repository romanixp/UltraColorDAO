/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.compra;



import dao.DAOFactory;
import dao.design.ICompraDAO;
import dao.to.CompraTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        CompraTO compraTO = new CompraTO();
        compraTO.setCodigo("0000011");

        //compraTO.setObservaciones(null);
        try {
            ICompraDAO compraDAO = DAOFactory.getInstance().getCompraDAO();
            compraDAO.eliminar(compraTO.getCodigo());
            System.out.println("Se ha eliminado: " + compraTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
