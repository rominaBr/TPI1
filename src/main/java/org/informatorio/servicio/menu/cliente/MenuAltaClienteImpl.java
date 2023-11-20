package org.informatorio.servicio.menu.cliente;

import org.informatorio.constantes.Constantes;
import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;

import static org.informatorio.constantes.Constantes.*;


public class MenuAltaClienteImpl implements MenuAltaCliente{
    @Override
    public void pedirDatosDeCliente(Banco banco) {
        System.out.println("Alta de nuevo cliente:");
        System.out.println("Ingrese los siguientes datos: ");

        System.out.println("Nombre: ");
        String nombre = InputConsoleService.getScanner().next();

        System.out.println("Apellido: ");
        String apellido = InputConsoleService.getScanner().next();

        System.out.println("Dirección: ");
        String direccion = InputConsoleService.getScanner().next();

        ClienteServicio clienteServicio = new ClienteServicioImpl(new BancoServicioImpl());
        clienteServicio.crearCliente(nombre, apellido, direccion, banco);

        System.out.println(SEPARADOR_TEMPLATE);

    }
}
