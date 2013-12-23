/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.design;

import dao.to.UsuarioTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public interface IUsuarioDAO {
    //Create
    public abstract void insertar(UsuarioTO usuarioTO ) throws Exception;
    //Read
    public abstract ArrayList<UsuarioTO> consultarUsuario (String campo,String valor) throws Exception;
    //Update
   public abstract void actualizar(UsuarioTO usuarioTO) throws Exception;
   //Delete
   public abstract void eliminar(String codigo) throws Exception;
   
   
   public abstract UsuarioTO consultarPorCorreo(String correo) throws Exception ;
}
