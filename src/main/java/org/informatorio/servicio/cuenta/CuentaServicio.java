package org.informatorio.servicio.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.enums.TipoDeCuenta;

import java.util.List;

public interface CuentaServicio {

    void crearCuenta(Cliente cliente, Banco banco, TipoDeCuenta tipoDeCuenta);

    List<Cuenta> ordenarCuentas(List<Cuenta> cuentas);

}
