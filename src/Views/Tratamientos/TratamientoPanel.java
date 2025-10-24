
package Views.Tratamientos;

import Modelo.Tratamiento;
import Persistencia.TratamientoData;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


public class TratamientoPanel extends javax.swing.JPanel {
    
    private int filaSeleccionadaParaEdicion = -1;
    
    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"ID", "Nombre", "Tipo", "Detalle", "Duracion","Costo","Estado"}, 0
    );

    public TratamientoPanel() {
        initComponents();
        setSize(760, 516);
        configurarBordesTabla();
        
        cargarComboBuscar();
        cargarComboTipo();
        cargarComboEstado();
        
        jTable1.setModel(modelo);
        // TAMAÑOS DE LA COLUMNAS
        int[] anchos = {20, 50, 40, 200, 35 ,45,35};
        for (int i = 0; i < anchos.length; i++) {
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
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
                            String nombre = jTable1.getValueAt(filaSeleccionada, 1).toString();
                            String tipo = jTable1.getValueAt(filaSeleccionada, 2).toString();
                            String detalle = jTable1.getValueAt(filaSeleccionada, 3).toString();
                            String duracion = jTable1.getValueAt(filaSeleccionada, 4).toString().replace(" min", "");
                            String costo = jTable1.getValueAt(filaSeleccionada, 5).toString().replace("$", "");
                            String estado = jTable1.getValueAt(filaSeleccionada, 6).toString();

                            // Asignar los valores de la tabla en los inputs
                            jTextNombre.setText(nombre);
                            jComboTipo.setSelectedItem(tipo);
                            jTextDetalle.setText(detalle);
                            jTextDuracion.setText(duracion);
                            jTextCosto.setText(costo);
                            comboEstado.setSelectedItem(estado);

                            // BUSCAR EL PRODUCTO ASOCIADO EN LA BASE DE DATOS
                            try {
                                int idTratamiento = Integer.parseInt(id);
                                Tratamiento tratamiento = TratamientoData.buscarPorId(idTratamiento);

                                if (tratamiento != null && tratamiento.getProductos() != null && !tratamiento.getProductos().trim().isEmpty()) {
                                    // Si tiene producto(s), mostrarlo
                                    jTextProducto.setText(tratamiento.getProductos());
                                } else {
                                    // Si no tiene producto, dejar vacío
                                    jTextProducto.setText("");
                                }
                            } catch (Exception ex) {
                                // En caso de error, dejar vacío
                                jTextProducto.setText("");
                                System.err.println("Error al cargar productos: " + ex.getMessage());
                            }
                        }
                    }
                }
            });
        
        
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jOptionPane1 = new javax.swing.JOptionPane();
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
                g2.setStroke(new java.awt.BasicStroke(2));
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
        jTextDuracion = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jTextCosto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jTextDetalle = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jTextProducto = new javax.swing.JTextField();
        jComboTipo = new javax.swing.JComboBox<>();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setText("Gestión Trataminetos");

        jButtonClearFilter.setBackground(new java.awt.Color(33, 150, 243));
        jButtonClearFilter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClearFilter.setText("Limpiar Filtro");
        jButtonClearFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
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
        jLabel5.setText("Editar Trataminetos");

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

        jLabel7.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel7.setText("Tipo");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel9.setText("Durarion:");

        jLabel10.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel10.setText("Costo");

        jTextCosto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextCostoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel11.setText("Detalle:");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jLabel12.setText("Producto:");

        jComboTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanelEditarLayout = new javax.swing.GroupLayout(jPanelEditar);
        jPanelEditar.setLayout(jPanelEditarLayout);
        jPanelEditarLayout.setHorizontalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jLabel6))
                                    .addComponent(jLabel11))
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addComponent(jLabel7))
                                            .addGroup(jPanelEditarLayout.createSequentialGroup()
                                                .addGap(18, 18, 18)
                                                .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextCosto)
                                            .addComponent(jComboTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addGap(20, 20, 20)
                                        .addComponent(jTextDetalle))))
                            .addComponent(jLabel9)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel8))
                                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(260, 260, 260))
                                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jTextProducto)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButtonBorrar)
                                .addComponent(jButtonActualizar, javax.swing.GroupLayout.Alignment.TRAILING))
                            .addComponent(jButtonGuardarEdit)
                            .addComponent(jButtonLimpiar)))
                    .addComponent(jLabel5))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        jPanelEditarLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonActualizar, jButtonBorrar, jButtonGuardarEdit, jButtonLimpiar});

        jPanelEditarLayout.setVerticalGroup(
            jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEditarLayout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jComboTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDuracion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextDetalle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 123, Short.MAX_VALUE)
                        .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelEditarLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonGuardarEdit)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBorrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonActualizar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonLimpiar)
                        .addGap(8, 8, 8)))
                .addGroup(jPanelEditarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelEditar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(13, 13, 13))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(jPanelAdministador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAdministador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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

        ArrayList<Tratamiento> resultados = TratamientoData.buscarPor(buscarPor, texto);

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

    private void jButtonGuardarEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarEditActionPerformed
        
        if( !validarFormularioTratamiento(0) ){
            return;
        }

        String nombre = jTextNombre.getText().trim();
        String tipo = jComboTipo.getSelectedItem().toString();
        String duracion = jTextDuracion.getText().trim();
        String costoTexto = jTextCosto.getText().trim();
        String detalle = jTextDetalle.getText().trim();
        String producto = jTextProducto.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Convertir a int y double
        int duracionInt = Integer.parseInt(duracion);
        double costo = Double.parseDouble(costoTexto);

        Tratamiento tratamiento = new Tratamiento(nombre, tipo, detalle, producto, duracionInt, costo, estado);
        Tratamiento resultado = TratamientoData.guardar(tratamiento);

        if( resultado != null ){
            JOptionPane.showMessageDialog(this,
              "Tratamiento guardado exitosamente\n\n"
              + "ID: " + resultado.getIdTratamiento() + "\n"
              + "Nombre: " + resultado.getNombre() + "\n"
              + "Tipo: " + resultado.getTipo() + "\n"
              + "Costo: $" + resultado.getCosto(),
              "Guardado exitoso",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarInputs();
            limpiarTabla();
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al guardar el tratamiento\n\n"
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
        Tratamiento TratamientoAEliminar = null;
        for( Tratamiento i : TratamientoData.obtenerTodos()){
            if( i.getIdTratamiento()== id ){
                TratamientoAEliminar = i;
                break;
            }
        }

        if( TratamientoAEliminar == null ){
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
          + "Nombre: " + TratamientoAEliminar.getNombre()+ "\n"
          + "ID: " + TratamientoAEliminar.getIdTratamiento()+ "\n\n"
          + "Esta acción no se puede deshacer.",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            boolean resultado = TratamientoData.eliminar(id);

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
        if( !validarFormularioTratamiento(id) ){
            return;
        }

        // Obtener los datos del formulario
        String nombre = jTextNombre.getText().trim();
        String tipo = jComboTipo.getSelectedItem().toString();
        String duracion = jTextDuracion.getText().trim();
        String costoTexto = jTextCosto.getText().trim();
        String detalle = jTextDetalle.getText().trim();
        String producto = jTextProducto.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Convertir precio a double
        int duracionInt = Integer.parseInt(duracion);
        double costo = Double.parseDouble(costoTexto);

        // Crear el objeto Cliente con los datos actualizados
        Tratamiento tratamiento = new Tratamiento(nombre, tipo, duracion, producto, duracionInt, costo, estado);
        tratamiento.setIdTratamiento(id); 

        // Buscar el cliente a actualizar
        Tratamiento tratamientoAActualizar = null;
        for( Tratamiento i : TratamientoData.obtenerTodos()){
            if( i.getIdTratamiento()== id ){
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
        boolean resultado = TratamientoData.actualizar(tratamiento);

        if( resultado ){
            JOptionPane.showMessageDialog(this,
              "Instalacion actualizada correctamente.\n\n"
              + "ID: " + tratamiento.getIdTratamiento()+ "\n"
              + "Nombre: " + tratamiento.getNombre()+ "\n",
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

    private void jTextCostoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextCostoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextCostoActionPerformed


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
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JOptionPane jOptionPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdministador;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JPanel jPanelEditar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTextField jTextCosto;
    private javax.swing.JTextField jTextDetalle;
    private javax.swing.JTextField jTextDuracion;
    private javax.swing.JTextField jTextNombre;
    private javax.swing.JTextField jTextProducto;
    // End of variables declaration//GEN-END:variables

    private boolean validarFormularioTratamiento(int idTratamiento){
    
        String nombre = jTextNombre.getText().trim();
        String duracion = jTextDuracion.getText().trim();
        String detalle = jTextDetalle.getText().trim();
        String costo = jTextCosto.getText().trim();

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

        // Validar Duración
        if( duracion.isEmpty() ){
            mostrarError("La Duración es obligatoria", jTextDuracion);
            return false;
        }
        try{
            int duracionNumerica = Integer.parseInt(duracion);
            if( duracionNumerica <= 0 ){
                mostrarError("La Duración debe ser mayor a 0", jTextDuracion);
                return false;
            }
        } catch( NumberFormatException e ){
            mostrarError("La Duración debe ser un número válido", jTextDuracion);
            return false;
        }

        // Validar Costo
        if( costo.isEmpty() ){
            mostrarError("El Costo es obligatorio", jTextCosto);
            return false;
        }
        try{
            double costoNumerico = Double.parseDouble(costo.replace(",", "."));
            if( costoNumerico <= 0 ){
                mostrarError("El Costo debe ser mayor a 0", jTextCosto);
                return false;
            }
        } catch( NumberFormatException e ){
            mostrarError("El Costo debe ser un número válido", jTextCosto);
            return false;
        }

        // Validar Detalle
        if( detalle.isEmpty() ){
            mostrarError("El Detalle es obligatorio", jTextDetalle);
            return false;
        }
        if( detalle.length() > 200 ){
            mostrarError("El Detalle no puede superar los 200 caracteres", jTextDetalle);
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
        jTextDetalle.setText(null);
        jTextCosto.setText(null);
        jTextDuracion.setText(null);
        jTextProducto.setText(null);
        comboEstado.setSelectedIndex(0);
        jComboTipo.setSelectedIndex(0);
        
    }
    
    private void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Tratamiento t : TratamientoData.obtenerTodos()){
            modelo.addRow(new Object[]{
                t.getIdTratamiento(),
                t.getNombre(),
                t.getTipo(),
                t.getDetalle(),
                t.getDuracion()+ " min",
                "$"+t.getCosto(),
                t.getEstado() ? "Activo" : "Inactivo" 
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
            jComboBoxBuscar.addItem("Tipo");
            jComboBoxBuscar.addItem("Estado");
    }
    
    private void actualizarTablaConResultados(ArrayList<Tratamiento> tratamiento){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);
        
        for( Tratamiento t : tratamiento ){
            modelo.addRow(new Object[]{
                t.getIdTratamiento(),
                t.getNombre(),
                t.getTipo(),
                t.getDetalle(),
                t.getDuracion()+ " min",
                "$"+t.getCosto(),
                t.getEstado() ? "Activo" : "Inactivo" 
            });
        }
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
