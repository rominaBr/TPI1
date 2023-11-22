package org.informatorio.servicio.cuenta;

import org.informatorio.domain.*;
import org.informatorio.enums.TipoDeCuenta;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;

import java.util.Comparator;
import java.util.List;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;

public class CuentaServicioImpl implements CuentaServicio{

    BancoServicio bancoServicio = new BancoServicioImpl();
    @Override
    public void crearCuenta(Cliente cliente, Banco banco, TipoDeCuenta tipoDeCuenta) {

        int nroCuenta = bancoServicio.getCantidadCuentas(banco) + 1;
        Cuenta nuevaCuenta;

        if(tipoDeCuenta.equals(TipoDeCuenta.AHORRO)){
            nuevaCuenta = new CuentaAhorro(nroCuenta, cliente, 0);
        }else{
            nuevaCuenta = new CuentaCorriente(nroCuenta, cliente, 0);
        }
        bancoServicio.actualizarCuentaDeCliente(cliente, nuevaCuenta);
        System.out.println(SEPARADOR_TEMPLATE);
        System.out.println("Cuenta "+nuevaCuenta.tipoCuenta()+" creada correctamente.");
        System.out.println(SEPARADOR_TEMPLATE);
    }

    @Override
    public List<Cuenta> ordenarCuentas(List<Cuenta> cuentas) {
        cuentas.sort(new Comparator<Cuenta>() {
            @Override
            public int compare(Cuenta o1, Cuenta o2) {
                Integer cuenta1 = o1.getNroCuenta();
                Integer cuenta2 = o2.getNroCuenta();

                return cuenta1.compareTo(cuenta2);
            }
        });
        return cuentas;
    }
}
