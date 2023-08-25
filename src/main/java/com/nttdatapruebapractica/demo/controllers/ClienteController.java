package com.nttdatapruebapractica.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nttdatapruebapractica.demo.exception.ClienteNotFoundException;
import com.nttdatapruebapractica.demo.models.Cliente;
import com.nttdatapruebapractica.demo.services.ClienteService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    private static final Logger logger = LoggerFactory.getLogger(ClienteController.class);

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    @GetMapping("/{tipo}/{numero}")
    public ResponseEntity<Cliente> consultarCliente(@PathVariable String tipo, @PathVariable String numero) {
        
        logger.info("Solicitud recibida para consultar cliente");
        logger.debug("Tipo de documento: {}, Número de documento: {}", tipo, numero);

        try {
            Cliente cliente = clienteService.consultarCliente(tipo, numero);
            logger.info("Consulta de cliente completada");
            return ResponseEntity.ok(cliente);
        } catch (ClienteNotFoundException ex) {
            logger.warn("Cliente no encontrado");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (IllegalArgumentException ex) {
            logger.warn("Solicitud inválida");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        } catch (Exception ex) {
            logger.error("Error en la consulta de cliente", ex);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}