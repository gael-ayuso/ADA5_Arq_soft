import filtros.*;
import models.Pedido;

import java.util.List;

public class Tuberia {
    private final List<Filtro> filtros;
    public Tuberia(List<Filtro> filtros){
        this.filtros = filtros;
    }


    public Pedido procesarPedido(Pedido pedido){
        if (pedido == null) return null;
        for (Filtro filtro : filtros) {
            pedido = filtro.procesar(pedido);
        }
        return pedido;
    }
}
