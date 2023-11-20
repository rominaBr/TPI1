package org.informatorio.domain;

import org.informatorio.constantes.Constantes;

import java.util.ArrayList;
import java.util.List;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;

public class Cliente {
    private int idCliente;
    private String nombreCliente;

    private String apellidoCliente;

    private String direccionCliente;
    private List<Cuenta> cuentas = new ArrayList<>();

    private double saldoTotal;

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente,String direccionCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        calcularSaldoTotal();
    }

    public Cliente(int idCliente, String nombreCliente, String apellidoCliente,String direccionCliente, List<Cuenta> cuentas) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.direccionCliente = direccionCliente;
        this.cuentas = cuentas;
        calcularSaldoTotal();
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public List<Cuenta> getCuentas() {
        return cuentas;
    }

    public void setCuentas(List<Cuenta> cuentas) {
        this.cuentas = cuentas;
    }

    private void calcularSaldoTotal(){
        if(cuentas != null){
            cuentas.forEach(cuenta -> {
                saldoTotal+= cuenta.getSaldo();
            });
        }
    }

    public double getSaldoTotal(){
        return saldoTotal;
    }

    @Override
    public String toString() {
        StringBuilder cuentasStr = new StringBuilder("Cuentas:\n");

        if (cuentas != null) {
            for (Cuenta cuenta : cuentas) {
                cuentasStr.append(cuenta.toString()).append("\n");
            }
        } else {
            cuentasStr.append("No tiene cuentas registradas.");
        }

        return SEPARADOR_TEMPLATE +
                "\nID: " + idCliente +
                "\nNombre: " + nombreCliente +" "+apellidoCliente+
                "\nDirección: " + direccionCliente +
                "\n" + cuentasStr +
                "\n*Saldo Total: $" + saldoTotal +
                "\n"+ SEPARADOR_TEMPLATE +"\n";
    }
}
