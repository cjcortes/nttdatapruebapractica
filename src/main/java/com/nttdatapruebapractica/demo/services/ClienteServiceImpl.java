package com.nttdatapruebapractica.demo.services;

import com.nttdatapruebapractica.demo.models.Cliente;
import com.nttdatapruebapractica.demo.repository.ClienteRepository;
import com.nttdatapruebapractica.demo.controllers.ClienteController;
import com.nttdatapruebapractica.demo.exception.ClienteNotFoundException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Value("${cliente.numeroDocumento}")
    private String numeroDocumentoValido;

    @Value("${cliente.tipooDocumentoValido1}")
    private String tipooDocumentoValido1;

    @Value("${cliente.tipooDocumentoValido2}")
    private String tipooDocumentoValido2;

    @Value("${cliente.mensajeUsuarioNoEncontrado}")
    private String mensajeUsuarioNoEncontrado;

    @Value("${cliente.mensajeTipoDocumentoInvalido}")
    private String mensajeTipoDocumentoInvalido;

    @Value("${cliente.mensajeNumeroDocumentoInvalido}")
    private String mensajeNumeroDocumentoInvalido;

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private final ClienteRepository clienteRepository;

    public ClienteServiceImpl(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente consultarCliente(String tipoDocumento, String numeroDocumento) {

        validarTipoDocumento(tipoDocumento);
        validarNumeroDocumento(numeroDocumento);

        Cliente cliente = clienteRepository.findByNumeroDocumento(numeroDocumento);
        if (cliente == null) {
            throw new ClienteNotFoundException(mensajeUsuarioNoEncontrado);
        }

        return cliente;
    }

    private void validarNumeroDocumento(String numeroDocumento) {
        if (!numeroDocumento.equalsIgnoreCase(numeroDocumentoValido)) {
            logger.debug(mensajeNumeroDocumentoInvalido);
            throw new IllegalArgumentException(mensajeNumeroDocumentoInvalido);
        }
    }

    private void validarTipoDocumento(String tipoDocumento) {
        if (!tipoDocumento.equalsIgnoreCase(tipooDocumentoValido1)
                && !tipoDocumento.equalsIgnoreCase(tipooDocumentoValido2)) {
            logger.debug(mensajeTipoDocumentoInvalido.toString());
            throw new IllegalArgumentException(mensajeTipoDocumentoInvalido);
        }
    }
}