package interfaz;

import dominio.*;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class VentanaRecepcion extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaRecepcion.class.getName());

    public VentanaRecepcion(Sistema sis) {
        modelo = sis;
        initComponents();
        Estilo.aplicar(this, "Recepción de envíos", "En amarillo, los envíos sin recepción registrada; en verde, los ya recibidos");
        Estilo.botonPrincipal(btnRegistrarRecepcion);
        colorLista();
        cargarEnvios();
        modelo.addObserver(this);
    }
    
    private void cargarEnvios() {
        lstEnvios.setListData(modelo.getEnviosOrdenados().toArray());
    }
    
    private void cargarPaquetes(dominio.Envio envio) {
        lstPaquetesEnvio.setListData(envio.getPaquetes().toArray());
    }
    
    private void colorLista() {
        lstEnvios.setCellRenderer(new javax.swing.DefaultListCellRenderer() {
            @Override
            public java.awt.Component getListCellRendererComponent(javax.swing.JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                java.awt.Component c = super.getListCellRendererComponent( list, value, index, isSelected, cellHasFocus);
                if (!isSelected) {
                    dominio.Envio envio = (dominio.Envio) value;
                    if (envio.getRegistroRecepcion()) {
                        c.setBackground(new java.awt.Color(214, 245, 222));
                    } else {
                        c.setBackground(new java.awt.Color(255, 240, 189));
                    }
                }
                return c;
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnRegistrarRecepcion = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        lstEnvios = new javax.swing.JList();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstPaquetesEnvio = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnRegistrarRecepcion.setText("Registrar recepción");
        btnRegistrarRecepcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegistrarRecepcionActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Envíos ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Paquetes del envío");

        lstEnvios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstEnviosValueChanged(evt);
            }
        });
        jScrollPane3.setViewportView(lstEnvios);

        jScrollPane1.setViewportView(lstPaquetesEnvio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(60, 60, 60))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40))))
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btnRegistrarRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 185, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
                .addComponent(btnRegistrarRecepcion, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34))
        );

        setSize(new java.awt.Dimension(574, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegistrarRecepcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegistrarRecepcionActionPerformed
        dominio.Envio envio = (dominio.Envio) lstEnvios.getSelectedValue();
        if (envio == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un envío");
        } else if (envio.getRegistroRecepcion()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Este envío ya fue registrado");
        } else {
            Object[] seleccionados = lstPaquetesEnvio.getSelectedValues();
            boolean confirmar = true;
            if (seleccionados.length == 0) {
                int op = javax.swing.JOptionPane.showConfirmDialog(this, "No seleccionaste ningún paquete como entregado."
                                    + "\nSe registrará la recepción y todos los paquetes del envío volverán a estado pendiente."
                                    + "\n¿Confirmás?", "Confirmar recepción", javax.swing.JOptionPane.YES_NO_OPTION);
                confirmar = (op == 0);
            }
            if (confirmar) {
                ArrayList<dominio.Paquete> recibidos = new ArrayList<>();
                for (Object o : seleccionados) {
                    recibidos.add((dominio.Paquete) o);
                }
                try {
                    modelo.registrarRecepcion(envio, recibidos);
                    lstEnvios.clearSelection();
                } catch (IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo escribir en el log de transacciones");
                }
            }
        }
    }//GEN-LAST:event_btnRegistrarRecepcionActionPerformed

    private void lstEnviosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstEnviosValueChanged
        dominio.Envio envio = (dominio.Envio) lstEnvios.getSelectedValue();
        if (envio != null) {
            cargarPaquetes(envio);
            if (envio.getRegistroRecepcion()) {
                lstPaquetesEnvio.setEnabled(false);
                btnRegistrarRecepcion.setEnabled(false);
            } else {
                lstPaquetesEnvio.setEnabled(true);
                btnRegistrarRecepcion.setEnabled(true);
            }
        } else {
            lstPaquetesEnvio.setListData(new Object[0]);
        }
    }//GEN-LAST:event_lstEnviosValueChanged

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRegistrarRecepcion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList lstEnvios;
    private javax.swing.JList lstPaquetesEnvio;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    
    @Override
    public void update(Observable o, Object arg) {
        cargarEnvios();
        lstPaquetesEnvio.setListData(new Object[0]);
    }
}
