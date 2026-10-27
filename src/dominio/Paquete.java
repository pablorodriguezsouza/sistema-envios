package dominio;

import java.io.Serializable;

public class Paquete implements Serializable {
    private String id;
    private Cliente cliente;
    private String fecha;
    private String destinatario;
    private String direccion;
    private String dpto;
    private int peso;
    private int precio;
    private String estado;
    
    public Paquete(String id, Cliente cliente, String fecha, String destinatario, String direccion, String dpto, int peso, int precio) {
        this.id = id;
        this.cliente = cliente;
        this.fecha = fecha;
        this.destinatario = destinatario;
        this.direccion = direccion;
        this.dpto = dpto;
        this.peso = peso;
        this.precio = precio;
        this.estado = "PENDIENTE";
    }

    public String getId() {
        return id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public String getFecha() {
        return fecha;
    }

    public String getDestinatario() {
        return destinatario;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getDpto() {
        return dpto;
    }

    public int getPeso() {
        return peso;
    }

    public int getPrecio() {
        return precio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return id + " - " + destinatario + " (" + dpto + ") - " + estado; 
    }
}
