package com.nttdatapruebapractica.demo.repository;

import com.nttdatapruebapractica.demo.models.Cliente;


public interface ClienteRepository {

    Cliente findByNumeroDocumento(String numeroDocumento);

}
