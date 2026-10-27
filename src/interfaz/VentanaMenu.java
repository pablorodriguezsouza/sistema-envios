package interfaz;

import dominio.*;
import java.io.IOException;

public class VentanaMenu extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaMenu.class.getName());

    public VentanaMenu(Sistema sis) {
        modelo = sis;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar = new javax.swing.JMenuBar();
        jMenuDatos = new javax.swing.JMenu();
        opcionClientes = new javax.swing.JMenuItem();
        opcionFuncionarios = new javax.swing.JMenuItem();
        opcionTarifas = new javax.swing.JMenuItem();
        jMenuPaquetes = new javax.swing.JMenu();
        opcionIngreso = new javax.swing.JMenuItem();
        opcionEnvio = new javax.swing.JMenuItem();
        opcionRecepcion = new javax.swing.JMenuItem();
        jMenuReportes = new javax.swing.JMenu();
        opcionPaquetesPorEstados = new javax.swing.JMenuItem();
        opcionConsultasPorCliente = new javax.swing.JMenuItem();
        opcionLogTransacciones = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jMenuDatos.setText("Datos");

        opcionClientes.setText("Clientes");
        opcionClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionClientesActionPerformed(evt);
            }
        });
        jMenuDatos.add(opcionClientes);

        opcionFuncionarios.setText("Funcionarios");
        opcionFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionFuncionariosActionPerformed(evt);
            }
        });
        jMenuDatos.add(opcionFuncionarios);

        opcionTarifas.setText("Tarifas");
        opcionTarifas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionTarifasActionPerformed(evt);
            }
        });
        jMenuDatos.add(opcionTarifas);

        jMenuBar.add(jMenuDatos);

        jMenuPaquetes.setText("Paquetes");

        opcionIngreso.setText("Ingreso");
        opcionIngreso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionIngresoActionPerformed(evt);
            }
        });
        jMenuPaquetes.add(opcionIngreso);

        opcionEnvio.setText("Envío");
        opcionEnvio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionEnvioActionPerformed(evt);
            }
        });
        jMenuPaquetes.add(opcionEnvio);

        opcionRecepcion.setText("Recepción");
        opcionRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionRecepcionActionPerformed(evt);
            }
        });
        jMenuPaquetes.add(opcionRecepcion);

        jMenuBar.add(jMenuPaquetes);

        jMenuReportes.setText("Reportes");

        opcionPaquetesPorEstados.setText("Paquetes por Estado");
        opcionPaquetesPorEstados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionPaquetesPorEstadosActionPerformed(evt);
            }
        });
        jMenuReportes.add(opcionPaquetesPorEstados);

        opcionConsultasPorCliente.setText("Consultas por Cliente");
        opcionConsultasPorCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionConsultasPorClienteActionPerformed(evt);
            }
        });
        jMenuReportes.add(opcionConsultasPorCliente);

        opcionLogTransacciones.setText("Log de Transacciones");
        opcionLogTransacciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionLogTransaccionesActionPerformed(evt);
            }
        });
        jMenuReportes.add(opcionLogTransacciones);

        jMenuBar.add(jMenuReportes);

        setJMenuBar(jMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 358, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(574, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void opcionClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionClientesActionPerformed
        interfaz.VentanaClientes vent = new interfaz.VentanaClientes(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionClientesActionPerformed

    private void opcionFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionFuncionariosActionPerformed
        interfaz.VentanaFuncionarios vent = new interfaz.VentanaFuncionarios(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionFuncionariosActionPerformed
    
    private void opcionTarifasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionTarifasActionPerformed
        interfaz.VentanaTarifas vent = new interfaz.VentanaTarifas(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionTarifasActionPerformed
    
    private void opcionIngresoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionIngresoActionPerformed
        interfaz.VentanaIngreso vent = new interfaz.VentanaIngreso(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionIngresoActionPerformed
    
    private void opcionEnvioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionEnvioActionPerformed
        interfaz.VentanaEnvio vent = new interfaz.VentanaEnvio(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionEnvioActionPerformed

    private void opcionRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionRecepcionActionPerformed
        interfaz.VentanaRecepcion vent = new interfaz.VentanaRecepcion(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionRecepcionActionPerformed
    
    private void opcionPaquetesPorEstadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionPaquetesPorEstadosActionPerformed
        interfaz.VentanaPaquetesPorEstado vent = new interfaz.VentanaPaquetesPorEstado(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionPaquetesPorEstadosActionPerformed
    
    private void opcionConsultasPorClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionConsultasPorClienteActionPerformed
        interfaz.VentanaConsultaPorCliente vent = new interfaz.VentanaConsultaPorCliente(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionConsultasPorClienteActionPerformed

    private void opcionLogTransaccionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionLogTransaccionesActionPerformed
        interfaz.VentanaLogTransacciones vent = new interfaz.VentanaLogTransacciones(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_opcionLogTransaccionesActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try {
            modelo.guardarDatos();
        } catch (IOException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Error al guardar datos");
        }
        dispose();
    }//GEN-LAST:event_formWindowClosing


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar jMenuBar;
    private javax.swing.JMenu jMenuDatos;
    private javax.swing.JMenu jMenuPaquetes;
    private javax.swing.JMenu jMenuReportes;
    private javax.swing.JMenuItem opcionClientes;
    private javax.swing.JMenuItem opcionConsultasPorCliente;
    private javax.swing.JMenuItem opcionEnvio;
    private javax.swing.JMenuItem opcionFuncionarios;
    private javax.swing.JMenuItem opcionIngreso;
    private javax.swing.JMenuItem opcionLogTransacciones;
    private javax.swing.JMenuItem opcionPaquetesPorEstados;
    private javax.swing.JMenuItem opcionRecepcion;
    private javax.swing.JMenuItem opcionTarifas;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
}
