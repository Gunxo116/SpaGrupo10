package Views.Masajistas;

import Modelo.Masajista;
import Persistencia.MasajistaData;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MasajistasPanel extends javax.swing.JPanel{

    private int filaSeleccionadaParaEdicion = -1;

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"ID", "Nombre completo", "Telefono", "Especialidad", "Estado"}, 0
    );

    public MasajistasPanel(){
        initComponents();
        setSize(760, 516);
        configurarBordesTabla();

        cargarComboBuscar();
        cargarComboTipo();
        cargarComboEstado();

        jTable1.setModel(modelo);

        // PANELES DISEÑO
        jPanelBuscar.setOpaque(false);
        jPanelBuscar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelEditar.setOpaque(false);
        jPanelEditar.setBackground(new java.awt.Color(255, 255, 255));
        jPanelAdministador.setOpaque(false);
        jPanelAdministador.setBackground(new java.awt.Color(255, 255, 255));

        limpiarTabla();

        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                jButtonGuardarEdit.setEnabled(false);
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        String id = jTable1.getValueAt(filaSeleccionada, 0).toString();
                        String nombreCompleto = jTable1.getValueAt(filaSeleccionada, 1).toString();
                        String telefono = jTable1.getValueAt(filaSeleccionada, 2).toString();
                        String tipo = jTable1.getValueAt(filaSeleccionada, 3).toString();
                        String estado = jTable1.getValueAt(filaSeleccionada, 4).toString();

                        // Asignar los valores de la tabla en los inputs
                        jTextNombre.setText(nombreCompleto);
                        jComboTipo.setSelectedItem(tipo);
                        jTextTelefono.setText(telefono);
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
                g2.setStroke(new java.awt.BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jButtonClearFilter = new javax.swing.JButton();
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
                g2.setStroke(new java.awt.BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel4 = new javax.swing.JLabel();
        jComboBoxBuscar = new javax.swing.JComboBox<>();
        jTextBuscar = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
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
                g2.setStroke(new java.awt.BasicStroke(1));
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        jButtonGuardarEdit = new javax.swing.JButton();
        jButtonBorrar = new javax.swing.JButton();
        jButtonActualizar = new javax.swing.JButton();
        jButtonLimpiar = new javax.swing.JButton();
        jTextNombre = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextTelefono = new javax.swing.JTextField();
        jComboTipo = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Gestión Masajistas");

        jButtonClearFilter.setBackground(new java.awt.Color(33, 150, 243));
        jButtonClearFilter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClearFilter.setText("Limpiar Filtro");
        jButtonClearFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

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
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addContainerGap())
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

        jPanelEditar.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(102, 102, 102));
        jLabel5.setText("Editar Masajistas");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel6.setText("Nombre:");

        jLabel8.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel8.setText("Estado:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        comboEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboEstadoActionPerformed(evt);
            }
        });

        jButtonGuardarEdit.setBackground(new java.awt.Color(76, 175, 80));
        jButtonGuardarEdit.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarEdit.setText("Guardar");
        jButtonGuardarEdit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonGuardarEdit.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarEditActionPerformed(evt);
            }
        });

        jButtonBorrar.setBackground(new java.awt.Color(244, 67, 54));
        jButtonBorrar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonBorrar.setText("Borrar");
        jButtonBorrar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonBorrar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonBorrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBorrarActionPerformed(evt);
            }
        });

        jButtonActualizar.setBackground(new java.awt.Color(255, 152, 0));
        jButtonActualizar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonActualizar.setText("Actualizar");
        jButtonActualizar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonActualizar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar.setText("Limpiar");
        jButtonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiarActionPerformed(evt);
            }
        });

        jTextNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextNombreActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Especialidad");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Telefono:");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(218, 218, 218))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanelEditarLayout.createSequentialGroup()
                                    .addGap(73, 73, 73)
                                    .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel9)))))
                .addGap(18, 18, 18)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(45, 45, 45)
                        .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jButtonBorrar)
                        .addComponent(jButtonActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                    .addComponent(jButtonGuardarEdit)
                    .addComponent(jButtonLimpiar))
                .addGap(21, 21, 21))
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(jLabel5)
                .addContainerGap())
        );

        jPanelEditarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonActualizar, jButtonBorrar, jButtonGuardarEdit, jButtonLimpiar});

        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                .addContainerGap(22, Short.MAX_VALUE)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addComponent(jButtonGuardarEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpiar)))
                .addGap(26, 26, 26))
        );

        jPanelEditarLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboEstado, jComboTipo, jTextNombre, jTextTelefono});

        javax.swing.GroupLayout jPanelAdministadorLayout = new javax.swing.GroupLayout(jPanelAdministador);
        jPanelAdministador.setLayout(jPanelAdministadorLayout);
        jPanelAdministadorLayout.setHorizontalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClearFilter))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanelAdministadorLayout.setVerticalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jButtonClearFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelEditar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jPanel1.add(jPanelAdministador, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, 480));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed

        limpiarInputs();
        jTextBuscar.setText("");
        limpiarTabla();
        jButtonGuardarEdit.setEnabled(true);
    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuscarActionPerformed

    }//GEN-LAST:event_jComboBoxBuscarActionPerformed

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed

    }//GEN-LAST:event_jTextBuscarActionPerformed

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

        ArrayList<Masajista> resultados = MasajistaData.buscarPor(buscarPor, texto);

        if( resultados.isEmpty() ){
            JOptionPane.showMessageDialog(this,
              "No se encontraron Masajistas con " + buscarPor + ": " + texto,
              "Sin resultados",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
        } else{
            actualizarTablaConResultados(resultados);
            JOptionPane.showMessageDialog(this,
              "Se encontraron " + resultados.size() + " Masajista(s)",
              "Búsqueda exitosa",
              JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void comboEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboEstadoActionPerformed

    }//GEN-LAST:event_comboEstadoActionPerformed

    private void jButtonGuardarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarEditActionPerformed

        if( !validarFormularioMasajista(0) ){
            return;
        }

        String nombreCompleto = jTextNombre.getText().trim();
        String tipo = jComboTipo.getSelectedItem().toString();
        String telefono = jTextTelefono.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        Masajista masajista = new Masajista(nombreCompleto, telefono, tipo, estado);
        Masajista resultado = MasajistaData.guardar(masajista);

        if( resultado != null ){
            JOptionPane.showMessageDialog(this,
              "Masajista guardado exitosamente\n\n"
              + "ID: " + resultado.getId() + "\n"
              + "Nombre: " + resultado.getNombreCompleto() + "\n"
              + "Tipo: " + resultado.getEspecialidad() + "\n",
              "Guardado exitoso",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarInputs();
            limpiarTabla();
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al guardar el masajista\n\n"
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
              "Por favor, seleccione un masajista de la tabla para eliminar.",
              "Advertencia",
              JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID de la Instalacion seleccionada
        int id = Integer.parseInt(jTable1.getValueAt(filaSeleccionadaParaEdicion, 0).toString());

        // Buscar el cliente a eliminar
        Masajista masajistaAEliminar = null;
        for( Masajista m : MasajistaData.obtenerTodos() ){
            if( m.getId() == id ){
                masajistaAEliminar = m;
                break;
            }
        }

        if( masajistaAEliminar == null ){
            JOptionPane.showMessageDialog(this,
              "Instalacion no encontrada.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(
          this,
          "¿Esta seguro de que desea eliminar el masajista?\n\n"
          + "Nombre: " + masajistaAEliminar.getNombreCompleto() + "\n"
          + "ID: " + masajistaAEliminar.getId() + "\n\n"
          + "Esta acción no se puede deshacer.",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            boolean resultado = MasajistaData.borrar(id);

            if( resultado ){
                JOptionPane.showMessageDialog(this,
                  "Masajista eliminado correctamente.",
                  "Éxito",
                  JOptionPane.INFORMATION_MESSAGE);

                limpiarInputs();
                limpiarTabla();
                jButtonGuardarEdit.setEnabled(true);
                filaSeleccionadaParaEdicion = -1;

            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al eliminar el masajista.",
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
        if( !validarFormularioMasajista(id) ){
            return;
        }

        // Obtener los datos del formulario
        String nombreCompleto = jTextNombre.getText().trim();
        String tipo = jComboTipo.getSelectedItem().toString();
        String telefono = jTextTelefono.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Crear el objeto Cliente con los datos actualizados
        Masajista masajista = new Masajista(nombreCompleto, telefono, tipo, estado);
        masajista.setId(id);

        // Buscar el cliente a actualizar
        Masajista tratamientoAActualizar = null;
        for( Masajista i : MasajistaData.obtenerTodos() ){
            if( i.getId() == id ){
                tratamientoAActualizar = i;
                break;
            }
        }

        if( tratamientoAActualizar == null ){
            JOptionPane.showMessageDialog(this,
              "Instalacion no encontrada.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar el cliente
        boolean resultado = MasajistaData.actualizar(masajista);

        if( resultado ){
            JOptionPane.showMessageDialog(this,
              "Masajista actualizado correctamente.\n\n"
              + "ID: " + masajista.getId() + "\n"
              + "Nombre: " + masajista.getNombreCompleto() + "\n",
              "Éxito",
              JOptionPane.INFORMATION_MESSAGE);

            // Limpiar y actualizar
            limpiarInputs();
            limpiarTabla();
            jButtonGuardarEdit.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al actualizar el masajista.\n"
              + "Por favor verifique los datos e intente nuevamente.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiarActionPerformed

        limpiarInputs();
        jButtonGuardarEdit.setEnabled(true);
    }//GEN-LAST:event_jButtonLimpiarActionPerformed

    private void jTextNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextNombreActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextNombreActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonBorrar;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JButton jButtonGuardarEdit;
    private javax.swing.JButton jButtonLimpiar;
    private javax.swing.JComboBox<String> jComboBoxBuscar;
    private javax.swing.JComboBox<String> jComboTipo;
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
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextTelefono;
    // End of variables declaration//GEN-END:variables
    private boolean validarFormularioMasajista(int idMasajista){

        String nombre = jTextNombre.getText().trim();
        String telefono = jTextTelefono.getText().trim();

        // Validar Nombre
        if( nombre.isEmpty() ){
            mostrarError("El Nombre es obligatorio", jTextNombre);
            return false;
        }
        if( nombre.length() < 3 ){
            mostrarError("El Nombre debe tener al menos 3 caracteres", jTextNombre);
            return false;
        }

        // Validar Tipo
        if( jComboTipo.getSelectedItem() == null ){
            mostrarError("Debe seleccionar un Tipo", jComboTipo);
            return false;
        }

        // Validar Teléfono
        if( telefono.isEmpty() ){
            mostrarError("El Teléfono es obligatorio", jTextTelefono);
            return false;
        }

        if( !telefono.matches("\\d+") ){
            mostrarError("El Teléfono debe contener solo números", jTextTelefono);
            return false;
        }

        if( telefono.length() < 7 || telefono.length() > 15 ){
            mostrarError("El Teléfono debe tener entre 7 y 15 dígitos", jTextTelefono);
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

    private void limpiarInputs(){

        jTextNombre.setText(null);
        jTextTelefono.setText(null);
        comboEstado.setSelectedIndex(0);
        jComboTipo.setSelectedIndex(0);

    }

    private void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Masajista m : MasajistaData.obtenerTodos() ){
            modelo.addRow(new Object[]{
                m.getId(),
                m.getNombreCompleto(),
                m.getTelefono(),
                m.getEspecialidad(),
                m.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    private void cargarComboTipo(){
        jComboTipo.removeAllItems();
        jComboTipo.addItem("Relajacion");
        jComboTipo.addItem("Facial");
        jComboTipo.addItem("Corporal");
        jComboTipo.addItem("Estetico");
    }

    private void cargarComboEstado(){
        comboEstado.removeAllItems();
        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");
    }

    private void cargarComboBuscar(){
        jComboBoxBuscar.removeAllItems();
        jComboBoxBuscar.addItem("ID");
        jComboBoxBuscar.addItem("Nombre");
        jComboBoxBuscar.addItem("Especialidad");
        jComboBoxBuscar.addItem("Estado");
    }

    private void actualizarTablaConResultados(ArrayList<Masajista> masajista){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Masajista m : masajista ){
            modelo.addRow(new Object[]{
                m.getId(),
                m.getNombreCompleto(),
                m.getTelefono(),
                m.getEspecialidad(),
                m.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    private void configurarBordesTabla(){
        // Hacer transparente para que se vea el borde personalizado
        jScrollPane1.setOpaque(false);
        jScrollPane1.getViewport().setOpaque(false);

        jScrollPane1.setBorder(new javax.swing.border.AbstractBorder(){
            @Override
            public void paintBorder(Component c, Graphics g, int x, int y, int width, int height){
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Fondo blanco redondeado
                g2.setColor(java.awt.Color.WHITE);
                g2.fillRoundRect(x, y, width - 1, height - 1, 15, 15);

                // Borde gris redondeado
                g2.setColor(new java.awt.Color(200, 200, 200));
                g2.setStroke(new java.awt.BasicStroke(1));
                g2.drawRoundRect(x + 1, y + 1, width - 3, height - 3, 15, 15);

                g2.dispose();
            }

            @Override
            public Insets getBorderInsets(Component c){
                return new Insets(5, 5, 5, 5);
            }

            @Override
            public Insets getBorderInsets(Component c, Insets insets){
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
