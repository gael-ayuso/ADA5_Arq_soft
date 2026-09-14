package filtros;

import models.EstadoPedido;
import models.Pedido;
import models.Producto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ComprobarDisponibilidad implements Filtro {
    @Override
    public Pedido procesar(Pedido pedido) {
        List<Producto> productos = pedido.getListaProductos();

        Map<String, Integer> cantidadTotalPedida = new HashMap<>();
        for (Producto producto : productos) {
            int cantidadActual = cantidadTotalPedida.getOrDefault(producto.getNombre(), 0);
            cantidadTotalPedida.put(producto.getNombre(), cantidadActual + producto.getCantidad());
        }

        for (Producto producto : productos) {
            int totalPedido = cantidadTotalPedida.get(producto.getNombre());
            if (totalPedido > producto.getCantidadExistencia()) {
                pedido.setEstado(EstadoPedido.PRODUCTO_CON_CANTIDAD_INSUFICIENTE);
                throw new RuntimeException("No hay suficiente stock");
            }
        }

        pedido.setEstado(EstadoPedido.PEDIDO_VALIDO);
        return pedido;
    }
}
