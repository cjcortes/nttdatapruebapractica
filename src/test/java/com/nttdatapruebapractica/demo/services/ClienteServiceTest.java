package com.nttdatapruebapractica.demo.services;

import com.nttdatapruebapractica.demo.models.Cliente;
import com.nttdatapruebapractica.demo.repository.ClienteRepository;
import com.nttdatapruebapractica.demo.exception.ClienteNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ClienteServiceTest {

    @Mock
    private ClienteRepository clienteRepository;

    private ClienteService clienteService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        clienteService = new ClienteServiceImpl(clienteRepository);
    }

    @Test
    public void testConsultarClienteEncontrado() {
        // Arrange
        String tipoDocumento = "C";
        String numeroDocumento = "23445322";
        Cliente clienteMock = new Cliente();
        when(clienteRepository.findByNumeroDocumento(numeroDocumento)).thenReturn(clienteMock);

        // Act
        Cliente clienteResultado = clienteService.consultarCliente(tipoDocumento, numeroDocumento);

        // Assert
        assertNotNull(clienteResultado);
        verify(clienteRepository, times(1)).findByNumeroDocumento(numeroDocumento);
    }

    @Test
    public void testConsultarClienteNoEncontrado() {
        // Arrange
        String tipoDocumento = "C";
        String numeroDocumento = "11111111";
        when(clienteRepository.findByNumeroDocumento(numeroDocumento)).thenReturn(null);

        // Act & Assert
        assertThrows(ClienteNotFoundException.class,
                () -> clienteService.consultarCliente(tipoDocumento, numeroDocumento));
        verify(clienteRepository, times(1)).findByNumeroDocumento(numeroDocumento);
    }

    @Test
    public void testConsultarClienteTipoDocumentoInvalido() {
        // Arrange
        String tipoDocumento = "X";
        String numeroDocumento = "23445322";

        // Act & Assert
        assertThrows(IllegalArgumentException.class,
                () -> clienteService.consultarCliente(tipoDocumento, numeroDocumento));
    }
}
