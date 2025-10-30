package Views.DiasSpa;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Persistencia.ClienteData;
import Persistencia.DiaDeSpaData;
import Views.DashboardMenu;
import java.awt.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.*;

public class DiasSpaPanel extends javax.swing.JPanel{

    private DefaultTableModel modeloTabla;

    public DiasSpaPanel(){
        initComponents();
        // Crear modelo de tabla con 6 columnas (incluyendo Acciones)
        String[] columnas = {"ID", "Cliente", "Fecha/Hora", "Monto", "Estado", "Acciones"};
        modeloTabla = new DefaultTableModel(columnas, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                // Solo la columna de acciones (índice 5) es editable
                return column == 5;
            }
        };

        tablaDiasSpa.setModel(modeloTabla);
        configurarTabla();
        cargarTabla();
        cargarCombo();
    }

    private void configurarTabla(){
        // Configurar altura de filas
        tablaDiasSpa.setRowHeight(35);

        // Configurar la columna de acciones
        TableColumn columnaAcciones = tablaDiasSpa.getColumnModel().getColumn(5);
        columnaAcciones.setCellRenderer(new PanelBotonesRenderer());
        columnaAcciones.setCellEditor(new PanelBotonesEditor(tablaDiasSpa, this));
        columnaAcciones.setPreferredWidth(180);
        columnaAcciones.setMinWidth(180);
        columnaAcciones.setMaxWidth(180);

        // Ajustar anchos de otras columnas
        tablaDiasSpa.getColumnModel().getColumn(0).setPreferredWidth(50);
        tablaDiasSpa.getColumnModel().getColumn(0).setMaxWidth(70);
        tablaDiasSpa.getColumnModel().getColumn(1).setPreferredWidth(150);
        tablaDiasSpa.getColumnModel().getColumn(2).setPreferredWidth(150);
        tablaDiasSpa.getColumnModel().getColumn(3).setPreferredWidth(100);
        tablaDiasSpa.getColumnModel().getColumn(4).setPreferredWidth(100);

        // Centrar el contenido de las columnas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        tablaDiasSpa.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        tablaDiasSpa.getColumnModel().getColumn(3).setCellRenderer(centerRenderer);
        tablaDiasSpa.getColumnModel().getColumn(4).setCellRenderer(centerRenderer);
    }

    public void cargarTabla(){
        modeloTabla.setRowCount(0);

        ArrayList<DiaDeSpa> diasSpa = DiaDeSpaData.obtenerTodos();

        for( DiaDeSpa dia : diasSpa ){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            // Obtener nombre del cliente
            Cliente cliente = ClienteData.obtenerPorId(dia.getIdCliente());
            String nombreCliente = cliente != null ? cliente.getNombreCompleto() : "Cliente " + dia.getIdCliente();

            // Formatear fecha y hora
            String fechaHora = dia.getFechaHora().format(formatter);

            // Formatear monto
            String monto = String.format("$%,.0f", dia.getMonto());

            modeloTabla.addRow(new Object[]{
                dia.getId(),
                nombreCliente,
                fechaHora,
                monto,
                dia.getEstado(),
                "" // Columna vacía para los botones
            });
        }
    }

    public void actualizarTablaConResultados(ArrayList<DiaDeSpa> diasSpa){
        modeloTabla.setRowCount(0);

        for( DiaDeSpa dia : diasSpa ){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

            Cliente cliente = ClienteData.obtenerPorId(dia.getIdCliente());
            String nombreCliente = cliente != null ? cliente.getNombreCompleto() : "Cliente " + dia.getIdCliente();

            String fechaHora = dia.getFechaHora().format(formatter);
            String monto = String.format("$%,.0f", dia.getMonto());

            modeloTabla.addRow(new Object[]{
                dia.getId(),
                nombreCliente,
                fechaHora,
                monto,
                dia.getEstado(),
                ""
            });
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
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
        buttonNuevo = new javax.swing.JButton();
        jButtonClearFilter = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaDiasSpa = new javax.swing.JTable();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Gestión Día de Spa");

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
        jButtonBuscar.setBorderPainted(false);
        jButtonBuscar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        buttonNuevo.setBackground(new java.awt.Color(33, 150, 243));
        buttonNuevo.setForeground(new java.awt.Color(255, 255, 255));
        buttonNuevo.setText("➕ Nuevo");
        buttonNuevo.setBorderPainted(false);
        buttonNuevo.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNuevoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelBuscarLayout = new javax.swing.GroupLayout(jPanelBuscar);
        jPanelBuscar.setLayout(jPanelBuscarLayout);
        jPanelBuscarLayout.setHorizontalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonNuevo)
                .addGap(34, 34, 34)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBuscar, 0, 112, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanelBuscarLayout.setVerticalGroup(
            jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBuscarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelBuscarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonNuevo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonClearFilter.setBackground(new java.awt.Color(33, 150, 243));
        jButtonClearFilter.setForeground(new java.awt.Color(255, 255, 255));
        jButtonClearFilter.setText("Limpiar Filtro");
        jButtonClearFilter.setBorderPainted(false);
        jButtonClearFilter.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

        tablaDiasSpa.setModel(new javax.swing.table.DefaultTableModel(
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
        tablaDiasSpa.setSelectionForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(tablaDiasSpa);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonClearFilter))
                    .addComponent(jSeparator1)
                    .addComponent(jPanelBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSeparator2)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jButtonClearFilter))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(88, Short.MAX_VALUE))
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

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuscarActionPerformed

    }//GEN-LAST:event_jComboBoxBuscarActionPerformed

    private void jTextBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextBuscarActionPerformed

    }//GEN-LAST:event_jTextBuscarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

//        String buscarPor = (String) jComboBoxBuscar.getSelectedItem();
//        String texto = jTextBuscar.getText().trim();
//
//        if( texto.isEmpty() ){
//            limpiarTabla();
//            return;
//        }
//
//        if( buscarPor.equals("ID") ){
//            try{
//                Integer.parseInt(texto);
//            } catch( NumberFormatException e ){
//                JOptionPane.showMessageDialog(this,
//                    "El ID debe ser un numero",
//                    "Error de formato",
//                    JOptionPane.ERROR_MESSAGE);
//                jTextBuscar.setText("");
//                return;
//            }
//        }
//
//        ArrayList<Instalacion> resultados = InstalacionData.buscarPor(buscarPor, texto);
//
//        if( resultados.isEmpty() ){
//            JOptionPane.showMessageDialog(this,
//                "No se encontraron Instalaciones con " + buscarPor + ": " + texto,
//                "Sin resultados",
//                JOptionPane.INFORMATION_MESSAGE);
//            limpiarTabla();
//        } else{
//            actualizarTablaConResultados(resultados);
//            JOptionPane.showMessageDialog(this,
//                "Se encontraron " + resultados.size() + " Instalaciones(s)",
//                "Búsqueda exitosa",
//                JOptionPane.INFORMATION_MESSAGE);
//        }
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed

        jTextBuscar.setText("");
        limpiarTabla();

    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    private void buttonNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNuevoActionPerformed
        DashboardMenu.ShowJPanel(new FormularioDiasSpaPanel());
    }//GEN-LAST:event_buttonNuevoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonNuevo;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JComboBox<String> jComboBoxBuscar;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBuscar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTextField jTextBuscar;
    private javax.swing.JTable tablaDiasSpa;
    // End of variables declaration//GEN-END:variables

    private void cargarCombo(){
        jComboBoxBuscar.removeAllItems();
        jComboBoxBuscar.addItem("ID");
        jComboBoxBuscar.addItem("Nombre");
        jComboBoxBuscar.addItem("Estado");
    }

    private void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) tablaDiasSpa.getModel();
        modelo.setRowCount(0);

        for( DiaDeSpa p : DiaDeSpaData.obtenerTodos() ){
            modelo.addRow(new Object[]{
                p.getId(),
                p.getIdCliente(),
                p.getPreferencias(),
                p.getEstado(),
                p.getFechaHora()
            });
        }
    }
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
