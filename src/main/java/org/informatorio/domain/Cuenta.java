package org.informatorio.domain;

import org.informatorio.enums.TipoDeCuenta;

import java.util.InputMismatchException;

public abstract class Cuenta {

    private int nroCuenta;

    private Cliente cliente;

    private double saldo;


    public Cuenta(int nroCuenta, double saldo) {
        this.nroCuenta = nroCuenta;
        this.saldo = saldo;
    }

    public Cuenta(int nroCuenta, Cliente cliente, double saldo) {
        this.nroCuenta = nroCuenta;
        this.cliente = cliente;
        this.saldo = saldo;
    }

    public int getNroCuenta() {
        return nroCuenta;
    }

    public void setNroCuenta(int nroCuenta) {
        this.nroCuenta = nroCuenta;
    }


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public abstract TipoDeCuenta tipoCuenta();

    public void dopositarDinero(double deposito) {
        if(deposito < 0){
            throw new InputMismatchException();
        }else{
            setSaldo(deposito+getSaldo());
            cliente.setSaldoTotal(cliente.getSaldoTotal()+deposito);
            System.out.println("Saldo actual de cuenta Nro. "+ getNroCuenta() +" $: " +getSaldo());
        }

    }

    public abstract void retirarDinero(double retiro);


    @Override
    public String toString() {
        return
                "Nro de Cuenta: " + nroCuenta +
                ", Saldo: $" + saldo +
                ", Tipo de cuenta: "+ tipoCuenta();
    }
}
