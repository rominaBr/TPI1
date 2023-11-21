package org.informatorio.servicio.cliente;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;

import java.util.List;
import java.util.Optional;

public interface ClienteServicio {

    Cliente crearCliente(String nombre, String apellido,String direccion, Banco banco);
    Optional<Cliente> consultarCliente(int nroCliente, Banco banco);
    Optional<Cuenta> consultarCuentaPorNro(int nroCuenta, Cliente cliente);


}
