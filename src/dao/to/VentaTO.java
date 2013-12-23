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
public class VentaTO {
    private String codigo;
    private Float subtotal;
    private Float igv;
    private Float total;
    private Date fecha;
    private String tipoVenta;
    private Date fechaVencimiento;
    private Float adelanto;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Float subtotal) {
        this.subtotal = subtotal;
    }

    public Float getIgv() {
        return igv;
    }

    public void setIgv(Float igv) {
        this.igv = igv;
    }

    public Float getTotal() {
        return total;
    }

    public void setTotal(Float total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(String tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Float getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Float adelanto) {
        this.adelanto = adelanto;
    }
    
}
