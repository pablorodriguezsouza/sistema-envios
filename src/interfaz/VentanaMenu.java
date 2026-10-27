package interfaz;

import dominio.*;
import java.awt.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import javax.swing.*;

public class VentanaMenu extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaMenu.class.getName());

    public VentanaMenu(Sistema sis) {
        modelo = sis;
        initComponents();
        armarInicio();
        actualizarResumen();
        modelo.addObserver(this);
    }

    // Pantalla de inicio: barra lateral con todas las opciones a la vista y, a la derecha, un resumen
    // que se actualiza solo (la ventana es Observer del sistema, igual que las demás).
    // La barra de menús del diseñador queda arriba como atajo de teclado (Alt).
    private void armarInicio() {
        JPanel lateral = new JPanel();
        lateral.setLayout(new BoxLayout(lateral, BoxLayout.Y_AXIS));
        lateral.setBackground(Estilo.AZUL_NOCHE);
        lateral.setBorder(BorderFactory.createEmptyBorder(22, 16, 22, 16));

        JLabel lblNombre = new JLabel("Envíos");
        lblNombre.setFont(new Font("Segoe UI", Font.BOLD, 24));
        lblNombre.setForeground(Color.WHITE);
        JLabel lblLema = new JLabel("Gestión de paquetes");
        lblLema.setForeground(Estilo.NARANJA);
        lateral.add(lblNombre);
        lateral.add(lblLema);

        agregarSeccion(lateral, "DATOS");
        lateral.add(crearBoton("Clientes", this::opcionClientesActionPerformed));
        lateral.add(crearBoton("Funcionarios", this::opcionFuncionariosActionPerformed));
        lateral.add(crearBoton("Tarifas", this::opcionTarifasActionPerformed));
        agregarSeccion(lateral, "PAQUETES");
        lateral.add(crearBoton("Ingreso", this::opcionIngresoActionPerformed));
        lateral.add(crearBoton("Envío", this::opcionEnvioActionPerformed));
        lateral.add(crearBoton("Recepción", this::opcionRecepcionActionPerformed));
        agregarSeccion(lateral, "REPORTES");
        lateral.add(crearBoton("Paquetes por estado", this::opcionPaquetesPorEstadosActionPerformed));
        lateral.add(crearBoton("Consulta por cliente", this::opcionConsultasPorClienteActionPerformed));
        lateral.add(crearBoton("Log de transacciones", this::opcionLogTransaccionesActionPerformed));

        lblClientes = new JLabel();
        lblPendientes = new JLabel();
        lblEnviados = new JLabel();
        lblRecibidos = new JLabel();
        JPanel indicadores = new JPanel(new GridLayout(1, 4, 12, 0));
        indicadores.setOpaque(false);
        indicadores.add(crearIndicador("Clientes", lblClientes));
        indicadores.add(crearIndicador("Pendientes", lblPendientes));
        indicadores.add(crearIndicador("En viaje", lblEnviados));
        indicadores.add(crearIndicador("Recibidos", lblRecibidos));

        JLabel lblTitulo = new JLabel("Resumen");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTitulo.setForeground(Estilo.AZUL_NOCHE);
        lblTitulo.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        Image mapa = new ImageIcon(getClass().getResource("/mapa.jpg")).getImage().getScaledInstance(260, 270, Image.SCALE_SMOOTH);
        JLabel lblMapa = new JLabel("Zonas de reparto", new ImageIcon(mapa), SwingConstants.CENTER);
        lblMapa.setVerticalTextPosition(SwingConstants.BOTTOM);
        lblMapa.setHorizontalTextPosition(SwingConstants.CENTER);
        lblMapa.setForeground(new Color(90, 98, 112));

        JPanel arriba = new JPanel(new BorderLayout());
        arriba.setOpaque(false);
        arriba.add(lblTitulo, BorderLayout.NORTH);
        arriba.add(indicadores, BorderLayout.CENTER);

        JPanel centro = new JPanel(new BorderLayout(0, 16));
        centro.setBackground(Estilo.FONDO);
        centro.setBorder(BorderFactory.createEmptyBorder(22, 24, 18, 24));
        centro.add(arriba, BorderLayout.NORTH);
        centro.add(lblMapa, BorderLayout.CENTER);

        JPanel contenido = new JPanel(new BorderLayout());
        contenido.add(lateral, BorderLayout.WEST);
        contenido.add(centro, BorderLayout.CENTER);
        setContentPane(contenido);
        setTitle("Envíos - Menú principal");
        setSize(820, 620);
        setLocationRelativeTo(null);
    }

    private void agregarSeccion(JPanel lateral, String nombre) {
        JLabel lblSeccion = new JLabel(nombre);
        lblSeccion.setFont(new Font("Segoe UI", Font.BOLD, 11));
        lblSeccion.setForeground(Estilo.AZUL_TEXTO);
        lblSeccion.setBorder(BorderFactory.createEmptyBorder(18, 10, 4, 0));
        lateral.add(lblSeccion);
    }

    // Botón de la barra lateral: ejecuta la misma acción que la opción de la barra de menús.
    private JButton crearBoton(String texto, java.awt.event.ActionListener accion) {
        JButton boton = new JButton(texto);
        Estilo.botonLateral(boton);
        boton.addActionListener(accion);
        return boton;
    }

    // Tarjeta blanca con un número grande y su nombre abajo.
    private JPanel crearIndicador(String nombre, JLabel lblNumero) {
        lblNumero.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblNumero.setForeground(Estilo.AZUL_NOCHE);
        JLabel lblNombreIndicador = new JLabel(nombre);
        lblNombreIndicador.setForeground(new Color(90, 98, 112));
        JPanel indicador = new JPanel(new GridLayout(2, 1));
        indicador.setBackground(Color.WHITE);
        indicador.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createMatteBorder(4, 0, 0, 0, Estilo.NARANJA),
                BorderFactory.createEmptyBorder(8, 14, 10, 14)));
        indicador.add(lblNumero);
        indicador.add(lblNombreIndicador);
        return indicador;
    }

    private void actualizarResumen() {
        int pendientes = 0;
        int enviados = 0;
        int recibidos = 0;
        for (Paquete p : modelo.getPaquetes()) {
            switch (p.getEstado()) {
                case "PENDIENTE":
                    pendientes++;
                    break;
                case "ENVIADO":
                    enviados++;
                    break;
                case "RECIBIDO":
                    recibidos++;
                    break;
            }
        }
        lblClientes.setText("" + modelo.getClientes().size());
        lblPendientes.setText("" + pendientes);
        lblEnviados.setText("" + enviados);
        lblRecibidos.setText("" + recibidos);
    }

    @Override
    public void update(Observable o, Object arg) {
        actualizarResumen();
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
    private JLabel lblClientes, lblPendientes, lblEnviados, lblRecibidos;
}
