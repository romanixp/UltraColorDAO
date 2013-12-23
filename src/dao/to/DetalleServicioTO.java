/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author Sistemas
 */
public class DetalleServicioTO {
    
    private String codigo;
    private int cantidad;
    private String comentario;

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

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }
    
}
