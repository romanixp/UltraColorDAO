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
public class CajaTO {
    private String codigo;
    private Float ingresos;
    private Float egresos;
    private Float total;
    private Date fecha;

    public CajaTO() {
    }

    public CajaTO(String codigo, Float ingresos, Float egresos, Float total, Date fecha) {
        this.codigo = codigo;
        this.ingresos = ingresos;
        this.egresos = egresos;
        this.total = total;
        this.fecha = fecha;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Float getIngresos() {
        return ingresos;
    }

    public void setIngresos(Float ingresos) {
        this.ingresos = ingresos;
    }

    public Float getEgresos() {
        return egresos;
    }

    public void setEgresos(Float egresos) {
        this.egresos = egresos;
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
    
    
}
