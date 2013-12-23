/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ServicioTO;
import java.util.ArrayList;


/**
 *
 * @author Sistemas
 */
public interface IServicioDAO {
    
     //Create
    public abstract void insertar(ServicioTO servicioTO ) throws Exception;
    //Read
    public abstract ArrayList<ServicioTO> consultarServicio (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(ServicioTO servicioTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
    
}
