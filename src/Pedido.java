import java.util.ArrayList;

public class Pedido {
    //Constantes
    private static final double IVA = 0.21;
    private static final double DESCUENTO = 0.95;

    private Cliente cliente;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    public double calcularSubtotal() {
        double subtotal = 0;

        //Bucle con for tradicional
        /* for (int i = 0; i < listaProductos.size(); i++) {
            subtotal += listaProductos.get(i).getPrecio();
        } */

        //Bucle utilizando foreach (Más intuitivo)
        for (Producto producto : listaProductos) {
            subtotal += producto.getPrecio();
        }

        return subtotal;
    }

    public double calcularDescuento() {
        double subtotal = calcularSubtotal();

            subtotal *= DESCUENTO;

        return subtotal;
    }

    public boolean aplicaDescuento() {
        double subtotal = calcularSubtotal();
        
        if (subtotal > 3000) {
            return true;
        }

        return false;
    }

    public double calcularSubtotalConIVA() {
        double subtotal = calcularSubtotal();

        subtotal += (subtotal * IVA);

        return subtotal;
    }
}
