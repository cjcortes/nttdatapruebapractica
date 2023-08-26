package com.nttdatapruebapractica.demo.controllers;

import com.nttdatapruebapractica.demo.exception.ClienteNotFoundException;
import com.nttdatapruebapractica.demo.models.Cliente;
import com.nttdatapruebapractica.demo.services.ClienteService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {

    @Mock
    private ClienteService mockClienteService;

    @InjectMocks
    private ClienteController clienteController;

    @Test
    public void testConsultarClienteFound() {
        // Arrange
        Cliente cliente = new Cliente();
        when(mockClienteService.consultarCliente("tipo", "numero")).thenReturn(cliente);

        // Act
        ResponseEntity<Cliente> response = clienteController.consultarCliente("tipo", "numero");

        // Assert
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(cliente, response.getBody());
    }

    @Test
    public void testConsultarClienteNotFound() {
        // Arrange
        when(mockClienteService.consultarCliente("tipo", "numero")).thenThrow(new ClienteNotFoundException("Cliente no encontrado"));

        // Act
        ResponseEntity<Cliente> response = clienteController.consultarCliente("tipo", "numero");

        // Assert
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
    }

    @Test
    public void testConsultarClienteInvalidRequest() {
        // Arrange
        when(mockClienteService.consultarCliente("tipo", "numero")).thenThrow(new IllegalArgumentException());

        // Act
        ResponseEntity<Cliente> response = clienteController.consultarCliente("tipo", "numero");

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    public void testConsultarClienteServerError() {
        // Arrange
        when(mockClienteService.consultarCliente("tipo", "numero")).thenThrow(new RuntimeException());

        // Act
        ResponseEntity<Cliente> response = clienteController.consultarCliente("tipo", "numero");

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
    }
}
