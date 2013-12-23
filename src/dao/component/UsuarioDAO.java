/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IUsuarioDAO;
import dao.design.IContadorDAO;
import dao.ds.AccesoDB;
import dao.to.UsuarioTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class UsuarioDAO implements IUsuarioDAO {

    
    @Override
    public UsuarioTO consultarPorCorreo(String correo) throws Exception {
		String sql = "select * from usuario where VCH_USUACORREO = ?";
		PreparedStatement ps = AccesoDB.getConnection().prepareStatement(sql);
		ps.setString(1, correo);
		ResultSet rs = ps.executeQuery();
		UsuarioTO usuarioTO = null;
   
		if (rs.next()) {
			usuarioTO = new UsuarioTO();
			usuarioTO.setCodigo(rs.getString("CHR_USUACODIGO"));
			usuarioTO.setPersCodigo(rs.getString("CHR_PERSCODIGO"));
			usuarioTO.setCorreo(rs.getString("VCH_USUACORREO"));
			usuarioTO.setNombre(rs.getString("VCH_USUANOMBRE"));
			usuarioTO.setClave(rs.getString("VCH_USUACLAVE"));
			usuarioTO.setPrivalegio(rs.getString("VCH_USUAPRIVILEGIO"));
		}
		return usuarioTO;
    }
    
    
    @Override
    public ArrayList<UsuarioTO> consultarUsuario(String campo,String valor) throws Exception {

                       
        String query = "select * from usuario where "+ campo + " like '" + valor + "%'";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<UsuarioTO> lista = new ArrayList<UsuarioTO>(); //se maneja con una lista de personal

        UsuarioTO usuario = null;

        while (rs.next()) {
            usuario = new UsuarioTO();

            usuario.setCodigo(rs.getString("CHR_USUACODIGO"));
            usuario.setPersCodigo(rs.getString("CHR_PERSCODIGO"));
            usuario.setCorreo(rs.getString("VCH_USUACORREO"));
            usuario.setNombre(rs.getString("VCH_USUANOMBRE"));
            usuario.setClave(rs.getString("VCH_USUACLAVE"));
            usuario.setPrivalegio(rs.getString("VCH_USUAPRIVILEGIO"));

            lista.add(usuario);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal

    @Override
    public void insertar(UsuarioTO usuarioTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_usuario(?,?,?,?,?,?,?)";

        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("usuario");

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
        cs.setString(3, usuarioTO.getPersCodigo());
        cs.setString(4, usuarioTO.getCorreo());
        cs.setString(5, usuarioTO.getNombre());
        cs.setString(6, usuarioTO.getClave());
        cs.setString(7, usuarioTO.getPrivalegio());

        cs.executeUpdate();

        usuarioTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(UsuarioTO usuarioTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_usuario(?,?,?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, usuarioTO.getCodigo());
        cs.setString(3, usuarioTO.getPersCodigo());
        cs.setString(4, usuarioTO.getCorreo());
        cs.setString(5, usuarioTO.getNombre());
        cs.setString(6, usuarioTO.getClave());
        cs.setString(7, usuarioTO.getPrivalegio());

        cs.execute();

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }
    }

    @Override
    public void eliminar(String codigo) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_elimina_datos_usuario(?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);


        cs.execute();

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }
    }
}
