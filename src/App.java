import java.io.FileWriter;
import java.io.IOException;

public class App {
    
    public static void main(String[] args) {
        System.out.println("INICIANDO SISTEMA DE PEDIDOS v1.0...");
        System.out.println();

        Cliente cliente1 = new Cliente("Tech Solutions SL", "B12345678", "Calle Industria 55");
        Pedido pedido1 = new Pedido(cliente1);
        pedido1.agregarProducto(new Producto("Servidor Dell PowerEdge", 2500.0));
        pedido1.agregarProducto(new Producto("Licencia Windows Server", 800.0));
        pedido1.agregarProducto(new Producto("Cableado Estructurado", 250.50));

        procesarPedido(pedido1);

        Cliente cliente2 = new Cliente("Libreria Moderna", "A98765432", "Av. Diagonal 200, Barcelona");
        Pedido pedido2 = new Pedido(cliente2);
        pedido2.agregarProducto(new Producto("Pack Libros Escolares", 1200.0));
        pedido2.agregarProducto(new Producto("Estantería Metálica", 300.0));   
        procesarPedido(pedido2);
    }

    /**
     * Procesa un pedido mostrando por pantalla la información y generando el archivo de la factura.
     * 
     * @param pedido pedido a procesar.
     */
    private static void procesarPedido(Pedido pedido) {
        imprimirPedido(pedido);
        generarFicheroPedido(pedido);

    }
    
    /**
     * Muestra por pantalla los datos del pedido.
     * 
     * @param pedido pedido a imprimir.
     */
    private static void imprimirPedido(Pedido pedido) {
        System.out.println(String.format("Procesando pedido para: %s", pedido.getCliente().getNombre()));
        System.out.println(String.format("ID Cliente: %s", pedido.getCliente().getId()));

        for (Producto producto: pedido.getListaProductos()) {
            System.out.println(String.format("Item %s %.2f - EUR", producto.getNombre(), producto.getPrecio()));
        }
        
        if (pedido.aplicaDescuento()) {
            System.out.println("Aplica descuento por gran volumen (5%)");
        }

        System.out.println(String.format("Total Neto: %.2f", pedido.calcularSubtotalConDescuento()));
        System.out.println(String.format("Total con IVA: %.2f", pedido.calcularSubtotalConIVA()));
        System.out.println("--------------------------------------------------");
    }

    /**
     * Genera un archivo de texto con los datos del pedido.
     * 
     * @param pedido pedido del cual se genera el fichero
     */
    private static void generarFicheroPedido(Pedido pedido) {
        try {
            FileWriter myWriter = new FileWriter(String.format("pedido_%s.txt", pedido.getCliente().getId()));
            myWriter.write("FACTURA\n");
            myWriter.write(String.format("Cliente: %s \n", pedido.getCliente().getNombre()));
            myWriter.write(String.format("Direccion: %s \n", pedido.getCliente().getDireccion()));
            myWriter.write(String.format("Total a pagar: %.2f \n", pedido.calcularSubtotalConIVA()));
            myWriter.close();
            System.out.println("Archivo guardado correctamente.");
            System.out.println();
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
