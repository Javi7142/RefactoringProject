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

    /**
     * Agrega un producto a la lista de productos del pedido.
     * 
     * @param producto producto a agregar.
     */
    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }

    /**
     * Calcula el subtotal sumando el precio de todos los productos.
     * 
     * @return subtotal total de los productos
     */
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

    /**
     * Calcula el subtotal aplicando descuento si cumple las condiciones.
     * 
     * @return subtotal con descuento (si aplica).
     */
    public double calcularSubtotalConDescuento() {
        double subtotal = calcularSubtotal();
            if (aplicaDescuento()) {
                subtotal *= DESCUENTO;
            }

        return subtotal;
    }

    /**
     * comprueba si el subtotal es mayor de 3000 y aplica el descuento.
     * 
     * @return true si aplica descuento, false si no aplica
     */
    public boolean aplicaDescuento() {
        double subtotal = calcularSubtotal();
        
        if (subtotal > 3000) {
            return true;
        }

        return false;
    }

    /**
     * Calcula el subtotal final aplicando descuento e IVA.
     * 
     * @return subtotal con descuento e IVA incluidos
     */
    public double calcularSubtotalConIVA() {
        double subtotal = calcularSubtotalConDescuento();

        subtotal += (subtotal * IVA);

        return subtotal;
    }
}
