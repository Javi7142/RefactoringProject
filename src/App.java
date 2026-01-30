import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class App {
    // Variables globales mal ubicadas y poco descriptivas
    private static final double TASA_IVA = 0.21; // Esto es el IVA

    public static void generarFactura(Cliente cliente, double t1_iva) {
        try {
            FileWriter myWriter = new FileWriter("pedido_" + cliente.getIdCliente() + ".txt");
            myWriter.write("FACTURA\n");
            myWriter.write("Cliente: " + cliente.getNombreCliente() + "\n");
            myWriter.write("Direccion: " + cliente.getDireccionCliente() + "\n");
            myWriter.write("Total a pagar: " + t1_iva + "\n");
            myWriter.close();
            System.out.println("Archivo guardado correctamente.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static double procesarPedido(Cliente cliente, ArrayList<String> p_n, ArrayList<Double> p_p) {
        // --- CLIENTE 1: CÁLCULOS (Mezclados con impresión) ---
        double total = 0; // total
        System.out.println("Procesando pedido para: " + cliente.getNombreCliente());
        System.out.println("ID Cliente: " + cliente.getIdCliente());

        for (int i = 0; i < p_n.size(); i++) {
            total = total + p_p.get(i);
            System.out.println("Item " + (i + 1) + ": " + p_n.get(i) + " - " +
                    p_p.get(i) + " EUR");
        }
        // Lógica de descuento "hardcodeada"
        if (total > 3000) {
            System.out.println("Aplica descuento por gran volumen (5%)");
            total = total * 0.95;
        }
        double totalConIva = total + (total * TASA_IVA);
        System.out.println("Total Neto: " + total);
        System.out.println("Total con IVA (" + (TASA_IVA * 100) + "%): " + totalConIva);
        System.out.println("--------------------------------------------------");
        return totalConIva;
    }
    
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Tech Solutions SL", "B12345678", "Calle Industria 55");
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.0));
        pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.0));
        pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));

        Cliente cliente2 = new Cliente("Libreria Moderna", "A98765432", "Av. Diagonal 200, Barcelona");
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.0));
        pedido2.agregarProducto(new Producto("Estantería Metálica", 300.0));

        
    }
}
