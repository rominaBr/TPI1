package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

public class CuentaCorriente extends Cuenta{

    private static double limiteSobregiro = 5000;


    public CuentaCorriente(int nroCuenta, double saldo) {

        super(nroCuenta, saldo);

    }

    public CuentaCorriente(int nroCuenta, Cliente cliente, double saldo) {
        super(nroCuenta, cliente, saldo);
    }

    public double getLimiteSobregiro(){
        return limiteSobregiro;
    }


    @Override
    public TipoDeCuenta tipoCuenta() {
        return TipoDeCuenta.CORRIENTE;
    }


    @Override
    public void retirarDinero(double retiro) {
        if(getSaldo()+limiteSobregiro<retiro){
            System.out.println("Fondos insuficientes.");
        }else{
            setSaldo(getSaldo()-retiro);
            getCliente().setSaldoTotal(getCliente().getSaldoTotal()-retiro);
            System.out.println("Saldo actual de cuenta Nro. "+ getNroCuenta() +" $: " +getSaldo());
        }

    }
}
