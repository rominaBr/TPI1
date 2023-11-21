package org.informatorio;

import org.informatorio.constantes.Constantes;
import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivosServicioImpl;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicioImpl;
import org.informatorio.servicio.cuenta.CuentaServicioImpl;
import org.informatorio.servicio.menu.banco.MenuBancoServicioImpl;
import org.informatorio.servicio.menu.cliente.MenuAltaClienteImpl;
import org.informatorio.servicio.menu.cliente.MenuClienteImpl;
import org.informatorio.servicio.menu.cliente.MenuIngresoClienteImpl;
import org.informatorio.servicio.menu.cuenta.MenuCuentaExistenteImpl;
import org.informatorio.servicio.menu.cuenta.MenuCuentaNuevaImpl;
import org.informatorio.servicio.menu.cuenta.MenuCuentaServicioImpl;
import org.informatorio.servicio.menu.principal.MenuPrincipal;
import org.informatorio.servicio.menu.principal.MenuPrincipalImpl;

import java.util.InputMismatchException;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;


public class App 
{

    public static void main( String[] args )
    {
        InputConsoleService.createScanner();

        MenuPrincipal menuPrincipal = new MenuPrincipalImpl(new MenuClienteImpl(
                new MenuIngresoClienteImpl(new ClienteServicioImpl(new BancoServicioImpl()),
                        new MenuCuentaServicioImpl(new MenuCuentaNuevaImpl(new CuentaServicioImpl()),
                        new MenuCuentaExistenteImpl())),
                new MenuAltaClienteImpl()),
                new MenuBancoServicioImpl(new ArchivosServicioImpl(), new BancoServicioImpl()), new Banco());

        boolean entradaValida = false;

        do {
            try {

                menuPrincipal.iniciar();
                entradaValida = true;

            } catch (InputMismatchException e) {
                System.out.println(SEPARADOR_TEMPLATE);
                System.out.println("Error: Ingresa un valor válido.");
                System.out.println(SEPARADOR_TEMPLATE);
                InputConsoleService.getScanner().nextLine();

            }
        } while (!entradaValida);

        InputConsoleService.closeScanner();
    }

}
