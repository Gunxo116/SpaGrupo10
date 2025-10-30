package Views.DiasSpa;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

// ============================================
// RENDERER PARA MOSTRAR LOS BOTONES
// ============================================
class PanelBotonesRenderer extends JPanel implements TableCellRenderer{

    private JButton btnSesiones;
    private JButton btnEditar;
    private JButton btnEliminar;

    public PanelBotonesRenderer(){
        setLayout(new FlowLayout(FlowLayout.CENTER, 5, 2));

        // Botón Sesiones (Verde)
        btnSesiones = new JButton("Sesiones");
        btnSesiones.setBackground(new Color(76, 175, 80));
        btnSesiones.setForeground(Color.WHITE);
        btnSesiones.setFocusPainted(false);
        btnSesiones.setBorderPainted(false);
        btnSesiones.setPreferredSize(new Dimension(80, 25));

        // Botón Editar (Naranja)
        btnEditar = new JButton("✏");
        btnEditar.setBackground(new Color(255, 152, 0));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusPainted(false);
        btnEditar.setBorderPainted(false);
        btnEditar.setPreferredSize(new Dimension(35, 25));

        // Botón Eliminar (Rojo)
        btnEliminar = new JButton("x");
        btnEliminar.setBackground(new Color(244, 67, 54));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setPreferredSize(new Dimension(35, 25));

        add(btnSesiones);
        add(btnEditar);
        add(btnEliminar);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
      boolean isSelected, boolean hasFocus, int row, int column){
        return this;
    }
}
