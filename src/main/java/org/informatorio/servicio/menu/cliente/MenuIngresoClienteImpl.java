package org.informatorio.servicio.menu.cliente;

import org.informatorio.constantes.Constantes;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.menu.cuenta.MenuCuentaServicio;

import java.util.Optional;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;

public class MenuIngresoClienteImpl implements MenuIngresoCliente{

    private ClienteServicio clienteServicio;
    private MenuCuentaServicio menuCuentaServicio;

    public MenuIngresoClienteImpl(ClienteServicio clienteServicio, MenuCuentaServicio menuCuentaServicio) {
        this.clienteServicio = clienteServicio;
        this.menuCuentaServicio = menuCuentaServicio;
    }

    @Override
    public void loginCliente(Banco banco) {
        boolean seguir;

        do{
            System.out.println("Ingrese su número de cliente: ");
            int nroCliente = InputConsoleService.getScanner().nextInt();

            Optional<Cliente> clienteOptional = clienteServicio.consultarCliente(nroCliente, banco);


            if(clienteOptional.isPresent()){
                Cliente cliente = clienteOptional.get();
                System.out.println("Bienvenid@ "+cliente.getNombreCliente());
                menuCuentaServicio.iniciarMenuCuentas(cliente, banco);
                seguir = false;

            }else{
                System.out.println(SEPARADOR_TEMPLATE);
                System.out.println("El cliente nro: "+nroCliente+" no existe.");
                System.out.println(SEPARADOR_TEMPLATE);
                seguir = true;
            }

        }while(seguir);


    }
}
