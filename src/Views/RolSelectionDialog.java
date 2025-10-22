package Views;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class RolSelectionDialog extends JDialog{

    private boolean isAdmin = false;
    private boolean selectionMade = false;

    public RolSelectionDialog(Frame parent){
        super(parent, "Seleccionar Rol", true);
        initComponents();
    }

    private void initComponents(){
        setSize(400, 300);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        // Cerrar sin seleccionar cuando se cierra con la X
        addWindowListener(new WindowAdapter(){
            @Override
            public void windowClosing(WindowEvent e){
                selectionMade = false;
                dispose();
            }
        });

        // Panel principal
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(Color.WHITE);

        // Título
        JLabel titleLabel = new JLabel("Bienvenido a Spa \"Entre Dedos\"");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setForeground(new Color(13, 71, 161));

        JLabel subtitleLabel = new JLabel("Seleccione su tipo de usuario");
        subtitleLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        subtitleLabel.setForeground(new Color(100, 100, 100));

        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 5, 5));
        headerPanel.setBackground(Color.WHITE);
        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        // Panel de botones
        JPanel buttonsPanel = new JPanel(new GridLayout(2, 1, 15, 15));
        buttonsPanel.setBackground(Color.WHITE);
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 30, 40));

        // Botón Cliente
        JButton btnCliente = createRoleButton(
          "CLIENTE",
          "Acceso a Días de Spa y Sesiones",
          new Color(76, 175, 80)
        );
        btnCliente.addActionListener(e -> {
            isAdmin = false;
            selectionMade = true;
            dispose();
        });

        // Botón Administrador
        JButton btnAdmin = createRoleButton(
          "ADMINISTRADOR",
          "Acceso completo al sistema",
          new Color(33, 150, 243)
        );
        btnAdmin.addActionListener(e -> {
            isAdmin = true;
            selectionMade = true;
            dispose();
        });

        buttonsPanel.add(btnCliente);
        buttonsPanel.add(btnAdmin);

        // Agregar componentes
        mainPanel.add(headerPanel, BorderLayout.NORTH);
        mainPanel.add(buttonsPanel, BorderLayout.CENTER);

        add(mainPanel);
    }

    private JButton createRoleButton(String title, String description, Color color){
        JButton button = new JButton();
        button.setLayout(new BorderLayout(10, 5));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setPreferredSize(new Dimension(300, 70));

        // Título del botón
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 16));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Descripción del botón
        JLabel descLabel = new JLabel(description);
        descLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        descLabel.setForeground(new Color(255, 255, 255, 200));
        descLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JPanel textPanel = new JPanel(new GridLayout(2, 1));
        textPanel.setOpaque(false);
        textPanel.add(titleLabel);
        textPanel.add(descLabel);

        button.add(textPanel, BorderLayout.CENTER);

        // Efecto hover
        button.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                button.setBackground(color.darker());
            }

            @Override
            public void mouseExited(MouseEvent e){
                button.setBackground(color);
            }
        });

        return button;
    }

    public boolean isAdmin(){
        return isAdmin;
    }

    public boolean isSelectionMade(){
        return selectionMade;
    }
}
