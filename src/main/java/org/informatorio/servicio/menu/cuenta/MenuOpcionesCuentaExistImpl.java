package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cuenta;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.enums.TipoDeCuenta;

import static org.informatorio.constantes.Constantes.*;

public class MenuOpcionesCuentaExistImpl implements MenuOpcionesCuentaExist{
    @Override
    public void iniciarMenuCuentaExist(Cuenta cuenta, Banco banco) {
        int opc;
        do{
            System.out.println(MENSAJE_OPCION_TEMPLATE);
            System.out.println("1. Depositar dinero.");
            System.out.println("2. Retirar dinero.");
            System.out.println("3. Consultar saldo.");
            if(cuenta.tipoCuenta().equals(TipoDeCuenta.AHORRO)){
                System.out.println("4. Calcular interés generado.");
            }else{
                System.out.println("4. Ver límite de sobregiro.");
            }
            System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);
            opc = InputConsoleService.getScanner().nextInt();

            switch (opc){
                case 1:
                    System.out.println("Ingrese el monto que desea depositar.");
                    double deposito = InputConsoleService.getScanner().nextDouble();
                    cuenta.dopositarDinero(deposito);
                    break;
                case 2:
                    System.out.println("Ingrese el monto que desea retirar.");
                    double retiro = InputConsoleService.getScanner().nextDouble();
                    cuenta.retirarDinero(retiro);
                    break;
                case 3:
                    break;
                case 4:
                    if(cuenta.tipoCuenta().equals(TipoDeCuenta.AHORRO)){

                    }else{

                    }
                    break;
                case 0:
                    System.out.println(MENSAJE_SALIENDO_TEMPLATE);
                    break;
            }
        }while(opc != 0);
    }
}
