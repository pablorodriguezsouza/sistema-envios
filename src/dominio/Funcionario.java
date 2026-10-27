package dominio;

import java.io.Serializable;

public class Funcionario extends Persona implements Serializable {
    private int numFuncionario;
    private int añoIngreso;
    
    public Funcionario(String nombre, String celular, int numFuncionario, int añoIngreso) {
        super(nombre, celular);
        this.numFuncionario = numFuncionario;
        this.añoIngreso = añoIngreso;
    }

    public int getNumFuncionario() {
        return numFuncionario;
    }

    public void setNumFuncionario(int numFuncionario) {
        this.numFuncionario = numFuncionario;
    }

    public int getAñoIngreso() {
        return añoIngreso;
    }

    public void setAñoIngreso(int añoIngreso) {
        this.añoIngreso = añoIngreso;
    }
}
