
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
        configurarDashboard();
    }
    
    // configurarDashboard //
    
    private void configurarDashboard() {
        
        jPanel1.setLayout(new BorderLayout(10, 10));
        jPanel1.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        jPanel1.setBackground(Color.WHITE);
        jPanel1.add(crearPanelEstadisticas(), BorderLayout.CENTER);
        actualizarEstadisticas();
        
    }
    

    private JPanel crearPanelEstadisticas() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBackground(Color.WHITE);

        JPanel panelTitulo = new JPanel(new FlowLayout(FlowLayout.LEFT));
        panelTitulo.setBackground(Color.WHITE);
        
        JLabel lblTituloStats = new JLabel("Estadísticas Generales");
        lblTituloStats.setFont(new Font("Segoe UI", Font.BOLD, 20));
        lblTituloStats.setForeground(new Color(44, 62, 80));
        panelTitulo.add(lblTituloStats);
        
        panelPrincipal.add(panelTitulo, BorderLayout.NORTH);

        JPanel panelGrid = new JPanel(new GridLayout(2, 4, 15, 15));
        panelGrid.setBackground(Color.WHITE);
        panelGrid.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        panelGrid.add(crearTarjetaEstadistica("Clientes", "0", new Color(52, 152, 219), "/img/hd/iconohd-clientes.png"));
        panelGrid.add(crearTarjetaEstadistica("Masajistas", "0", new Color(46, 204, 113), "/img/hd/iconohd-Masajistas.png"));
        panelGrid.add(crearTarjetaEstadistica("Sesiones Hoy", "0", new Color(155, 89, 182), "/img/hd/iconohd-Sesiones.png"));
        panelGrid.add(crearTarjetaEstadistica("Días Spa", "0", new Color(241, 196, 15), "/img/hd/iconohd-DiasSpa.png"));
        panelGrid.add(crearTarjetaEstadistica("Instalaciones", "0", new Color(230, 126, 34), "/img/hd/iconohd-Instalaciones.png"));
        panelGrid.add(crearTarjetaEstadistica("Tratamientos", "0", new Color(231, 76, 60), "/img/hd/iconohd-Tratamientos.png"));
        panelGrid.add(crearTarjetaEstadistica("Ingresos Mes", "$0.00", new Color(26, 188, 156), "/img/hd/iconohd-Ingresos.png"));
        panelGrid.add(crearBotonActualizar());

        panelPrincipal.add(panelGrid, BorderLayout.CENTER);

        return panelPrincipal;
    }

    private JPanel crearTarjetaEstadistica(String titulo, String valor, Color colorBase, String rutaIcono) {
        JPanel tarjeta = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 25, 25);
                GradientPaint gradient = new GradientPaint(
                    0, 0, colorBase,
                    0, getHeight(), colorBase.darker()
                );
                g2.setPaint(gradient);
                g2.fillRoundRect(0, 0, getWidth() - 4, getHeight() - 4, 25, 25);
                
                g2.dispose();
            }
        };
        
        tarjeta.setLayout(new BorderLayout(5, 5));
        tarjeta.setOpaque(false);
        tarjeta.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        tarjeta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                tarjeta.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                tarjeta.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
            }
        });

        JPanel panelIcono = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(255, 255, 255, 50));
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                g2.dispose();
            }
        };
        panelIcono.setOpaque(false);
        panelIcono.setLayout(new GridBagLayout());
        panelIcono.setPreferredSize(new Dimension(60, 60));

        JLabel lblIcono = new JLabel();
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource(rutaIcono));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(36, 36, Image.SCALE_SMOOTH);
            lblIcono.setIcon(new ImageIcon(imagenEscalada));
        } catch (Exception e) {
            lblIcono.setText("◆");
            lblIcono.setFont(new Font("Arial", Font.BOLD, 36));
            lblIcono.setForeground(Color.WHITE);
        }
        panelIcono.add(lblIcono);
        JPanel panelTexto = new JPanel();
        panelTexto.setLayout(new BoxLayout(panelTexto, BoxLayout.Y_AXIS));
        panelTexto.setOpaque(false);
        panelTexto.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblTitulo.setForeground(new Color(255, 255, 255, 220));
        lblTitulo.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 32));
        lblValor.setForeground(Color.WHITE);
        lblValor.setAlignmentX(Component.CENTER_ALIGNMENT);

        switch(titulo) {
            case "Clientes": lblClientesActivos = lblValor; break;
            case "Masajistas": lblMasajistasDisponibles = lblValor; break;
            case "Sesiones Hoy": lblSesionesDelDia = lblValor; break;
            case "Días Spa": lblDiasSpasPendientes = lblValor; break;
            case "Instalaciones": lblInstalacionesActivas = lblValor; break;
            case "Tratamientos": lblTratamientosActivos = lblValor; break;
            case "Ingresos Mes": lblIngresosDelMes = lblValor; break;
        }

        panelTexto.add(lblTitulo);
        panelTexto.add(Box.createVerticalStrut(5));
        panelTexto.add(lblValor);

        tarjeta.add(panelIcono, BorderLayout.NORTH);
        tarjeta.add(panelTexto, BorderLayout.CENTER);

        return tarjeta;
    }

    private JPanel crearBotonActualizar() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(0, 0, 0, 20));
                g2.fillRoundRect(2, 2, getWidth() - 4, getHeight() - 4, 25, 25);
                GradientPaint gradient = new GradientPaint(
                    0, 0, new Color(52, 152, 219),
                    0, getHeight(), new Color(41, 128, 185)
                );
                g2.setPaint(gradient);
                g2.fillRoundRect(0, 0, getWidth() - 4, getHeight() - 4, 25, 25);
                g2.dispose();
            }
        };
        
        panel.setLayout(new GridBagLayout());
        panel.setOpaque(false);

        JButton btnActualizar = new JButton();
        
        try {
            ImageIcon iconoOriginal = new ImageIcon(getClass().getResource("/img/hd/iconohd-Actualizar.png"));
            Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(48, 48, Image.SCALE_SMOOTH);
            btnActualizar.setIcon(new ImageIcon(imagenEscalada));
        } catch (Exception e) {
            btnActualizar.setText("↻");
            btnActualizar.setFont(new Font("Arial", Font.BOLD, 48));
        }

        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setContentAreaFilled(false);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizar.setToolTipText("Actualizar estadísticas");
        
        // Efecto hover
        btnActualizar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panel.setBackground(new Color(52, 152, 219).brighter());
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panel.setBackground(new Color(52, 152, 219));
            }
        });

        btnActualizar.addActionListener(e -> actualizarEstadisticas());

        panel.add(btnActualizar);

        return panel;
    }
    
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
            
            lblClientesActivos.setText(String.valueOf(clientesActivos));
            lblMasajistasDisponibles.setText(String.valueOf(masajistasDisponibles));
            lblSesionesDelDia.setText(String.valueOf(sesionesDelDia));
            lblDiasSpasPendientes.setText(String.valueOf(diasSpasPendientes));
            lblInstalacionesActivas.setText(String.valueOf(instalacionesActivas));
            lblTratamientosActivos.setText(String.valueOf(tratamientosActivos));
            lblIngresosDelMes.setText(String.format("$%.2f", ingresosDelMes));
            
            System.out.println("Estadisticas actualizadas correctamente");
            
        } catch (Exception e) {
            System.err.println("Error actualizando estadisticas: " + e.getMessage());
            JOptionPane.showMessageDialog(this,
                "Error al cargar las estadísticas.\nVerifique la conexión a la base de datos.",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        } finally {
            setCursor(Cursor.getDefaultCursor());
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 51, 51));
        jPanel1.setToolTipText("");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 760, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 531, Short.MAX_VALUE)
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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}


/*
             /\_/\           ___
            = o_o =_______    \ \
             __^      __(  \.__) )
         (@)<_____>__(_____)____/
*/
