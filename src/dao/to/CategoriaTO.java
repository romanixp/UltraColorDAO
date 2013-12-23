/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author Sistemas
 */
public class CategoriaTO {
    private String codigo;
    private String nombre;

    public CategoriaTO() {
    }

    public CategoriaTO(String codigo, String nombre) {
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
}
