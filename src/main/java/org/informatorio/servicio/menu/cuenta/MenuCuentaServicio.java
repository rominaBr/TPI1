package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public interface MenuCuentaServicio {

    void iniciarMenuCuentas(Cliente cliente, Banco banco);

}
