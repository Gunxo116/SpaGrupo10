
package Views.Principal;

import Persistencia.EstadisticasData;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class PrincipalPanel extends javax.swing.JPanel {
    
    private JLabel lblClientesActivos;
    private JLabel lblMasajistasDisponibles;
    private JLabel lblSesionesDelDia;
    private JLabel lblDiasSpasPendientes;
    private JLabel lblInstalacionesActivas;
    private JLabel lblTratamientosActivos;
    private JLabel lblIngresosDelMes;

    public PrincipalPanel() {
        initComponents();
        
        configurarPrincipal();
        actualizarEstadisticas();
        //configurarDashboard();
    }
    
    
    private void configurarPrincipal(){

        PanelClientes.setOpaque(false);
        PanelClientes.setBackground(new java.awt.Color(52, 152, 219)); 
        PanelMasajistas.setOpaque(false);
        PanelMasajistas.setBackground(new java.awt.Color(46, 204, 113)); 
        PanelSesiones.setOpaque(false);
        PanelSesiones.setBackground(new java.awt.Color(155, 89, 182)); 
        PanelDiaSpa.setOpaque(false);
        PanelDiaSpa.setBackground(new java.awt.Color(241, 196, 15));
        PanelInstalaciones.setOpaque(false);
        PanelInstalaciones.setBackground(new java.awt.Color(230, 126, 34));
        PanelTratamientos.setOpaque(false);
        PanelTratamientos.setBackground(new java.awt.Color(231, 76, 60));
        PanelIngresos.setOpaque(false);
        PanelIngresos.setBackground(new java.awt.Color(26, 188, 156));
        PanelRecargar.setOpaque(false);
        PanelRecargar.setBackground(new java.awt.Color(52, 152, 219));
        
        jPanelicono.setOpaque(false);
        jPanelicono.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono1.setOpaque(false);
        jPanelicono1.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono2.setOpaque(false);
        jPanelicono2.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono3.setOpaque(false);
        jPanelicono3.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono4.setOpaque(false);
        jPanelicono4.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono5.setOpaque(false);
        jPanelicono5.setBackground(new java.awt.Color(0, 0, 0, 60));
        jPanelicono6.setOpaque(false);
        jPanelicono6.setBackground(new java.awt.Color(0, 0, 0, 60));
        
        
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        PanelClientes = new javax.swing.JPanel(){

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
        jPanelicono = new javax.swing.JPanel(){

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
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        numClientes = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        PanelMasajistas = new javax.swing.JPanel(){

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
        jPanelicono1 = new javax.swing.JPanel(){

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
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        numMasajistas = new javax.swing.JLabel();
        PanelSesiones = new javax.swing.JPanel(){

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
        jPanelicono2 = new javax.swing.JPanel(){

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
        jLabel4 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        numSesiones = new javax.swing.JLabel();
        PanelDiaSpa = new javax.swing.JPanel(){

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
        jPanelicono3 = new javax.swing.JPanel(){

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
        jLabel5 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        numDiaSpa = new javax.swing.JLabel();
        PanelInstalaciones = new javax.swing.JPanel(){

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
        jPanelicono4 = new javax.swing.JPanel(){

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
        jLabel6 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        numInstalaciones = new javax.swing.JLabel();
        PanelTratamientos = new javax.swing.JPanel(){

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
        jPanelicono5 = new javax.swing.JPanel(){

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
        jLabel7 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        numTratamientos = new javax.swing.JLabel();
        PanelRecargar = new javax.swing.JPanel(){

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
        jLabel10 = new javax.swing.JLabel();
        PanelIngresos = new javax.swing.JPanel(){

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
        jPanelicono6 = new javax.swing.JPanel(){

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
        jLabel8 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        numIngresoMes = new javax.swing.JLabel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        PanelClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-clientes.png"))); // NOI18N

        javax.swing.GroupLayout jPaneliconoLayout = new javax.swing.GroupLayout(jPanelicono);
        jPanelicono.setLayout(jPaneliconoLayout);
        jPaneliconoLayout.setHorizontalGroup(
            jPaneliconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneliconoLayout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(43, 43, 43))
        );
        jPaneliconoLayout.setVerticalGroup(
            jPaneliconoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPaneliconoLayout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addGap(15, 15, 15))
        );

        jLabel9.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel9.setText("Clientes");

        numClientes.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numClientes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numClientes.setText("0");

        javax.swing.GroupLayout PanelClientesLayout = new javax.swing.GroupLayout(PanelClientes);
        PanelClientes.setLayout(PanelClientesLayout);
        PanelClientesLayout.setHorizontalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelClientesLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(52, 52, 52))
        );
        PanelClientesLayout.setVerticalGroup(
            PanelClientesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelClientesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numClientes)
                .addGap(28, 28, 28))
        );

        jLabel1.setFont(new java.awt.Font("Century Gothic", 1, 18)); // NOI18N
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-consultorios.png"))); // NOI18N
        jLabel1.setText("Estadisticas Generales");

        jSeparator1.setForeground(new java.awt.Color(204, 204, 204));

        PanelMasajistas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-masajistas.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono1Layout = new javax.swing.GroupLayout(jPanelicono1);
        jPanelicono1.setLayout(jPanelicono1Layout);
        jPanelicono1Layout.setHorizontalGroup(
            jPanelicono1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono1Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(43, 43, 43))
        );
        jPanelicono1Layout.setVerticalGroup(
            jPanelicono1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(15, 15, 15))
        );

        jLabel11.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel11.setText("Masajistas");

        numMasajistas.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numMasajistas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numMasajistas.setText("0");

        javax.swing.GroupLayout PanelMasajistasLayout = new javax.swing.GroupLayout(PanelMasajistas);
        PanelMasajistas.setLayout(PanelMasajistasLayout);
        PanelMasajistasLayout.setHorizontalGroup(
            PanelMasajistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasajistasLayout.createSequentialGroup()
                .addGroup(PanelMasajistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelMasajistasLayout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jPanelicono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(PanelMasajistasLayout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(PanelMasajistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel11, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(numMasajistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        PanelMasajistasLayout.setVerticalGroup(
            PanelMasajistasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMasajistasLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(numMasajistas)
                .addGap(27, 27, 27))
        );

        PanelSesiones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-reportes.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono2Layout = new javax.swing.GroupLayout(jPanelicono2);
        jPanelicono2.setLayout(jPanelicono2Layout);
        jPanelicono2Layout.setHorizontalGroup(
            jPanelicono2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono2Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(43, 43, 43))
        );
        jPanelicono2Layout.setVerticalGroup(
            jPanelicono2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel4)
                .addGap(15, 15, 15))
        );

        jLabel12.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel12.setText("Sesiones hoy");

        numSesiones.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numSesiones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numSesiones.setText("0");

        javax.swing.GroupLayout PanelSesionesLayout = new javax.swing.GroupLayout(PanelSesiones);
        PanelSesiones.setLayout(PanelSesionesLayout);
        PanelSesionesLayout.setHorizontalGroup(
            PanelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSesionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelSesionesLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PanelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numSesiones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(35, 35, 35))
        );
        PanelSesionesLayout.setVerticalGroup(
            PanelSesionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelSesionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel12)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(numSesiones)
                .addGap(23, 23, 23))
        );

        PanelDiaSpa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono3.setBackground(new java.awt.Color(255, 255, 255));

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-diasspa.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono3Layout = new javax.swing.GroupLayout(jPanelicono3);
        jPanelicono3.setLayout(jPanelicono3Layout);
        jPanelicono3Layout.setHorizontalGroup(
            jPanelicono3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono3Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(43, 43, 43))
        );
        jPanelicono3Layout.setVerticalGroup(
            jPanelicono3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono3Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addGap(15, 15, 15))
        );

        jLabel13.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel13.setText("Dias Spa");

        numDiaSpa.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numDiaSpa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numDiaSpa.setText("0");

        javax.swing.GroupLayout PanelDiaSpaLayout = new javax.swing.GroupLayout(PanelDiaSpa);
        PanelDiaSpa.setLayout(PanelDiaSpaLayout);
        PanelDiaSpaLayout.setHorizontalGroup(
            PanelDiaSpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDiaSpaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelDiaSpaLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(PanelDiaSpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numDiaSpa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(47, 47, 47))
        );
        PanelDiaSpaLayout.setVerticalGroup(
            PanelDiaSpaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelDiaSpaLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel13)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(numDiaSpa)
                .addGap(23, 23, 23))
        );

        PanelInstalaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono4.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-home.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono4Layout = new javax.swing.GroupLayout(jPanelicono4);
        jPanelicono4.setLayout(jPanelicono4Layout);
        jPanelicono4Layout.setHorizontalGroup(
            jPanelicono4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono4Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(43, 43, 43))
        );
        jPanelicono4Layout.setVerticalGroup(
            jPanelicono4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono4Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(15, 15, 15))
        );

        jLabel14.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel14.setText("Instalaciones");

        numInstalaciones.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numInstalaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numInstalaciones.setText("0");

        javax.swing.GroupLayout PanelInstalacionesLayout = new javax.swing.GroupLayout(PanelInstalaciones);
        PanelInstalaciones.setLayout(PanelInstalacionesLayout);
        PanelInstalacionesLayout.setHorizontalGroup(
            PanelInstalacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInstalacionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelInstalacionesLayout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(PanelInstalacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numInstalaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel14, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(34, 34, 34))
        );
        PanelInstalacionesLayout.setVerticalGroup(
            PanelInstalacionesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelInstalacionesLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel14)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(numInstalaciones)
                .addGap(26, 26, 26))
        );

        PanelTratamientos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelTratamientos.setPreferredSize(new java.awt.Dimension(145, 196));

        jPanelicono5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-tratamientos.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono5Layout = new javax.swing.GroupLayout(jPanelicono5);
        jPanelicono5.setLayout(jPanelicono5Layout);
        jPanelicono5Layout.setHorizontalGroup(
            jPanelicono5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono5Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(43, 43, 43))
        );
        jPanelicono5Layout.setVerticalGroup(
            jPanelicono5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono5Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(15, 15, 15))
        );

        jLabel15.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel15.setText("Tratamientos");

        numTratamientos.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numTratamientos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numTratamientos.setText("0");

        javax.swing.GroupLayout PanelTratamientosLayout = new javax.swing.GroupLayout(PanelTratamientos);
        PanelTratamientos.setLayout(PanelTratamientosLayout);
        PanelTratamientosLayout.setHorizontalGroup(
            PanelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTratamientosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelTratamientosLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(PanelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(36, 36, 36))
        );
        PanelTratamientosLayout.setVerticalGroup(
            PanelTratamientosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelTratamientosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numTratamientos)
                .addGap(23, 23, 23))
        );

        PanelRecargar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        PanelRecargar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PanelRecargarMouseClicked(evt);
            }
        });

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hd/iconohd-Actualizar.png"))); // NOI18N

        javax.swing.GroupLayout PanelRecargarLayout = new javax.swing.GroupLayout(PanelRecargar);
        PanelRecargar.setLayout(PanelRecargarLayout);
        PanelRecargarLayout.setHorizontalGroup(
            PanelRecargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelRecargarLayout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(jLabel10)
                .addGap(40, 40, 40))
        );
        PanelRecargarLayout.setVerticalGroup(
            PanelRecargarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelRecargarLayout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addComponent(jLabel10)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        PanelIngresos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanelicono6.setBackground(new java.awt.Color(255, 255, 255));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icono-Ingresos.png"))); // NOI18N

        javax.swing.GroupLayout jPanelicono6Layout = new javax.swing.GroupLayout(jPanelicono6);
        jPanelicono6.setLayout(jPanelicono6Layout);
        jPanelicono6Layout.setHorizontalGroup(
            jPanelicono6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono6Layout.createSequentialGroup()
                .addContainerGap(46, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(43, 43, 43))
        );
        jPanelicono6Layout.setVerticalGroup(
            jPanelicono6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelicono6Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(15, 15, 15))
        );

        jLabel16.setFont(new java.awt.Font("Century Gothic", 1, 12)); // NOI18N
        jLabel16.setText("Ingresos Mes");

        numIngresoMes.setFont(new java.awt.Font("Century Gothic", 1, 30)); // NOI18N
        numIngresoMes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        numIngresoMes.setText("0");

        javax.swing.GroupLayout PanelIngresosLayout = new javax.swing.GroupLayout(PanelIngresos);
        PanelIngresos.setLayout(PanelIngresosLayout);
        PanelIngresosLayout.setHorizontalGroup(
            PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelIngresosLayout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(numIngresoMes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(37, 37, 37))
        );
        PanelIngresosLayout.setVerticalGroup(
            PanelIngresosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelIngresosLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanelicono6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel16)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(numIngresoMes)
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(30, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelClientes, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelInstalaciones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelTratamientos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelMasajistas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PanelIngresos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelDiaSpa, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PanelRecargar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 700, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(PanelDiaSpa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PanelSesiones, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(PanelMasajistas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(PanelClientes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(PanelInstalaciones, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelTratamientos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelIngresos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PanelRecargar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(32, Short.MAX_VALUE))
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

    private void PanelRecargarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PanelRecargarMouseClicked
        
        actualizarEstadisticas();
        
    }//GEN-LAST:event_PanelRecargarMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelClientes;
    private javax.swing.JPanel PanelDiaSpa;
    private javax.swing.JPanel PanelIngresos;
    private javax.swing.JPanel PanelInstalaciones;
    private javax.swing.JPanel PanelMasajistas;
    private javax.swing.JPanel PanelRecargar;
    private javax.swing.JPanel PanelSesiones;
    private javax.swing.JPanel PanelTratamientos;
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
    private javax.swing.JPanel jPanelicono;
    private javax.swing.JPanel jPanelicono1;
    private javax.swing.JPanel jPanelicono2;
    private javax.swing.JPanel jPanelicono3;
    private javax.swing.JPanel jPanelicono4;
    private javax.swing.JPanel jPanelicono5;
    private javax.swing.JPanel jPanelicono6;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel numClientes;
    private javax.swing.JLabel numDiaSpa;
    private javax.swing.JLabel numIngresoMes;
    private javax.swing.JLabel numInstalaciones;
    private javax.swing.JLabel numMasajistas;
    private javax.swing.JLabel numSesiones;
    private javax.swing.JLabel numTratamientos;
    // End of variables declaration//GEN-END:variables

    public void actualizarEstadisticas() {
        setCursor(Cursor.getPredefinedCursor(Cursor.WAIT_CURSOR));

        try {
            int clientesActivos = EstadisticasData.obtenerTotalClientesActivos();
            int masajistasDisponibles = EstadisticasData.obtenerTotalMasajistasDisponibles();
            int sesionesDelDia = EstadisticasData.obtenerSesionesDelDia();
            int diasSpasPendientes = EstadisticasData.obtenerDiasDeSpasPendientes();
            int instalacionesActivas = EstadisticasData.obtenerTotalInstalacionesActivas();
            int tratamientosActivos = EstadisticasData.obtenerTotalTratamientosActivos();
            double ingresosDelMes = EstadisticasData.obtenerIngresosDelMes();

            // Actualizar los labels con tus nombres actuales
            numClientes.setText(String.valueOf(clientesActivos));
            numMasajistas.setText(String.valueOf(masajistasDisponibles));
            numSesiones.setText(String.valueOf(sesionesDelDia));
            numDiaSpa.setText(String.valueOf(diasSpasPendientes));
            numInstalaciones.setText(String.valueOf(instalacionesActivas));
            numTratamientos.setText(String.valueOf(tratamientosActivos));
            numIngresoMes.setText(String.format("$%.2f", ingresosDelMes));

            System.out.println("Estadisticas actualizadas correctamente");

        } catch (Exception e) {
            System.err.println("Error actualizando estadisticas: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al cargar las estadísticas.\nVerifique la conexion a la base de datos.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }


}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
