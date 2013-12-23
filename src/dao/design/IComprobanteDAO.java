/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.ComprobanteTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IComprobanteDAO {
    
        //Create
    public abstract void insertar(ComprobanteTO comprobanteTO ) throws Exception;
    //Read
    public abstract ArrayList<ComprobanteTO> consultarComprobante (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(ComprobanteTO comprobanteTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
    
}
