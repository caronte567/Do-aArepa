import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAO {

    public void insertarCliente(Cliente cliente) {
        String sql = "INSERT INTO Cliente (nombreCliente, telefono, correoElectronico) VALUES (?, ?, ?)";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            pstmt.setString(1, cliente.getNombreCliente());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreoElectronico());
            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    cliente.setIdCliente(generatedKeys.getInt(1)); 
                }
            }
        } catch (SQLException e) {
            System.err.println("Error al insertar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public List<Cliente> consultarClientes() {
        List<Cliente> clientes = new ArrayList<>();
        String sql = "SELECT * FROM Cliente";
        try (Connection conn = ConexionDB.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Cliente cliente = new Cliente(
                rs.getInt("idCliente"), 
                rs.getString("nombreCliente"), 
                rs.getString("telefono"), 
                rs.getString("correoElectronico"));
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.err.println("Error al consultar clientes: " + e.getMessage());
            e.printStackTrace();
        }
        return clientes;
    }

    public void actualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nombreCliente = ?, telefono = ?, correoElectronico = ? WHERE idCliente = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, cliente.getNombreCliente());
            pstmt.setString(2, cliente.getTelefono());
            pstmt.setString(3, cliente.getCorreoElectronico());
            pstmt.setInt(4, cliente.getIdCliente());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al actualizar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void eliminarCliente(int idCliente) {
        String sql = "DELETE FROM Cliente WHERE idCliente = ?";
        try (Connection conn = ConexionDB.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, idCliente);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al eliminar cliente: " + e.getMessage());
            e.printStackTrace();
        }
    }
}