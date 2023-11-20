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
                new CuentaAhorro(1, 1, 10),
                new CuentaCorriente(2, 1, 100)
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
                new CuentaCorriente(5, 3, 0),
                new CuentaCorriente(6, 3, 100),
                new CuentaAhorro(7, 3, 0)
        ));
    }

    public static List<Cliente> initClientes(){

        Cliente cliente1 = new Cliente(1, "Jorge", "Sanchez", "calle 1", cuentas1);
        Cliente cliente2 = new Cliente(2, "Ana", "Romero", "av. laprida", cuentas2);
        Cliente cliente3 = new Cliente(3, "Carlos","Gonzalez", "calle 14", cuentas3);

        return List.of(cliente1, cliente2, cliente3);

    }

    public static List<Cliente> getListaClientesPrincipal(){
        return clientes;
    }

}
