package models;

public class Producto {
    private final String nombre;
    private final double precio;
    private final int cantidad;
    private final int cantidadExistencia;

    public Producto(double precio, String nombre, int cantidadExistencia, int cantidad) {
        this.precio = precio;
        this.nombre = nombre;
        this.cantidadExistencia = cantidadExistencia;
        this.cantidad = cantidad;
    }

    public int getCantidadExistencia() {
        return cantidadExistencia;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }
}
