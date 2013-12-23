/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test.usuario;


import test.usuario.*;
import dao.DAOFactory;
import dao.design.IUsuarioDAO;
import dao.to.UsuarioTO;
/**
 *
 * @author Sistemas
 */
public class Test03 {  //Eliminar
    public static void main(String[] args) {
        //datos
        UsuarioTO usuarioTO = new UsuarioTO();
        usuarioTO.setCodigo("0000003");

        //usuarioTO.setObservaciones(null);
        try {
            IUsuarioDAO usuarioDAO = DAOFactory.getInstance().getUsuarioDAO();
            usuarioDAO.eliminar(usuarioTO.getCodigo());
            //System.out.println("Código generado: " + usuarioTO.getCodigo());

        } catch (Exception e) {
            e.printStackTrace();
        }
    } // main 
    
}
