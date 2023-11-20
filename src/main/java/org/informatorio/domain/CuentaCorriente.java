package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

public class CuentaCorriente extends Cuenta{

    private double limiteSobregiro = 5000;
    public CuentaCorriente(int nroCuenta, int nroTitular, double saldo) {

        super(nroCuenta, nroTitular, saldo);

    }

    public double getLimiteSobregiro(){
        return limiteSobregiro;
    }

    @Override
    public TipoDeCuenta tipoCuenta() {
        return TipoDeCuenta.CORRIENTE;
    }

    @Override
    public void dopositarDinero(double deposito) {

    }

    @Override
    public void retirarDinero(double retiro) {

    }
}
