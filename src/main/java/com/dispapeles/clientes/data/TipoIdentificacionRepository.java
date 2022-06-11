package com.dispapeles.clientes.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dispapeles.clientes.domain.TipoIdentificacion;

@Repository
public interface TipoIdentificacionRepository extends CrudRepository<TipoIdentificacion, Integer> {

}
