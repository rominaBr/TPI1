package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

public class CuentaAhorro extends Cuenta{

    private double interes = 0.10;

    public CuentaAhorro(int nroCuenta, int nroTitular, double saldo) {

        super(nroCuenta, nroTitular, saldo);

    }

    public double getInteres(){
        return interes;
    }

    @Override
    public TipoDeCuenta tipoCuenta() {
        return TipoDeCuenta.AHORRO;
    }

    @Override
    public void dopositarDinero(double deposito) {
        setSaldo(deposito+getSaldo());
        System.out.println(getSaldo());
    }

    @Override
    public void retirarDinero(double retiro) {

    }
}
