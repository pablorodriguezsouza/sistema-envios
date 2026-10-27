package interfaz;

import dominio.*;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

public class VentanaTarifas extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaTarifas.class.getName());

    public VentanaTarifas(Sistema sis) {
        modelo = sis;
        initComponents();
        Estilo.aplicar(this, "Tarifas", "Precio por zona y categoría de peso; se pueden ajustar todos con un porcentaje");
        Estilo.botonPrincipal(btnActualizar);
        cargarTabla();
        modelo.addObserver(this);
    }
    
    public void cargarTabla() {
        javax.swing.table.DefaultTableModel tabla = (javax.swing.table.DefaultTableModel) jTable1.getModel();
        int[][] precios = modelo.getTarifas().getPrecios();
        for (int i = 0; i < 4; i++) {
            tabla.setValueAt(precios[i][0], i, 1);
            tabla.setValueAt(precios[i][1], i, 2);
            tabla.setValueAt(precios[i][2], i, 3);
            tabla.setValueAt(precios[i][3], i, 4);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup2 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        txtPorcentaje = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        aumentar = new javax.swing.JRadioButton();
        descontar = new javax.swing.JRadioButton();
        btnActualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(560, 381));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NORTE", null, null, null, null},
                {"OESTE", null, null, null, null},
                {"ESTE", null, null, null, null},
                {"SUR", null, null, null, null}
            },
            new String [] {
                "ZONA", "CAT 1", "CAT 2", "CAT 3", "CAT 4"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(90);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
            jTable1.getColumnModel().getColumn(4).setResizable(false);
        }

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Porcentaje");

        buttonGroup2.add(aumentar);
        aumentar.setText("Aumentar");

        buttonGroup2.add(descontar);
        descontar.setText("Descontar");

        btnActualizar.setText("Actualizar tarifas");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(200, 200, 200))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(aumentar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(descontar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPorcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(descontar)
                    .addComponent(aumentar))
                .addGap(18, 18, 18)
                .addComponent(btnActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );

        setSize(new java.awt.Dimension(574, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        if (!aumentar.isSelected() && !descontar.isSelected()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Selecciona Aumentar o Descontar");
        } else {
            String txt = txtPorcentaje.getText().trim();
            if (txt.equals("")) {
                javax.swing.JOptionPane.showMessageDialog(this, "Ingresá un porcentaje");
            } else {
                try {
                    int porcentaje = Integer.parseInt(txt);
                    if (porcentaje <= 0) {
                        javax.swing.JOptionPane.showMessageDialog(this, "El porcentaje debe ser un número mayor a 0");
                    } else if (descontar.isSelected() && porcentaje >= 100) {
                        javax.swing.JOptionPane.showMessageDialog(this, "El descuento debe ser menor a 100%");
                    } else {
                        if (descontar.isSelected()) {
                            porcentaje = - porcentaje;
                        }
                        try {
                            modelo.actualizarTarifas(porcentaje);
                            txtPorcentaje.setText("");
                        } catch (IOException e) {
                            javax.swing.JOptionPane.showMessageDialog(this, "No se pudo actualizar Tarifas.txt");
                        }
                    }
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El porcentaje debe ser numérico");
                }
            }
        }
    }//GEN-LAST:event_btnActualizarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton aumentar;
    private javax.swing.JButton btnActualizar;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JRadioButton descontar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtPorcentaje;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    
    @Override
    public void update(Observable o, Object args) {
        cargarTabla();
    }
}
