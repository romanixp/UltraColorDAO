
package dao.design;

import dao.to.PersonalTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IPersonalDAO {
    
    //Create
    public abstract void insertar(PersonalTO personalTO ) throws Exception;
    //Read
    public abstract ArrayList<PersonalTO> consultarPersonal (String campo, String valor) throws Exception;
    //Update
   public abstract void actualizar(PersonalTO personalTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
   
   public abstract PersonalTO consultaPorUsuario (String codigo) throws Exception;
           
           
}
