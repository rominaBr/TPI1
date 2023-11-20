package org.informatorio.servicio.banco;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;

import java.util.concurrent.atomic.AtomicInteger;


public class BancoServicioImpl implements BancoServicio{

    @Override
    public void actualizarListaClientes(Cliente cliente, Banco banco) {
        banco.getListaClientes().add(cliente);
    }

    @Override
    public int getCantidadClientes(Banco banco) {
        return banco.getListaClientes().size();
    }

    @Override
    public Cliente getClienteById(int id, Banco banco) {
        for(Cliente cli: banco.getListaClientes()){
            if(id == cli.getIdCliente()){
                return cli;
            }
        }
        return null;
    }

    @Override
    public int getCantidadCuentas(Banco banco) {

        AtomicInteger cant = new AtomicInteger();

        banco.getListaClientes().forEach(cliente -> {

            if(cliente.getCuentas() != null){
                cant.addAndGet(cliente.getCuentas().size());
            }

        });

        return cant.get();
    }

    @Override
    public void actualizarCuentaDeCliente(Cliente cliente, Cuenta cuenta) {
        cliente.getCuentas().add(cuenta);
    }
}
