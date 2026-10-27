package dominio;

import java.io.Serializable;

public class Tarifas implements Serializable{
    private int[][] precios; // [zona][categoria]
    
    public Tarifas() {
        precios = new int[4][4];
    }
    
    public int[][] getPrecios() {
        return precios;
    }
    
    public void setZona(int zona, int[] valores) {
        precios[zona] = valores;
    }

    
    // ================= Utilidades =================
    
    public int calcularPrecio(String zona, int peso) {
        int z = getZonaIndice(zona);
        int cat = calcularCategoria(peso);
        return precios[z][cat];
    }
    
    public int calcularCategoria(int peso) {
        int cat;
        if (peso < 1000) {
            cat = 0;
        } else if (peso < 5000) {
            cat = 1;
        } else if (peso < 10000) {
            cat = 2;
        } else {
            cat = 3;
        }
        return cat;
    }
    
    public void porcentajeAumento(int porcentaje) {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                precios[i][j] = (int) Math.round(precios[i][j] * (1 + porcentaje / 100.0));
            }
        }
    }
    
    public String getDptoZona(String dpto) {
        String res;
        switch (dpto) {
            case "Artigas": case "Salto": case "Paysandú": case "Rivera": case "Tacuarembó":
                res = "NORTE";
                break;
            case "Río Negro": case "Soriano": case "Colonia": case "San José":
                res = "OESTE";
                break;
            case "Cerro Largo": case "Treinta y Tres": case "Lavalleja": case "Rocha": case "Maldonado":
                res = "ESTE";
                break;
            default:
                res = "SUR";
                break;
        }
        return res;
    }
    
    public int getZonaIndice(String zona) {
        int numZona;
        switch (zona.toUpperCase()) {
            case "NORTE":
                numZona = 0;
                break;
            case "OESTE":
                numZona = 1;
                break;
            case "ESTE":
                numZona = 2;
                break;
            case "SUR":
                numZona = 3;
                break;
            default:
                numZona = -1;
        }
        return numZona;
    } 
}
