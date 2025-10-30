
package Views.Sesiones;

import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Sesion;
import Modelo.Tratamiento;
import Persistencia.MasajistaData;
import Persistencia.SesionData;
import Persistencia.TratamientoData;
import Views.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;


public class SesionesPanel extends javax.swing.JPanel {
    
    private DefaultTableModel modeloTabla;
    private int idDiaSpaActual;

    public SesionesPanel() {
        initComponents();
        
        
        
        //TABLA
        String[] columnas = {"ID", "Hora Inicio", "Hora Fin", "Tratamiento", "Masajista", "Estado", "Acciones"};
        modeloTabla = new DefaultTableModel(columnas, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return column == 6;
            }
        };
        jTableSesion.setModel(modeloTabla);
        configurarTabla();
        
        
        
        // PANELES BONITOS        jPanelFondo.setOpaque(false);
        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelPrincipal.setOpaque(false);
        jPanelPrincipal.setBackground(new java.awt.Color(21, 104, 195));
        
    }
    
    
    public void cargarDatosDiaSpa(int idDiaSpa, String nombreCliente, String fecha) {
        this.idDiaSpaActual = idDiaSpa;
        jLabelDiaSpa.setText(String.valueOf(idDiaSpa));
        jLabelCliente.setText(nombreCliente);
        jLabelFecha.setText(fecha);
        
        cargarTabla();
    }
    
    
    
    
    private void configurarTabla() {
        jTableSesion.setRowHeight(35);
        
        TableColumn columnaAcciones = jTableSesion.getColumnModel().getColumn(6);
        columnaAcciones.setCellRenderer(new PanelBotonesRenderer());
        columnaAcciones.setCellEditor(new PanelBotonesEditor(jTableSesion, this));
        columnaAcciones.setPreferredWidth(180);
        columnaAcciones.setMinWidth(180);
        columnaAcciones.setMaxWidth(180);
        
        // Ajustar anchos de otras columnas
        jTableSesion.getColumnModel().getColumn(0).setPreferredWidth(50);
        jTableSesion.getColumnModel().getColumn(0).setMaxWidth(70);
        jTableSesion.getColumnModel().getColumn(1).setPreferredWidth(100);
        jTableSesion.getColumnModel().getColumn(2).setPreferredWidth(100);
        jTableSesion.getColumnModel().getColumn(3).setPreferredWidth(150);
        jTableSesion.getColumnModel().getColumn(4).setPreferredWidth(150);
        jTableSesion.getColumnModel().getColumn(5).setPreferredWidth(100);
        
        // Centrar el contenido de las columnas
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(JLabel.CENTER);
        jTableSesion.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);
        jTableSesion.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
        jTableSesion.getColumnModel().getColumn(2).setCellRenderer(centerRenderer);
        jTableSesion.getColumnModel().getColumn(5).setCellRenderer(centerRenderer);
    }
    
    
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelFondo = new javax.swing.JPanel(){

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
        jPanelPrincipal = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                // Dibujar borde gris redondeado
                g2.drawRoundRect(1, 1, getWidth() - 2, getHeight() - 2, 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabelDiaSpa = new javax.swing.JLabel();
        jButtonNuevaSesion = new javax.swing.JButton();
        jButtonVolver = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableSesion = new javax.swing.JTable();

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setForeground(new java.awt.Color(255, 51, 51));
        jPanelFondo.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-masajistas.png"))); // NOI18N
        jLabel1.setText("Gestión de Sesiones ");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Día de Spa:");

        jPanel1.setBackground(new java.awt.Color(227, 242, 253));
        jPanel1.setForeground(new java.awt.Color(227, 242, 253));

        jLabel6.setBackground(new java.awt.Color(21, 104, 195));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(21, 104, 195));
        jLabel6.setText("| Cliente:");

        jLabel7.setBackground(new java.awt.Color(21, 104, 195));
        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(21, 104, 195));
        jLabel7.setText("| Fecha:");

        jLabelCliente.setForeground(new java.awt.Color(0, 0, 0));
        jLabelCliente.setText("jLabel4");

        jLabelFecha.setForeground(new java.awt.Color(0, 0, 0));
        jLabelFecha.setText("jLabel4");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCliente)
                    .addComponent(jLabelFecha))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        jLabelDiaSpa.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDiaSpa.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabelDiaSpa.setForeground(new java.awt.Color(255, 255, 255));
        jLabelDiaSpa.setText("jLabel2");

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelDiaSpa))
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabelDiaSpa))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jButtonNuevaSesion.setBackground(new java.awt.Color(21, 104, 195));
        jButtonNuevaSesion.setForeground(new java.awt.Color(255, 255, 255));
        jButtonNuevaSesion.setText("➕ Nueva Sesion");
        jButtonNuevaSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevaSesionActionPerformed(evt);
            }
        });

        jButtonVolver.setBackground(new java.awt.Color(2, 136, 209));
        jButtonVolver.setForeground(new java.awt.Color(255, 255, 255));
        jButtonVolver.setText("🔙 Volver");
        jButtonVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVolverActionPerformed(evt);
            }
        });

        jSeparator1.setBackground(new java.awt.Color(203, 230, 250));
        jSeparator1.setForeground(new java.awt.Color(203, 230, 250));

        jSeparator2.setForeground(new java.awt.Color(204, 204, 204));

        jTableSesion.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableSesion);

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jButtonNuevaSesion)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonVolver)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jSeparator1)
                            .addGroup(jPanelFondoLayout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 734, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 8, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonNuevaSesion)
                    .addComponent(jButtonVolver))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 381, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelFondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonNuevaSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevaSesionActionPerformed
        
        FormularioSesionesPanel formulario = new FormularioSesionesPanel();
        formulario.cargarDatosDiaSpa(
            idDiaSpaActual, 
            jLabelCliente.getText(), 
            jLabelFecha.getText()
        );
        DashboardMenu.ShowJPanel(formulario);
        
    }//GEN-LAST:event_jButtonNuevaSesionActionPerformed

    private void jButtonVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVolverActionPerformed
        
        DashboardMenu.ShowJPanel(new Views.DiasSpa.DiasSpaPanel());
        
    }//GEN-LAST:event_jButtonVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonNuevaSesion;
    private javax.swing.JButton jButtonVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDiaSpa;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JTable jTableSesion;
    // End of variables declaration//GEN-END:variables

    public void cargarTabla() {
        modeloTabla.setRowCount(0);
        
        ArrayList<Sesion> sesiones;
        if (idDiaSpaActual > 0) {
            sesiones = SesionData.obtenerPorDiaSpa(idDiaSpaActual);
        } else {
            sesiones = SesionData.obtenerTodas();
        }
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for (Sesion sesion : sesiones) {
            String horaInicio = sesion.getFechaHoraInicio().format(formatter);
            String horaFin = sesion.getFechaHoraFin().format(formatter);
            
            
            String nombreTratamiento = "-";
            if (sesion.getIdTratamiento() != null) {
                Tratamiento tratamiento = TratamientoData.buscarPorId(sesion.getIdTratamiento());
                if (tratamiento != null) {
                    nombreTratamiento = tratamiento.getNombre();
                }
            }
            
            String nombreMasajista = "-";
            if (sesion.getIdMasajista() != null) {
                Masajista masajista = MasajistaData.buscarPorId(sesion.getIdMasajista());
                if (masajista != null) {
                    nombreMasajista = masajista.getNombreCompleto();
                }
            }
            
            modeloTabla.addRow(new Object[]{
                sesion.getId(),
                horaInicio,
                horaFin,
                nombreTratamiento,
                nombreMasajista,
                sesion.getEstado(),
                ""
            });
        }
    }
    
    public void actualizarTablaConResultados(ArrayList<Sesion> sesiones) {
        modeloTabla.setRowCount(0);
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm");
        
        for (Sesion sesion : sesiones) {
            String horaInicio = sesion.getFechaHoraInicio().format(formatter);
            String horaFin = sesion.getFechaHoraFin().format(formatter);
            
            String nombreTratamiento = "-";
            if (sesion.getIdTratamiento() != null) {
                Tratamiento tratamiento = TratamientoData.buscarPorId(sesion.getIdTratamiento());
                if (tratamiento != null) {
                    nombreTratamiento = tratamiento.getNombre();
                }
            }
            
            String nombreMasajista = "-";
            if (sesion.getIdMasajista() != null) {
                Masajista masajista = MasajistaData.buscarPorId(sesion.getIdMasajista());
                if (masajista != null) {
                    nombreMasajista = masajista.getNombreCompleto();
                }
            }
            
            modeloTabla.addRow(new Object[]{
                sesion.getId(),
                horaInicio,
                horaFin,
                nombreTratamiento,
                nombreMasajista,
                sesion.getEstado(),
                ""
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
