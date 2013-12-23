/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IProveedorDAO;
import dao.ds.AccesoDB;
import dao.to.ProveedorTO;
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
public class ProveedorDAO implements IProveedorDAO {

    @Override
    public ArrayList<ProveedorTO> consultarProveedor(String campo,String valor) throws Exception {

                       
        String query = "select * from proveedor where "+ campo + " like '" + valor + "%'";
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<ProveedorTO> lista = new ArrayList<ProveedorTO>(); //se maneja con una lista de proveedor

        ProveedorTO proveedor = null;

        while (rs.next()) {
            proveedor = new ProveedorTO();


            proveedor.setCodigo(rs.getString("CHR_PROVCODIGO"));
            proveedor.setNombre(rs.getString("VCH_PROVNOMBRE"));
            proveedor.setRuc(rs.getString("CHR_PROVRUC"));
            proveedor.setDireccion(rs.getString("VCH_PROVDIRECCION"));
            proveedor.setTelefono(rs.getString("CHR_PROVTELEFONO"));
            proveedor.setRp(rs.getString("VCH_PROVRP"));
            proveedor.setCorreo(rs.getString("VCH_PROVCORREO"));
            proveedor.setPaginaweb(rs.getString("VCH_PROVPAGINAWEB"));
            proveedor.setObservacion(rs.getString("VCH_PROVOBSERVACION"));

            lista.add(proveedor);
        }
        rs.close();
        ps.close();
        return lista;
    } // consultarProveedor

    {
//    @Override
//    public void insertar(ProveedorTO proveedorTO) throws Exception {
//        Connection cn = null;
//        try {
//            cn = AccesoDB.getConnection();
//            cn.setAutoCommit(false); //inicio de transaccion
//            IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
//            String codigo = contadorDAO.generaCodigo("proveedor");
//            String sql = "insert into proveedor(CHR_PERSCODIGO,VCH_PERSNOMBRE,VCH_PERSAPELLIDOS,CHR_PERSDNI,DTT_PERSFECHANACIMIENTO,"
//                    + "VCH_PERSDIRECCION,CHR_PERSCEL,CHR_PERSRP,VCH_PERSCORREO,VCH_PERSOBSERVACIONES) values"
//                    + "(?,?,?,?,?,?,?,?,?,?)";
//
//            PreparedStatement ps = cn.prepareStatement(sql);
//            ps.setString(1, codigo);
//            ps.setString(2, proveedorTO.getNombre());
//            ps.setString(3, proveedorTO.getApellidos());
//            ps.setString(4, proveedorTO.getDni());
//            ps.setDate(5, proveedorTO.getFechaNacimiento());
//            ps.setString(6, proveedorTO.getDireccion());
//            ps.setString(7, proveedorTO.getCelular());
//            ps.setString(8, proveedorTO.getRp());
//            ps.setString(9, proveedorTO.getCorreo());
//            ps.setString(10, proveedorTO.getObservaciones());
//            ps.executeUpdate();
//
//            proveedorTO.setCodigo(codigo);  // en el controlador los objetos se pasan por referencia
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
    public void insertar(ProveedorTO proveedorTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_proveedor(?,?,?,?,?,?,?,?,?,?)";

        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("proveedor");

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
        cs.setString(3, proveedorTO.getNombre());
        cs.setString(4, proveedorTO.getRuc());
        cs.setString(5, proveedorTO.getDireccion());
        cs.setString(6, proveedorTO.getTelefono());
        cs.setString(7, proveedorTO.getRp());
        cs.setString(8, proveedorTO.getCorreo());
        cs.setString(9, proveedorTO.getPaginaweb());
        cs.setString(10, proveedorTO.getObservacion());


        cs.executeUpdate();

        proveedorTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(ProveedorTO proveedorTO) throws Exception {

        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_proveedor(?,?,?,?,?,?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);

        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, proveedorTO.getCodigo());
        cs.setString(3, proveedorTO.getNombre());
        cs.setString(4, proveedorTO.getRuc());
        cs.setString(5, proveedorTO.getDireccion());
        cs.setString(6, proveedorTO.getTelefono());
        cs.setString(7, proveedorTO.getRp());
        cs.setString(8, proveedorTO.getCorreo());
        cs.setString(9, proveedorTO.getPaginaweb());
        cs.setString(10, proveedorTO.getObservacion());

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
        String sql = "call usp_elimina_datos_proveedor(?,?)";

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
