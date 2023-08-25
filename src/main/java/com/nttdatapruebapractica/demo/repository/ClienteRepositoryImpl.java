package com.nttdatapruebapractica.demo.repository;

import com.nttdatapruebapractica.demo.models.Cliente;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Value("${cliente.numeroDocumento}")
    private String numeroDocumento;

    @Value("${cliente.primerNombre}")
    private String primerNombre;

    @Value("${cliente.segundoNombre}")
    private String segundoNombre;

    @Value("${cliente.primerApellido}")
    private String primerApellido;

    @Value("${cliente.segundoApellido}")
    private String segundoApellido;

    @Value("${cliente.telefono}")
    private String telefono;

    @Value("${cliente.direccion}")
    private String direccion;

    @Value("${cliente.ciudadResidencia}")
    private String ciudadResidencia;

    @Override
    public Cliente findByNumeroDocumento(String numeroDocumento) {
        Cliente cliente = new Cliente();
        cliente.setPrimerNombre(primerNombre);
        cliente.setSegundoNombre(segundoNombre);
        cliente.setPrimerApellido(primerApellido);
        cliente.setSegundoApellido(segundoApellido);
        cliente.setTelefono(telefono);
        cliente.setDireccion(direccion);
        cliente.setCiudadResidencia(ciudadResidencia);
        return cliente;
    }
}
