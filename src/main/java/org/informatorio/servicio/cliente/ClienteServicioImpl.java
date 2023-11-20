package org.informatorio.servicio.cliente;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.servicio.banco.BancoServicio;

import java.util.Optional;

public class ClienteServicioImpl implements ClienteServicio{

    BancoServicio bancoServicio;

    public ClienteServicioImpl(BancoServicio bancoServicio) {
        this.bancoServicio = bancoServicio;
    }

    @Override
    public void crearCliente(String nombre, String apellido, String direccion, Banco banco) {
        int id = bancoServicio.getCantidadClientes(banco)+1;
        Cliente cliente = new Cliente(id, nombre, apellido, direccion);
        bancoServicio.actualizarListaClientes(cliente, banco);
        System.out.println(cliente.getIdCliente());
    }

    @Override
    public Optional<Cliente> consultarCliente(int nroCliente, Banco banco) {
        Cliente cliente = bancoServicio.getClienteById(nroCliente, banco);
        if(cliente == null){
            return Optional.empty();
        }else {
            return Optional.of(cliente);
        }
    }

    @Override
    public Optional<Cuenta> consultarCuentaPorNro(int nroCuenta, Cliente cliente) {
        for(Cuenta cuenta: cliente.getCuentas()){
            if(nroCuenta == cuenta.getNroCuenta()){
                return Optional.of(cuenta);
            }
        }
        return Optional.empty();
    }

}
