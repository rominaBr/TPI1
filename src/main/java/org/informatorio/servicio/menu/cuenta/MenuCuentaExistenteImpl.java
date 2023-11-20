package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;

public class MenuCuentaExistenteImpl implements MenuCuentaExistente{
    @Override
    public void iniciarMenuCuentaExistente(Cliente cliente, Banco banco) {
        System.out.println("Cuenta existente de: "+cliente.getNombreCliente());
    }
}
