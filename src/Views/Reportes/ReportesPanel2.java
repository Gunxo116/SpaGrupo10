
package Views.Reportes;

import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Tratamiento;
import Persistencia.InstalacionData;
import Persistencia.MasajistaData;
import Persistencia.ReportesData;
import Persistencia.TratamientoData;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
    
    private DefaultTableModel modelo3 = new DefaultTableModel(
      new String[]{"ID", "Nombre", "Telefeno", "Sesiones Totales", "Estado"}, 0
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
        jDateChooser1.setCalendar(Calendar.getInstance());
        // MASAJISTAS POR ESPECIALIDAD //
        configurarPanelesMasajistas();
        cargarPanelesConMasajistas();
        cargarComboEspecialidad();
        cargarMasajistaEstado();
        cargarTodosLosMasajistas();
        
    }
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel12 = new javax.swing.JLabel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        BotonBuscarInstalacion = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        Calendar cal2 = Calendar.getInstance();
        cal2.set(Calendar.HOUR_OF_DAY, 10);
        cal2.set(Calendar.MINUTE, 0);
        cal2.set(Calendar.SECOND, 0);
        Date date2 = cal2.getTime();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        timeChooser2 = new javax.swing.JSpinner(sm2);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, 9);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        Date date = cal.getTime();
        SpinnerDateModel sm = new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
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
        jLabel9 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        ComboEspecialidad = new javax.swing.JComboBox<>();
        ComboEstadoMasajista = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        BotonFlitrarMasajistasEspecialidad = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableMasajistasPorEspecialidad = new javax.swing.JTable();
        jPanelFacial = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel13 = new javax.swing.JLabel();
        numFaciales = new javax.swing.JLabel();
        jPanelCorporal = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel14 = new javax.swing.JLabel();
        numCorporales = new javax.swing.JLabel();
        jPanelEstetico = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel16 = new javax.swing.JLabel();
        numEsteticos = new javax.swing.JLabel();
        jPanelRelajacion = new javax.swing.JPanel(){

            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Dibujar fondo blanco redondeado
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);

                g2.dispose();
                super.paintComponent(g);
            }

        };
        jLabel15 = new javax.swing.JLabel();
        numRelajaciones = new javax.swing.JLabel();
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

        jLabel12.setText("jLabel12");

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setForeground(new java.awt.Color(0, 0, 0));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jSeparator3.setForeground(new java.awt.Color(21, 104, 195));

        jLabel4.setBackground(new java.awt.Color(0, 0, 0));
        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-InstalacionNegro.png"))); // NOI18N
        jLabel4.setText("Instalaciones Disponibles");

        jLabel5.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel5.setText("Fecha:");

        jLabel6.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel6.setText("Hora Inicio:");

        BotonBuscarInstalacion.setBackground(new java.awt.Color(21, 104, 195));
        BotonBuscarInstalacion.setForeground(new java.awt.Color(255, 255, 255));
        BotonBuscarInstalacion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Buscardor.png"))); // NOI18N
        BotonBuscarInstalacion.setText("Buscar Disponibilidad");
        BotonBuscarInstalacion.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        BotonBuscarInstalacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonBuscarInstalacionActionPerformed(evt);
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
                                    .addComponent(BotonBuscarInstalacion)
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
                        .addComponent(BotonBuscarInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
            .addGap(0, 460, Short.MAX_VALUE)
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
            .addGap(0, 460, Short.MAX_VALUE)
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

        jLabel9.setBackground(new java.awt.Color(0, 0, 0));
        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-ManosTratamientos.png"))); // NOI18N
        jLabel9.setText("Masajistas por Especialidad");

        jSeparator4.setForeground(new java.awt.Color(21, 104, 195));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel10.setText("Especialidad:");

        ComboEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ComboEspecialidadActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Estado:");

        BotonFlitrarMasajistasEspecialidad.setBackground(new java.awt.Color(21, 104, 195));
        BotonFlitrarMasajistasEspecialidad.setForeground(new java.awt.Color(255, 255, 255));
        BotonFlitrarMasajistasEspecialidad.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Buscardor.png"))); // NOI18N
        BotonFlitrarMasajistasEspecialidad.setText("Filtrar");
        BotonFlitrarMasajistasEspecialidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonFlitrarMasajistasEspecialidadActionPerformed(evt);
            }
        });

        jTableMasajistasPorEspecialidad.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(jTableMasajistasPorEspecialidad);

        jPanelFacial.setPreferredSize(new java.awt.Dimension(76, 76));

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("Facial");

        numFaciales.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        numFaciales.setForeground(new java.awt.Color(0, 0, 0));
        numFaciales.setText("0");

        javax.swing.GroupLayout jPanelFacialLayout = new javax.swing.GroupLayout(jPanelFacial);
        jPanelFacial.setLayout(jPanelFacialLayout);
        jPanelFacialLayout.setHorizontalGroup(
            jPanelFacialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacialLayout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanelFacialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(jPanelFacialLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(numFaciales)))
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanelFacialLayout.setVerticalGroup(
            jPanelFacialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFacialLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel13)
                .addGap(18, 18, 18)
                .addComponent(numFaciales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelCorporal.setPreferredSize(new java.awt.Dimension(76, 76));

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Corporal");

        numCorporales.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        numCorporales.setForeground(new java.awt.Color(0, 0, 0));
        numCorporales.setText("0");

        javax.swing.GroupLayout jPanelCorporalLayout = new javax.swing.GroupLayout(jPanelCorporal);
        jPanelCorporal.setLayout(jPanelCorporalLayout);
        jPanelCorporalLayout.setHorizontalGroup(
            jPanelCorporalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorporalLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addComponent(jLabel14)
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(jPanelCorporalLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(numCorporales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelCorporalLayout.setVerticalGroup(
            jPanelCorporalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCorporalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel14)
                .addGap(18, 18, 18)
                .addComponent(numCorporales)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelEstetico.setMinimumSize(new java.awt.Dimension(70, 76));
        jPanelEstetico.setPreferredSize(new java.awt.Dimension(76, 76));

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Estético");

        numEsteticos.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        numEsteticos.setForeground(new java.awt.Color(0, 0, 0));
        numEsteticos.setText("0");

        javax.swing.GroupLayout jPanelEsteticoLayout = new javax.swing.GroupLayout(jPanelEstetico);
        jPanelEstetico.setLayout(jPanelEsteticoLayout);
        jPanelEsteticoLayout.setHorizontalGroup(
            jPanelEsteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEsteticoLayout.createSequentialGroup()
                .addGroup(jPanelEsteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelEsteticoLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel16))
                    .addGroup(jPanelEsteticoLayout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addComponent(numEsteticos)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        jPanelEsteticoLayout.setVerticalGroup(
            jPanelEsteticoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEsteticoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel16)
                .addGap(18, 18, 18)
                .addComponent(numEsteticos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanelRelajacion.setMinimumSize(new java.awt.Dimension(0, 0));
        jPanelRelajacion.setPreferredSize(new java.awt.Dimension(76, 76));

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Relajación");

        numRelajaciones.setFont(new java.awt.Font("Century Gothic", 1, 20)); // NOI18N
        numRelajaciones.setForeground(new java.awt.Color(0, 0, 0));
        numRelajaciones.setText("0");

        javax.swing.GroupLayout jPanelRelajacionLayout = new javax.swing.GroupLayout(jPanelRelajacion);
        jPanelRelajacion.setLayout(jPanelRelajacionLayout);
        jPanelRelajacionLayout.setHorizontalGroup(
            jPanelRelajacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRelajacionLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelRelajacionLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numRelajaciones)
                .addGap(31, 31, 31))
        );
        jPanelRelajacionLayout.setVerticalGroup(
            jPanelRelajacionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRelajacionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel15)
                .addGap(18, 18, 18)
                .addComponent(numRelajaciones)
                .addContainerGap(10, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel11Layout.createSequentialGroup()
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(ComboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel11Layout.createSequentialGroup()
                                        .addComponent(ComboEstadoMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(BotonFlitrarMasajistasEspecialidad))
                                    .addComponent(jLabel11))
                                .addGap(279, 279, 279))))
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel9))
                    .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(jPanel11Layout.createSequentialGroup()
                            .addComponent(jPanelFacial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelCorporal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelRelajacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanelEstetico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 712, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel11Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(ComboEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ComboEstadoMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BotonFlitrarMasajistasEspecialidad, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                        .addGroup(jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelRelajacion, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelEstetico, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelFacial, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelCorporal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(9, 9, 9)))
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
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
            .addGap(0, 460, Short.MAX_VALUE)
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
            .addGap(0, 460, Short.MAX_VALUE)
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
            .addGap(0, 460, Short.MAX_VALUE)
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

    private void BotonBuscarInstalacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonBuscarInstalacionActionPerformed
        
        if (jDateChooser1.getDate() == null) {
            JOptionPane.showMessageDialog(this,
                "Por favor seleccione una fecha",
                "Fecha requerida",
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        Date fechaSeleccionada = jDateChooser1.getDate();
        Date horaInicio = (Date) timeChooser.getValue();
        Date horaFin = (Date) timeChooser2.getValue();
        
        LebelHoras.setText("("+horaInicio+" - "+horaFin+")");

        if (horaFin.before(horaInicio) || horaFin.equals(horaInicio)) {
            JOptionPane.showMessageDialog(this,
                "La hora de fin debe ser posterior a la hora de inicio",
                "Error en horarios",
                JOptionPane.WARNING_MESSAGE);
            return;
        }

        // Formatear fecha y horas para la consulta
        java.text.SimpleDateFormat formatoFecha = new java.text.SimpleDateFormat("yyyy-MM-dd");
        java.text.SimpleDateFormat formatoHora = new java.text.SimpleDateFormat("HH:mm:ss");

        String fecha = formatoFecha.format(fechaSeleccionada);
        String horaInicioStr = formatoHora.format(horaInicio);
        String horaFinStr = formatoHora.format(horaFin);

        modelo2.setRowCount(0);

        ArrayList<Object[]> instalaciones = ReportesData.obtenerInstalacionesDisponibles(fecha, horaInicioStr, horaFinStr);
        for (Object[] inst : instalaciones) {
            int id = (int) inst[0];
            String nombre = (String) inst[1];
            String detalle = (String) inst[2];
            double precio30m = (double) inst[3];

            modelo2.addRow(new Object[]{
                id,
                nombre,
                detalle,
                "$" + String.format("%.2f", precio30m),
                "$" + String.format("%.2f", precio30m * 2),
                "Disponible"
            });
        }

        int cantidadResultados = modelo2.getRowCount();
        LebelHoras.setText("(" + formatoHora.format(horaInicio).substring(0, 5) + 
                          " - " + formatoHora.format(horaFin).substring(0, 5) + ")");
        if (cantidadResultados == 0) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron instalaciones disponibles en el horario seleccionado",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Se encontraron " + cantidadResultados + " instalación(es) disponible(s)",
                "Búsqueda exitosa",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_BotonBuscarInstalacionActionPerformed

    private void ComboEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ComboEspecialidadActionPerformed
        
        
        
    }//GEN-LAST:event_ComboEspecialidadActionPerformed

    private void BotonFlitrarMasajistasEspecialidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonFlitrarMasajistasEspecialidadActionPerformed
        
        String especialidadSeleccionada = (String) ComboEspecialidad.getSelectedItem();
        String estadoSeleccionado = (String) ComboEstadoMasajista.getSelectedItem();
        modelo3.setRowCount(0);

        ArrayList<Masajista> masajistas = new ArrayList<>();

        if (especialidadSeleccionada.equals("Todos") && estadoSeleccionado.equals("Todos")) {
            masajistas = MasajistaData.obtenerTodos();
        } else if (especialidadSeleccionada.equals("Todos")) {
            ArrayList<Masajista> todos = MasajistaData.obtenerTodos();
            boolean estadoBuscado = estadoSeleccionado.equals("Activo");
            for (Masajista m : todos) {
                if (m.getEstado() == estadoBuscado) {
                    masajistas.add(m);
                }
            }
        } else if (estadoSeleccionado.equals("Todos")) {
            masajistas = MasajistaData.buscarPor("Especialidad", especialidadSeleccionada);
        } else {
            ArrayList<Masajista> porEspecialidad = MasajistaData.buscarPor("Especialidad", especialidadSeleccionada);
            boolean estadoBuscado = estadoSeleccionado.equals("Activo");
            for (Masajista m : porEspecialidad) {
                if (m.getEstado() == estadoBuscado) {
                    masajistas.add(m);
                }
            }
        }
        for (Masajista m : masajistas) {
            modelo3.addRow(new Object[]{
                m.getId(),
                m.getNombreCompleto(),
                m.getTelefono(),
                m.getEspecialidad(),
                m.getEstado() ? "Activo" : "Inactivo"
            });
        }

        int cantidadResultados = modelo3.getRowCount();
        if (cantidadResultados == 0) {
            JOptionPane.showMessageDialog(this,
                "No se encontraron masajistas con los criterios seleccionados",
                "Sin resultados",
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this,
                "Se encontraron " + cantidadResultados + " masajista(s)",
                "Búsqueda exitosa",
                JOptionPane.INFORMATION_MESSAGE);
        }
        
    }//GEN-LAST:event_BotonFlitrarMasajistasEspecialidadActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotonBuscarInstalacion;
    private javax.swing.JButton BotonFlitrarMasajistasEspecialidad;
    private javax.swing.JButton BotonGuardar;
    private javax.swing.JComboBox<String> ComboEspecialidad;
    private javax.swing.JComboBox<String> ComboEstadoMasajista;
    private javax.swing.JComboBox<String> ComboEstadoTrata;
    private javax.swing.JComboBox<String> ComboTipoTrata;
    private javax.swing.JLabel LebelHoras;
    private com.toedter.calendar.JDateChooser jDateChooser1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
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
    private javax.swing.JPanel jPanelCorporal;
    private javax.swing.JPanel jPanelEstetico;
    private javax.swing.JPanel jPanelFacial;
    private javax.swing.JPanel jPanelRelajacion;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JTable jTableInstalaciones;
    private javax.swing.JTable jTableMasajistasPorEspecialidad;
    private javax.swing.JTable jTableTratamientos;
    private javax.swing.JLabel numCorporales;
    private javax.swing.JLabel numEsteticos;
    private javax.swing.JLabel numFaciales;
    private javax.swing.JLabel numRelajaciones;
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
        jTableMasajistasPorEspecialidad.setModel(modelo3);
        
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
        
        JTableHeader header3 = jTableMasajistasPorEspecialidad.getTableHeader();
        header3.setBackground(new Color(21, 104, 195));
        header3.setForeground(Color.WHITE);
        header3.setOpaque(true);
        header3.setFont(header2.getFont().deriveFont(Font.BOLD));
        
    }
    
    
    private void configurarPanelesMasajistas(){
    
        jPanelFacial.setOpaque(false);
        jPanelFacial.setBackground(new java.awt.Color(52, 152, 219)); 
        jPanelCorporal.setOpaque(false);
        jPanelCorporal.setBackground(new java.awt.Color(46, 204, 113)); 
        jPanelRelajacion.setOpaque(false);
        jPanelRelajacion.setBackground(new java.awt.Color(231, 76, 60));
        jPanelEstetico.setOpaque(false);
        jPanelEstetico.setBackground(new java.awt.Color(26, 188, 156));
        
    }
    private void cargarPanelesConMasajistas(){
    
        ArrayList<Masajista> masajistas = MasajistaData.obtenerActivos();
    
        int faciales = 0;
        int corporales = 0;
        int relajaciones = 0;
        int esteticos = 0;

        for (Masajista m : masajistas) {
            String especialidad = m.getEspecialidad();
            if (especialidad != null) {
                switch (especialidad.toLowerCase()) {
                    case "facial":
                    case "faciales":
                        faciales++;
                        break;
                    case "corporal":
                    case "corporales":
                        corporales++;
                        break;
                    case "relajacion":
                    case "relajaciones":
                    case "relajación":
                        relajaciones++;
                        break;
                    case "estetico":
                    case "esteticos":
                    case "estético":
                    case "estéticos":
                        esteticos++;
                        break;
                }
            }
        }
        numFaciales.setText(String.valueOf(faciales));
        numCorporales.setText(String.valueOf(corporales));
        numRelajaciones.setText(String.valueOf(relajaciones));
        numEsteticos.setText(String.valueOf(esteticos));
    } 
    private void cargarComboEspecialidad(){
        
        ComboEspecialidad.removeAllItems();
        ComboEspecialidad.addItem("Todos");
        ArrayList<String> Especialidades = ReportesData.obtenerEspecialidades();
        for(String tipo : Especialidades){
            ComboEspecialidad.addItem(tipo);
        }
        
    }
    
    private void cargarMasajistaEstado(){
        ComboEstadoMasajista.removeAllItems();
        ComboEstadoMasajista.addItem("Todos");
        ComboEstadoMasajista.addItem("Activo");
        ComboEstadoMasajista.addItem("Inactivo");
    }
    
    private void cargarTodosLosMasajistas() {
        modelo3.setRowCount(0);
        ArrayList<Masajista> masajistas = MasajistaData.obtenerTodos();

        for (Masajista m : masajistas) {
            modelo3.addRow(new Object[]{
                m.getId(),
                m.getNombreCompleto(),
                m.getTelefono(),
                m.getEspecialidad(),
                m.getEstado() ? "Activo" : "Inactivo"
            });
        }
    }
    
}
