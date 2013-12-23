/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.clientes;


import dao.DAOFactory;
import dao.design.IClienteDAO;

import dao.to.ClienteTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<ClienteTO> lista = null;

        try {
            IClienteDAO clienteDAO = DAOFactory.getInstance().getClienteDAO();
            lista = clienteDAO.consultarCliente("VCH_CLENOMBRE","");

            for (ClienteTO clienteTO : lista) {
                System.out.println(clienteTO.getCodigo());
                System.out.println(clienteTO.getNombre());
                System.out.println(clienteTO.getApellido());
                System.out.println(clienteTO.getTipoDocumento());

                System.out.println(clienteTO.getDireccion());
                System.out.println(clienteTO.getCelular());
                System.out.println(clienteTO.getRp());
                System.out.println(clienteTO.getTelefono());
                System.out.println(clienteTO.getCorreo());
                System.out.println(clienteTO.getFechaNacimiento());
                System.out.println("");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
