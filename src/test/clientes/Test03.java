/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.clientes;



import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.to.ClienteTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        ClienteTO clienteTO = new ClienteTO();
        clienteTO.setCodigo("0000002");

        //clienteTO.setObservaciones(null);
        try {
            IClienteDAO clienteDAO = DAOFactory.getInstance().getClienteDAO();
            clienteDAO.eliminar(clienteTO.getCodigo());
            //System.out.println("Código generado: " + clienteTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
