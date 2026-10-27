package dominio;

import java.io.Serializable;

public class Persona implements Serializable {
    private String nombre;
    private String celular;
    
    public Persona(String nombre, String celular) {
        this.nombre = nombre;
        this.celular = celular;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    @Override
    public String toString() {
        return nombre;
    }
}
