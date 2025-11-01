
package Views.Reportes;

import Modelo.Instalacion;
import Modelo.Tratamiento;
import Persistencia.InstalacionData;
import Persistencia.ReportesData;
import Persistencia.TratamientoData;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;



public class ReportesPanel2 extends javax.swing.JPanel {
    
    private DefaultTableModel modelo = new DefaultTableModel(
      new String[]{"ID", "Nombre", "Tipo", "Duracion (min)", "Costo", "Estado"}, 0
    );
    
    private DefaultTableModel modelo2 = new DefaultTableModel(
      new String[]{"ID", "Nombre", "Detalle", "Precio30m", "Precio60m", "Estado"}, 0
    );
    
    public ReportesPanel2() {
        initComponents();
        
        
        
        cargarTablasBonitas();
        
        // TRATAMIENTOS TIPO //
        cargarComboEstadoTrata();
        cargarComboTipoTrata();
        cargarTodosLosTratamientos();
        // INSTALACIONES DISPONIBLES //
        cargarTodasLasIntalaciones();
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BotonGuardar1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Date date2 = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        timeChooser2 = new javax.swing.JSpinner(sm2);
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeChooser = new javax.swing.JSpinner(sm);
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        jLabel8 = new javax.swing.JLabel();
        LebelHoras = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableInstalaciones = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableTratamientos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        ComboTipoTrata = new javax.swing.JComboBox<>();
        ComboEstadoTrata = new javax.swing.JComboBox<>();
        BotonGuardar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel14 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(21, 104, 195));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-ManosTratamientos.png"))); // NOI18N
        jLabel4.setText("Instalaciones Disponibles");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Hora Inicio:");

        BotonGuardar1.setBackground(new java.awt.Color(21, 104, 195));
        BotonGuardar1.setForeground(new java.awt.Color(255, 255, 255));
        BotonGuardar1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Buscardor.png"))); // NOI18N
        BotonGuardar1.setText("Buscar Disponibilidad");
        BotonGuardar1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonGuardar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardar1ActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel7.setText("Hora Fin:");

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(timeChooser2, "HH:mm");
        timeChooser2.setEditor(de2);

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(timeChooser, "HH:mm");
        timeChooser.setEditor(de1);

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setBackground(new java.awt.Color(0, 0, 0));
        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(21, 104, 195));
        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-checksAzul.png"))); // NOI18N
        jLabel8.setText("Instalaciones LIbres");
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        LebelHoras.setBackground(new java.awt.Color(0, 0, 0));
        LebelHoras.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        LebelHoras.setForeground(new java.awt.Color(21, 104, 195));
        LebelHoras.setText("Label");

        jTableInstalaciones.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTableInstalaciones);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 726, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(11, 11, 11)
                                            .addComponent(jLabel6)
                                            .addGap(54, 54, 54)
                                            .addComponent(jLabel7)
                                            .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(12, 12, 12)
                                            .addComponent(timeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(12, 12, 12)
                                            .addComponent(timeChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(BotonGuardar1)
                                    .addGap(164, 164, 164))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(LebelHoras)
                                    .addGap(0, 0, Short.MAX_VALUE))))))
                .addContainerGap(17, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(jLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(timeChooser, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(timeChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(BotonGuardar1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(LebelHoras))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );

        jTabbedPane2.addTab("Instalaciones Disponibles", jPanel1);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Ranking Instalaciones", jPanel2);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Masajistas Disponibles", jPanel3);

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Masajistas por Especialidad", jPanel4);

        jPanel12.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(0, 0, 0));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-ManosTratamientos.png"))); // NOI18N
        jLabel1.setText("Tratamientos por Tipo");

        jSeparator2.setForeground(new java.awt.Color(21, 104, 195));

        jTableTratamientos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTableTratamientos);

        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setText("Tipo de Tratamiento:");

        jLabel3.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel3.setText("Estado:");

        ComboTipoTrata.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboTipoTrataActionPerformed(evt);
            }
        });

        BotonGuardar.setBackground(new java.awt.Color(21, 104, 195));
        BotonGuardar.setForeground(new java.awt.Color(255, 255, 255));
        BotonGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Buscardor.png"))); // NOI18N
        BotonGuardar.setText("Buscar");
        BotonGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jLabel1))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel12Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(ComboTipoTrata, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(jPanel12Layout.createSequentialGroup()
                                        .addComponent(ComboEstadoTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(33, 33, 33)
                                        .addComponent(BotonGuardar)))))))
                .addGap(24, 24, 24))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {ComboEstadoTrata, ComboTipoTrata});

        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboTipoTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboEstadoTrata, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotonGuardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(17, 17, 17))
        );

        jPanel12Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {BotonGuardar, ComboEstadoTrata, ComboTipoTrata});

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Tratamientos por Tipo", jPanel5);

        jPanel13.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel13Layout = new javax.swing.GroupLayout(jPanel13);
        jPanel13.setLayout(jPanel13Layout);
        jPanel13Layout.setHorizontalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel13Layout.setVerticalGroup(
            jPanel13Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Tratamientos Mas Solicitados", jPanel6);

        jPanel14.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel14Layout = new javax.swing.GroupLayout(jPanel14);
        jPanel14.setLayout(jPanel14Layout);
        jPanel14Layout.setHorizontalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel14Layout.setVerticalGroup(
            jPanel14Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Dia de Spa Completo", jPanel7);

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 459, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jTabbedPane2.addTab("Informe de Dias de Spa", jPanel8);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane2)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ComboTipoTrataActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboTipoTrataActionPerformed
    }//GEN-LAST:event_ComboTipoTrataActionPerformed

    private void BotonGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardarActionPerformed
        
        String tipoSeleccionado = (String) ComboTipoTrata.getSelectedItem();
        String estadoSeleccionado = (String) ComboEstadoTrata.getSelectedItem();

        modelo.setRowCount(0);

        ArrayList<Tratamiento> tratamientos = ReportesData.filtrarTratamientos(tipoSeleccionado, estadoSeleccionado);

        for (Tratamiento t : tratamientos) {
            modelo.addRow(new Object[]{
                t.getIdTratamiento(),
                t.getNombre(),
                t.getTipo(),
                t.getDuracion() + " min",
                "$" + t.getCosto(),
                t.getEstado() ? "Activo" : "Inactivo"
            });
        }
        
        int cantidadResultados = modelo.getRowCount();
        if (cantidadResultados == 0) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron tratamientos con los criterios seleccionados",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Se encontraron " + cantidadResultados + " tratamiento(s)",
                "Búsqueda exitosa",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_BotonGuardarActionPerformed

    private void BotonGuardar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonGuardar1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonGuardar1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JButton BotonGuardar1;
    private javax.swing.JComboBox<String> ComboEstadoTrata;
    private javax.swing.JComboBox<String> ComboTipoTrata;
    private javax.swing.JLabel LebelHoras;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    private javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableInstalaciones;
    private javax.swing.JTable jTableTratamientos;
    private javax.swing.JSpinner timeChooser;
    private javax.swing.JSpinner timeChooser2;
    // End of variables declaration//GEN-END:variables



    private void cargarComboTipoTrata(){
        ComboTipoTrata.removeAllItems();
        ComboTipoTrata.addItem("Todos");

        ArrayList<String> tipos = ReportesData.obtenerTiposTratamiento();
        for(String tipo : tipos){
            ComboTipoTrata.addItem(tipo);
        }
    }

    private void cargarComboEstadoTrata(){
        ComboEstadoTrata.removeAllItems();
        ComboEstadoTrata.addItem("Todos");

        ArrayList<String> estados = ReportesData.obtenerEstados();
        for(String estado : estados){
            ComboEstadoTrata.addItem(estado);
        }
    }
    
    
    private void cargarTodosLosTratamientos() {
        modelo.setRowCount(0);
        ArrayList<Tratamiento> tratamientos = TratamientoData.obtenerTodos();

        for (Tratamiento t : tratamientos) {
            modelo.addRow(new Object[]{
                t.getIdTratamiento(),
                t.getNombre(),
                t.getTipo(),
                t.getDuracion() + " min",
                "$" + t.getCosto(),
                t.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }
    
    private void cargarTodasLasIntalaciones(){
        
        modelo2.setRowCount(0);
    
        ArrayList<Instalacion> instalaciones = InstalacionData.obtenerTodas();

        for(Instalacion i : instalaciones){
            modelo2.addRow(new Object[]{
                i.getIdInstalacion(),
                i.getNombre(),
                i.getDetalleUso(),
                "$" + String.format("%.2f", i.getPrecio30m()),
                "$" + String.format("%.2f", i.getPrecio30m() * 2), 
                i.isEstado()? "Activo" : "Inactivo"
            });
        }

        // Ajustar anchos de columnas
        int[] anchos = {50, 120, 250, 80, 80, 70};
        for(int i = 0; i < anchos.length; i++){
            jTableInstalaciones.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
        }
        
    }
    
    private void cargarTablasBonitas(){
        
        jTableTratamientos.setModel(modelo);
        jTableInstalaciones.setModel(modelo2);
        
        JTableHeader header = jTableTratamientos.getTableHeader();
        header.setBackground(new Color(21, 104, 195));
        header.setForeground(Color.WHITE);
        header.setOpaque(true);
        header.setFont(header.getFont().deriveFont(Font.BOLD));
        
        JTableHeader header2 = jTableInstalaciones.getTableHeader();
        header2.setBackground(new Color(21, 104, 195));
        header2.setForeground(Color.WHITE);
        header2.setOpaque(true);
        header2.setFont(header2.getFont().deriveFont(Font.BOLD));
        
    }
}
