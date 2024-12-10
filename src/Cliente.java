public class Cliente {
    private int idCliente;
    private String nombreCliente;
    private String telefono;
    private String correoElectronico;

    public Cliente(String nombreCliente, String telefono, String correoElectronico) {
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public Cliente(int idCliente, String nombreCliente, String telefono, String correoElectronico) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.telefono = telefono;
        this.correoElectronico = correoElectronico;
    }

    public int getIdCliente() { return idCliente; }
    public void setIdCliente(int idCliente) { this.idCliente = idCliente; }
    public String getNombreCliente() { return nombreCliente; }
    public void setNombreCliente(String nombreCliente) { this.nombreCliente = nombreCliente; }
    public String getTelefono() { return telefono; }
    public void setTelefono(String telefono) { this.telefono = telefono; }
    public String getCorreoElectronico() { return correoElectronico; }
    public void setCorreoElectronico(String correoElectronico) { this.correoElectronico = correoElectronico; }
}