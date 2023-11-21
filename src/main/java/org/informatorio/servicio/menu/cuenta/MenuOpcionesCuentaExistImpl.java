package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cuenta;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.domain.CuentaCorriente;
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
                    System.out.println("El saldo actual de la cuenta Nro. "+cuenta.getNroCuenta()+" es $: "+cuenta.getSaldo());
                    break;
                case 4:
                    if(cuenta.tipoCuenta().equals(TipoDeCuenta.AHORRO)){
                        CuentaAhorro cuentaAhorro = (CuentaAhorro) cuenta;
                        System.out.println("Interés del "+cuentaAhorro.getInteres()+"%");
                        System.out.println("Interés que va a generar su cuenta Nro. "+cuenta.getNroCuenta()+" : $"+cuentaAhorro.calcularInteres());
                    }else{
                        CuentaCorriente cuentaCorriente = (CuentaCorriente) cuenta;
                        System.out.println("El límite de sobregiro de su cuenta Nro. "+cuenta.getNroCuenta()+" es: $"+cuentaCorriente.verSobregiroDisponible());
                    }
                    break;
                case 0:
                    System.out.println(MENSAJE_SALIENDO_TEMPLATE);
                    break;
            }
        }while(opc != 0);
    }
}
