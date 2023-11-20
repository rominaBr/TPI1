package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

public abstract class Cuenta {

    private int nroCuenta;

    private int nroTitular;

    private double saldo;


    public Cuenta(int nroCuenta, int nroTitular, double saldo) {
        this.nroCuenta = nroCuenta;
        this.nroTitular = nroTitular;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }

    public int getTitular(){
        return nroTitular;
    }

    public void setTitular(int nroTitular){
        this.nroTitular = nroTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract TipoDeCuenta tipoCuenta();

    @Override
    public String toString() {
        return
                "Nro de Cuenta: " + nroCuenta +
                ", Saldo: $" + saldo +
                ", Tipo de cuenta: "+ tipoCuenta();
    }
}
