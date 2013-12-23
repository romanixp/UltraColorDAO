/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IContadorDAO;
import dao.design.IServicioDAO;
import dao.ds.AccesoDB;
import dao.to.ServicioTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class ServicioDAO implements IServicioDAO {

    @Override
    public ArrayList<ServicioTO> consultarServicio(String campo,String valor) throws Exception {

                       
        String query = "select * from servicios where "+ campo + " like '" + valor + "%'";
        
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<ServicioTO> lista = new ArrayList<ServicioTO>(); //se maneja con una lista de servicio

        ServicioTO servicio = null;

        while (rs.next()) {
            servicio = new ServicioTO();
            servicio.setCodigo(rs.getString("CHR_SERVCODIGO"));
            servicio.setNombre(rs.getString("VCH_SERVNOMBRE"));
            servicio.setPrecio(rs.getFloat("DEC_SERVPRECIO"));
            servicio.setDescripcion(rs.getString("VCH_SERVDESCRIPCION"));


            lista.add(servicio);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarServicio

    @Override
    public void insertar(ServicioTO servicioTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_servicio(?,?,?,?,?)";

        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("servicios");

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
        cs.setString(3, servicioTO.getNombre());
        cs.setFloat(4, servicioTO.getPrecio());
        cs.setString(5, servicioTO.getDescripcion());


        cs.executeUpdate();

        servicioTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(ServicioTO servicioTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_servicio(?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, servicioTO.getCodigo());
        cs.setString(3, servicioTO.getNombre());
        cs.setFloat(4, servicioTO.getPrecio());
        cs.setString(5, servicioTO.getDescripcion());

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
        String sql = "call usp_elimina_datos_servicio(?,?)";

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
