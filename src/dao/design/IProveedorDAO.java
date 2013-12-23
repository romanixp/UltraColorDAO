
package dao.design;

import dao.to.ProveedorTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IProveedorDAO {
    
    //Create
    public abstract void insertar(ProveedorTO proveedorTO ) throws Exception;
    //Read
    public abstract ArrayList<ProveedorTO> consultarProveedor (String campo, String valor) throws Exception;
    //Update
   public abstract void actualizar(ProveedorTO proveedorTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
}
