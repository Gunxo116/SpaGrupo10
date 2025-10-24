
package Views.Instalaciones;

import Modelo.Instalacion;
import Persistencia.InstalacionData;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class InstalacionesPanel extends javax.swing.JPanel {
    
    private int filaSeleccionadaParaEdicion = -1;
    
    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"ID", "Nombre", "Detalles de uso", "Precio 30min","Estado"}, 0
    );

    public InstalacionesPanel() {
        initComponents();
        setSize(760, 522);
        configurarBordesTabla();
        jTable1.setModel(modelo);
        
        // TAMAÑOS DE LA COLUMNAS
        int[] anchos = {20, 60, 200, 60, 40};
        for (int i = 0; i < anchos.length; i++) {
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        jPanelBuscar.setOpaque(false);
        jPanelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        
        jPanelAdministador.setOpaque(false);
        jPanelAdministador.setBackground(new java.awt.Color(255, 255, 255));
        
        jPanelEditar.setOpaque(false);
        jPanelEditar.setBackground(new java.awt.Color(255, 255, 255));
        
        cargarCombo();
        cargarComboEstado();
        limpiarTabla();
        
        // Funcion para que al hacer click sobre un alumno se cargue la información en el formulario de edición
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                jButtonGuardarEdit.setEnabled(false);
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        String id = jTable1.getValueAt(filaSeleccionada, 0).toString();
                        String nombre = jTable1.getValueAt(filaSeleccionada, 1).toString();
                        String detalles = jTable1.getValueAt(filaSeleccionada, 2).toString();
                        String precio30m = jTable1.getValueAt(filaSeleccionada, 3).toString().replace("$", ""); // ← QUITAR EL $
                        String estado = jTable1.getValueAt(filaSeleccionada, 4).toString();
                        // Asignar los valores de la tabla en los inputs
                        jTextNombre.setText(nombre);
                        jTextDetallesUso.setText(detalles);
                        jTextPrecio.setText(precio30m);
                        comboEstado.setSelectedItem(estado);
                    }
                }
            }
        });
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanelAdministador = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Dibujar borde gris redondeado
                g2.setColor(new java.awt.Color(200, 200, 200));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jPanelEditar = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Dibujar borde gris redondeado
                g2.setColor(new java.awt.Color(200, 200, 200));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jTextDetallesUso = new javax.swing.JTextField();
        jTextNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextPrecio = new javax.swing.JTextField();
        jButtonGuardarEdit = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanelBuscar = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Dibujar borde gris redondeado
                g2.setColor(new java.awt.Color(200, 200, 200));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel4 = new javax.swing.JLabel();
        jComboBoxBuscar = new javax.swing.JComboBox<>();
        jTextBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jButtonClearFilter = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelEditar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Editar Instalacion");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Detalle de uso:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        jTextDetallesUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextDetallesUsoActionPerformed(evt);
            }
        });

        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Precio 30min:");

        jTextPrecio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextPrecioActionPerformed(evt);
            }
        });

        jButtonGuardarEdit.setBackground(new java.awt.Color(76, 175, 80));
        jButtonGuardarEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarEdit.setText("Guardar");
        jButtonGuardarEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonGuardarEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarEditActionPerformed(evt);
            }
        });

        jButtonBorrar.setBackground(new java.awt.Color(244, 67, 54));
        jButtonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonActualizar.setBackground(new java.awt.Color(255, 152, 0));
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGuardarEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButtonBorrar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButtonActualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButtonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(76, 76, 76))
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6)
                                .addComponent(jLabel9)
                                .addGap(6, 6, 6)
                                .addComponent(jTextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDetallesUso, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(19, 19, 19))
        );
        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jTextPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextDetallesUso, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardarEdit)
                    .addComponent(jButtonBorrar)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonLimpiar))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Gestión Instalaciones");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        jPanelBuscar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Buscar Por:");

        jComboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBuscarActionPerformed(evt);
            }
        });

        jTextBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextBuscarActionPerformed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(76, 175, 80));
        jButtonBuscar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBuscar)
                .addGap(16, 16, 16))
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelBuscarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonBuscar, jComboBoxBuscar, jLabel4, jTextBuscar});

        jButtonClearFilter.setBackground(new java.awt.Color(33, 150, 243));
        jButtonClearFilter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClearFilter.setText("Limpiar Filtro");
        jButtonClearFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdministadorLayout = new javax.swing.GroupLayout(jPanelAdministador);
        jPanelAdministador.setLayout(jPanelAdministadorLayout);
        jPanelAdministadorLayout.setHorizontalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClearFilter))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
        );
        jPanelAdministadorLayout.setVerticalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonClearFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel1.add(jPanelAdministador, new org.netbeans.lib.awtextra.AbsoluteConstraints(62, 6, -1, 510));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 760, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuscarActionPerformed

    }//GEN-LAST:event_jComboBoxBuscarActionPerformed

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed

    }//GEN-LAST:event_jTextBuscarActionPerformed

    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed

        limpiarInputs();
        jTextBuscar.setText("");
        limpiarTabla();
        jButtonGuardarEdit.setEnabled(true);
        
    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        
        String buscarPor = (String) jComboBoxBuscar.getSelectedItem();
        String texto = jTextBuscar.getText().trim();

        if( texto.isEmpty() ){
            limpiarTabla();
            return;
        }

        if( buscarPor.equals("ID") ){
            try{
                Integer.parseInt(texto);
            } catch( NumberFormatException e ){
                JOptionPane.showMessageDialog(this,
                  "El ID debe ser un numero",
                  "Error de formato",
                  JOptionPane.ERROR_MESSAGE);
                jTextBuscar.setText("");
                return;
            }
        }

        ArrayList<Instalacion> resultados = InstalacionData.buscarPor(buscarPor, texto);

        if( resultados.isEmpty() ){
            JOptionPane.showMessageDialog(this,
              "No se encontraron Instalaciones con " + buscarPor + ": " + texto,
              "Sin resultados",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
        } else{
            actualizarTablaConResultados(resultados);
            JOptionPane.showMessageDialog(this,
              "Se encontraron " + resultados.size() + " Instalaciones(s)",
              "Búsqueda exitosa",
              JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed
    }//GEN-LAST:event_comboEstadoActionPerformed
    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
    }//GEN-LAST:event_jTextNombreActionPerformed
    private void jTextDetallesUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextDetallesUsoActionPerformed
    }//GEN-LAST:event_jTextDetallesUsoActionPerformed
    private void jTextPrecioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextPrecioActionPerformed
    }//GEN-LAST:event_jTextPrecioActionPerformed
    private void jButtonGuardarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarEditActionPerformed
        
        if( !validarFormularioCliente(0) ){
            return;
        }

        String nombre = jTextNombre.getText().trim();
        String precio30mTexto = jTextPrecio.getText().trim();
        String detalleUso = jTextDetallesUso.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Convertir precio a double
        double precio30m = Double.parseDouble(precio30mTexto);

        // Crear objeto Instalacion
        Instalacion instalacion = new Instalacion(nombre, detalleUso, precio30m, estado);

        // Guardar la instalación
        Instalacion resultado = InstalacionData.guardar(instalacion);

        if( resultado != null ){
            JOptionPane.showMessageDialog(this,
              "Instalacion guardada exitosamente\n\n"
              + "ID: " + resultado.getIdInstalacion() + "\n"
              + "Nombre: " + resultado.getNombre() + "\n"
              + "Precio 30min: $" + resultado.getPrecio30m(),
              "Guardado exitoso",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarInputs();
            limpiarTabla();
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al guardar la instalacion\n\n"
              + "Por favor verifique los datos e intente nuevamente",
              "Error al guardar",
              JOptionPane.ERROR_MESSAGE);
        }
        limpiarInputs();
        limpiarTabla();
        filaSeleccionadaParaEdicion = -1;
        
    }//GEN-LAST:event_jButtonGuardarEditActionPerformed

    private void jButtonBorrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBorrarActionPerformed
        
        // Verificar que haya una fila seleccionada
        int filaSeleccionadaParaEdicion = jTable1.getSelectedRow();
        if( filaSeleccionadaParaEdicion == -1 ){
            JOptionPane.showMessageDialog(this,
              "Por favor, seleccione una Instalacion de la tabla para eliminar.",
              "Advertencia",
              JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID de la Instalacion seleccionada
        int id = Integer.parseInt(jTable1.getValueAt(filaSeleccionadaParaEdicion, 0).toString());

        // Buscar el cliente a eliminar
        Instalacion InstalacionAEliminar = null;
        for( Instalacion i : InstalacionData.obtenerTodas() ){
            if( i.getIdInstalacion()== id ){
                InstalacionAEliminar = i;
                break;
            }
        }

        if( InstalacionAEliminar == null ){
            JOptionPane.showMessageDialog(this,
              "Instalacion no encontrada.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(
          this,
          "¿Esta seguro de que desea eliminar la Instalacion?\n\n"
          + "Nombre: " + InstalacionAEliminar.getNombre()+ "\n"
          + "ID: " + InstalacionAEliminar.getIdInstalacion()+ "\n\n"
          + "Esta acción no se puede deshacer.",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            boolean resultado = InstalacionData.eliminar(id);

            if( resultado ){
                JOptionPane.showMessageDialog(this,
                  "Cliente eliminado correctamente.",
                  "Éxito",
                  JOptionPane.INFORMATION_MESSAGE);

                limpiarInputs();
                limpiarTabla();
                jButtonGuardarEdit.setEnabled(true);
                filaSeleccionadaParaEdicion = -1;
                
            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al eliminar el cliente.",
                  "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
        }
        
    }//GEN-LAST:event_jButtonBorrarActionPerformed

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        
        // Verificar que haya una fila seleccionada
        int filaSeleccionadaParaEdicion = jTable1.getSelectedRow();
        if( filaSeleccionadaParaEdicion == -1 ){
            JOptionPane.showMessageDialog(this,
              "Por favor, seleccione una Instalacion de la tabla para actualizar.",
              "Advertencia",
              JOptionPane.WARNING_MESSAGE);
            return;
        }
        // Obtener el ID del cliente seleccionado
        int id = Integer.parseInt(jTable1.getValueAt(filaSeleccionadaParaEdicion, 0).toString());
        // Validar el formulario
        if( !validarFormularioCliente(id) ){
            return;
        }

        // Obtener los datos del formulario
        String nombre = jTextNombre.getText().trim();
        String precio30mTexto = jTextPrecio.getText().trim();
        String detalleUso = jTextDetallesUso.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Convertir precio a double
        double precio30m = Double.parseDouble(precio30mTexto);

        // Crear el objeto Cliente con los datos actualizados
        Instalacion instalacion = new Instalacion(nombre, detalleUso, precio30m, estado);
        instalacion.setIdInstalacion(id); 

        // Buscar el cliente a actualizar
        Instalacion clienteAActualizar = null;
        for( Instalacion i : InstalacionData.obtenerTodas() ){
            if( i.getIdInstalacion()== id ){
                clienteAActualizar = i;
                break;
            }
        }

        if( clienteAActualizar == null ){
            JOptionPane.showMessageDialog(this,
              "Instalacion no encontrada.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar el cliente
        boolean resultado = InstalacionData.actualizar(instalacion);

        if( resultado ){
            JOptionPane.showMessageDialog(this,
              "Instalacion actualizada correctamente.\n\n"
              + "ID: " + instalacion.getIdInstalacion()+ "\n"
              + "Nombre: " + instalacion.getNombre()+ "\n",
              "Éxito",
              JOptionPane.INFORMATION_MESSAGE);

            // Limpiar y actualizar
            limpiarInputs();
            limpiarTabla();
            jButtonGuardarEdit.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al actualizar la Instalacion.\n"
              + "Por favor verifique los datos e intente nuevamente.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        }
        
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed
        
        limpiarInputs();
        jButtonGuardarEdit.setEnabled(true);
        
    }//GEN-LAST:event_jButtonLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JButton jButtonGuardarEdit;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdministador;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextDetallesUso;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextPrecio;
    // End of variables declaration//GEN-END:variables


    private void cargarCombo(){
            jComboBoxBuscar.removeAllItems();
            jComboBoxBuscar.addItem("ID");
            jComboBoxBuscar.addItem("Nombre");
            jComboBoxBuscar.addItem("Estado");
    }
    
    private void cargarComboEstado(){
        comboEstado.removeAllItems();
        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");
    }
    
    private void limpiarInputs(){
        jTextNombre.setText(null);
        jTextPrecio.setText(null);
        jTextDetallesUso.setText(null);
        comboEstado.setSelectedIndex(0);
    }
    
    private void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Instalacion p : InstalacionData.obtenerTodas() ){
            modelo.addRow(new Object[]{
                p.getIdInstalacion(),
                p.getNombre(),
                p.getDetalleUso(),
                "$"+p.getPrecio30m(),
                p.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }
    
    
    private void actualizarTablaConResultados(ArrayList<Instalacion> instalacion){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Instalacion i : instalacion ){
            modelo.addRow(new Object[]{
                i.getIdInstalacion(),
                i.getNombre(),
                i.getDetalleUso(),
                "$"+i.getPrecio30m(),
                i.isEstado() ? "Activo" : "Inactivo"
            });
        }
    }
    
    private boolean validarFormularioCliente(int idCliente){
        String nombre = jTextNombre.getText().trim();
        String precio30m = jTextPrecio.getText().trim();
        String detalleUso = jTextDetallesUso.getText().trim();

        // Validar Nombre Completo
        if( nombre.isEmpty() ){
            mostrarError("El Nombre es obligatorio", jTextNombre);
            return false;
        }
        if( nombre.length() < 3 ){
            mostrarError("El Nombre debe tener al menos 3 caracteres", jTextNombre);
            return false;
        }
        
        // Validar Edad
       if( precio30m.isEmpty() ){
            mostrarError("El precio es obligatorio", jTextPrecio);
            return false;
        }
        try{
            double precio30mNumerico = Double.parseDouble(precio30m.replace(",", "."));
            if( precio30mNumerico <= 0 ){
                mostrarError("El precio debe ser mayor a 0", jTextPrecio);
                return false;
            }
        } catch( NumberFormatException e ){
            mostrarError("El precio debe ser un número válido", jTextPrecio);
            return false;
        }

        // Validar Afecciones
        if( detalleUso.length() > 200 ){
            mostrarError("Las Afecciones no pueden superar los 200 caracteres", jTextDetallesUso);
            return false;
        }

        // Validar Estado
        if( comboEstado.getSelectedItem() == null ){
            mostrarError("Debe seleccionar un Estado", comboEstado);
            return false;
        }

        return true;
    }
    
    private void mostrarError(String mensaje, Component componente){
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
        componente.requestFocus();
    }
    
    private void configurarBordesTabla(){
        // Hacer transparente para que se vea el borde personalizado
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jScrollPane1.setBorder(new javax.swing.border.AbstractBorder() {
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fondo blanco redondeado
                g2.setColor(java.awt.Color.WHITE);
                g2.fillRoundRect(x, y, width - 1, height - 1, 15, 15);

                // Borde gris redondeado
                g2.setColor(new java.awt.Color(200, 200, 200));
                g2.setStroke(new java.awt.BasicStroke(2));
                g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, 15, 15);

                g2.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c) {
                return new Insets(5, 5, 5, 5);
            }

            @Override
            public Insets getBorderInsets(Component c, Insets insets) {
                insets.left = insets.right = insets.top = insets.bottom = 5;
                return insets;
            }
        });
    }
    

}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
