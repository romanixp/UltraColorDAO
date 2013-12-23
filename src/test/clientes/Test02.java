/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.clientes;



import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.to.ClienteTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        ClienteTO clienteTO = new ClienteTO();
        
        clienteTO.setCodigo("0000001");
        clienteTO.setNombre("Luis");
        clienteTO.setApellido("Torres Diaz");
        clienteTO.setTipoDocumento("38394542");
        clienteTO.setDireccion("Av. 2 de Julio 4576");
        clienteTO.setCelular("979495358");
        clienteTO.setRp("#979495358");
        clienteTO.setTelefono(null);
        clienteTO.setCorreo("Carlos@gmail.com");
        clienteTO.setFechaNacimiento(Date.valueOf("1995-03-10"));
        
        try {
            IClienteDAO clienteDAO = DAOFactory.getInstance().getClienteDAO();
            clienteDAO.actualizar(clienteTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
