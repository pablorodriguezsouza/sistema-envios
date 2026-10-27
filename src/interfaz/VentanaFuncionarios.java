package interfaz;

import dominio.*;
import java.io.IOException;
import java.util.Observer;
import java.util.Observable;

public class VentanaFuncionarios extends javax.swing.JFrame implements Observer {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(VentanaFuncionarios.class.getName());

    public VentanaFuncionarios(Sistema sis) {
        modelo = sis;
        initComponents();
        Estilo.aplicar(this, "Funcionarios", "Ordenados por año de ingreso, del más reciente al más antiguo");
        Estilo.botonPrincipal(btnAgregar);
        cargarLista();
        modelo.addObserver(this);
    }
    
    private void cargarLista() {
        lstFuncionarios.setListData(modelo.getFuncionariosOrdenados().toArray());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstFuncionarios = new javax.swing.JList();
        txtNombre = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtCelular = new javax.swing.JTextField();
        txtNumFuncionario = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtAñoIngreso = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        btnModificar = new javax.swing.JButton();
        btnAgregar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lstFuncionarios.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstFuncionariosValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(lstFuncionarios);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel1.setText("Nombre");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel2.setText("Celular");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel3.setText("N°");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setText("Lista de Funcionarios");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 13)); // NOI18N
        jLabel4.setText("Año Ingreso");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnAgregar.setText("Agregar");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(txtNumFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAgregar)
                        .addGap(59, 59, 59)
                        .addComponent(btnModificar)
                        .addGap(14, 14, 14)))
                .addContainerGap(37, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtNumFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtAñoIngreso, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(62, 62, 62)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 265, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(66, Short.MAX_VALUE))
        );

        layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {txtCelular, txtNombre, txtNumFuncionario});

        setSize(new java.awt.Dimension(574, 389));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        dominio.Funcionario seleccionado = (dominio.Funcionario) lstFuncionarios.getSelectedValue();
        if (seleccionado == null) {
            javax.swing.JOptionPane.showMessageDialog(this, "Seleccioná un funcionario de la lista");
        } else {
            String nombre = txtNombre.getText().trim();
            String celular = txtCelular.getText().trim();
            String num = txtNumFuncionario.getText().trim();
            String año = txtAñoIngreso.getText().trim();
            if (nombre.equals("") || celular.equals("") || num.equals("") || año.equals("")) {
               javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios"); 
            } else {
                try {
                    int numInt = Integer.parseInt(num);
                    int añoInt = Integer.parseInt(año);
                    if (String.valueOf(añoInt).length() != 4) {
                        javax.swing.JOptionPane.showMessageDialog(this, "El año debe tener 4 dígitos");
                    } else {
                        if (!modelo.modificarFuncionario(seleccionado, nombre, celular, numInt, añoInt)) {
                            if (modelo.existeComoCliente(nombre)) {
                                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese nombre");
                            } else {
                                javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un funcionario con ese nombre");
                            }
                        } else {
                            lstFuncionarios.clearSelection();
                        }
                    }
                } catch (NumberFormatException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "N° y Año deben ser numéricos");
                } catch (IOException e) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No se pudo escribir en el log de transacciones");
                }
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        String nombre = txtNombre.getText().trim();
        String celular = txtCelular.getText().trim();
        String num = txtNumFuncionario.getText().trim();
        String año = txtAñoIngreso.getText().trim();
        if (nombre.equals("") || celular.equals("") || num.equals("") || año.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(this, "Todos los campos son obligatorios");
        } else {
            try {
                int numInt = Integer.parseInt(num);
                int añoInt = Integer.parseInt(año);
                if (String.valueOf(añoInt).length() != 4) {
                    javax.swing.JOptionPane.showMessageDialog(this, "El año debe tener 4 dígitos");
                } else {
                    if (!modelo.addFuncionario(nombre, celular, numInt, añoInt)) {
                        if (modelo.existeComoCliente(nombre)) {
                            javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un cliente con ese nombre");
                        } else {
                            javax.swing.JOptionPane.showMessageDialog(this, "Ya existe un funcionario con ese nombre");
                        }
                    } else {
                        txtNombre.setText("");
                        txtCelular.setText("");
                        txtNumFuncionario.setText("");
                        txtAñoIngreso.setText("");
                    }
                }    
            } catch (NumberFormatException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "N° y Año deben ser numéricos");
            } catch (IOException e) {
                javax.swing.JOptionPane.showMessageDialog(this, "No se pudo escribir en el log de transacciones");
            }
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void lstFuncionariosValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_lstFuncionariosValueChanged
        dominio.Funcionario f = (dominio.Funcionario) lstFuncionarios.getSelectedValue();
        if (f != null) {
            txtNombre.setText(f.getNombre());
            txtCelular.setText(f.getCelular());
            txtNumFuncionario.setText(f.getNumFuncionario() + "");
            txtAñoIngreso.setText(f.getAñoIngreso() + "");
        } else {
            txtNombre.setText("");
            txtCelular.setText("");
            txtNumFuncionario.setText("");
            txtAñoIngreso.setText("");
        }
    }//GEN-LAST:event_lstFuncionariosValueChanged


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList lstFuncionarios;
    private javax.swing.JTextField txtAñoIngreso;
    private javax.swing.JTextField txtCelular;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumFuncionario;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    
    @Override
    public void update(Observable o, Object arg) {
        cargarLista();
    }
}
