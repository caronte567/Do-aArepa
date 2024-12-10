import javax.swing.*;
import java.awt.*;
import java.util.List;

public class ClienteApp extends JFrame {

    private JTextField txtNombre, txtTelefono, txtEmail;
    private final JButton btnInsertar, btnActualizar, btnEliminar, btnConsultar;

    private ClienteDAO clienteDAO;

    public ClienteApp() {
        clienteDAO = new ClienteDAO();

        setTitle("Gestión de Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 2));

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);

        panel.add(new JLabel("Teléfono:"));
        txtTelefono = new JTextField();
        panel.add(txtTelefono);

        panel.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        panel.add(txtEmail);

        btnInsertar = new JButton("Insertar");
        btnActualizar = new JButton("Actualizar");
        btnEliminar = new JButton("Eliminar");
        btnConsultar = new JButton("Consultar");

        panel.add(btnInsertar);
        panel.add(btnActualizar);
        
        panel.add(btnEliminar);
        panel.add(btnConsultar);

        add(panel);

        btnInsertar.addActionListener(event -> {
            Cliente nuevoCliente = new Cliente(txtNombre.getText(), txtTelefono.getText(), txtEmail.getText());
            clienteDAO.insertarCliente(nuevoCliente);
            JOptionPane.showMessageDialog(null, "Cliente Insertado con ID: " + nuevoCliente.getIdCliente());
            limpiarCampos();
        });

        btnConsultar.addActionListener(event -> {
            List<Cliente> clientes = clienteDAO.consultarClientes();
            StringBuilder sb = new StringBuilder();
            for (Cliente c : clientes) {
                sb.append(c.getIdCliente()).append(": ").append(c.getNombreCliente()).append("\n");
            }
            JOptionPane.showMessageDialog(null, sb.toString(), "Lista de Clientes", JOptionPane.INFORMATION_MESSAGE);
        });


        setVisible(true);
    }

    private void limpiarCampos() {
        txtNombre.setText("");
        txtTelefono.setText("");
        txtEmail.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ClienteApp());
    }
}