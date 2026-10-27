package interfaz;

import dominio.*;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class VentanaEnvio extends javax.swing.JFrame implements Observer {

    public VentanaEnvio(Sistema sis) {
        modelo = sis;
        initComponents();
        cargarListas();
        modelo.addObserver(this);
    }

    private void cargarListas() {
        lstFuncionarios.setListData(modelo.getFuncionariosOrdenados().toArray());
        String[] zonas = {"NORTE", "SUR", "ESTE", "OESTE"};
        lstZona.setListData(zonas);
        lblNumEnvio.setText("Nro. Envío: " + modelo.getNumSigEnvio());
    }

    private void cargarPendientes() {
        String zona = (String) lstZona.getSelectedValue();
        if (zona != null) {
            ArrayList<Paquete> todos = modelo.getPaquetesPendientesPorZona(zona);
            ArrayList<Paquete> disponibles = new ArrayList<>();
            for (Paquete p : todos) {
                if (!seleccionados.contains(p)) {
                    disponibles.add(p);
                }
            }
            lstPendientes.setListData(disponibles.toArray());
        }
    }

    private void actualizarTotales() {
        lstSeleccionados.setListData(seleccionados.toArray());
        int peso = 0;
        int precio = 0;
        for (Paquete p : seleccionados) {
            peso += p.getPeso();
            precio += p.getPrecio();
        }
        int kg = peso / 1000;
        int gr = peso % 1000;
        lblTotales.setText("Paquetes: " + seleccionados.size() + "  |  Peso: " + kg + " kg, " + gr + " gr  |  Total: $" + precio);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuncionarios = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        lstZona = new javax.swing.JList();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstPendientes = new javax.swing.JList();
        jScrollPane4 = new javax.swing.JScrollPane();
        lstSeleccionados = new javax.swing.JList();
        lblNumEnvio = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        btnAgregar = new javax.swing.JButton();
        btnQuitar = new javax.swing.JButton();
        lblTotales = new javax.swing.JLabel();
        btnConfirmar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstFuncionarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFuncionariosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFuncionarios);

        lstZona.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstZonaValueChanged(evt);
            }
        });
        jScrollPane2.setViewportView(lstZona);

        jScrollPane3.setViewportView(lstPendientes);

        jScrollPane4.setViewportView(lstSeleccionados);

        lblNumEnvio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNumEnvio.setText("Nro. Envío: 1");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Fecha");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Funcionario");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("Zona");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Disponibles");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel5.setText("Seleccionados");

        btnAgregar.setText(">>");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        btnQuitar.setText("<<");
        btnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnQuitarActionPerformed(evt);
            }
        });

        lblTotales.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblTotales.setText("Paquetes: 0  |  Peso: 0 gr  |  Total: $0");

        btnConfirmar.setText("Confirmar");
        btnConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblNumEnvio))
            .addGroup(layout.createSequentialGroup()
                .addGap(240, 240, 240)
                .addComponent(jLabel2)
                .addGap(116, 116, 116)
                .addComponent(jLabel3))
            .addGroup(layout.createSequentialGroup()
                .addGap(60, 60, 60)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(90, 90, 90)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel4)
                .addGap(328, 328, 328)
                .addComponent(jLabel5))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnAgregar)
                    .addComponent(btnQuitar))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblTotales))
            .addGroup(layout.createSequentialGroup()
                .addGap(227, 227, 227)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, 160, Short.MAX_VALUE)
                .addGap(213, 213, 213))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblNumEnvio)
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(2, 2, 2)
                        .addComponent(txtFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(btnAgregar)
                        .addGap(12, 12, 12)
                        .addComponent(btnQuitar))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addComponent(lblTotales)
                .addGap(34, 34, 34)
                .addComponent(btnConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        setSize(new java.awt.Dimension(614, 549));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstZonaValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstZonaValueChanged
        String zona = (String) lstZona.getSelectedValue();
        if (zona != null) {
            seleccionados.clear();
            cargarPendientes();
            actualizarTotales();
        }
    }//GEN-LAST:event_lstZonaValueChanged

    private void lstFuncionariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFuncionariosValueChanged
    }//GEN-LAST:event_lstFuncionariosValueChanged

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        Paquete p = (Paquete) lstPendientes.getSelectedValue();
        if (p != null) {
            seleccionados.add(p);
            cargarPendientes();
            actualizarTotales();
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnQuitarActionPerformed
        Paquete p = (Paquete) lstSeleccionados.getSelectedValue();
        if (p != null) {
            seleccionados.remove(p);
            cargarPendientes();
            actualizarTotales();
        }
    }//GEN-LAST:event_btnQuitarActionPerformed

    private void btnConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConfirmarActionPerformed
        String fecha = txtFecha.getText().trim();
        Funcionario funcionario = (Funcionario) lstFuncionarios.getSelectedValue();
        String zona = (String) lstZona.getSelectedValue();

        if (fecha.equals("") || funcionario == null || zona == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
        } else if (!modelo.fechaValida(fecha)) {
            javax.swing.JOptionPane.showMessageDialog(this, "La fecha debe tener formato dd/mm/aaaa y ser una fecha válida");
        } else if (seleccionados.size() == 0) {
            javax.swing.JOptionPane.showMessageDialog(this, "Debe seleccionar al menos un paquete");
        } else {
            try {
                if (!modelo.addEnvio(fecha, zona, funcionario, seleccionados)) {
                    javax.swing.JOptionPane.showMessageDialog(this, "Error al crear el envío");
                } else {
                    seleccionados = new ArrayList<>();
                    txtFecha.setText("");
                    lstFuncionarios.clearSelection();
                    lstZona.clearSelection();
                    lstPendientes.setListData(new Object[0]);
                    lblNumEnvio.setText("Nro. Envío: " + modelo.getNumSigEnvio());
                    actualizarTotales();
                }
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo escribir en el log de transacciones");
            }
        }
    }//GEN-LAST:event_btnConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnConfirmar;
    private javax.swing.JButton btnQuitar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JLabel lblNumEnvio;
    private javax.swing.JLabel lblTotales;
    private javax.swing.JList lstFuncionarios;
    private javax.swing.JList lstPendientes;
    private javax.swing.JList lstSeleccionados;
    private javax.swing.JList lstZona;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private ArrayList<Paquete> seleccionados = new ArrayList<>();

    @Override
    public void update(Observable o, Object arg) {
        cargarListas();
        cargarPendientes();
        actualizarTotales();
    }
}
