package org.informatorio.servicio.menu.banco;

import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.archivos.ArchivosServicio;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;

import static org.informatorio.constantes.Constantes.*;

public class MenuBancoServicioImpl implements MenuBancoServicio{

    private ArchivosServicio archivosServicio;
    private BancoServicio bancoServicio;

    public MenuBancoServicioImpl(ArchivosServicio archivosServicio, BancoServicio bancoServicio) {
        this.archivosServicio = archivosServicio;
        this.bancoServicio = bancoServicio;
    }

    @Override
    public void iniciarMenuBanco(Banco banco) {
       int opc;

       do{
           System.out.println(MENSAJE_OPCION_TEMPLATE);
           System.out.println("1. Mostrar listado de clientes.");
           System.out.println("2. Guardar listado de clientes.");
           System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);
           opc = InputConsoleService.getScanner().nextInt();

           switch (opc){
               case 1:
                   System.out.println(SEPARADOR_TEMPLATE);
                   System.out.println("Listado de Clientes:");
                   System.out.println(bancoServicio.getListaClientesOrdenada(banco));
                   System.out.println(SEPARADOR_TEMPLATE);
                   break;
               case 2:
                   System.out.println("Ingrese el nombre del Archivo: ");
                   String nombre = InputConsoleService.getScanner().next();
                   archivosServicio.exportarClientesACsv(banco, nombre, bancoServicio);
                   break;
               case 0:
                   System.out.println(MENSAJE_SALIENDO_TEMPLATE);
                   break;
               default:
                   System.out.println(MENSAJE_OPCION_INCORRECTA_TEMPLATE);
                   break;
           }
       }while(opc != 0);
    }
}
