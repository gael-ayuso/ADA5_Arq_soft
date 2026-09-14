package models;

import java.util.List;

public class Pedido {
    private final String cliente;
    private final List<Producto> listaProductos;
    private final int subtotal;
    private final int descuento;
    private final int impuestos;
    private final int total;
    private EstadoPedido estado;

    public Pedido(
            String cliente,
            List<Producto> listaProductos,
            int subtotal,
            int descuento,
            int impuestos,
            int total,
            EstadoPedido estado) {
        this.cliente = cliente;
        this.listaProductos = listaProductos;
        this.subtotal = subtotal;
        this.descuento = descuento;
        this.impuestos = impuestos;
        this.total = total;
        this.estado = estado;
    }

    public Pedido(
            String cliente,
            List<Producto> listaProductos
    ) {
        this(
                cliente,
                listaProductos,
                0,
                0,
                0,
                0,
                null
        );
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public void setEstado(EstadoPedido estado) {
        this.estado = estado;
    }

    public String getCliente() {
        return cliente;
    }

    public List<Producto> getListaProductos() {
        return listaProductos;
    }
}
