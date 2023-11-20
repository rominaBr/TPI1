package org.informatorio.servicio.menu.cuenta;

import org.informatorio.constantes.Constantes;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.entrada.InputConsoleService;
import org.informatorio.servicio.banco.BancoServicioImpl;
import org.informatorio.servicio.cliente.ClienteServicio;
import org.informatorio.servicio.cliente.ClienteServicioImpl;

import java.util.Optional;

import static org.informatorio.constantes.Constantes.SEPARADOR_TEMPLATE;

public class MenuCuentaExistenteImpl implements MenuCuentaExistente{

    private ClienteServicio clienteServicio = new ClienteServicioImpl(new BancoServicioImpl());
    @Override
    public void iniciarMenuCuentaExistente(Cliente cliente, Banco banco) {
        boolean seguir;
        do{
            System.out.println("Cuentas de: "+cliente.getNombreCliente());
            System.out.println(cliente.getCuentas());
            System.out.println("Ingrese el número de cuenta con el que desea operar.");
            int nroCuenta = InputConsoleService.getScanner().nextInt();
            Optional<Cuenta> cuentaOptional = clienteServicio.consultarCuentaPorNro(nroCuenta, cliente);

            if(cuentaOptional.isPresent()){
                System.out.println("Existe.");
                seguir = false;
            }else{
                System.out.println(SEPARADOR_TEMPLATE);
                System.out.println("Usted no posee la cuenta Nro.: "+nroCuenta);
                System.out.println(SEPARADOR_TEMPLATE);
                seguir = true;
            }
        }while (seguir);

    }
}
