/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author Sistemas
 */
public class PedidoCompraTO {
    private String codigo;
    
    private String compCodigo;
    
    private String prodCodigo;
    private int cantidad;   
    

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCompCodigo() {
        return compCodigo;
    }

    public void setCompCodigo(String compCodigo) {
        this.compCodigo = compCodigo;
    }

    public String getProdCodigo() {
        return prodCodigo;
    }

    public void setProdCodigo(String prodCodigo) {
        this.prodCodigo = prodCodigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }


    
}
