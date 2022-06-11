package com.dispapeles.clientes.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dispapeles.clientes.domain.Cliente;
import com.dispapeles.clientes.domain.TipoIdentificacion;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Integer>{

	Cliente findByNumeroDocumentoAndTipoIdentificacion( String numeroDocumento, TipoIdentificacion tipoIdentificacion);
}
