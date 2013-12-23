/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.usuario;


import test.usuario.*;
import dao.DAOFactory;
import dao.design.IUsuarioDAO;
import dao.to.UsuarioTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test02 { //prueba de actualizacion

    public static void main(String[] args) {
        //datos
        UsuarioTO usuarioTO = new UsuarioTO();
        
        usuarioTO.setCodigo("0000002");
        usuarioTO.setPersCodigo("02");
        usuarioTO.setCorreo("Jose@gmail.com");
        
        usuarioTO.setNombre("Jose Manuel");
        usuarioTO.setClave("123456");
        usuarioTO.setPrivalegio("personal");
        
        try {
            IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
            usuarioDAO.actualizar(usuarioTO);
            //System.out.println("Código generado: " + personalTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main    
}
