package obl2;

import dominio.Sistema;
import java.io.IOException;

public class Obl2 {
    public static void main(String[] args) {
        Sistema sis = new Sistema();
        try {
            sis.leerTarifas();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(null, "No se pudo cargar Tarifas.txt");
        }
        
        if (sis.existenDatosGuardados()) {
            int opcion = javax.swing.JOptionPane.showConfirmDialog(null, "Cargar los datos de la ultima ejecución", "Iniciar sistema", javax.swing.JOptionPane.YES_NO_OPTION);
            if (opcion == 0) {
                try {
                    Sistema guardado = Sistema.cargarDatos();
                    guardado.leerTarifas();
                    sis = guardado;
                } catch (Exception e) {
                    javax.swing.JOptionPane.showMessageDialog(null, "Error al cargar los datos guardados. Se iniciará un sistema nuevo.");
                }
            }
        }
        
        interfaz.VentanaMenu ventana = new interfaz.VentanaMenu(sis);
        ventana.setVisible(true);
    }
}
