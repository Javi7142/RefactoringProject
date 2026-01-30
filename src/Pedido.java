import java.lang.reflect.Array;
import java.util.ArrayList;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> listaProductos = new ArrayList<>();

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
    }

    public void agregarProducto(Producto producto) {
        listaProductos.add(producto);
    }
}
