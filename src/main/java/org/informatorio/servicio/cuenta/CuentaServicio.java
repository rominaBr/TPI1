package org.informatorio.servicio.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.enums.TipoDeCuenta;

public interface CuentaServicio {

    void crearCuenta(Cliente cliente, Banco banco, TipoDeCuenta tipoDeCuenta);

}
