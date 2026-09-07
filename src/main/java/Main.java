import filtros.*;
import models.Pedido;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Filtro> listaFiltros = List.of(
                new ValidarDatos(),
                new AplicarDescuento(),
                new CalcularSubtotal(),
                new CalcularImpuestos(),
                new ConfirmarPedido(),
                new ComprobarDisponibilidad()
        );
        Tuberia tuberia = new Tuberia(listaFiltros);
    }
}
