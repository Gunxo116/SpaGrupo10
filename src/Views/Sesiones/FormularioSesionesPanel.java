package Views.Sesiones;

import Modelo.Cliente;
import Modelo.DiaDeSpa;
import Modelo.Instalacion;
import Modelo.Masajista;
import Modelo.Sesion;
import Modelo.Tratamiento;
import Persistencia.ClienteData;
import Persistencia.DiaDeSpaData;
import Persistencia.InstalacionData;
import Persistencia.MasajistaData;
import Persistencia.SesionData;
import Persistencia.TratamientoData;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class FormularioSesionesPanel extends javax.swing.JPanel{

    public FormularioSesionesPanel(){
        initComponents();

        jPanelFondo.setOpaque(false);
        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));

        jPanelPrincipal.setOpaque(false);
        jPanelPrincipal.setBackground(new java.awt.Color(21, 104, 195));

        configurarFormulario();

    }

    private void configurarFormulario(){
        cargarComboInstalacion();
        cargarComboTratamiento();
        cargarComboMasajista();
        cargarComboEstado();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
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
        jLabel3 = new javax.swing.JLabel();
        jLabelDiaSpaID = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabelCliente = new javax.swing.JLabel();
        jLabelFecha = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jSeparator4 = new javax.swing.JSeparator();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jDateChooser1 = new com.toedter.calendar.JDateChooser();
        Date date = new Date();
        SpinnerDateModel sm =
        new SpinnerDateModel(date, null, null, Calendar.HOUR_OF_DAY);
        timeChooser = new javax.swing.JSpinner(sm);
        Date date2 = new Date();
        SpinnerDateModel sm2 = new SpinnerDateModel(date2, null, null, Calendar.HOUR_OF_DAY);
        timeChooser2 = new javax.swing.JSpinner(sm2);
        jLabel13 = new javax.swing.JLabel();
        jComboInstalacion = new javax.swing.JComboBox<>();
        jComboTratamiento = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jComboMasajista = new javax.swing.JComboBox<>();
        jComboEstado = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        jButtonCancelar = new javax.swing.JButton();
        jButtonGuardarEdit1 = new javax.swing.JButton();
        jButtonLimpiar1 = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jPanelFondo.setBackground(new java.awt.Color(255, 255, 255));
        jPanelFondo.setForeground(new java.awt.Color(255, 51, 51));
        jPanelFondo.setToolTipText("");

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 16)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-masajistas.png"))); // NOI18N
        jLabel1.setText("Formulario Sesión");

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("jLabel2");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setBackground(new java.awt.Color(21, 104, 195));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(21, 104, 195));
        jLabel3.setText("Dia de Spa: ");

        jLabelDiaSpaID.setForeground(new java.awt.Color(0, 0, 0));
        jLabelDiaSpaID.setText("jLabel4");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(245, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelDiaSpaID, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabelDiaSpaID)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabelCliente)
                    .addComponent(jLabelFecha))
                .addGap(0, 14, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelPrincipalLayout = new javax.swing.GroupLayout(jPanelPrincipal);
        jPanelPrincipal.setLayout(jPanelPrincipalLayout);
        jPanelPrincipalLayout.setHorizontalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelPrincipalLayout.setVerticalGroup(
            jPanelPrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelPrincipalLayout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel4.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel4.setText("⏰ Fecha y Horario");

        jSeparator1.setBackground(new java.awt.Color(21, 104, 195));
        jSeparator1.setForeground(new java.awt.Color(21, 104, 195));

        jSeparator2.setBackground(new java.awt.Color(21, 104, 195));
        jSeparator2.setForeground(new java.awt.Color(21, 104, 195));

        jLabel8.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel8.setText("🏢 Instalación");

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel9.setText("💆‍♀️ Tratamiento ");

        jSeparator3.setBackground(new java.awt.Color(21, 104, 195));
        jSeparator3.setForeground(new java.awt.Color(21, 104, 195));

        jLabel10.setFont(new java.awt.Font("Century Gothic", 1, 14)); // NOI18N
        jLabel10.setText("👐 Masajista");

        jSeparator4.setBackground(new java.awt.Color(21, 104, 195));
        jSeparator4.setForeground(new java.awt.Color(21, 104, 195));

        jSeparator5.setBackground(new java.awt.Color(21, 104, 195));
        jSeparator5.setForeground(new java.awt.Color(204, 204, 204));

        jLabel5.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel5.setText("Fecha Inicio");

        jLabel11.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel11.setText("Hora Inicio");

        jLabel12.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel12.setText("Hora Fin");

        jDateChooser1.setBackground(new java.awt.Color(255, 255, 255));

        JSpinner.DateEditor de1 = new JSpinner.DateEditor(timeChooser, "HH:mm");
        timeChooser.setEditor(de1);

        JSpinner.DateEditor de2 = new JSpinner.DateEditor(timeChooser2, "HH:mm");
        timeChooser2.setEditor(de2);

        jLabel13.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel13.setText("Seleccionar Instalación");

        jComboTratamiento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboTratamientoActionPerformed(evt);
            }
        });

        jLabel14.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel14.setText("Seleccionar Tratamiento");

        jLabel15.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel15.setText("Asignar Masajista ");

        jLabel16.setFont(new java.awt.Font("Century Gothic", 0, 12)); // NOI18N
        jLabel16.setText("Estado ");

        jButtonCancelar.setBackground(new java.awt.Color(102, 102, 102));
        jButtonCancelar.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonCancelar.setForeground(new java.awt.Color(255, 255, 255));
        jButtonCancelar.setText("Cancelar");
        jButtonCancelar.setBorderPainted(false);
        jButtonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonCancelar.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarActionPerformed(evt);
            }
        });

        jButtonGuardarEdit1.setBackground(new java.awt.Color(76, 175, 80));
        jButtonGuardarEdit1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonGuardarEdit1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonGuardarEdit1.setText("Guardar");
        jButtonGuardarEdit1.setBorderPainted(false);
        jButtonGuardarEdit1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonGuardarEdit1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonGuardarEdit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarEdit1ActionPerformed(evt);
            }
        });

        jButtonLimpiar1.setBackground(new java.awt.Color(21, 104, 195));
        jButtonLimpiar1.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jButtonLimpiar1.setForeground(new java.awt.Color(255, 255, 255));
        jButtonLimpiar1.setText("Limpiar");
        jButtonLimpiar1.setBorderPainted(false);
        jButtonLimpiar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jButtonLimpiar1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButtonLimpiar1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLimpiar1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelFondoLayout = new javax.swing.GroupLayout(jPanelFondo);
        jPanelFondo.setLayout(jPanelFondoLayout);
        jPanelFondoLayout.setHorizontalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel5)
                        .addGap(166, 166, 166))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)))
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(timeChooser, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(18, 18, 18)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addComponent(timeChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4)
                            .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, 736, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)))
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel13)))
                .addContainerGap(12, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jComboInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jComboTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 697, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel15)
                    .addGroup(jPanelFondoLayout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jComboMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16))
                .addGap(33, 33, 33))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addComponent(jButtonLimpiar1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButtonGuardarEdit1, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanelFondoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jDateChooser1, timeChooser, timeChooser2});

        jPanelFondoLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jButtonCancelar, jButtonGuardarEdit1});

        jPanelFondoLayout.setVerticalGroup(
            jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelFondoLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(timeChooser)
                    .addComponent(timeChooser2)
                    .addComponent(jDateChooser1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboInstalacion, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboTratamiento, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboMasajista, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonLimpiar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanelFondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButtonCancelar)
                        .addComponent(jButtonGuardarEdit1)))
                .addContainerGap())
        );

        jPanelFondoLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jButtonCancelar, jButtonGuardarEdit1});

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

    private void jButtonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarActionPerformed

        int confirmar = JOptionPane.showConfirmDialog(
          this,
          "¿Estas seguro de cancelar?\nLos cambios no guardados se perderan.",
          "Cancelar",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmar == JOptionPane.YES_OPTION ){
            // Volver al panel de sesiones
            Views.Sesiones.SesionesPanel panelSesiones = new Views.Sesiones.SesionesPanel();
            panelSesiones.cargarDatosDiaSpa(
              Integer.parseInt(jLabelDiaSpaID.getText()),
              jLabelCliente.getText(),
              jLabelFecha.getText()
            );
            Views.DashboardMenu.ShowJPanel(panelSesiones);
        }

    }//GEN-LAST:event_jButtonCancelarActionPerformed

    private void jButtonGuardarEdit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarEdit1ActionPerformed

        Double monto = 0.0;

        try{
            if( !validarDatos() ){
                return;
            }
            Sesion sesion;
            if( sesionEnEdicion != null ){
                sesion = sesionEnEdicion;
            } else{
                sesion = new Sesion();
            }

            // Obtener fechas y horas combinadas
            LocalDateTime fechaHoraInicio = obtenerFechaHoraInicio();
            LocalDateTime fechaHoraFin = obtenerFechaHoraFin();

            sesion.setFechaHoraInicio(fechaHoraInicio);
            sesion.setFechaHoraFin(fechaHoraFin);

            // Tratamiento (opcional)
            Tratamiento tratamiento = (Tratamiento) jComboTratamiento.getSelectedItem();
            if( tratamiento != null ){
                sesion.setIdTratamiento(tratamiento.getIdTratamiento());
            } else{
                sesion.setIdTratamiento(null);
            }

            // Masajista (opcional)
            Masajista masajista = (Masajista) jComboMasajista.getSelectedItem();
            if( masajista != null ){
                sesion.setIdMasajista(masajista.getId());
            } else{
                sesion.setIdMasajista(null);
            }

            // Instalación (obligatorio)
            Instalacion instalacion = (Instalacion) jComboInstalacion.getSelectedItem();
            sesion.setIdInstalacion(instalacion.getIdInstalacion());

            // Estado
            String estado = (String) jComboEstado.getSelectedItem();
            sesion.setEstado(estado);

            // ID Día Spa
            int idDiaSpa = Integer.parseInt(jLabelDiaSpaID.getText().trim());
            sesion.setIdDiaSpa(idDiaSpa);

            // Actualizar monto del DiaSpa
            monto += DiaDeSpaData.buscarPorId(sesion.getIdDiaSpa()).getMonto();

            monto += tratamiento.getCosto();
            monto += instalacion.getPrecio30m();

            // Guardar el monto en el DiaSpa
            if( monto != 0.0 ){
                DiaDeSpaData.actualizarMonto(idDiaSpa, monto);
            }

            // Guardar o actualizar en la base de datos
            boolean exito;
            if( sesionEnEdicion != null ){
                exito = SesionData.actualizar(sesion);
                if( exito ){
                    JOptionPane.showMessageDialog(this,
                      "Sesión actualizada exitosamente",
                      "Éxito",
                      JOptionPane.INFORMATION_MESSAGE);

                    Views.Sesiones.SesionesPanel panelSesiones = new Views.Sesiones.SesionesPanel();
                    panelSesiones.cargarDatosDiaSpa(
                      Integer.parseInt(jLabelDiaSpaID.getText()),
                      jLabelCliente.getText(),
                      jLabelFecha.getText()
                    );
                    Views.DashboardMenu.ShowJPanel(panelSesiones);

                } else{
                    JOptionPane.showMessageDialog(this,
                      "Error al actualizar la sesión",
                      "Error",
                      JOptionPane.ERROR_MESSAGE);

                }
            } else{
                Sesion sesionGuardada = SesionData.guardar(sesion);
                if( sesionGuardada != null ){
                    JOptionPane.showMessageDialog(this,
                      "Sesión guardada exitosamente con ID: " + sesionGuardada.getId(),
                      "Éxito",
                      JOptionPane.INFORMATION_MESSAGE);
                    limpiarFormulario();

                    Views.Sesiones.SesionesPanel panelSesiones = new Views.Sesiones.SesionesPanel();
                    panelSesiones.cargarDatosDiaSpa(
                      Integer.parseInt(jLabelDiaSpaID.getText()),
                      jLabelCliente.getText(),
                      jLabelFecha.getText()
                    );
                    Views.DashboardMenu.ShowJPanel(panelSesiones);

                } else{
                    JOptionPane.showMessageDialog(this,
                      "Error al guardar la sesión en la base de datos",
                      "Error",
                      JOptionPane.ERROR_MESSAGE);
                }
            }

        } catch( Exception e ){
            JOptionPane.showMessageDialog(this,
              "Error inesperado: " + e.getMessage(),
              "Error",
              JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }//GEN-LAST:event_jButtonGuardarEdit1ActionPerformed

    private void jButtonLimpiar1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLimpiar1ActionPerformed
        limpiarFormulario();
    }//GEN-LAST:event_jButtonLimpiar1ActionPerformed

    private void jComboTratamientoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboTratamientoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboTratamientoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtonCancelar;
    private javax.swing.JButton jButtonGuardarEdit1;
    private javax.swing.JButton jButtonLimpiar1;
    private javax.swing.JComboBox<String> jComboEstado;
    private javax.swing.JComboBox<Instalacion> jComboInstalacion;
    private javax.swing.JComboBox<Masajista> jComboMasajista;
    private javax.swing.JComboBox<Tratamiento> jComboTratamiento;
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
    private javax.swing.JLabel jLabelCliente;
    private javax.swing.JLabel jLabelDiaSpaID;
    private javax.swing.JLabel jLabelFecha;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelFondo;
    private javax.swing.JPanel jPanelPrincipal;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSpinner timeChooser;
    private javax.swing.JSpinner timeChooser2;
    // End of variables declaration//GEN-END:variables

    private void cargarComboInstalacion(){
        jComboInstalacion.removeAllItems();

        ArrayList<Instalacion> instalaciones = InstalacionData.obtenerActivas();
        for( Instalacion instalacion : instalaciones ){
            if( instalacion.isEstado() ){
                jComboInstalacion.addItem(instalacion);
            }
        }
    }

    private void cargarComboTratamiento(){
        jComboTratamiento.removeAllItems();

        ArrayList<Tratamiento> tratamientos = TratamientoData.obtenerActivos();
        for( Tratamiento tratamiento : tratamientos ){
            if( tratamiento.getEstado() ){
                jComboTratamiento.addItem(tratamiento);
            }
        }
    }

    private void cargarComboMasajista(){
        jComboMasajista.removeAllItems();

        ArrayList<Masajista> masajistas = MasajistaData.obtenerActivos();
        for( Masajista masajista : masajistas ){
            if( masajista.getEstado() ){
                jComboMasajista.addItem(masajista);
            }
        }
    }

    private void cargarComboEstado(){
        jComboEstado.removeAllItems();
        jComboEstado.addItem("Completada");
        jComboEstado.addItem("Reservada");
        jComboEstado.addItem("En Curso");
        jComboEstado.addItem("Cancelada");
    }

    private LocalDateTime obtenerFechaHoraInicio(){
        Date fechaDate = jDateChooser1.getDate();
        if( fechaDate == null ){
            return null;
        }

        LocalDate fecha = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Date horaDate = (Date) timeChooser.getValue();
        LocalTime hora = horaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
        return LocalDateTime.of(fecha, hora);

    }

    private LocalDateTime obtenerFechaHoraFin(){
        Date fechaDate = jDateChooser1.getDate();
        if( fechaDate == null ){
            return null;
        }
        LocalDate fecha = fechaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Date horaDate = (Date) timeChooser2.getValue();
        LocalTime hora = horaDate.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();

        return LocalDateTime.of(fecha, hora);
    }

    private boolean validarDatos(){
        if( jDateChooser1.getDate() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una fecha",
              "Campo requerido",
              JOptionPane.WARNING_MESSAGE);
            jDateChooser1.requestFocus();
            return false;
        }
        if( timeChooser.getValue() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una hora de inicio",
              "Campo requerido",
              JOptionPane.WARNING_MESSAGE);
            timeChooser.requestFocus();
            return false;
        }
        if( timeChooser2.getValue() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una hora de fin",
              "Campo requerido",
              JOptionPane.WARNING_MESSAGE);
            timeChooser2.requestFocus();
            return false;
        }

        LocalDateTime fechaHoraInicio = obtenerFechaHoraInicio();
        LocalDateTime fechaHoraFin = obtenerFechaHoraFin();

        if( fechaHoraFin.isBefore(fechaHoraInicio) || fechaHoraFin.isEqual(fechaHoraInicio) ){
            JOptionPane.showMessageDialog(this,
              "La hora de fin debe ser Mayor a la hora inicio",
              "Error en horarios",
              JOptionPane.WARNING_MESSAGE);
            timeChooser2.requestFocus();
            return false;
        }

        if( jComboInstalacion.getSelectedItem() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar una instalación",
              "Campo requerido",
              JOptionPane.WARNING_MESSAGE);
            jComboInstalacion.requestFocus();
            return false;
        }

        if( jComboEstado.getSelectedItem() == null ){
            JOptionPane.showMessageDialog(this,
              "Debe seleccionar un estado",
              "Campo requerido",
              JOptionPane.WARNING_MESSAGE);
            jComboEstado.requestFocus();
            return false;
        }

        // Validar que el label tenga el ID del día spa
        if( jLabelDiaSpaID.getText() == null || jLabelDiaSpaID.getText().trim().isEmpty() ){
            JOptionPane.showMessageDialog(this,
              "Error: No se ha cargado el día de spa",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validar que el ID sea un número válido
        try{
            Integer.parseInt(jLabelDiaSpaID.getText().trim());
        } catch( NumberFormatException e ){
            JOptionPane.showMessageDialog(this,
              "Error: ID de día de spa inválido",
              "Error",
              JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true;
    }

    private void limpiarFormulario(){
        jDateChooser1.setDate(new Date());
        timeChooser.setValue(new Date());
        timeChooser2.setValue(new Date());
        jComboInstalacion.setSelectedIndex(-1);
        jComboTratamiento.setSelectedIndex(-1);
        jComboMasajista.setSelectedIndex(-1);
        jComboEstado.setSelectedIndex(0);
    }

    public void cargarDatosDiaSpa(int idDiaSpa, String nombreCliente, String fecha){
        jLabelDiaSpaID.setText(String.valueOf(idDiaSpa));
        jLabel2.setText("Día de Spa: " + idDiaSpa);

        // Actualizar cliente y fecha
        jLabelCliente.setText(nombreCliente);
        jLabelFecha.setText(fecha);
    }

    public void cargarDatosParaEditar(Sesion sesion){
        jLabelDiaSpaID.setText(String.valueOf(sesion.getIdDiaSpa()));
        jLabel2.setText("Día de Spa: " + sesion.getIdDiaSpa());

        DiaDeSpa diaSpa = DiaDeSpaData.buscarPorId(sesion.getIdDiaSpa());
        if( diaSpa != null ){
            Cliente cliente = ClienteData.obtenerPorId(diaSpa.getIdCliente());
            if( cliente != null ){
                jLabelCliente.setText(cliente.getNombreCompleto());
            }
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
            jLabelFecha.setText(diaSpa.getFechaHora().format(formatter));
        }

        LocalDateTime fechaHoraInicio = sesion.getFechaHoraInicio();
        LocalDateTime fechaHoraFin = sesion.getFechaHoraFin();

        Date fechaInicio = Date.from(fechaHoraInicio.atZone(ZoneId.systemDefault()).toInstant());
        Date horaInicio = Date.from(fechaHoraInicio.atZone(ZoneId.systemDefault()).toInstant());
        Date horaFin = Date.from(fechaHoraFin.atZone(ZoneId.systemDefault()).toInstant());

        jDateChooser1.setDate(fechaInicio);
        timeChooser.setValue(horaInicio);
        timeChooser2.setValue(horaFin);

        for( int i = 0 ; i < jComboInstalacion.getItemCount() ; i++ ){
            Instalacion inst = jComboInstalacion.getItemAt(i);
            if( inst.getIdInstalacion() == sesion.getIdInstalacion() ){
                jComboInstalacion.setSelectedIndex(i);
                break;
            }
        }

        if( sesion.getIdTratamiento() != null ){
            for( int i = 0 ; i < jComboTratamiento.getItemCount() ; i++ ){
                Tratamiento trat = jComboTratamiento.getItemAt(i);
                if( trat.getIdTratamiento() == sesion.getIdTratamiento() ){
                    jComboTratamiento.setSelectedIndex(i);
                    break;
                }
            }
        }

        if( sesion.getIdMasajista() != null ){
            for( int i = 0 ; i < jComboMasajista.getItemCount() ; i++ ){
                Masajista mas = jComboMasajista.getItemAt(i);
                if( mas.getId() == sesion.getIdMasajista() ){
                    jComboMasajista.setSelectedIndex(i);
                    break;
                }
            }
        }

        jComboEstado.setSelectedItem(sesion.getEstado());
        jButtonGuardarEdit1.setText("Actualizar");
        this.sesionEnEdicion = sesion;
    }

    private Sesion sesionEnEdicion = null;

}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
