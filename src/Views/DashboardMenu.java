package Views;

import Views.Clientes.ClientesPanel;
import Views.DiasSpa.DiasSpaPanel;
import Views.DiasSpa.FormularioDiasSpaPanel;
import Views.Instalaciones.InstalacionesPanel;
import Views.Masajistas.MasajistasPanel;
import Views.Principal.PrincipalPanel;
import Views.Reportes.ReportesPanel;
import Views.Tratamientos.TratamientoPanel;
import com.formdev.flatlaf.FlatIntelliJLaf;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class DashboardMenu extends javax.swing.JFrame{
    
    public static ClientesPanel clientesPanel;
    public static MasajistasPanel masajistasPanel;
    public static TratamientoPanel tratamientoPanel;
    public static InstalacionesPanel instalacionesPanel;
    public static DiasSpaPanel diasSpaPanel;
    public static FormularioDiasSpaPanel formularioDiasSpaPanel;
    public static ReportesPanel reportesPanel;

    public DashboardMenu(){
        initComponents();
        InitStyles();
        InitContent();
        
        inicializarPanelesEstaticos();
    }

    private void InitStyles(){
        navText.setHorizontalAlignment(SwingConstants.CENTER);
        navText.setFont(new Font("Segoe UI", Font.BOLD, 20));
        navText.setForeground(Color.WHITE);
        
        appName.setFont(new Font("Segoe UI", Font.BOLD, 24));
        appName.setHorizontalAlignment(SwingConstants.CENTER);
        appName.setForeground(Color.WHITE);


        appName1.setForeground(Color.WHITE);
        appName1.setHorizontalAlignment(SwingConstants.CENTER);

        header.revalidate();
        header.repaint();
    }

    private void InitContent(){
        ShowJPanel(new PrincipalPanel());
    }

    public static void ShowJPanel(JPanel p){
        p.setSize(760, 522);
        p.setLocation(0, 0);

        content.removeAll();
        content.add(p, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        background = new javax.swing.JPanel();
        menu = new javax.swing.JPanel();
        appName = new javax.swing.JLabel();
        btn_prin = new javax.swing.JButton();
        btn_Clientes = new javax.swing.JButton();
        btn_Masajistas = new javax.swing.JButton();
        btn_Tratamientos = new javax.swing.JButton();
        btn_Instalaciones = new javax.swing.JButton();
        btn_Salir = new javax.swing.JButton();
        btn_Reportes = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JSeparator();
        btn_Instalaciones1 = new javax.swing.JButton();
        btn_Instalaciones2 = new javax.swing.JButton();
        header = new javax.swing.JPanel();
        navText = new javax.swing.JLabel();
        appName1 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        content = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(0, 0, 255));
        setMinimumSize(new java.awt.Dimension(1050, 660));

        background.setBackground(new java.awt.Color(255, 255, 255));

        menu.setBackground(new java.awt.Color(13, 71, 161));
        menu.setPreferredSize(new java.awt.Dimension(270, 640));
        menu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        appName.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        appName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName.setText("Spa “Entre Dedos” ");
        menu.add(appName, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 52, 250, 34));

        btn_prin.setBackground(new java.awt.Color(21, 101, 192));
        btn_prin.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_prin.setForeground(new java.awt.Color(255, 255, 255));
        btn_prin.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-home.png"))); // NOI18N
        btn_prin.setText("Principal");
        btn_prin.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_prin.setBorderPainted(false);
        btn_prin.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_prin.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_prin.setIconTextGap(13);
        btn_prin.setInheritsPopupMenu(true);
        btn_prin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_prinActionPerformed(evt);
            }
        });
        menu.add(btn_prin, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 140, 270, 52));

        btn_Clientes.setBackground(new java.awt.Color(21, 101, 192));
        btn_Clientes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Clientes.setForeground(new java.awt.Color(255, 255, 255));
        btn_Clientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-clientes.png"))); // NOI18N
        btn_Clientes.setText("Clientes");
        btn_Clientes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Clientes.setBorderPainted(false);
        btn_Clientes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Clientes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Clientes.setIconTextGap(13);
        btn_Clientes.setInheritsPopupMenu(true);
        btn_Clientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ClientesActionPerformed(evt);
            }
        });
        menu.add(btn_Clientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 190, 270, 52));

        btn_Masajistas.setBackground(new java.awt.Color(21, 101, 192));
        btn_Masajistas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Masajistas.setForeground(new java.awt.Color(255, 255, 255));
        btn_Masajistas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-masajistas.png"))); // NOI18N
        btn_Masajistas.setText("Masajistas");
        btn_Masajistas.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Masajistas.setBorderPainted(false);
        btn_Masajistas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Masajistas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Masajistas.setIconTextGap(13);
        btn_Masajistas.setInheritsPopupMenu(true);
        btn_Masajistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_MasajistasActionPerformed(evt);
            }
        });
        menu.add(btn_Masajistas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 270, 52));

        btn_Tratamientos.setBackground(new java.awt.Color(21, 101, 192));
        btn_Tratamientos.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Tratamientos.setForeground(new java.awt.Color(255, 255, 255));
        btn_Tratamientos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-tratamientos.png"))); // NOI18N
        btn_Tratamientos.setText("Tratamientos");
        btn_Tratamientos.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Tratamientos.setBorderPainted(false);
        btn_Tratamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Tratamientos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Tratamientos.setIconTextGap(13);
        btn_Tratamientos.setInheritsPopupMenu(true);
        btn_Tratamientos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_TratamientosActionPerformed(evt);
            }
        });
        menu.add(btn_Tratamientos, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 290, 270, 52));

        btn_Instalaciones.setBackground(new java.awt.Color(21, 101, 192));
        btn_Instalaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Instalaciones.setForeground(new java.awt.Color(255, 255, 255));
        btn_Instalaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-gestion.png"))); // NOI18N
        btn_Instalaciones.setText("Formulario Día de Spa");
        btn_Instalaciones.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Instalaciones.setBorderPainted(false);
        btn_Instalaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Instalaciones.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Instalaciones.setIconTextGap(13);
        btn_Instalaciones.setInheritsPopupMenu(true);
        btn_Instalaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_InstalacionesActionPerformed(evt);
            }
        });
        menu.add(btn_Instalaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 440, 270, 52));

        btn_Salir.setBackground(new java.awt.Color(21, 101, 192));
        btn_Salir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Salir.setForeground(new java.awt.Color(255, 255, 255));
        btn_Salir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-quit.png"))); // NOI18N
        btn_Salir.setText("Salir");
        btn_Salir.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Salir.setBorderPainted(false);
        btn_Salir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Salir.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Salir.setIconTextGap(13);
        btn_Salir.setInheritsPopupMenu(true);
        btn_Salir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_SalirActionPerformed(evt);
            }
        });
        menu.add(btn_Salir, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 610, 270, 52));

        btn_Reportes.setBackground(new java.awt.Color(21, 101, 192));
        btn_Reportes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Reportes.setForeground(new java.awt.Color(255, 255, 255));
        btn_Reportes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-reportes.png"))); // NOI18N
        btn_Reportes.setText("Reportes");
        btn_Reportes.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Reportes.setBorderPainted(false);
        btn_Reportes.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Reportes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Reportes.setIconTextGap(13);
        btn_Reportes.setInheritsPopupMenu(true);
        btn_Reportes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_ReportesActionPerformed(evt);
            }
        });
        menu.add(btn_Reportes, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 490, 270, 52));

        jSeparator2.setPreferredSize(new java.awt.Dimension(50, 5));
        menu.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 210, 20));

        btn_Instalaciones1.setBackground(new java.awt.Color(21, 101, 192));
        btn_Instalaciones1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Instalaciones1.setForeground(new java.awt.Color(255, 255, 255));
        btn_Instalaciones1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-instalaciones.png"))); // NOI18N
        btn_Instalaciones1.setText("Instalaciones");
        btn_Instalaciones1.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Instalaciones1.setBorderPainted(false);
        btn_Instalaciones1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Instalaciones1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Instalaciones1.setIconTextGap(13);
        btn_Instalaciones1.setInheritsPopupMenu(true);
        btn_Instalaciones1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Instalaciones1ActionPerformed(evt);
            }
        });
        menu.add(btn_Instalaciones1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 340, 270, 52));

        btn_Instalaciones2.setBackground(new java.awt.Color(21, 101, 192));
        btn_Instalaciones2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btn_Instalaciones2.setForeground(new java.awt.Color(255, 255, 255));
        btn_Instalaciones2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-diasspa.png"))); // NOI18N
        btn_Instalaciones2.setText("Gestión Día de Spa");
        btn_Instalaciones2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 13, 1, 1, new java.awt.Color(0, 0, 0)));
        btn_Instalaciones2.setBorderPainted(false);
        btn_Instalaciones2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        btn_Instalaciones2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btn_Instalaciones2.setIconTextGap(13);
        btn_Instalaciones2.setInheritsPopupMenu(true);
        btn_Instalaciones2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_Instalaciones2ActionPerformed(evt);
            }
        });
        menu.add(btn_Instalaciones2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 390, 270, 52));

        header.setBackground(new java.awt.Color(25, 118, 210));
        header.setPreferredSize(new java.awt.Dimension(744, 150));
        header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        navText.setFont(new java.awt.Font("Roboto SemiCondensed Light", 1, 24)); // NOI18N
        navText.setText("Dashboard Menu");
        header.add(navText, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 10, 180, 33));

        appName1.setFont(new java.awt.Font("Roboto Condensed", 1, 20)); // NOI18N
        appName1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        appName1.setText("“Entre Dedos”");
        header.add(appName1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 180, 34));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/LogoMenu.png"))); // NOI18N
        header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-120, -230, -1, -1));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));
        header.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 40, 180, 20));

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout backgroundLayout = new javax.swing.GroupLayout(background);
        background.setLayout(backgroundLayout);
        backgroundLayout.setHorizontalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 760, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        backgroundLayout.setVerticalGroup(
            backgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(menu, javax.swing.GroupLayout.PREFERRED_SIZE, 662, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backgroundLayout.createSequentialGroup()
                .addComponent(header, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_prinActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_prinActionPerformed
        ShowJPanel(new PrincipalPanel());
    }//GEN-LAST:event_btn_prinActionPerformed

    private void btn_ClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ClientesActionPerformed
        ShowJPanel(new ClientesPanel());
    }//GEN-LAST:event_btn_ClientesActionPerformed

    private void btn_MasajistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_MasajistasActionPerformed
        ShowJPanel(new MasajistasPanel());
    }//GEN-LAST:event_btn_MasajistasActionPerformed

    private void btn_TratamientosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_TratamientosActionPerformed
        ShowJPanel(new TratamientoPanel());
    }//GEN-LAST:event_btn_TratamientosActionPerformed

    private void btn_InstalacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_InstalacionesActionPerformed
        ShowJPanel(new FormularioDiasSpaPanel());
    }//GEN-LAST:event_btn_InstalacionesActionPerformed

    private void btn_SalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_SalirActionPerformed

        int confirma = JOptionPane.showConfirmDialog(
          this,
          "¿Esta seguro que desea salir de la aplicación?",
          "Confirmar salida",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.QUESTION_MESSAGE
        );

        if( confirma == JOptionPane.YES_OPTION ){
            System.exit(0);
        }

    }//GEN-LAST:event_btn_SalirActionPerformed

    private void btn_ReportesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ReportesActionPerformed
        ShowJPanel(new ReportesPanel());
    }//GEN-LAST:event_btn_ReportesActionPerformed

    private void btn_Instalaciones1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Instalaciones1ActionPerformed
        ShowJPanel(new InstalacionesPanel());
    }//GEN-LAST:event_btn_Instalaciones1ActionPerformed

    private void btn_Instalaciones2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_Instalaciones2ActionPerformed
        ShowJPanel(new DiasSpaPanel());
    }//GEN-LAST:event_btn_Instalaciones2ActionPerformed

    public static void main(String args[]){
        configurarTemaYEstilosGlobales();

        try{
            UIManager.setLookAndFeel(new FlatIntelliJLaf());
        } catch( Exception e ){
            System.err.println("Error al aplicar FlatLaf: " + e.getMessage());
        }

        java.awt.EventQueue.invokeLater(new Runnable(){
            public void run(){
                new DashboardMenu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel appName;
    private javax.swing.JLabel appName1;
    private javax.swing.JPanel background;
    private javax.swing.JButton btn_Clientes;
    private javax.swing.JButton btn_Instalaciones;
    private javax.swing.JButton btn_Instalaciones1;
    private javax.swing.JButton btn_Instalaciones2;
    private javax.swing.JButton btn_Masajistas;
    private javax.swing.JButton btn_Reportes;
    private javax.swing.JButton btn_Salir;
    private javax.swing.JButton btn_Tratamientos;
    private javax.swing.JButton btn_prin;
    private static javax.swing.JPanel content;
    private javax.swing.JPanel header;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel menu;
    private javax.swing.JLabel navText;
    // End of variables declaration//GEN-END:variables

    private void inicializarPanelesEstaticos() {
        if (clientesPanel == null) {
            clientesPanel = new ClientesPanel();
            masajistasPanel = new MasajistasPanel();
            tratamientoPanel = new TratamientoPanel();
            instalacionesPanel = new InstalacionesPanel();
            diasSpaPanel = new DiasSpaPanel();
            formularioDiasSpaPanel = new FormularioDiasSpaPanel();
            reportesPanel = new ReportesPanel();
        }
    }
    
    private static void configurarTemaYEstilosGlobales(){
        try{

            UIManager.setLookAndFeel(new FlatIntelliJLaf());
            // CONFIGURACIÓN GLOBAL DE BORDES REDONDEADOS
            UIManager.put("Panel.arc", 20);              // Paneles redondeados
            UIManager.put("Button.arc", 15);             // Botones redondeados
            UIManager.put("Component.arc", 15);          // Componentes generales
            UIManager.put("TextComponent.arc", 10);      // Campos de texto base

            UIManager.put("TextField.arc", 10);          // Campos de texto
            UIManager.put("FormattedTextField.arc", 10); // Campos formateados
            UIManager.put("PasswordField.arc", 10);      // Campos de contraseña
            UIManager.put("TextArea.arc", 10);           // Áreas de texto
            UIManager.put("EditorPane.arc", 10);         // Editor de texto
            UIManager.put("TextPane.arc", 10);           // Panel de texto
            UIManager.put("Spinner.arc", 10);            // Spinners

            UIManager.put("CheckBox.arc", 5);            // CheckBoxes
            UIManager.put("ComboBox.arc", 10);           // ComboBoxes
            UIManager.put("ProgressBar.arc", 10);        // ProgressBars
            UIManager.put("TabbedPane.tabArc", 10);
            UIManager.put("TabbedPane.underlineColor", new Color(76, 175, 80)); // Pestañas
            UIManager.put("ScrollBar.thumbArc", 999);    // ScrollBars

            // Configuraciones adicionales
            UIManager.put("Table.showHorizontalLines", true);
            UIManager.put("Table.rowHeight", 25);
            UIManager.put("ScrollBar.thumbInsets", new java.awt.Insets(2, 2, 2, 2));

            System.out.println("Estilos globales aplicados");

        } catch( Exception e ){
            System.err.println("Error al configurar estilos: " + e.getMessage());
        }
    }

}

/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
 */
