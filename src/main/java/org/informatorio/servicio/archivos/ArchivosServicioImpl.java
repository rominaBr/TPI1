package org.informatorio.servicio.archivos;

import com.opencsv.CSVWriter;
import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.domain.Cuenta;
import org.informatorio.servicio.banco.BancoServicio;
import org.informatorio.servicio.banco.BancoServicioImpl;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ArchivosServicioImpl implements ArchivosServicio{

    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\org\\informatorio\\recursos\\";

    @Override
    public void exportarClientesACsv(Banco banco, String nombreArchivo, BancoServicio bancoServicio) {

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(nombreArchivo).concat(".csv");

        System.out.println("Exportando...");
        try(CSVWriter writer = new CSVWriter(new FileWriter(ruta))){

            String[] encabezados = {"ID","Nombre","Apellido","Dirección","Nro Cuenta","Saldo Cuenta","Tipo de Cuenta"};
            writer.writeNext(encabezados);

            List<Cliente> listaClientes = bancoServicio.getListaClientesOrdenada(banco);

            if (!listaClientes.isEmpty()){
                for (Cliente cliente: listaClientes) {
                    List<Cuenta> listaCuentas = cliente.getCuentas();
                    if(listaCuentas != null){
                        for(Cuenta cuenta: listaCuentas){
                            String[] datos = {
                                    String.valueOf(cliente.getIdCliente()),
                                    cliente.getNombreCliente(),
                                    cliente.getApellidoCliente(),
                                    cliente.getDireccionCliente(),
                                    String.valueOf(cuenta.getNroCuenta()),
                                    String.valueOf(cuenta.getSaldo()),
                                    String.valueOf(cuenta.tipoCuenta())
                            };
                            writer.writeNext(datos);
                        }
                    }else{
                        String[] datos = {
                                String.valueOf(cliente.getIdCliente()),
                                cliente.getNombreCliente(),
                                cliente.getApellidoCliente(),
                                cliente.getDireccionCliente(),
                                "-",
                                String.valueOf(cliente.getSaldoTotal()),
                                "NO TIENE CUENTAS."
                        };
                        writer.writeNext(datos);
                    }


                }
            }

            System.out.println("Exportación a CSV exitosa.");
            System.out.println(ruta);
        } catch (IOException e ) {
            System.out.println("Algo salio mal motivo : " +
                    e.getMessage().concat(" Ubicacion indicada : " + ruta)
            );
        }

    }
}