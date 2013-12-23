/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.FormaPagoTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IFormaPagoDAO {
    
        //Create
    public abstract void insertar(FormaPagoTO formaPagoTO ) throws Exception;
    //Read
    public abstract ArrayList<FormaPagoTO> consultarFormaPago (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(FormaPagoTO formaPagoTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
    
}
