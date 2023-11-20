package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public interface MenuCuentaExistente {
    void iniciarMenuCuentaExistente(Cliente cliente, Banco banco);

}
