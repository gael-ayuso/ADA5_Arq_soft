import filtros.*;
import models.Pedido;

import java.util.List;

public class Tuberia {
    private final List<Filtro> pipeline;
    public Tuberia(List<Filtro> pipeline){
        this.pipeline = pipeline;
    }


    public Pedido procesarPedido(Pedido pedido){
        if (pedido == null) return null;
        for (Filtro filtro : pipeline) {
            pedido = filtro.procesar(pedido);
        }
        return pedido;
    }
}
