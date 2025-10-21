
package Views.Principal;

import Views.*;
import Persistencia.EstadisticasData;
import javax.swing.*;
import java.awt.*;
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
    private JLabel lblFechaHora;
    private Timer timer;

    public PrincipalPanel() {
        initComponents();
        configurarDashboard();
    }
    
    // configurarDashboard //
    
    private void configurarDashboard() {
        jPanel1.setLayout(new BorderLayout(5, 5));
        jPanel1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Panel central con estadísticas (SIN panel superior)
        jPanel1.add(crearPanelEstadisticas(), BorderLayout.CENTER);

        // Cargar estadísticas iniciales
        actualizarEstadisticas();
    }
    

    private JPanel crearPanelEstadisticas() {
        JPanel panelPrincipal = new JPanel(new BorderLayout(5, 5));
        panelPrincipal.setBackground(Color.WHITE);

        JLabel lblTituloStats = new JLabel("Estadísticas Generales");
        lblTituloStats.setFont(new Font("Segoe UI", Font.BOLD, 14));
        lblTituloStats.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0));
        panelPrincipal.add(lblTituloStats, BorderLayout.NORTH);

        JPanel panelGrid = new JPanel(new GridLayout(2, 4, 10, 10));
        panelGrid.setBackground(Color.WHITE);

        // Usar los iconos que ya tienes
        panelGrid.add(crearTarjetaEstadistica("Clientes", "0", new Color(52, 152, 219), "/img/icono-clientes.png"));
        panelGrid.add(crearTarjetaEstadistica("Masajistas", "0", new Color(46, 204, 113), "/img/icono-consultorios.png"));
        panelGrid.add(crearTarjetaEstadistica("Sesiones Hoy", "0", new Color(155, 89, 182), "/img/icono-masajistas.png"));
        panelGrid.add(crearTarjetaEstadistica("Días Spa", "0", new Color(241, 196, 15), "/img/icono-diasspa.png"));
        panelGrid.add(crearTarjetaEstadistica("Instalaciones", "0", new Color(230, 126, 34), "/img/icono-instalaciones.png"));
        panelGrid.add(crearTarjetaEstadistica("Tratamientos", "0", new Color(231, 76, 60), "/img/icono-tratamientos.png"));
        panelGrid.add(crearTarjetaEstadistica("Ingresos Mes", "$0.00", new Color(26, 188, 156), "/img/icono-reportes.png"));

        JPanel btnActualizar = crearBotonActualizar();
        panelGrid.add(btnActualizar);

        panelPrincipal.add(panelGrid, BorderLayout.CENTER);

        return panelPrincipal;
    }

    private JPanel crearTarjetaEstadistica(String titulo, String valor, Color color, String rutaIcono) {
        JPanel tarjeta = new JPanel(new BorderLayout(3, 3));
        tarjeta.setBackground(color);
        tarjeta.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(color.darker(), 2, true),
            BorderFactory.createEmptyBorder(8, 8, 8, 8)
        ));

        // Cargar el icono sin escalar (24x24 original)
        JLabel lblIcono = new JLabel();
        try {
            ImageIcon icono = new ImageIcon(getClass().getResource(rutaIcono));
            lblIcono.setIcon(icono);
        } catch (Exception e) {
            lblIcono.setText("▣");
            lblIcono.setFont(new Font("Arial", Font.PLAIN, 24));
            lblIcono.setForeground(Color.WHITE);
        }
        lblIcono.setHorizontalAlignment(SwingConstants.CENTER);
        lblIcono.setBorder(BorderFactory.createEmptyBorder(5, 0, 5, 0)); // Espaciado extra

        JPanel panelTexto = new JPanel(new GridLayout(2, 1, 0, 2));
        panelTexto.setBackground(color);

        JLabel lblTitulo = new JLabel(titulo);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 10));
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel lblValor = new JLabel(valor);
        lblValor.setFont(new Font("Segoe UI", Font.BOLD, 18));
        lblValor.setForeground(Color.WHITE);
        lblValor.setHorizontalAlignment(SwingConstants.CENTER);

        switch(titulo) {
            case "Clientes":
                lblClientesActivos = lblValor;
                break;
            case "Masajistas":
                lblMasajistasDisponibles = lblValor;
                break;
            case "Sesiones Hoy":
                lblSesionesDelDia = lblValor;
                break;
            case "Días Spa":
                lblDiasSpasPendientes = lblValor;
                break;
            case "Instalaciones":
                lblInstalacionesActivas = lblValor;
                break;
            case "Tratamientos":
                lblTratamientosActivos = lblValor;
                break;
            case "Ingresos Mes":
                lblIngresosDelMes = lblValor;
                break;
        }

        panelTexto.add(lblTitulo);
        panelTexto.add(lblValor);

        tarjeta.add(lblIcono, BorderLayout.NORTH);
        tarjeta.add(panelTexto, BorderLayout.CENTER);

        return tarjeta;
    }

    private JPanel crearBotonActualizar() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(new Color(52, 152, 219));
        panel.setBorder(BorderFactory.createLineBorder(new Color(189, 195, 199), 2, true));

        JButton btnActualizar = new JButton();

        try {
            ImageIcon icono = new ImageIcon(getClass().getResource("/img/icono-recargar.png"));
            btnActualizar.setIcon(icono);
        } catch (Exception e) {
            btnActualizar.setText("↻");
            btnActualizar.setFont(new Font("Arial", Font.BOLD, 32));
        }

        btnActualizar.setBackground(new Color(52, 152, 219));
        btnActualizar.setForeground(Color.WHITE);
        btnActualizar.setFocusPainted(false);
        btnActualizar.setBorderPainted(false);
        btnActualizar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnActualizar.setPreferredSize(new Dimension(60, 60));
        btnActualizar.setToolTipText("Actualizar estadísticas");

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
            
            System.out.println("Estadísticas actualizadas correctamente");
            
        } catch (Exception e) {
            System.err.println("Error actualizando estadísticas: " + e.getMessage());
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
