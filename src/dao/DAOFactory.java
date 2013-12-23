/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import dao.component.*;
import dao.design.*;
//
//import dao.component.CompraDAO;
//import dao.component.ContadorDAO;
//import dao.component.PersonalDAO;
//import dao.component.ProductoDAO;
//import dao.component.ProveedorDAO;
//import dao.component.ServicioDAO;
//import dao.design.IClienteDAO;
//import dao.design.IContadorDAO;
//import dao.design.IPersonalDAO;
//import dao.design.IProductoDAO;
//import dao.design.IProveedorDAO;
//import dao.design.IServicioDAO;

/**
 *
 * @author Sistemas
 */
public class DAOFactory {
    //permite el acceso transparente a los objetos DAO

    private static DAOFactory daoFac;

    static {
        daoFac = new DAOFactory();
    }

    public static DAOFactory getInstance() {
        return daoFac;
    }

    public IPersonalDAO getPersonalDAO() {
        return new PersonalDAO();
    }

    public ICompraDAO getCompraDAO() {
        return new CompraDAO();
    }
     public IClienteDAO getClienteDAO() {
        return new ClienteDAO();
    }

    public IContadorDAO getContadorDAO() {
        return new ContadorDAO();
    }

    public IProductoDAO getProductoDAO() {
        return new ProductoDAO();
    }

    public IServicioDAO getServicioDAO() {
        return new ServicioDAO();
    }
    public IProveedorDAO getProveedorDAO() {
        return new ProveedorDAO();
    }
    public IUsuarioDAO getUsuarioDAO() {
        return new UsuarioDAO();
    }
    public IPedidoCompraDAO getPedidoCompraDAO() {
        return new PedidoCompraDAO();
    }
    
    public IFormaPagoDAO getFormaPagoDAO() {
        return new FormaPagoDAO();
    }
    
    public IComprobanteDAO getComprobanteDAO() {
        return new ComprobanteDAO();
    }
    
    
}
