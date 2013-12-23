/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao.to;

/**
 *
 * @author Sistemas
 */
public class UsuarioTO {
    
    private String codigo;   
    private String persCodigo;
    private String correo;
    private String nombre;
    private String clave;
    private String privalegio;

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    
    public String getPersCodigo() {
        return persCodigo;
    }

    public void setPersCodigo(String persCodigo) {
        this.persCodigo = persCodigo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getPrivalegio() {
        return privalegio;
    }

    public void setPrivalegio(String privalegio) {
        this.privalegio = privalegio;
    }
    
}
