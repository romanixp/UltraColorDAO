/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ClienteTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IClienteDAO {
    //Create
    public abstract void insertar(ClienteTO clienteTO ) throws Exception;
    //Read
    public abstract ArrayList<ClienteTO> consultarCliente (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(ClienteTO clienteTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
}
