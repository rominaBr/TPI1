package org.informatorio;

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
                new MenuBancoServicioImpl(new ArchivosServicioImpl()), new Banco());


        menuPrincipal.iniciar();

        InputConsoleService.closeScanner();
    }

}
