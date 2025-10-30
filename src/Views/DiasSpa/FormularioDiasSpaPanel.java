package Views.DiasSpa;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Persistencia.ClienteData;
import Persistencia.DiaDeSpaData;
import Views.DashboardMenu;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class FormularioDiasSpaPanel extends javax.swing.JPanel{

    // Variable para identificar si es modo edición o creación
    private boolean modoEdicion = false;
    private DiaDeSpa diaSpaAEditar = null;

    // Constructor para CREAR nuevo día de spa
    public FormularioDiasSpaPanel(){
        initComponents();
        configurarFormulario();
        modoEdicion = false;
    }

    // Constructor para EDITAR día de spa existente
    public FormularioDiasSpaPanel(DiaDeSpa diaSpa){
        initComponents();
        configurarFormulario();
        this.modoEdicion = true;
        this.diaSpaAEditar = diaSpa;
        cargarDatosParaEdicion(diaSpa);
        ajustarInterfazParaEdicion();
    }

    private void configurarFormulario(){
        cargarComboCliente();
        cargarComboEstado();
    }

    private void ajustarInterfazParaEdicion(){
        // Cambiar el título y texto del botón cuando es edición
        jLabel2.setText("Editar Día de Spa");
        buttonGuardar.setText("Actualizar");
    }

    private void cargarDatosParaEdicion(DiaDeSpa diaSpa){
        // Extraer fecha y hora del LocalDateTime
        LocalDateTime fechaHora = diaSpa.getFechaHora();

        // Convertir LocalDateTime a Date para el dateChooser
        Calendar cal = Calendar.getInstance();
        cal.set(fechaHora.getYear(),
          fechaHora.getMonthValue() - 1, // Restar 1 porque Calendar usa 0-11
          fechaHora.getDayOfMonth());
        dateChooser.setDate(cal.getTime());

        // Convertir LocalDateTime a Date para el timeChooser
        Calendar calHora = Calendar.getInstance();
        calHora.set(Calendar.HOUR_OF_DAY, fechaHora.getHour());
        calHora.set(Calendar.MINUTE, fechaHora.getMinute());
        timeChooser.setValue(calHora.getTime());

        // Cargar preferencias
        textAreaPreferencias.setText(diaSpa.getPreferencias());

        // Seleccionar cliente en el combo
        for( int i = 0 ; i < comboCliente.getItemCount() ; i++ ){
            Object item = comboCliente.getItemAt(i);
            if( item instanceof Cliente ){
                Cliente cliente = (Cliente) item;
                if( cliente.getIdCliente() == diaSpa.getIdCliente() ){
                    comboCliente.setSelectedIndex(i);
                    break;
                }
            }
        }

        // Seleccionar estado
        comboEstado.setSelectedItem(diaSpa.getEstado());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
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
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        comboCliente = new javax.swing.JComboBox<>();
        comboEstado = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dateChooser = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeChooser = new javax.swing.JSpinner(sm);
        jLabel8 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textAreaPreferencias = new javax.swing.JTextArea();
        buttonGuardar = new javax.swing.JButton();
        buttonLimpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        jPanelAdministador.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel2.setText("Formulario Día de Spa");

        jLabel1.setText("📋 Información del cliente");

        jLabel3.setText("Cliente:");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel4.setText("Estado:");

        jLabel5.setText("⏰ Fecha y hora");

        jLabel6.setText("Fecha:");

        jLabel7.setText("Hora:");

        dateChooser.setBackground(new java.awt.Color(255, 255, 255));

        JSpinner.DateEditor de = new JSpinner.DateEditor(timeChooser, "HH:mm");
        timeChooser.setEditor(de);

        jLabel8.setText("💬 Preferencias");

        jLabel9.setText("Preferencias del cliente:");

        textAreaPreferencias.setColumns(20);
        textAreaPreferencias.setRows(5);
        jScrollPane1.setViewportView(textAreaPreferencias);

        buttonGuardar.setBackground(new java.awt.Color(76, 175, 80));
        buttonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        buttonGuardar.setText("Guardar");
        buttonGuardar.setBorderPainted(false);
        buttonGuardar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonGuardarActionPerformed(evt);
            }
        });

        buttonLimpiar.setBackground(new java.awt.Color(102, 102, 102));
        buttonLimpiar.setForeground(new java.awt.Color(255, 255, 255));
        buttonLimpiar.setText("Limpiar");
        buttonLimpiar.setBorderPainted(false);
        buttonLimpiar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        buttonLimpiar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        buttonLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelAdministadorLayout = new javax.swing.GroupLayout(jPanelAdministador);
        jPanelAdministador.setLayout(jPanelAdministadorLayout);
        jPanelAdministadorLayout.setHorizontalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator1)
                            .addComponent(jSeparator2)
                            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1)
                                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel3)
                                            .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 302, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel4)
                                            .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(jLabel5))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 324, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(timeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(0, 36, Short.MAX_VALUE))
                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3)
                            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel8)
                                    .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel9)
                                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 666, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addGap(274, 274, 274)
                .addComponent(buttonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelAdministadorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {comboCliente, comboEstado, dateChooser, timeChooser});

        jPanelAdministadorLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel3, jLabel4, jLabel6, jLabel7});

        jPanelAdministadorLayout.setVerticalGroup(
            jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelAdministadorLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dateChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(timeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37)
                .addGroup(jPanelAdministadorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        jPanelAdministadorLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {buttonGuardar, buttonLimpiar});

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAdministador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelAdministador, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
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

    private void buttonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGuardarActionPerformed
        // Validar inputs formulario
        if( !validarFormularioDiaSpa() ){
            return;
        }

        // Obtener valores del formulario
        Cliente clienteSeleccionado = (Cliente) comboCliente.getSelectedItem();
        int idCliente = clienteSeleccionado.getIdCliente();
        String estado = comboEstado.getSelectedItem().toString();

        // Combinar fecha y hora
        java.util.Date fechaUtil = dateChooser.getDate();
        java.util.Date tiempoUtil = (java.util.Date) timeChooser.getValue();

        Calendar calFecha = Calendar.getInstance();
        calFecha.setTime(fechaUtil);
        int año = calFecha.get(Calendar.YEAR);
        int mes = calFecha.get(Calendar.MONTH) + 1;
        int dia = calFecha.get(Calendar.DAY_OF_MONTH);

        Calendar calHora = Calendar.getInstance();
        calHora.setTime(tiempoUtil);
        int hora = calHora.get(Calendar.HOUR_OF_DAY);
        int minuto = calHora.get(Calendar.MINUTE);

        LocalDateTime fechaHora = LocalDateTime.of(año, mes, dia, hora, minuto);
        String preferencias = textAreaPreferencias.getText().trim();
        double monto = 0.0;

        if( modoEdicion ){
            // MODO EDICIÓN: Actualizar día de spa existente
            diaSpaAEditar.setIdCliente(idCliente);
            diaSpaAEditar.setFechaHora(fechaHora);
            diaSpaAEditar.setPreferencias(preferencias);
            diaSpaAEditar.setEstado(estado);
            diaSpaAEditar.setMonto(monto);

            boolean actualizado = DiaDeSpaData.actualizar(diaSpaAEditar);

            if( actualizado ){
                DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

                JOptionPane.showMessageDialog(this,
                  "Día de Spa actualizado exitosamente\n\n"
                  + "ID: " + diaSpaAEditar.getId() + "\n"
                  + "Cliente: " + clienteSeleccionado.getNombreCompleto() + "\n"
                  + "Fecha: " + diaSpaAEditar.getFechaHora().format(formatterFecha) + "\n"
                  + "Hora: " + diaSpaAEditar.getFechaHora().format(formatterHora) + "\n"
                  + "Estado: " + diaSpaAEditar.getEstado(),
                  "Actualización exitosa",
                  JOptionPane.INFORMATION_MESSAGE);

                DashboardMenu.ShowJPanel(new DiasSpaPanel());
            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al actualizar el día de spa\n\n"
                  + "Por favor verifique los datos e intente nuevamente",
                  "Error al actualizar",
                  JOptionPane.ERROR_MESSAGE);
            }

        } else{
            // MODO CREACIÓN: Crear nuevo día de spa
            DiaDeSpa diaSpa = new DiaDeSpa(fechaHora, preferencias, idCliente, monto, estado);
            DiaDeSpa resultado = DiaDeSpaData.guardar(diaSpa);

            if( resultado != null ){
                DateTimeFormatter formatterFecha = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");

                JOptionPane.showMessageDialog(this,
                  "Día de Spa guardado exitosamente\n\n"
                  + "ID: " + resultado.getId() + "\n"
                  + "Cliente: " + clienteSeleccionado.getNombreCompleto() + "\n"
                  + "Fecha: " + resultado.getFechaHora().format(formatterFecha) + "\n"
                  + "Hora: " + resultado.getFechaHora().format(formatterHora) + "\n"
                  + "Estado: " + resultado.getEstado() + "\n"
                  + "Monto: $" + resultado.getMonto(),
                  "Guardado exitoso",
                  JOptionPane.INFORMATION_MESSAGE);

                DashboardMenu.ShowJPanel(new DiasSpaPanel());
            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al guardar el día de spa\n\n"
                  + "Por favor verifique los datos e intente nuevamente",
                  "Error al guardar",
                  JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_buttonGuardarActionPerformed

    private void buttonLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonLimpiarActionPerformed

        if( modoEdicion ){
            // En modo edición, preguntar si desea cancelar
            int respuesta = JOptionPane.showConfirmDialog(this,
              "¿Desea cancelar la edición y volver a la gestión?",
              "Cancelar edición",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);

            if( respuesta == JOptionPane.YES_OPTION ){
                DashboardMenu.ShowJPanel(new DiasSpaPanel());
            }
        } else{
            // En modo creación, solo limpiar
            limpiarInputs();
            buttonGuardar.setEnabled(true);
        }

    }//GEN-LAST:event_buttonLimpiarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton buttonGuardar;
    private javax.swing.JButton buttonLimpiar;
    private javax.swing.JComboBox<Cliente> comboCliente;
    private javax.swing.JComboBox<String> comboEstado;
    private com.toedter.calendar.JDateChooser dateChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelAdministador;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTextArea textAreaPreferencias;
    private javax.swing.JSpinner timeChooser;
    // End of variables declaration//GEN-END:variables

    private void cargarComboCliente(){
        comboCliente.removeAllItems();

        // Agregar opción por defecto (puedes usar null o un objeto especial)
        comboCliente.addItem(null);

        // Obtener todos los clientes desde la base de datos
        ArrayList<Cliente> clientes = ClienteData.obtenerActivos();

        // Agregar cada cliente al combo
        for( Cliente cliente : clientes ){
            // Solo agregar clientes activos
            if( cliente.getEstado() ){
                comboCliente.addItem(cliente);
            }
        }
    }

    private void configurarComboCliente(){
        comboCliente.setRenderer(new DefaultListCellRenderer(){
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value,
              int index, boolean isSelected, boolean cellHasFocus){
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

                if( value == null ){
                    setText("Seleccione un cliente");
                } else if( value instanceof Cliente ){
                    Cliente cliente = (Cliente) value;
                    setText(cliente.getIdCliente() + " - " + cliente.getNombreCompleto());
                }

                return this;
            }
        });
    }

    private void cargarComboEstado(){
        comboEstado.removeAllItems();
        comboEstado.addItem("Completado");
        comboEstado.addItem("Confirmado");
        comboEstado.addItem("Pendiente");
        comboEstado.addItem("Cancelado");
    }

    private void limpiarInputs(){
        textAreaPreferencias.setText("");
        dateChooser.setDate(null);
        timeChooser.setValue(new Date());
        comboCliente.setSelectedIndex(0);
        comboEstado.setSelectedIndex(0);
    }

    private boolean validarFormularioDiaSpa(){
        // Validar que se haya seleccionado un cliente
        if( comboCliente.getSelectedIndex() == 0 || comboCliente.getSelectedItem() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar un cliente",
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            comboCliente.requestFocus();
            return false;
        }

        // Validar que se haya seleccionado un estado
        if( comboEstado.getSelectedIndex() == -1 || comboEstado.getSelectedItem() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar un estado",
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            comboEstado.requestFocus();
            return false;
        }

        // Validar que se haya seleccionado una fecha
        if( dateChooser.getDate() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una fecha",
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            dateChooser.requestFocus();
            return false;
        }

        // Validar que se haya seleccionado una hora
        if( timeChooser.getValue() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una hora",
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            timeChooser.requestFocus();
            return false;
        }

        // Validar que la fecha no sea anterior a hoy
        Date fechaSeleccionada = dateChooser.getDate();
        Date hoy = new Date();

        // Comparar solo la fecha sin la hora
        Calendar calSeleccionada = Calendar.getInstance();
        calSeleccionada.setTime(fechaSeleccionada);
        calSeleccionada.set(Calendar.HOUR_OF_DAY, 0);
        calSeleccionada.set(Calendar.MINUTE, 0);
        calSeleccionada.set(Calendar.SECOND, 0);
        calSeleccionada.set(Calendar.MILLISECOND, 0);

        Calendar calHoy = Calendar.getInstance();
        calHoy.setTime(hoy);
        calHoy.set(Calendar.HOUR_OF_DAY, 0);
        calHoy.set(Calendar.MINUTE, 0);
        calHoy.set(Calendar.SECOND, 0);
        calHoy.set(Calendar.MILLISECOND, 0);

        if( calSeleccionada.before(calHoy) ){
            JOptionPane.showMessageDialog(this,
              "La fecha no puede ser anterior al día de hoy",
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            dateChooser.requestFocus();
            return false;
        }

        // Validar preferencias (opcional, depende de tu lógica de negocio)
        String preferencias = textAreaPreferencias.getText().trim();
        if( preferencias.isEmpty() ){
            int respuesta = JOptionPane.showConfirmDialog(this,
              "No ha ingresado preferencias del cliente.\n¿Desea continuar sin preferencias?",
              "Confirmación",
              JOptionPane.YES_NO_OPTION,
              JOptionPane.QUESTION_MESSAGE);

            if( respuesta != JOptionPane.YES_OPTION ){
                textAreaPreferencias.requestFocus();
                return false;
            }
        }

        // Validar longitud máxima de preferencias (si tu DB tiene límite)
        if( preferencias.length() > 500 ){
            JOptionPane.showMessageDialog(this,
              "Las preferencias no pueden exceder 500 caracteres\n"
              + "Caracteres actuales: " + preferencias.length(),
              "Validación de formulario",
              JOptionPane.WARNING_MESSAGE);
            textAreaPreferencias.requestFocus();
            return false;
        }

        return true;
    }
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
