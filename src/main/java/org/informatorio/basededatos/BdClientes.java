package org.informatorio.basededatos;

import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.domain.CuentaAhorro;
import org.informatorio.domain.CuentaCorriente;

import java.util.ArrayList;
import java.util.List;

public class BdClientes {

    public static List<Cuenta> cuentas1 = initCuentas1();
    public static List<Cuenta> cuentas2 = initCuentas2();
    public static List<Cuenta> cuentas3 = initCuentas3();
    public static List<Cliente> clientes = initClientes();

    private static List<Cuenta> initCuentas1() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(2, 1, 100),
                new CuentaAhorro(1, 1, 10)
        ));
    }

    private static List<Cuenta> initCuentas2() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(3, 2, 10),
                new CuentaCorriente(4, 2, 200)
        ));
    }

    private static List<Cuenta> initCuentas3() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(6, 3, 100),
                new CuentaCorriente(5, 3, 0),
                new CuentaAhorro(7, 3, 0)
        ));
    }

    public static List<Cliente> initClientes(){

        Cliente cliente1 = new Cliente(2, "Jorge", "Sanchez", "calle 1", cuentas2);
        Cliente cliente2 = new Cliente(3, "Ana", "Romero", "av. laprida", cuentas3);
        Cliente cliente3 = new Cliente(1, "Carlos","Gonzalez", "calle 14", cuentas1);

        return List.of(cliente1, cliente2, cliente3);

    }

    public static List<Cliente> getListaClientesPrincipal(){
        return clientes;
    }

}
