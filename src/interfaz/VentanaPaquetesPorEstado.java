package interfaz;

import dominio.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Observer;
import java.util.Observable;

public class VentanaPaquetesPorEstado extends javax.swing.JFrame implements Observer {

    public VentanaPaquetesPorEstado(Sistema sis) {
        modelo = sis;
        initComponents();
        javax.swing.ToolTipManager.sharedInstance().setInitialDelay(100);
        cargarTabla();
        modelo.addObserver(this);
    }
    
    private void cargarTabla() {
        javax.swing.table.DefaultTableModel tabla = (javax.swing.table.DefaultTableModel) tblPaquetes.getModel();
        String zonas[] = {"NORTE", "OESTE", "ESTE", "SUR"};
        javax.swing.JLabel[] labels = {lblNorte, lblOeste, lblEste, lblSur};
        for (int i = 0; i < 4; i++) {
            int pendiente = modelo.getPaquetesPorZonaYEstado(zonas[i], "PENDIENTE").size();
            int enviado = modelo.getPaquetesPorZonaYEstado(zonas[i], "ENVIADO").size();
            int recibido = modelo.getPaquetesPorZonaYEstado(zonas[i], "RECIBIDO").size();
            int total = pendiente + enviado + recibido;
            tabla.setValueAt(pendiente, i, 1);
            tabla.setValueAt(enviado, i, 2);
            tabla.setValueAt(recibido, i, 3);
            tabla.setValueAt(total, i, 4);
            
            labels[i].setToolTipText("<html><b>" + zonas[i] + "</b><br>"
            + "Pendiente: " + pendiente + "<br>"
            + "Enviado: "   + enviado   + "<br>"
            + "Recibido: "  + recibido  + "</html>");
        }
        
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        tblPaquetes = new javax.swing.JTable();
        lblNorte = new javax.swing.JLabel();
        lblEste = new javax.swing.JLabel();
        lblSur = new javax.swing.JLabel();
        lblOeste = new javax.swing.JLabel();
        lblMapa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Paquetes por Estado");

        tblPaquetes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"NORTE", null, null, null, null},
                {"OESTE", null, null, null, null},
                {"ESTE", null, null, null, null},
                {"SUR", null, null, null, null}
            },
            new String [] {
                "ZONA", "Pendiente", "Enviado", "Recibido", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblPaquetes.setPreferredSize(new java.awt.Dimension(500, 80));
        tblPaquetes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblPaquetesMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblPaquetes);

        lblNorte.setBackground(new java.awt.Color(0, 0, 255));
        lblNorte.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblNorte.setForeground(new java.awt.Color(255, 255, 255));
        lblNorte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblNorte.setText("NORTE");
        lblNorte.setOpaque(true);
        lblNorte.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblNorteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblNorteMouseExited(evt);
            }
        });

        lblEste.setBackground(new java.awt.Color(0, 0, 255));
        lblEste.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblEste.setForeground(new java.awt.Color(255, 255, 255));
        lblEste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblEste.setText("ESTE");
        lblEste.setOpaque(true);
        lblEste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblEsteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblEsteMouseExited(evt);
            }
        });

        lblSur.setBackground(new java.awt.Color(0, 0, 255));
        lblSur.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblSur.setForeground(new java.awt.Color(255, 255, 255));
        lblSur.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblSur.setText("SUR");
        lblSur.setOpaque(true);
        lblSur.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblSurMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblSurMouseExited(evt);
            }
        });

        lblOeste.setBackground(new java.awt.Color(0, 0, 255));
        lblOeste.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lblOeste.setForeground(new java.awt.Color(255, 255, 255));
        lblOeste.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblOeste.setText("OESTE");
        lblOeste.setOpaque(true);
        lblOeste.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblOesteMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblOesteMouseExited(evt);
            }
        });

        lblMapa.setHorizontalAlignment(javax.swing.SwingConstants.TRAILING);
        lblMapa.setIcon(new javax.swing.ImageIcon(getClass().getResource("/mapa.jpg"))); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 501, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(lblOeste, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(lblNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lblSur, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addComponent(lblEste, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMapa)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lblOeste, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(lblNorte, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(150, 150, 150)
                        .addComponent(lblSur, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(180, 180, 180)
                        .addComponent(lblEste, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(lblMapa, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        setSize(new java.awt.Dimension(579, 694));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    private void tblPaquetesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblPaquetesMouseClicked
        int fila = tblPaquetes.getSelectedRow();
        int col  = tblPaquetes.getSelectedColumn();
        if (fila >= 0 && col >= 1 && col <= 3) {
            String[] zonas   = {"NORTE", "OESTE", "ESTE", "SUR"};
            String[] estados = {"PENDIENTE", "ENVIADO", "RECIBIDO"};
            String zona   = zonas[fila];
            String estado = estados[col - 1];
            if (modelo.getPaquetesPorZonaYEstado(zona, estado).size() == 0) {
                javax.swing.JOptionPane.showMessageDialog(this, "No hay paquetes en zona " + zona + " con estado " + estado);
            } else {
                int cantClientes = modelo.getClientesPorZonaYEstado(zona, estado);
                ArrayList<String> dptos = modelo.getDptosPorZonaYEstado(zona, estado);
                String dptosTxt = "";
                for (int i = 0; i < dptos.size(); i++) {
                    if (i > 0) dptosTxt += ", ";
                    dptosTxt += dptos.get(i);
                }
                String msg = "Zona: " + zona + " - " + estado
                    + "\nClientes distintos: " + cantClientes
                    + "\nDepartamentos: " + dptosTxt;
                javax.swing.JOptionPane.showMessageDialog(this, msg);
            }
        }
    }//GEN-LAST:event_tblPaquetesMouseClicked

    private void lblNorteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNorteMouseEntered
        lblNorte.setBackground(Color.RED);
    }//GEN-LAST:event_lblNorteMouseEntered

    private void lblNorteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblNorteMouseExited
        lblNorte.setBackground(Color.BLUE);
    }//GEN-LAST:event_lblNorteMouseExited

    private void lblEsteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsteMouseEntered
        lblEste.setBackground(Color.RED);
    }//GEN-LAST:event_lblEsteMouseEntered

    private void lblEsteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblEsteMouseExited
        lblEste.setBackground(Color.BLUE);
    }//GEN-LAST:event_lblEsteMouseExited

    private void lblSurMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSurMouseEntered
        lblSur.setBackground(Color.RED);
    }//GEN-LAST:event_lblSurMouseEntered

    private void lblSurMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblSurMouseExited
        lblSur.setBackground(Color.BLUE);
    }//GEN-LAST:event_lblSurMouseExited

    private void lblOesteMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOesteMouseEntered
        lblOeste.setBackground(Color.RED);
    }//GEN-LAST:event_lblOesteMouseEntered

    private void lblOesteMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblOesteMouseExited
        lblOeste.setBackground(Color.BLUE);
    }//GEN-LAST:event_lblOesteMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblEste;
    private javax.swing.JLabel lblMapa;
    private javax.swing.JLabel lblNorte;
    private javax.swing.JLabel lblOeste;
    private javax.swing.JLabel lblSur;
    private javax.swing.JTable tblPaquetes;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;

    @Override
    public void update(Observable o, Object arg) {
        cargarTabla();
    }
}
