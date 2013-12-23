/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IPersonalDAO;
import dao.ds.AccesoDB;
import dao.to.PersonalTO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import dao.design.IContadorDAO;

import java.sql.CallableStatement;

/**
 *
 * @author Sistemas
 */
public class PersonalDAO implements IPersonalDAO {

    @Override
    public PersonalTO consultaPorUsuario(String codigo) throws Exception {
        
        String query = "select * from personal where CHR_PERSCODIGO "
                + "in (select CHR_PERSCODIGO from usuario where CHR_USUACODIGO = ?)";

        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ps.setString(1, codigo);
        
        ResultSet rs = ps.executeQuery();
        PersonalTO personalTO = null;
        
        if (rs.next()) {
            personalTO = new PersonalTO();        
            personalTO.setCodigo(rs.getString("CHR_PERSCODIGO"));
            personalTO.setNombre(rs.getString("VCH_PERSNOMBRE"));
            personalTO.setApellidos(rs.getString("VCH_PERSAPELLIDOS"));
            personalTO.setDni(rs.getString("CHR_PERSDNI"));
            personalTO.setFechaNacimiento(rs.getString("DTT_PERSFECHANACIMIENTO"));
            personalTO.setDireccion(rs.getString("VCH_PERSDIRECCION"));
            personalTO.setCelular(rs.getString("CHR_PERSCEL"));
            personalTO.setRp(rs.getString("CHR_PERSRP"));
            personalTO.setCorreo(rs.getString("VCH_PERSCORREO"));
            personalTO.setObservaciones(rs.getString("VCH_PERSOBSERVACIONES"));
        }
        rs.close();
        ps.close();
        return personalTO;

    }

//    @Override
//    public ArrayList<PersonalTO> consultarPersonal() throws Exception {
//
//        String query = "select * from personal ";
//        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
//        ResultSet rs = ps.executeQuery();
//
//        ArrayList<PersonalTO> lista = new ArrayList<PersonalTO>(); //se maneja con una lista de personal
//
//        PersonalTO personal = null;
//
//        while (rs.next()) {
//            personal = new PersonalTO();
//
//            personal.setCodigo(rs.getString("CHR_PERSCODIGO"));
//            personal.setNombre(rs.getString("VCH_PERSNOMBRE"));
//            personal.setApellidos(rs.getString("VCH_PERSAPELLIDOS"));
//            personal.setDni(rs.getString("CHR_PERSDNI"));
//            personal.setFechaNacimiento(rs.getDate("DTT_PERSFECHANACIMIENTO"));
//            personal.setDireccion(rs.getString("VCH_PERSDIRECCION"));
//            personal.setCelular(rs.getString("CHR_PERSCEL"));
//            personal.setRp(rs.getString("CHR_PERSRP"));
//            personal.setCorreo(rs.getString("VCH_PERSCORREO"));
//            personal.setObservaciones(rs.getString("VCH_PERSOBSERVACIONES"));
//            lista.add(personal);
//        }
//        rs.close();
//        ps.close();
//        return lista;
//    } // consultarPersonal
        @Override
    public ArrayList<PersonalTO> consultarPersonal(String campo,String valor) throws Exception {

                       
        String query = "select * from personal where "+ campo + " like '" + valor + "%'";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);

        ResultSet rs = ps.executeQuery();

        ArrayList<PersonalTO> lista = new ArrayList<PersonalTO>(); //se maneja con una lista de personal

        PersonalTO personal = null;

        while (rs.next()) {
            personal = new PersonalTO();

            personal.setCodigo(rs.getString("CHR_PERSCODIGO"));
            personal.setNombre(rs.getString("VCH_PERSNOMBRE"));
            personal.setApellidos(rs.getString("VCH_PERSAPELLIDOS"));
            personal.setDni(rs.getString("CHR_PERSDNI"));
            personal.setFechaNacimiento(rs.getString("DTT_PERSFECHANACIMIENTO"));
            personal.setDireccion(rs.getString("VCH_PERSDIRECCION"));
            personal.setCelular(rs.getString("CHR_PERSCEL"));
            personal.setRp(rs.getString("CHR_PERSRP"));
            personal.setCorreo(rs.getString("VCH_PERSCORREO"));
            personal.setObservaciones(rs.getString("VCH_PERSOBSERVACIONES"));
            lista.add(personal);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarPersonal

    {
//    @Override
//    public void insertar(PersonalTO personalTO) throws Exception {
//        Connection cn = null;
//        try {
//            cn = AccesoDB.getConnection();
//            cn.setAutoCommit(false); //inicio de transaccion
//            IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
//            String codigo = contadorDAO.generaCodigo("personal");
//            String sql = "insert into personal(CHR_PERSCODIGO,VCH_PERSNOMBRE,VCH_PERSAPELLIDOS,CHR_PERSDNI,DTT_PERSFECHANACIMIENTO,"
//                    + "VCH_PERSDIRECCION,CHR_PERSCEL,CHR_PERSRP,VCH_PERSCORREO,VCH_PERSOBSERVACIONES) values"
//                    + "(?,?,?,?,?,?,?,?,?,?)";
//
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ps.setString(1, codigo);
//            ps.setString(2, personalTO.getNombre());
//            ps.setString(3, personalTO.getApellidos());
//            ps.setString(4, personalTO.getDni());
//            ps.setDate(5, personalTO.getFechaNacimiento());
//            ps.setString(6, personalTO.getDireccion());
//            ps.setString(7, personalTO.getCelular());
//            ps.setString(8, personalTO.getRp());
//            ps.setString(9, personalTO.getCorreo());
//            ps.setString(10, personalTO.getObservaciones());
//            ps.executeUpdate();
//
//            personalTO.setCodigo(codigo);  // en el controlador los objetos se pasan por referencia
//            cn.commit();
//            ps.close();
//        } catch (Exception e) {
//            try {
//                cn.rollback();
//            } catch (Exception e1) {
//            }
//            throw e;
//        }
//    } // insertar
    }

    @Override
    public void insertar(PersonalTO personalTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_personal(?,?,?,?,?,?,?,?,?,?,?)";

        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("personal");

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
        cs.setString(3, personalTO.getNombre());
        cs.setString(4, personalTO.getApellidos());
        cs.setString(5, personalTO.getDni());
        cs.setString(6, personalTO.getFechaNacimiento());
        cs.setString(7, personalTO.getDireccion());
        cs.setString(8, personalTO.getCelular());
        cs.setString(9, personalTO.getRp());
        cs.setString(10, personalTO.getCorreo());
        cs.setString(11, personalTO.getObservaciones());

        cs.executeUpdate();

        personalTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(PersonalTO personalTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_personal(?,?,?,?,?,?,?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, personalTO.getCodigo());
        cs.setString(3, personalTO.getNombre());
        cs.setString(4, personalTO.getApellidos());
        cs.setString(5, personalTO.getDni());
        cs.setString(6, personalTO.getFechaNacimiento());
        cs.setString(7, personalTO.getDireccion());
        cs.setString(8, personalTO.getCelular());
        cs.setString(9, personalTO.getRp());
        cs.setString(10, personalTO.getCorreo());
        cs.setString(11, personalTO.getObservaciones());

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
        String sql = "call usp_elimina_datos_personal(?,?)";

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
