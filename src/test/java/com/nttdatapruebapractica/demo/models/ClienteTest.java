package com.nttdatapruebapractica.demo.models;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTest {

    @Test
    public void testGetAndSetPrimerNombre() {
        // Arrange
        Cliente cliente = new Cliente();
        String nombre = "Juan";
        cliente.setPrimerNombre(nombre);

        // Act
        String result = cliente.getPrimerNombre();

        // Assert
        assertEquals(nombre, result);
    }

    @Test
    public void testGetAndSetSegundoNombre() {
        // Arrange
        Cliente cliente = new Cliente();
        String nombre = "Pablo";
        cliente.setSegundoNombre(nombre);

        // Act
        String result = cliente.getSegundoNombre();

        // Assert
        assertEquals(nombre, result);
    }

    @Test
    public void testGetAndSetPrimerApellido() {
        // Arrange
        Cliente cliente = new Cliente();
        String apellido = "Gómez";
        cliente.setPrimerApellido(apellido);

        // Act
        String result = cliente.getPrimerApellido();

        // Assert
        assertEquals(apellido, result);
    }

    @Test
    public void testGetAndSetSegundoApellido() {
        // Arrange
        Cliente cliente = new Cliente();
        String apellido = "López";
        cliente.setSegundoApellido(apellido);

        // Act
        String result = cliente.getSegundoApellido();

        // Assert
        assertEquals(apellido, result);
    }

    @Test
    public void testGetAndSetTelefono() {
        // Arrange
        Cliente cliente = new Cliente();
        String telefono = "123456789";
        cliente.setTelefono(telefono);

        // Act
        String result = cliente.getTelefono();

        // Assert
        assertEquals(telefono, result);
    }

    @Test
    public void testGetAndSetDireccion() {
        // Arrange
        Cliente cliente = new Cliente();
        String direccion = "Calle 123";
        cliente.setDireccion(direccion);

        // Act
        String result = cliente.getDireccion();

        // Assert
        assertEquals(direccion, result);
    }

    @Test
    public void testGetAndSetCiudadResidencia() {
        // Arrange
        Cliente cliente = new Cliente();
        String ciudad = "Bogotá";
        cliente.setCiudadResidencia(ciudad);

        // Act
        String result = cliente.getCiudadResidencia();

        // Assert
        assertEquals(ciudad, result);
    }
}
