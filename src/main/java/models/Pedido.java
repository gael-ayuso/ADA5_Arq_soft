package models;

import java.util.Map;

public class Pedido {
    private String cliente;
    private Map<Producto, Integer> cantidadProductos;
    private int subtotal;
    private int descuento;
    private int impuestos;
    private int total;
    private EstadoPedido estado;
}
