package com.nttdatapruebapractica.demo.services;

import com.nttdatapruebapractica.demo.models.Cliente;

public interface ClienteService {

    Cliente consultarCliente(String tipoDocumento, String numeroDocumento);
    
}
