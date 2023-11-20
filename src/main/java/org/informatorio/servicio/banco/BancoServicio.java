package org.informatorio.servicio.banco;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;

import java.util.List;

public interface BancoServicio {

   void actualizarListaClientes(Cliente cliente, Banco banco);

   int getCantidadClientes(Banco banco);

   Cliente getClienteById(int id, Banco banco);

   int getCantidadCuentas(Banco banco);

   void actualizarCuentaDeCliente(Cliente cliente, Cuenta cuenta);

   List<Cliente> getListaClientesOrdenada(Banco banco);


}
