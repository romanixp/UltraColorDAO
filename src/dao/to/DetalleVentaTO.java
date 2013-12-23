/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author Sistemas
 */
public class DetalleVentaTO {
    private String codigo;
    private int cantidad;
    private String descripcion;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
}
