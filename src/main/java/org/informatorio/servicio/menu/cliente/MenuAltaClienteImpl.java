package org.informatorio.servicio.menu.cliente;


import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;
import org.informatorio.servicio.cuenta.CuentaServicioImpl;
import org.informatorio.servicio.menu.cuenta.*;

import java.util.InputMismatchException;


public class MenuAltaClienteImpl implements MenuAltaCliente{

    MenuCuentaNueva menuCuentaNueva = new MenuCuentaNuevaImpl(new CuentaServicioImpl());
    @Override
    public void pedirDatosDeCliente(Banco banco) {

        System.out.println("Alta de nuevo cliente:");
        System.out.println("Ingrese los siguientes datos: ");


        System.out.println("Nombre: ");

        String nombre = InputConsoleService.getScanner().next();

        InputConsoleService.getScanner().nextLine();

        System.out.println("Apellido: ");
        String apellido = InputConsoleService.getScanner().next();

        InputConsoleService.getScanner().nextLine();

        System.out.println("Dirección: ");
        String direccion = InputConsoleService.getScanner().next();

        InputConsoleService.getScanner().nextLine();

        ClienteServicio clienteServicio = new ClienteServicioImpl(new BancoServicioImpl());
        Cliente clienteNuevo = clienteServicio.crearCliente(nombre, apellido, direccion, banco);

        menuCuentaNueva.iniciarMenuCuentaNueva(clienteNuevo,banco);

        System.out.println("Bienvenido: "+clienteNuevo.getApellidoCliente()+" "+clienteNuevo.getNombreCliente());
        System.out.println("Su número único de cliente es: "+clienteNuevo.getIdCliente());

        MenuCuentaServicio menuCuentaServicio = new MenuCuentaServicioImpl(new MenuCuentaNuevaImpl(new CuentaServicioImpl()), new MenuCuentaExistenteImpl());

        menuCuentaServicio.iniciarMenuCuentas(clienteNuevo, banco);

    }
}
