package Vista;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    private JComboBox<String> reservationsDropdown;
    private JComboBox<String> roomsDropdown;
    private JComboBox<String> usersDropdown;

    public HomeFrame(String role) {
        setupFrame(role);
        initializeComponents(role);
        setupLayout(role);
        setVisible(true);
    }

    private void setupFrame(String role) {
        setTitle("Home - " + role);
        setSize(400, 300);  // Tamaño ajustado para mejor visualización
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());
    }

    private void initializeComponents(String role) {
        reservationsDropdown = new JComboBox<>(getReservationsOptions(role));
        if (role.equals("admin")) {
            roomsDropdown = new JComboBox<>(new String[]{"Agregar Cuarto", "Modificar Cuarto", "Remover Cuarto"});
            usersDropdown = new JComboBox<>(new String[]{"Agregar Usuario", "Modificar Usuario", "Remover Usuario"});
        }
    }

    private void setupLayout(String role) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 10, 5, 10);

        addComponent("Reservaciones:", reservationsDropdown, gbc);
        reservationsDropdown.addActionListener(e -> handleSelection(reservationsDropdown.getSelectedItem().toString(), "Reservaciones"));

        if (role.equals("admin")) {
            addComponent("Cuartos:", roomsDropdown, gbc);
            addComponent("Usuarios:", usersDropdown, gbc);
            roomsDropdown.addActionListener(e -> handleSelection(roomsDropdown.getSelectedItem().toString(), "Cuartos"));
            usersDropdown.addActionListener(e -> handleSelection(usersDropdown.getSelectedItem().toString(), "Usuarios"));
        }
    }

    private void addComponent(String labelText, JComboBox<String> comboBox, GridBagConstraints gbc) {
        add(new JLabel(labelText), gbc);
        add(comboBox, gbc);
    }

    private String[] getReservationsOptions(String role) {
        if (role.equals("admin")) {
            return new String[]{"Ver Reservaciones", "Modificar Reservacion", "Cancelar Reservacion"};
        } else {
            return new String[]{"Hacer Reservacion", "Ver mis Reservaciones"};
        }
    }

    private void handleSelection(String option, String category) {
        JOptionPane.showMessageDialog(this, "Opción seleccionada: " + option + " en " + category);
    }
}
