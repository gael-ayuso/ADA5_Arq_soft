package filtros;

import models.EstadoPedido;
import models.Pedido;

public class ConfirmarPedido implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido == null) {
            return null;
        }

        // Si el filtro de fraude no lo marcó para revisión, lo confirmamos
        if (!pedido.isRevisionFraude()) {
            pedido.setEstado(EstadoPedido.PEDIDO_CONFIRMADO);
        }
        
        return pedido;
    }
}
