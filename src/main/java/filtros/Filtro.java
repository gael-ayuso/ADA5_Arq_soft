package filtros;

import models.Pedido;

public interface Filtro {
    Pedido procesar(Pedido pedido);
}
