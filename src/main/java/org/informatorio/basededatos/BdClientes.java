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
    public static List<Cuenta> cuentas4 = initCuentas4();
    public static List<Cliente> clientes = initClientes();

    private static List<Cuenta> initCuentas1() {
        List<Cuenta> cuentas = new ArrayList<>(List.of(
                new CuentaCorriente(2, 100),
                new CuentaAhorro(1, 10)
        ));

        return new ArrayList<>(cuentas);
    }

    private static List<Cuenta> initCuentas2() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(3, 10),
                new CuentaCorriente(4, 200)
        ));
    }

    private static List<Cuenta> initCuentas3() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(6, 100),
                new CuentaCorriente(5, 0),
                new CuentaAhorro(7, 0)
        ));
    }

    private static List<Cuenta> initCuentas4() {
        return new ArrayList<>(List.of(
                new CuentaCorriente(8, 100)
        ));
    }

    public static List<Cliente> initClientes() {
        Cliente cliente1 = new Cliente(2, "Jorge", "Sanchez", "calle 1", new ArrayList<>(cuentas2));
        Cliente cliente4 = new Cliente(4, "Laura", "Gomez", "Brown 330", new ArrayList<>(cuentas4));
        Cliente cliente2 = new Cliente(3, "Ana", "Romero", "av. laprida", new ArrayList<>(cuentas3));
        Cliente cliente3 = new Cliente(1, "Carlos", "Gonzalez", "calle 14", new ArrayList<>(cuentas1));

        asignarClienteACuentas(cliente1.getCuentas(), cliente1);
        asignarClienteACuentas(cliente4.getCuentas(), cliente4);
        asignarClienteACuentas(cliente2.getCuentas(), cliente2);
        asignarClienteACuentas(cliente3.getCuentas(), cliente3);

        return List.of(cliente1, cliente4, cliente2, cliente3);
    }

    private static void asignarClienteACuentas(List<Cuenta> cuentas, Cliente cliente) {
        for (Cuenta cuenta : cuentas) {
            cuenta.setCliente(cliente);
        }
    }

    public static List<Cliente> getListaClientesPrincipal() {
        return clientes;
    }
}
