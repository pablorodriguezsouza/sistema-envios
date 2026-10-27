package interfaz;

import dominio.*;
import java.util.Observer;
import java.util.Observable;
import java.util.ArrayList;

public class VentanaConsultaPorCliente extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaConsultaPorCliente.class.getName());

    public VentanaConsultaPorCliente(Sistema sis) {
        modelo = sis;
        initComponents();
        Estilo.aplicar(this, "Consulta por cliente", "Estado de los paquetes enviados por cada cliente");
        cargarLista();
        lblPendientes.setVisible(false);
        lblRecibidos.setVisible(false);
        lblTotal.setVisible(false);
        lblEnviados.setVisible(false);
        modelo.addObserver(this);
    }
    
    private void cargarLista() {
        lstClientes.setListData(modelo.getClienteOrdenados().toArray());
    }
    
    private void mostrarInfoCliente() {
        Cliente c = (Cliente) lstClientes.getSelectedValue();
        if (c != null) {
            ArrayList<Paquete> paquetes = modelo.getPaquetesPorCliente(c);
            int pendiente = 0;
            int enviado = 0;
            int recibido = 0;
            for (Paquete p : paquetes) {
                switch (p.getEstado()) {
                    case "PENDIENTE":
                        pendiente++;
                        break;
                    case "ENVIADO":
                        enviado++;
                        break;
                    case "RECIBIDO":
                        recibido++;
                        break;
                }
            }
            lblMsgInicial.setVisible(false);
            lblPendientes.setText("Pendiente: " + pendiente);
            lblPendientes.setVisible(true);
            lblEnviados.setText("Enviado: " + enviado);
            lblEnviados.setVisible(true);
            lblRecibidos.setText("Recibido: " + recibido);
            lblRecibidos.setVisible(true);
            lblTotal.setText("Total: " + paquetes.size());
            lblTotal.setVisible(true);
            
        }
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstClientes = new javax.swing.JList();
        jLabel1 = new javax.swing.JLabel();
        lblPendientes = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        lblTotal = new javax.swing.JLabel();
        lblEnviados = new javax.swing.JLabel();
        lblRecibidos = new javax.swing.JLabel();
        lblMsgInicial = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lstClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(lstClientes);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Lista de Clientes");

        lblPendientes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblPendientes.setText("Pendientes: ");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel2.setText("Información de Cliente:");

        lblTotal.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        lblTotal.setText("TOTAL: ");

        lblEnviados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblEnviados.setText("Enviados: ");

        lblRecibidos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblRecibidos.setText("Recibidos: ");

        lblMsgInicial.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lblMsgInicial.setText("[Selecciona un cliente]");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(76, 76, 76)
                .addComponent(jLabel1))
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblPendientes)
                            .addComponent(lblEnviados)
                            .addComponent(lblRecibidos)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(43, 43, 43)
                                .addComponent(lblMsgInicial))
                            .addComponent(lblTotal)))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(lblPendientes)
                        .addGap(14, 14, 14)
                        .addComponent(lblEnviados)
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addComponent(lblRecibidos))
                            .addComponent(lblMsgInicial))
                        .addGap(14, 14, 14)
                        .addComponent(lblTotal))))
        );

        setSize(new java.awt.Dimension(574, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void lstClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lstClientesMouseClicked
        mostrarInfoCliente();
    }//GEN-LAST:event_lstClientesMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblEnviados;
    private javax.swing.JLabel lblMsgInicial;
    private javax.swing.JLabel lblPendientes;
    private javax.swing.JLabel lblRecibidos;
    private javax.swing.JLabel lblTotal;
    private javax.swing.JList lstClientes;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    
    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
        mostrarInfoCliente();
    }
}
