package org.informatorio.servicio.menu.cuenta;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;
import org.informatorio.servicio.cuenta.CuentaServicio;
import org.informatorio.servicio.cuenta.CuentaServicioImpl;

import java.util.Optional;

import static org.informatorio.constantes.Constantes.*;

public class MenuCuentaExistenteImpl implements MenuCuentaExistente{

    private ClienteServicio clienteServicio = new ClienteServicioImpl(new BancoServicioImpl());
    private MenuOpcionesCuentaExist menuOpcionesCuentaExist = new MenuOpcionesCuentaExistImpl();

    private CuentaServicio cuentaServicio = new CuentaServicioImpl();
    @Override
    public void iniciarMenuCuentaExistente(Cliente cliente, Banco banco) {
        boolean seguir;
        do{
            System.out.println("Cuentas de: "+cliente.getNombreCliente());
            System.out.println(cuentaServicio.ordenarCuentas(cliente.getCuentas()));
            System.out.println("Ingrese el número de cuenta con el que desea operar.");
            System.out.println(MENSAJE_MENUANTERIOR_TEMPLATE);

            int nroCuenta = InputConsoleService.getScanner().nextInt();
            Optional<Cuenta> cuentaOptional = clienteServicio.consultarCuentaPorNro(nroCuenta, cliente);

            if(cuentaOptional.isPresent()){
                Cuenta cuenta = cuentaOptional.get();
                menuOpcionesCuentaExist.iniciarMenuCuentaExist(cuenta, banco);

                seguir = false;
            }else{
                if(nroCuenta != 0){
                    System.out.println(SEPARADOR_TEMPLATE);
                    System.out.println("Usted no posee la cuenta Nro.: "+nroCuenta);
                    System.out.println(SEPARADOR_TEMPLATE);
                }
                seguir = true;
            }
            if(nroCuenta == 0){
                seguir = false;
                System.out.println(MENSAJE_SALIENDO_TEMPLATE);
            }
        }while (seguir);

    }
}
