/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.PedidoCompraTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IPedidoCompraDAO {
      //Create
    public abstract void insertar(PedidoCompraTO pedidocompraTO ) throws Exception;
    //Read
    public abstract ArrayList<PedidoCompraTO> consultarPedidoCompra (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(PedidoCompraTO pedidocompraTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
}
