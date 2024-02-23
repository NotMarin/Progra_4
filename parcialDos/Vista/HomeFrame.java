package Vista;

import javax.swing.*;
import java.awt.*;

public class HomeFrame extends JFrame {
    private CardLayout cardLayout = new CardLayout();
    private JPanel mainPanel = new JPanel(cardLayout);
    private JPanel menuPanel = new JPanel(new FlowLayout());

    public HomeFrame(String role) {
        setupFrame(role);
        initializeComponents(role);
        setupLayout(role);
        setVisible(true);
    }

    private void setupFrame(String role) {
        setTitle("Home - " + role);
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
    }

    private void initializeComponents(String role) {
        // Botones de menú
        JButton btnReservations = createMenuButton("Reservaciones");
        menuPanel.add(btnReservations);
        mainPanel.add(createReservationsPanel(), "Reservaciones");

        if (role.equals("admin")) {
            JButton btnRooms = createMenuButton("Cuartos");
            JButton btnUsers = createMenuButton("Usuarios");
            menuPanel.add(btnRooms);
            menuPanel.add(btnUsers);
            mainPanel.add(createRoomsPanel(), "Cuartos");
            mainPanel.add(createUsersPanel(), "Usuarios");
        }
    }

    private void setupLayout(String role) {
        add(menuPanel, BorderLayout.NORTH);
        add(mainPanel, BorderLayout.CENTER);
    }

    private JButton createMenuButton(String name) {
        JButton button = new JButton(name);
        button.addActionListener(e -> cardLayout.show(mainPanel, name));
        return button;
    }

    private JPanel createReservationsPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createActionButton("Realizar Reservación", "Realizar Reservaciones"));
        panel.add(createActionButton("Reservaciones Hechas", "Reservaciones Hechas"));
        panel.add(createActionButton("Historial de Reservaciones", "Historial de Reservaciones"));
        return panel;
    }

    private JPanel createRoomsPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createActionButton("Agregar Cuarto", "Agregar Cuarto"));
        panel.add(createActionButton("Modificar Cuarto", "Modificar Cuarto"));
        panel.add(createActionButton("Eliminar Cuarto", "Eliminar Cuarto"));
        return panel;
    }

    private JPanel createUsersPanel() {
        JPanel panel = new JPanel(new FlowLayout());
        panel.add(createActionButton("Agregar Usuario", "Agregar Usuario"));
        panel.add(createActionButton("Modificar Usuario", "Modificar Usuario"));
        panel.add(createActionButton("Eliminar Usuario", "Eliminar Usuario"));
        return panel;
    }

    private JButton createActionButton(String buttonText, String frameTitle) {
        JButton button = new JButton(buttonText);
        button.addActionListener(e -> openCategoryFrame(frameTitle));
        return button;
    }

    private void openCategoryFrame(String title) {
        JFrame categoryFrame = new JFrame(title);
        categoryFrame.setSize(300, 200);
        categoryFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        categoryFrame.setLocationRelativeTo(null);
        categoryFrame.setTitle(title);
        categoryFrame.setVisible(true);
    }
}
