/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.component;

import dao.DAOFactory;
import dao.design.IClienteDAO;
import dao.design.IContadorDAO;
import dao.ds.AccesoDB;
import dao.to.ClienteTO;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author Sistemas
 */
public class ClienteDAO implements IClienteDAO{
        @Override
    public ArrayList<ClienteTO> consultarCliente(String campo,String valor) throws Exception {

                       
        String query = "select * from cliente where "+ campo + " like '" + valor + "%'";
        
        PreparedStatement ps = AccesoDB.getConnection().prepareStatement(query);
        ResultSet rs = ps.executeQuery();

        ArrayList<ClienteTO> lista = new ArrayList<ClienteTO>(); //se maneja con una lista de personal

        ClienteTO cliente = null;

        while (rs.next()) {
            cliente = new ClienteTO();

            cliente.setCodigo(rs.getString("CHR_CLIECODIGO"));
            cliente.setNombre(rs.getString("VCH_CLENOMBRE"));
            cliente.setApellido(rs.getString("VCH_CLIEAPELLIDO"));
            cliente.setTipoDocumento(rs.getString("CHR_CLIETIPODOCUMENTO"));            
            cliente.setDireccion(rs.getString("VCH_CLIEDIRECCION"));
            cliente.setCelular(rs.getString("CHR_CLIECELULAR"));
            cliente.setRp(rs.getString("CHR_CLIERP"));
            cliente.setTelefono("CHR_CLIETELEFONO");
            cliente.setCorreo(rs.getString("VCH_CLIECORREO"));
            cliente.setFechaNacimiento(rs.getDate("DTT_CLIEFECHANACIMIENTO"));
            lista.add(cliente);
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
    public void insertar(ClienteTO clienteTO) throws Exception {
            
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_inserta_datos_cliente(?,?,?,?,?,?,?,?,?,?,?)";
        
        IContadorDAO contadorDAO = DAOFactory.getInstance().getContadorDAO();
        String codigo = contadorDAO.generaCodigo("cliente");
        
        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, codigo);
       
        cs.setString(3, clienteTO.getNombre());
        cs.setString(4, clienteTO.getApellido());
        cs.setString(5, clienteTO.getTipoDocumento());
        cs.setString(6, clienteTO.getDireccion());
        cs.setString(7, clienteTO.getCelular());
        cs.setString(8, clienteTO.getRp());
        cs.setString(9, clienteTO.getTelefono());
        cs.setString(10, clienteTO.getCorreo());        
        cs.setDate(11, clienteTO.getFechaNacimiento());
        

        cs.executeUpdate();
        
        clienteTO.setCodigo(codigo);

        String estado = cs.getString(1);
        cs.close();
        cs = null;
        if (!estado.equals("OK")) {
            throw new Exception(estado);
        }

    } // insertar

    @Override
    public void actualizar(ClienteTO clienteTO) throws Exception {
        
        Connection cn = AccesoDB.getConnection();
        String sql = "call usp_actualiza_datos_cliente(?,?,?,?,?,?,?,?,?,?,?)";

        cn.setAutoCommit(true);
        CallableStatement cs = cn.prepareCall(sql);
        
        cs.registerOutParameter(1, java.sql.Types.VARCHAR);
        cs.setString(2, clienteTO.getCodigo());
        cs.setString(3, clienteTO.getNombre());
        cs.setString(4, clienteTO.getApellido());
        cs.setString(5, clienteTO.getTipoDocumento());
        cs.setString(6, clienteTO.getDireccion());
        cs.setString(7, clienteTO.getCelular());
        cs.setString(8, clienteTO.getRp());
        cs.setString(9, clienteTO.getTelefono());
        cs.setString(10, clienteTO.getCorreo());        
        cs.setDate(11, clienteTO.getFechaNacimiento());

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
        String sql = "call usp_elimina_datos_cliente(?,?)";

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
