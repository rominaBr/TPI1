package org.informatorio.domain;

import org.informatorio.basededatos.BdClientes;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> listaClientes;

    public Banco() {
        this.listaClientes = new ArrayList<>(BdClientes.getListaClientesPrincipal());
    }

    public List<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void setListaClientes(List<Cliente> listaClientes) {
        this.listaClientes = listaClientes;
    }


}
