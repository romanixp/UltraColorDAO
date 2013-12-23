/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.CompraTO;
import dao.to.PedidoCompraTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface ICompraDAO {
    
    public abstract float pedido(ArrayList<PedidoCompraTO> listaPedido,String provCodigo,String usuaCodigo) throws Exception;
    
    public abstract void comprar(ArrayList<PedidoCompraTO> listaPedido,String formaPago, String comprobante, String numComprobante ) throws Exception;
    
    //Create
    public abstract void insertar(CompraTO compraTO ) throws Exception;
    //Read
//    public abstract ArrayList<CompraTO> consultarCompra (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(CompraTO compraTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
    public ArrayList<CompraTO> consultarCompra(String campo,String valor) throws Exception ;
}
