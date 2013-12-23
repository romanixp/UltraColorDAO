/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.usuario;

import dao.DAOFactory;
import dao.design.IUsuarioDAO;



import dao.to.UsuarioTO;
import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class Test01 { //Test de insertar

    public static void main(String[] args) {
        // Datos
        //Date fecha = Date.valueOf("");            
        
        UsuarioTO usuarioTO = new UsuarioTO();
        
        //usuarioTO.setCodigo("");
        usuarioTO.setPersCodigo("03");
        usuarioTO.setCorreo("romaniUC@gmail.com");
        
        usuarioTO.setNombre("Raul");
        usuarioTO.setClave("romani");
        usuarioTO.setPrivalegio("admin");
        


        try {
            IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
            usuarioDAO.insertar(usuarioTO);
            System.out.println("Código generado: " + usuarioTO.getCodigo());
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
