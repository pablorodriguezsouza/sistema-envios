package dominio;

import java.io.Serializable;
import java.util.ArrayList;

public class Envio implements Serializable {
    private int numero;
    private String fecha;
    private Funcionario funcionario;
    private String zona;
    private ArrayList<Paquete> paquetes;
    private boolean registroRecepcion;

    public Envio(int numero, String fecha, String zona, Funcionario funcionario) {
        this.numero = numero;
        this.fecha = fecha;
        this.funcionario = funcionario;
        this.zona = zona;
        this.paquetes = new ArrayList<>();
        this.registroRecepcion = false;
    }

    public int getNumero() {
        return numero;
    }

    public String getFecha() {
        return fecha;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public String getZona() {
        return zona;
    }

    public ArrayList<Paquete> getPaquetes() {
        return paquetes;
    }
    
    public void addPaquete(Paquete p) {
        paquetes.add(p);
    }
    
    public void removePaquete(Paquete p) {
        paquetes.remove(p);
    }
    
    public int getTotalPaquetes() {
        return paquetes.size();
    }
    
    public boolean getRegistroRecepcion() {
        return registroRecepcion;
    }
    
    public void setRegistroRecepcion(boolean registroRecepcion) {
        this.registroRecepcion = registroRecepcion;
    }
    
    @Override
    public String toString() {
        return "Envio " + numero + " - " + fecha + " - " + zona;
    }
    
   // ================= UTILIDADES =================
    
    public int getTotalPeso() {
        int total = 0;
        for (Paquete p : paquetes) {
            total += p.getPeso();
        }
        return total;
    }
    
    public int getTotalPrecio() {
        int total = 0;
        for (Paquete p : paquetes) {
            total += p.getPrecio();
        }
        return total;
    }   
}
