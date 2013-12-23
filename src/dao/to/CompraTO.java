/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

import java.sql.Date;

/**
 *
 * @author Sistemas
 */
public class CompraTO {
    private String codigo;
    private String formCodigo;
    private String cajacodigo;
    private String provCodigo;
    private String usuaCodigo;
    private Float total;    
    private String fechaPedido;
    private String fechaCompra;
    private String estado;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFormCodigo() {
        return formCodigo;
    }

    public void setFormCodigo(String formCodigo) {
        this.formCodigo = formCodigo;
    }

    public String getCajacodigo() {
        return cajacodigo;
    }

    public void setCajacodigo(String cajacodigo) {
        this.cajacodigo = cajacodigo;
    }

    public String getProvCodigo() {
        return provCodigo;
    }

    public void setProvCodigo(String provCodigo) {
        this.provCodigo = provCodigo;
    }

    public String getUsuaCodigo() {
        return usuaCodigo;
    }

    public void setUsuaCodigo(String usuaCodigo) {
        this.usuaCodigo = usuaCodigo;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public String getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(String fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getFechaCompra() {
        return fechaCompra;
    }

    public void setFechaCompra(String fechaCompra) {
        this.fechaCompra = fechaCompra;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
   
    
    
}
