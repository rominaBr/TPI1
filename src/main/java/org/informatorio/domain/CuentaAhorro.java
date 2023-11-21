package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;

public class CuentaAhorro extends Cuenta{

    private static double interes = 10;

    public CuentaAhorro(int nroCuenta, double saldo) {

        super(nroCuenta, saldo);

    }

    public CuentaAhorro(int nroCuenta, Cliente cliente, double saldo) {
        super(nroCuenta, cliente, saldo);
    }

    public double getInteres(){
        return interes;
    }

    @Override
    public TipoDeCuenta tipoCuenta() {
        return TipoDeCuenta.AHORRO;
    }

    @Override
    public void retirarDinero(double retiro) {
        if(getSaldo() < retiro){
            System.out.println(SEPARADOR_TEMPLATE);
            System.out.println("Fondos insuficientes.");
            System.out.println(SEPARADOR_TEMPLATE);
        }else{
            setSaldo(getSaldo()-retiro);
            getCliente().setSaldoTotal(getCliente().getSaldoTotal()-retiro);
            System.out.println("Saldo actual de cuenta Nro. "+ getNroCuenta() +" $: " +getSaldo());
        }
    }

    public double calcularInteres(){
        return getSaldo()*(interes/100);
    }
}
