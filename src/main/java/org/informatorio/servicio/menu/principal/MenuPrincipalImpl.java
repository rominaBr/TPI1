package org.informatorio.servicio.menu.principal;


import org.informatorio.domain.Banco;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.menu.banco.MenuBancoServicio;
import org.informatorio.servicio.menu.cliente.MenuCliente;

import static org.informatorio.constantes.Constantes.*;

public class MenuPrincipalImpl implements MenuPrincipal{

    private MenuCliente menuCliente;
    private MenuBancoServicio menuBancoServicio;

    private Banco banco;


    public MenuPrincipalImpl(MenuCliente menuCliente, MenuBancoServicio menuBancoServicio, Banco banco){
        this.menuCliente = menuCliente;
        this.menuBancoServicio = menuBancoServicio;
        this.banco = banco;
    }
    @Override
    public void iniciar() {

        int opc;
        do{
            System.out.println("1. Menú banco.");
            System.out.println("2. Menú cliente.");
            System.out.println("0. Salir.");
            System.out.println(MENSAJE_OPCION_TEMPLATE);

            opc = InputConsoleService.getScanner().nextInt();
            switch (opc){
                case 1:
                    System.out.println(SEPARADOR_TEMPLATE);
                    System.out.println("Menú banco.");
                    menuBancoServicio.iniciarMenuBanco(banco);
                    System.out.println(SEPARADOR_TEMPLATE);
                    break;
                case 2:
                    System.out.println(SEPARADOR_TEMPLATE);
                    System.out.println("Menú cliente.");
                    System.out.println(SEPARADOR_TEMPLATE);
                    menuCliente.mostrarOpcionesCliente(banco);
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
