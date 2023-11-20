package org.informatorio.servicio.cuenta;

import org.informatorio.domain.*;
import org.informatorio.enums.TipoDeCuenta;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;

public class CuentaServicioImpl implements CuentaServicio{

    BancoServicio bancoServicio = new BancoServicioImpl();
    @Override
    public void crearCuenta(Cliente cliente, Banco banco, TipoDeCuenta tipoDeCuenta) {

        int nroCuenta = bancoServicio.getCantidadCuentas(banco) + 1;
        Cuenta nuevaCuenta;

        if(tipoDeCuenta.equals(TipoDeCuenta.AHORRO)){
            nuevaCuenta = new CuentaAhorro(nroCuenta, cliente.getIdCliente(), 0);
        }else{
            nuevaCuenta = new CuentaCorriente(nroCuenta, cliente.getIdCliente(), 0);
        }
        bancoServicio.actualizarCuentaDeCliente(cliente, nuevaCuenta);
    }
}