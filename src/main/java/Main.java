import filtros.*;
import models.Pedido;
import models.Producto;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filtro> listaFiltros = List.of(
                new ValidarDatos(),
                new ComprobarDisponibilidad(),
                new CalcularSubtotal(),
                new VerificarFraude(),
                new AplicarDescuento(),
                new CalcularImpuestos(),
                new ConfirmarPedido()
        );
        Tuberia tuberia = new Tuberia(listaFiltros);

        System.out.println("PRUEBAS DEL SISTEMA: TUBERÍAS Y FILTROS");

        // Caso 1 y 4 donde el pedido es válido y con descuento
        Pedido caso1 = new Pedido("Cliente Válido", Arrays.asList(
                new Producto(600.0, "Teclado Mecánico", 10, 2) // Subtotal: 1200
        ));
        ejecutarPrueba("Caso 1 & 4: Pedido válido y con descuento", caso1, tuberia);

        // Caso 2 donde el pedido no tiene podructos
        Pedido caso2 = new Pedido("Cliente Vacío", new ArrayList<>());
        ejecutarPrueba("Caso 2: Pedido sin productos", caso2, tuberia);

        // Caso 3 donde el producto tiene una cantidad superior al de la existencia
        Pedido caso3 = new Pedido("Cliente Excedente", Arrays.asList(
                new Producto(100.0, "Mouse", 5, 10)
        ));
        ejecutarPrueba("Caso 3: Producto excede existencia", caso3, tuberia);

        // Caso 5 donde el pedido es sin descuento
        Pedido caso5 = new Pedido("Cliente Básico", Arrays.asList(
                new Producto(400.0, "Silla de oficina", 15, 1) // Subtotal: 400
        ));
        ejecutarPrueba("Caso 5: Pedido sin descuento", caso5, tuberia);

        // Caso 6 donde el pedido esta marcado para revisión de fraude
        Pedido caso6 = new Pedido("Cliente Sospechoso", Arrays.asList(
                new Producto(3000.0, "Laptop Gamer", 10, 2) // Subtotal: 6000
        ));
        ejecutarPrueba("Caso 6: Pedido marcado por revisión de fraude", caso6, tuberia);
    }

    private static void ejecutarPrueba(String nombrePrueba, Pedido pedido, Tuberia tuberia) {
        System.out.println("\n Ejecutando: " + nombrePrueba);
        try {
            Pedido procesado = tuberia.procesarPedido(pedido);
            System.out.println("Resultado Final del Objeto: \n" + procesado.toString());
        } catch (RuntimeException e) {
            System.out.println("Excepción arrojada (Filtro abortó el flujo): " + e.getMessage());
            System.out.println("Resultado Final del Objeto: \n" + pedido.toString());
        }
    }
}
