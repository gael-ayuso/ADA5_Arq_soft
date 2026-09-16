package filtros;

import models.EstadoPedido;
import models.Pedido;

public class ConfirmarPedido implements Filtro{
    @Override
    public Pedido procesar(Pedido pedido) {
        if (pedido == null) {
            return null;
        }

        // Si viene marcado como fraude desde el filtro VerificarFraude, reafirmamos ese estado final
        if (pedido.isRevisionFraude()) {
            pedido.setEstado(EstadoPedido.PEDIDO_MARCADO_COMO_FRAUDE);
        } else {
            // Si todo está en orden, confirmamos el pedido
            pedido.setEstado(EstadoPedido.PEDIDO_CONFIRMADO);
        }
        
        return pedido;
    }
}
