package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.entrada.InputConsoleService;

import static org.informatorio.constantes.Constantes.*;


public class MenuCuentaServicioImpl implements MenuCuentaServicio{

    private MenuCuentaNueva menuCuentaNueva;
    private MenuCuentaExistente menuCuentaExistente;

    public MenuCuentaServicioImpl(MenuCuentaNueva menuCuentaNueva, MenuCuentaExistente menuCuentaExistente) {
        this.menuCuentaNueva = menuCuentaNueva;
        this.menuCuentaExistente = menuCuentaExistente;
    }

    @Override
    public void iniciarMenuCuentas(Cliente cliente, Banco banco) {
        int opc;

        do{
            System.out.println(MENSAJE_OPCION_TEMPLATE);
            System.out.println("1. Abrir una nueva cuenta.");
            System.out.println("2. Operar con una cuenta existente.");
            System.out.println("3. Ver datos del cliente.");
            System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc){
                case 1:
                    menuCuentaNueva.iniciarMenuCuentaNueva(cliente, banco);
                    break;
                case 2:
                    menuCuentaExistente.iniciarMenuCuentaExistente(cliente, banco);
                    break;
                case 3:
                    System.out.println(cliente);
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
