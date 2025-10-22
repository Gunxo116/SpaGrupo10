package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RolSelectionDialog extends JDialog {

    private boolean isAdmin = false;
    private boolean selectionMade = false;

    public RolSelectionDialog(Frame parent) {
        super(parent, "Seleccionar Rol", true);
        initComponents();
    }

    private void initComponents() {
        setSize(600, 480);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                selectionMade = false;
                dispose();
            }
        });

        // Panel principal con gradiente
        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
                int w = getWidth();
                int h = getHeight();
                GradientPaint gp = new GradientPaint(0, 0, new Color(240, 242, 245), 0, h, new Color(255, 255, 255));
                g2d.setPaint(gp);
                g2d.fillRect(0, 0, w, h);
            }
        };
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Header con logo y título
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new BoxLayout(headerPanel, BoxLayout.Y_AXIS));
        headerPanel.setOpaque(false);

        // Logo
        JLabel logoLabel = new JLabel();
        try {
            ImageIcon logoIcon = new ImageIcon(getClass().getResource("/img/LogoCompleto.png"));
            Image img = logoIcon.getImage().getScaledInstance(140, 140, Image.SCALE_SMOOTH);
            logoLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            logoLabel.setText("SPA ENTRE DEDOS");
            logoLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
            logoLabel.setForeground(new Color(33, 33, 33));
        }
        logoLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Título
        JLabel titleLabel = new JLabel("Bienvenido");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(new Color(33, 33, 33));

        // Subtítulo
        JLabel subtitleLabel = new JLabel("Seleccione cómo desea ingresar");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        subtitleLabel.setForeground(new Color(117, 117, 117));

        headerPanel.add(logoLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        headerPanel.add(titleLabel);
        headerPanel.add(Box.createRigidArea(new Dimension(0, 5)));
        headerPanel.add(subtitleLabel);

        // Panel de botones con GridLayout para alinearlos lado a lado
        JPanel buttonsPanel = new JPanel(new GridLayout(1, 2, 20, 0));
        buttonsPanel.setOpaque(false);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(15, 50, 15, 50));

        // Botón Cliente
        JPanel btnCliente = createModernRoleCard(
                "CLIENTE",
                "Gestión de turnos y servicios",
                "/img/hd/iconohd-Clientes.png",
                new Color(76, 175, 80)
        );
        btnCliente.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isAdmin = false;
                selectionMade = true;
                dispose();
            }
        });

        // Botón Administrador
        JPanel btnAdmin = createModernRoleCard(
                "ADMINISTRADOR",
                "Control total del sistema",
                "/img/hd/iconohd-Instalaciones.png",
                new Color(33, 150, 243)
        );
        btnAdmin.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                isAdmin = true;
                selectionMade = true;
                dispose();
            }
        });

        buttonsPanel.add(btnCliente);
        buttonsPanel.add(btnAdmin);

        // Footer
        JLabel footerLabel = new JLabel("© 2025 Spa Entre Dedos - Grupo10 - Todos los derechos reservados");
        footerLabel.setFont(new Font("Segoe UI", Font.PLAIN, 10));
        footerLabel.setForeground(new Color(158, 158, 158));
        footerLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Agregar componentes
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);
        mainPanel.add(footerLabel, BorderLayout.SOUTH);

        add(mainPanel);
    }

    private JPanel createModernRoleCard(String title, String description, String iconPath, Color accentColor) {
        // Panel principal con bordes redondeados y tamaño fijo más compacto
        JPanel card = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                
                // Fondo con color del acento
                g2d.setColor(accentColor);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 15, 15);
                
                // Borde más oscuro
                g2d.setColor(accentColor.darker());
                g2d.setStroke(new BasicStroke(2));
                g2d.drawRoundRect(1, 1, getWidth() - 3, getHeight() - 3, 15, 15);
            }
            
            @Override
            public Dimension getPreferredSize() {
                return new Dimension(220, 120);
            }
        };
        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setOpaque(false);
        card.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        // Panel de contenido con padding reducido
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 15, 20, 15));
        
        // Espaciador superior
        Component topSpacer = Box.createVerticalGlue();
        
        // Icono
        JLabel iconLabel = new JLabel();
        try {
            ImageIcon icon = new ImageIcon(getClass().getResource(iconPath));
            Image img = icon.getImage().getScaledInstance(35, 35, Image.SCALE_SMOOTH);
            iconLabel.setIcon(new ImageIcon(img));
        } catch (Exception e) {
            System.err.println("No se pudo cargar el icono: " + iconPath);
        }
        iconLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        
        // Espacio después del icono
        Component iconSpacer = Box.createRigidArea(new Dimension(0, 10));
        
        // Título - BLANCO para contraste con fondo de color
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 17));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setForeground(Color.WHITE);

        // Espaciador inferior
        Component bottomSpacer = Box.createVerticalGlue();
        
        // Añadir componentes al panel de contenido
        contentPanel.add(topSpacer);
        contentPanel.add(iconLabel);
        contentPanel.add(iconSpacer);
        contentPanel.add(titleLabel);
        contentPanel.add(bottomSpacer);
        
        // Añadir componentes al card
        card.add(contentPanel);

        // Efecto hover
        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                card.repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                card.repaint();
            }

            @Override
            public void mousePressed(MouseEvent e) {
                // Efecto de presión - mover ligeramente
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // Volver a posición normal
            }
        });

        return card;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public boolean isSelectionMade() {
        return selectionMade;
    }
}