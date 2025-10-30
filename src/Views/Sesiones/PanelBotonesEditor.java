package Views.Sesiones;

import Modelo.Sesion;
import Persistencia.SesionData;
import Views.DashboardMenu;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class PanelBotonesEditor extends AbstractCellEditor implements TableCellEditor {
    
    private JPanel panel;
    private JButton btnEditar;
    private JButton btnEliminar;
    private JTable tabla;
    private int filaActual;
    private SesionesPanel panelPadre;
    
    public PanelBotonesEditor(JTable tabla, SesionesPanel panelPadre) {
        this.tabla = tabla;
        this.panelPadre = panelPadre;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 2));
        
        
        // Botón Editar (Naranja)
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
        
        // Botón Eliminar (Rojo)
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
        
        panel.add(btnEditar);
        panel.add(btnEliminar);
    }
    
    private void accionVer() {
        int idSesion = (int) tabla.getValueAt(filaActual, 0);
        System.out.println("Ver detalles de sesión ID: " + idSesion);
        
        Sesion sesion = SesionData.buscarPorId(idSesion);
        
        if (sesion != null) {
            StringBuilder info = new StringBuilder();
            info.append("═══════════════════════════════════\n");
            info.append("     DETALLES DE LA SESIÓN\n");
            info.append("═══════════════════════════════════\n\n");
            info.append("ID: ").append(sesion.getId()).append("\n\n");
            info.append("📅 Fecha y Hora Inicio:\n   ").append(sesion.getFechaHoraInicio()).append("\n\n");
            info.append("🕐 Fecha y Hora Fin:\n   ").append(sesion.getFechaHoraFin()).append("\n\n");
            info.append("💆 ID Tratamiento: ").append(sesion.getIdTratamiento() != null ? sesion.getIdTratamiento() : "Sin tratamiento").append("\n\n");
            info.append("👐 ID Masajista: ").append(sesion.getIdMasajista() != null ? sesion.getIdMasajista() : "Sin masajista").append("\n\n");
            info.append("🏢 ID Instalación: ").append(sesion.getIdInstalacion()).append("\n\n");
            info.append("🏨 ID Día de Spa: ").append(sesion.getIdDiaSpa()).append("\n\n");
            info.append("📊 Estado: ").append(sesion.getEstado()).append("\n");
            info.append("═══════════════════════════════════");
            
            JTextArea textArea = new JTextArea(info.toString());
            textArea.setEditable(false);
            textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
            textArea.setBackground(Color.WHITE);
            
            JOptionPane.showMessageDialog(tabla, 
                new JScrollPane(textArea), 
                "Detalles de la Sesión", 
                JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(tabla,
                "Error al cargar los datos de la sesión",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void accionEditar() {
        int idSesion = (int) tabla.getValueAt(filaActual, 0);
        System.out.println("Editar sesión ID: " + idSesion);
        
        Sesion sesion = SesionData.buscarPorId(idSesion);
        
        if (sesion != null) {
            // Abrir el formulario en modo edición
            FormularioSesionesPanel formulario = new FormularioSesionesPanel();
            formulario.cargarDatosParaEditar(sesion);
            DashboardMenu.ShowJPanel(formulario);
        } else {
            JOptionPane.showMessageDialog(tabla,
                "Error al cargar los datos de la sesión",
                "Error",
                JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void accionEliminar() {
        int idSesion = (int) tabla.getValueAt(filaActual, 0);
        String horaInicio = (String) tabla.getValueAt(filaActual, 1);
        String horaFin = (String) tabla.getValueAt(filaActual, 2);
        
        int confirmar = JOptionPane.showConfirmDialog(
            tabla,
            "¿Está seguro de eliminar la sesión?\n" +
            "Horario: " + horaInicio + " - " + horaFin + "\n\n" +
            "Esta acción no se puede deshacer.",
            "Confirmar eliminación",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.WARNING_MESSAGE
        );
        
        if (confirmar == JOptionPane.YES_OPTION) {
            boolean eliminado = SesionData.eliminar(idSesion);
            
            if (eliminado) {
                JOptionPane.showMessageDialog(tabla,
                    "Sesión eliminada correctamente",
                    "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);
                
                // Recargar la tabla
                panelPadre.cargarTabla();
            } else {
                JOptionPane.showMessageDialog(tabla,
                    "Error al eliminar la sesión",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value,
            boolean isSelected, int row, int column) {
        filaActual = row;
        return panel;
    }
    
    @Override
    public Object getCellEditorValue() {
        return "";
    }
}