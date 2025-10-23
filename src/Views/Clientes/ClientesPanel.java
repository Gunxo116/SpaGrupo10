package Views.Clientes;

import Modelo.Cliente;
import Persistencia.ClienteData;
import java.awt.Component;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ClientesPanel extends javax.swing.JPanel{

    private int filaSeleccionadaParaEdicion = -1;

    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"ID", "Dni", "Nombre completo", "telefono", "Edad", "Afecciones", "Estado"}, 0
    );

    public ClientesPanel(){
        initComponents();
        cargarCombo();
        cargarCombo2();
        jTable1.setModel(modelo);
        
        // ELEGIR TAMAÑO DE CADA COLUMNA DE LA TABLA 
        int[] anchos = {50, 100, 200, 100, 45, 150, 60};
        for (int i = 0; i < anchos.length; i++) {
            jTable1.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
        limpiarTabla();

        // Función para que al hacer click sobre un alumno se cargue la información en el formulario de edición
        jTable1.getSelectionModel().addListSelectionListener(new javax.swing.event.ListSelectionListener(){
            @Override
            public void valueChanged(javax.swing.event.ListSelectionEvent e){
                // Deshabilitar el botón de guardar
                jButtonGuardar.setEnabled(false);
                if( !e.getValueIsAdjusting() ){
                    int filaSeleccionada = jTable1.getSelectedRow();
                    filaSeleccionadaParaEdicion = filaSeleccionada;

                    if( filaSeleccionada >= 0 ){
                        // Obtener los valores del producto desde la tabla
                        String id = jTable1.getValueAt(filaSeleccionada, 0).toString();
                        String dni = jTable1.getValueAt(filaSeleccionada, 1).toString();
                        String nombreCompleto = jTable1.getValueAt(filaSeleccionada, 2).toString();
                        String telefono = jTable1.getValueAt(filaSeleccionada, 3).toString();
                        String edad = jTable1.getValueAt(filaSeleccionada, 4).toString();
                        String afecciones = jTable1.getValueAt(filaSeleccionada, 5).toString();
                        String estado = jTable1.getValueAt(filaSeleccionada, 6).toString();

                        // Asignar los valores de la tabla en los inputs
                        inputDni.setText(dni);
                        inputNombre.setText(nombreCompleto);
                        inputTelefono.setText(telefono);
                        inputEdad.setText(edad);
                        inputAfecciones.setText(afecciones);
                        comboEstado.setSelectedItem(estado);
                    }
                }
            }
        });

    }

    private void limpiarInputs(){
        inputDni.setText(null);
        inputNombre.setText(null);
        inputTelefono.setText(null);
        inputEdad.setText(null);
        inputAfecciones.setText(null);
        comboEstado.setSelectedItem(true);
        jButtonGuardar.setEnabled(true);
    }

    private boolean validarFormularioCliente(int idCliente){
        String dni = inputDni.getText().trim();
        String nombreCompleto = inputNombre.getText().trim();
        String telefono = inputTelefono.getText().trim();
        String edad = inputEdad.getText().trim();
        String afecciones = inputAfecciones.getText().trim();

        // Validar DNI
        if( dni.isEmpty() ){
            mostrarError("El DNI es obligatorio", inputDni);
            return false;
        }
        if( !dni.matches("\\d{7,8}") ){
            mostrarError("El DNI debe contener entre 7 y 8 dígitos", inputDni);
            return false;
        }

        // Verificar si el DNI ya existe (excepto para el cliente actual en edición)
        if( idCliente == 0 ){
            if( ClienteData.existeDni(dni) ){
                mostrarError("Ya existe un cliente con este DNI", inputDni);
                return false;
            }
        } else{
            ArrayList<Cliente> resultados = ClienteData.buscarPor("DNI", dni);
            if( !resultados.isEmpty() ){
                Cliente clienteExistente = resultados.get(0);
                if( clienteExistente.getIdCliente() != idCliente ){
                    mostrarError("Ya existe un cliente con este DNI", inputDni);
                    return false;
                }
            }
        }

        // Validar Nombre Completo
        if( nombreCompleto.isEmpty() ){
            mostrarError("El Nombre Completo es obligatorio", inputNombre);
            return false;
        }
        if( !nombreCompleto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+") ){
            mostrarError("El Nombre solo debe contener letras y espacios", inputNombre);
            return false;
        }
        if( nombreCompleto.length() < 3 ){
            mostrarError("El Nombre debe tener al menos 3 caracteres", inputNombre);
            return false;
        }

        // Validar Teléfono
        if( telefono.isEmpty() ){
            mostrarError("El Teléfono es obligatorio", inputTelefono);
            return false;
        }
        if( !telefono.matches("\\d{10}") ){
            mostrarError("El Teléfono debe contener exactamente 10 dígitos", inputTelefono);
            return false;
        }

        // Validar Edad
        if( edad.isEmpty() ){
            mostrarError("La Edad es obligatoria", inputEdad);
            return false;
        }
        try{
            int edadNumerica = Integer.parseInt(edad);
            if( edadNumerica < 1 || edadNumerica > 120 ){
                mostrarError("La Edad debe estar entre 1 y 120 años", inputEdad);
                return false;
            }
        } catch( NumberFormatException e ){
            mostrarError("La Edad debe ser un número válido", inputEdad);
            return false;
        }

        // Validar Afecciones (opcional pero con longitud máxima)
        if( afecciones.length() > 200 ){
            mostrarError("Las Afecciones no pueden superar los 200 caracteres", inputAfecciones);
            return false;
        }

        // Validar Estado (verificar que haya una selección válida)
        if( comboEstado.getSelectedItem() == null ){
            mostrarError("Debe seleccionar un Estado", comboEstado);
            return false;
        }

        return true;
    }

    private void cargarCombo(){
        jComboBoxBuscar.removeAllItems();
        jComboBoxBuscar.addItem("DNI");
        jComboBoxBuscar.addItem("Nombre");

    }

    private void cargarCombo2(){
        comboEstado.removeAllItems();
        comboEstado.addItem("Activo");
        comboEstado.addItem("Inactivo");
    }

    private void limpiarTabla(){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Cliente p : ClienteData.obtenerTodos() ){
            modelo.addRow(new Object[]{
                p.getIdCliente(),
                p.getDni(),
                p.getNombreCompleto(),
                p.getTelefono(),
                p.getEdad(),
                p.getAfecciones(),
                p.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    private void actualizarTablaConResultados(ArrayList<Cliente> clientes){
        DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
        modelo.setRowCount(0);

        for( Cliente c : clientes ){
            modelo.addRow(new Object[]{
                c.getIdCliente(),
                c.getDni(),
                c.getNombreCompleto(),
                c.getTelefono(),
                c.getEdad(),
                c.getAfecciones(),
                c.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }

    private void mostrarError(String mensaje, Component componente){
        JOptionPane.showMessageDialog(this, mensaje, "Error de validación", JOptionPane.ERROR_MESSAGE);
        componente.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jComboBoxBuscar = new javax.swing.JComboBox<>();
        jLabel4 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        comboBusqueda = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jButtonGuardar = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        inputDni = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        inputNombre = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        inputTelefono = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        inputEdad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        inputAfecciones = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        comboEstado = new javax.swing.JComboBox<>();
        Icono = new javax.swing.JLabel();
        jButtonClearFilter = new javax.swing.JButton();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel2.setText("Gestión Clientes");

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));

        jComboBoxBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jComboBoxBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBoxBuscarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(102, 102, 102));
        jLabel4.setText("Buscar Por:");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        comboBusqueda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBusquedaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(comboBusqueda)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBuscar)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBoxBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBuscar))
                .addGap(5, 5, 5))
        );

        jTable1.setBackground(new java.awt.Color(255, 255, 255));
        jTable1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {"1", "234234", "asdfasdfas", "5343534", "234", "dfasdfasdfasdfasdf", "1"},
                {"2", "234234", "dfasdfasd", "5345345", "234", "asdfasdfasdfasdfasdf", "1"},
                {"3", "234234234", "fasdfasdf", "34534", "234", "asdfasdfasdfasdfasdf", null}
            },
            new String [] {
                "ID", "DNI", "Nombre completo", "Telefono", "Edad", "Afecciones", "Estado"
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setPreferredWidth(10);
        }

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        jPanel3.setToolTipText("Agregar Cliente");

        jButton4.setText("Limpiar");
        jButton4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButtonGuardar.setText("Guardar");
        jButtonGuardar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarActionPerformed(evt);
            }
        });

        jButton2.setText("Borrar");
        jButton2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Actualizar");
        jButton3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel6.setText("DNI:");

        jLabel9.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel9.setText("N. Completo:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel11.setText("Telefono:");

        jLabel12.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel12.setText("Edad:");

        jLabel13.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel13.setText("Afecciones:");

        jLabel14.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel14.setText("Estado:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setText("Editar Cliente");

        comboEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(70, 70, 70))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addComponent(jLabel3))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputDni, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(51, 51, 51)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputAfecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(21, 21, 21)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel14)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboEstado, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(20, 20, 20))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputDni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputEdad, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputAfecciones, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(9, 9, 9)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(inputTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(comboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonGuardar)
                    .addComponent(jButton2)
                    .addComponent(jButton3)
                    .addComponent(jButton4))
                .addGap(16, 16, 16))
        );

        jPanel3Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {comboEstado, inputAfecciones});

        inputDni.getAccessibleContext().setAccessibleName("");
        inputDni.getAccessibleContext().setAccessibleDescription("");

        jButtonClearFilter.setText("Limpiar Filtro");
        jButtonClearFilter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClearFilterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(570, 570, 570)
                        .addComponent(jButtonClearFilter))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Icono)
                .addGap(74, 74, 74))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addComponent(Icono)
                .addGap(271, 465, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonClearFilter)))
                .addGap(9, 9, 9)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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

    private void jComboBoxBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBoxBuscarActionPerformed

    }//GEN-LAST:event_jComboBoxBuscarActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed

        String buscarPor = (String) jComboBoxBuscar.getSelectedItem();
        String texto = comboBusqueda.getText().trim();

        if( texto.isEmpty() ){
            limpiarTabla();
            return;
        }

        if( buscarPor.equals("ID") ){
            try{
                Integer.parseInt(texto);
            } catch( NumberFormatException e ){
                JOptionPane.showMessageDialog(this,
                  "El ID debe ser un número",
                  "Error de formato",
                  JOptionPane.ERROR_MESSAGE);
                comboBusqueda.setText("");
                return;
            }
        }

        ArrayList<Cliente> resultados = ClienteData.buscarPor(buscarPor, texto);

        if( resultados.isEmpty() ){
            JOptionPane.showMessageDialog(this,
              "No se encontraron alumnos con " + buscarPor + ": " + texto,
              "Sin resultados",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarTabla();
        } else{
            actualizarTablaConResultados(resultados);
            JOptionPane.showMessageDialog(this,
              "Se encontraron " + resultados.size() + " alumno(s)",
              "Búsqueda exitosa",
              JOptionPane.INFORMATION_MESSAGE);
        }

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void comboBusquedaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBusquedaActionPerformed

    }//GEN-LAST:event_comboBusquedaActionPerformed

    private void jButtonClearFilterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClearFilterActionPerformed
        limpiarInputs();
        comboBusqueda.setText("");
        limpiarTabla();
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButtonClearFilterActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Verificar que haya una fila seleccionada
        int filaSeleccionadaParaEdicion = jTable1.getSelectedRow();
        if( filaSeleccionadaParaEdicion == -1 ){
            JOptionPane.showMessageDialog(this,
              "Por favor, seleccione un Cliente de la tabla para actualizar.",
              "Advertencia",
              JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID del cliente seleccionado
        int id = Integer.parseInt(jTable1.getValueAt(filaSeleccionadaParaEdicion, 0).toString());

        // Validar el formulario (pasando el ID para permitir el mismo DNI)
        if( !validarFormularioCliente(id) ){
            return;
        }

        // Obtener los datos del formulario
        String dni = inputDni.getText().trim();
        String nombreCompleto = inputNombre.getText().trim();
        String telefono = inputTelefono.getText().trim();
        int edad = Integer.parseInt(inputEdad.getText().trim());
        String afecciones = inputAfecciones.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString().equals("Activo");

        // Crear el objeto Cliente con los datos actualizados
        Cliente cliente = new Cliente(dni, nombreCompleto, telefono, edad, afecciones, estado);
        cliente.setIdCliente(id); // Asignar el ID existente

        // Buscar el cliente a actualizar
        Cliente clienteAActualizar = null;
        for( Cliente c : ClienteData.obtenerTodos() ){
            if( c.getIdCliente() == id ){
                clienteAActualizar = c;
                break;
            }
        }

        if( clienteAActualizar == null ){
            JOptionPane.showMessageDialog(this,
              "Cliente no encontrado.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Actualizar el cliente
        boolean resultado = ClienteData.actualizar(cliente);

        if( resultado ){
            JOptionPane.showMessageDialog(this,
              "Cliente actualizado correctamente.\n\n"
              + "ID: " + cliente.getIdCliente() + "\n"
              + "Nombre: " + cliente.getNombreCompleto() + "\n"
              + "DNI: " + cliente.getDni(),
              "Éxito",
              JOptionPane.INFORMATION_MESSAGE);

            // Limpiar y actualizar
            limpiarInputs();
            limpiarTabla();
            jButtonGuardar.setEnabled(true);
            filaSeleccionadaParaEdicion = -1;
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al actualizar el cliente.\n"
              + "Por favor verifique los datos e intente nuevamente.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

//         // Verificar que haya una fila seleccionada
        int filaSeleccionadaParaEdicion = jTable1.getSelectedRow();
        if( filaSeleccionadaParaEdicion == -1 ){
            JOptionPane.showMessageDialog(this,
              "Por favor, seleccione un Cliente de la tabla para eliminar.",
              "Advertencia",
              JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Obtener el ID del cliente seleccionado
        int id = Integer.parseInt(jTable1.getValueAt(filaSeleccionadaParaEdicion, 0).toString());

        // Buscar el cliente a eliminar
        Cliente clienteAEliminar = null;
        for( Cliente c : ClienteData.obtenerTodos() ){
            if( c.getIdCliente() == id ){
                clienteAEliminar = c;
                break;
            }
        }

        if( clienteAEliminar == null ){
            JOptionPane.showMessageDialog(this,
              "Cliente no encontrado.",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Confirmar eliminación
        int confirmacion = JOptionPane.showConfirmDialog(
          this,
          "¿Está seguro de que desea eliminar el Cliente?\n\n"
          + "Nombre: " + clienteAEliminar.getNombreCompleto() + "\n"
          + "DNI: " + clienteAEliminar.getDni() + "\n\n"
          + "Esta acción no se puede deshacer.",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmacion == JOptionPane.YES_OPTION ){
            boolean resultado = ClienteData.borrar(id);

            if( resultado ){
                JOptionPane.showMessageDialog(this,
                  "Cliente eliminado correctamente.",
                  "Éxito",
                  JOptionPane.INFORMATION_MESSAGE);

                // Limpiar y actualizar
                limpiarInputs();
                limpiarTabla();
                jButtonGuardar.setEnabled(true);
                filaSeleccionadaParaEdicion = -1;
            } else{
                JOptionPane.showMessageDialog(this,
                  "Error al eliminar el cliente.",
                  "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
        }
//        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarActionPerformed

        if( !validarFormularioCliente(0) ){
            return;
        }

        String dni = inputDni.getText().trim();
        String nombreCompleto = inputNombre.getText().trim();
        String telefono = inputTelefono.getText().trim();
        int edad = Integer.parseInt(inputEdad.getText().trim());
        String afecciones = inputAfecciones.getText().trim();
        Boolean estado = comboEstado.getSelectedItem().toString() == "Activo" ? true : false;

        Cliente cliente = new Cliente(dni, nombreCompleto, telefono, edad, afecciones, estado);

        Cliente resultado = ClienteData.guardar(cliente);
        if( resultado != null ){
            JOptionPane.showMessageDialog(this,
              "Alumno guardado exitosamente\n\n"
              + "ID: " + resultado.getIdCliente() + "\n"
              + "Nombre: " + resultado.getNombreCompleto() + "\n"
              + "DNI: " + resultado.getDni(),
              "Guardado exitoso",
              JOptionPane.INFORMATION_MESSAGE);
            limpiarInputs();
        } else{
            JOptionPane.showMessageDialog(this,
              "Error al guardar el alumno\n\n"
              + "Por favor verifique los datos e intente nuevamente",
              "Error al guardar",
              JOptionPane.ERROR_MESSAGE);
        }
        limpiarInputs();
        limpiarTabla();
        filaSeleccionadaParaEdicion = -1;
    }//GEN-LAST:event_jButtonGuardarActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        limpiarInputs();
        jButtonGuardar.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Icono;
    private javax.swing.JTextField comboBusqueda;
    private javax.swing.JComboBox<String> comboEstado;
    private javax.swing.JTextField inputAfecciones;
    private javax.swing.JTextField inputDni;
    private javax.swing.JTextField inputEdad;
    private javax.swing.JTextField inputNombre;
    private javax.swing.JTextField inputTelefono;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonClearFilter;
    private javax.swing.JButton jButtonGuardar;
    private javax.swing.JComboBox<String> jComboBoxBuscar;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
