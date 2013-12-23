/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.usuario;
import dao.DAOFactory;
import dao.design.IUsuarioDAO;

import dao.to.UsuarioTO;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class Test04 {

    public static void main(String[] args) {

        ArrayList<UsuarioTO> lista = null;

        try {
            IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
            lista = usuarioDAO.consultarUsuario("VCH_SERVNOMBRE","");

            for (UsuarioTO usuarioTO : lista) {
                
                System.out.println(usuarioTO.getCodigo());
                System.out.println(usuarioTO.getPersCodigo());
                System.out.println(usuarioTO.getCorreo());
                System.out.println(usuarioTO.getNombre());

                System.out.println(usuarioTO.getClave());
                System.out.println(usuarioTO.getPrivalegio());
                System.out.println("");
                System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main
}
