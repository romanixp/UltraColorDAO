/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ProductoTO;
import java.util.ArrayList;


/**
 *
 * @author Sistemas
 */
public interface IProductoDAO {
    
     //Create
    public abstract void insertar(ProductoTO productoTO ) throws Exception;
    //Read
    public abstract ArrayList<ProductoTO> consultarProducto (String campo, String valor) throws Exception;
    //Update
   public abstract void actualizar(ProductoTO productoTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
    
}
