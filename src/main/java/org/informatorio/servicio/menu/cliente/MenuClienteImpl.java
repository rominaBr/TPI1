package org.informatorio.servicio.menu.cliente;

import org.informatorio.constantes.Constantes;
import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;

import static org.informatorio.constantes.Constantes.*;

public class MenuClienteImpl implements MenuCliente{

    private MenuIngresoCliente menuIngresoCliente;
    private MenuAltaCliente menuAltaCliente;

    public MenuClienteImpl(MenuIngresoCliente menuIngresoCliente, MenuAltaCliente menuAltaCliente) {
        this.menuIngresoCliente = menuIngresoCliente;
        this.menuAltaCliente = menuAltaCliente;
    }

    @Override
    public void mostrarOpcionesCliente(Banco banco) {

        System.out.println("¿Usted ya es cliente?");
        System.out.println("1. Sí");
        System.out.println("2. No");
        System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);
        int opcion = InputConsoleService.getScanner().nextInt();

        switch (opcion){
            case 1:
                menuIngresoCliente.loginCliente(banco);
                break;
            case 2:
                menuAltaCliente.pedirDatosDeCliente(banco);
                break;
            case 0:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println(MENSAJE_OPCION_INCORRECTA_TEMPLATE);
                break;
        }


    }
}
