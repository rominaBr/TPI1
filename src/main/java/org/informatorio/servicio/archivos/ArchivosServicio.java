package org.informatorio.servicio.archivos;

import org.informatorio.domain.Banco;
import org.informatorio.domain.Cliente;
import org.informatorio.servicio.banco.BancoServicio;

import java.util.List;

public interface ArchivosServicio {

    void exportarClientesACsv(Banco banco, String nombreArchivo, BancoServicio bancoServicio);
}
