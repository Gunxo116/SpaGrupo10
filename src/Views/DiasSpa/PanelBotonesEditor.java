package Views.DiasSpa;

import Modelo.DiaDeSpa;
import Persistencia.DiaDeSpaData;
import Views.DashboardMenu;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

class PanelBotonesEditor extends AbstractCellEditor implements TableCellEditor{

    private JPanel panel;
    private JButton btnSesiones;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JTable tabla;
    private int filaActual;
    private DiasSpaPanel panelPadre; // Referencia al panel padre para recargar

    public PanelBotonesEditor(JTable tabla, DiasSpaPanel panelPadre){
        this.tabla = tabla;
        this.panelPadre = panelPadre;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));

        // Botón Sesiones
        btnSesiones = new JButton("Sesiones");
        btnSesiones.setBackground(new Color(76, 175, 80));
        btnSesiones.setForeground(Color.WHITE);
        btnSesiones.setFocusPainted(false);
        btnSesiones.setBorderPainted(false);
        btnSesiones.setPreferredSize(new Dimension(80, 25));
        btnSesiones.addActionListener(e -> {
            fireEditingStopped();
            accionSesiones();
        });

        // Botón Editar
        btnEditar = new JButton("✏");
        btnEditar.setBackground(new Color(255, 152, 0));
        btnEditar.setForeground(Color.WHITE);
        btnEditar.setFocusPainted(false);
        btnEditar.setBorderPainted(false);
        btnEditar.setPreferredSize(new Dimension(35, 25));
        btnEditar.addActionListener(e -> {
            fireEditingStopped();
            accionEditar();
        });

        // Botón Eliminar
        btnEliminar = new JButton("x");
        btnEliminar.setBackground(new Color(244, 67, 54));
        btnEliminar.setForeground(Color.WHITE);
        btnEliminar.setFocusPainted(false);
        btnEliminar.setBorderPainted(false);
        btnEliminar.setPreferredSize(new Dimension(35, 25));
        btnEliminar.addActionListener(e -> {
            fireEditingStopped();
            accionEliminar();
        });

        panel.add(btnSesiones);
        panel.add(btnEditar);
        panel.add(btnEliminar);
    }

    private void accionSesiones(){
        int idDiaSpa = (int) tabla.getValueAt(filaActual, 0);
        System.out.println("Gestionar sesiones del día de spa ID: " + idDiaSpa);

        // Obtener el día de spa completo
        DiaDeSpa diaSpa = DiaDeSpaData.buscarPorId(idDiaSpa);

        if( diaSpa != null ){
            // Aquí abres el panel de sesiones (cuando lo tengas creado)
            // DashboardMenu.ShowJPanel(new PanelSesiones(diaSpa));
            JOptionPane.showMessageDialog(tabla,
              "Funcionalidad de sesiones próximamente\nDía de Spa ID: " + idDiaSpa,
              "Sesiones",
              JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void accionEditar(){
        int idDiaSpa = (int) tabla.getValueAt(filaActual, 0);
        System.out.println("Editar día de spa ID: " + idDiaSpa);

        // Obtener el día de spa completo
        DiaDeSpa diaSpa = DiaDeSpaData.buscarPorId(idDiaSpa);

        if( diaSpa != null ){
            // Abrir el formulario en modo edición
            DashboardMenu.ShowJPanel(new FormularioDiasSpaPanel(diaSpa));
        } else{
            JOptionPane.showMessageDialog(tabla,
              "Error al cargar los datos del día de spa",
              "Error",
              JOptionPane.ERROR_MESSAGE);
        }
    }

    private void accionEliminar(){
        int idDiaSpa = (int) tabla.getValueAt(filaActual, 0);
        String cliente = (String) tabla.getValueAt(filaActual, 1);

        int confirmar = JOptionPane.showConfirmDialog(
          tabla,
          "¿Está seguro de eliminar el día de spa del cliente:\n" + cliente + "?",
          "Confirmar eliminación",
          JOptionPane.YES_NO_OPTION,
          JOptionPane.WARNING_MESSAGE
        );

        if( confirmar == JOptionPane.YES_OPTION ){
            boolean eliminado = DiaDeSpaData.eliminar(idDiaSpa);

            if( eliminado ){
                JOptionPane.showMessageDialog(tabla,
                  "Día de spa eliminado correctamente",
                  "Éxito",
                  JOptionPane.INFORMATION_MESSAGE);

                // Recargar la tabla
                panelPadre.cargarTabla();
            } else{
                JOptionPane.showMessageDialog(tabla,
                  "Error al eliminar el día de spa",
                  "Error",
                  JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
      boolean isSelected, int row, int column){
        filaActual = row;
        return panel;
    }

    @Override
    public Object getCellEditorValue(){
        return "";
    }
}
