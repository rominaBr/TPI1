package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.enums.TipoDeCuenta;
import org.informatorio.servicio.cuenta.CuentaServicio;

import static org.informatorio.constantes.Constantes.*;

public class MenuCuentaNuevaImpl implements MenuCuentaNueva{
    private CuentaServicio cuentaServicio;

    public MenuCuentaNuevaImpl(CuentaServicio cuentaServicio) {
        this.cuentaServicio = cuentaServicio;
    }

    @Override
    public void iniciarMenuCuentaNueva(Cliente cliente, Banco banco) {

        int opc;

        System.out.println("Seleccione el tipo de cuenta que desea crear.");
        System.out.println("1. Caja de Ahorro.");
        System.out.println("2. Cuenta Corriente.");
        System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);
        opc = InputConsoleService.getScanner().nextInt();
        switch (opc){
            case 1:
                cuentaServicio.crearCuenta(cliente, banco, TipoDeCuenta.AHORRO);
                break;
            case 2:
                cuentaServicio.crearCuenta(cliente, banco, TipoDeCuenta.CORRIENTE);
                break;
            case 0:
                System.out.println(MENSAJE_SALIENDO_TEMPLATE);
                break;
            default:
                System.out.println(MENSAJE_OPCION_INCORRECTA_TEMPLATE);
                break;
        }


    }
}
