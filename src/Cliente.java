public class Cliente {
    private String nombreCliente;
    private String idCliente;
    private String direccionCliente;

    public Cliente(String nombreCliente, String idCliente, String direccionCliente) {
        this.nombreCliente = nombreCliente;
        this.idCliente = idCliente;
        this.direccionCliente = direccionCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }
}
