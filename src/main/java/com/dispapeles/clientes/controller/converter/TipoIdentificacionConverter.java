package com.dispapeles.clientes.controller.converter;

import org.springframework.stereotype.Component;

import com.dispapeles.clientes.controller.dto.TipoIdentificacionDTO;
import com.dispapeles.clientes.domain.TipoIdentificacion;

@Component
public class TipoIdentificacionConverter {

	
	public TipoIdentificacionDTO tipoIdentificacionToTipoIdentificacionDTO(TipoIdentificacion tipoIdentificacion) {
		TipoIdentificacionDTO tipoIdentificacionDTO = new TipoIdentificacionDTO();
		tipoIdentificacionDTO.setTipoIdentificacionId(tipoIdentificacion.getTipoIdentificacionId());
		tipoIdentificacionDTO.setNombre(tipoIdentificacion.getNombre());
		return tipoIdentificacionDTO;
		
	}
	
	public TipoIdentificacion tipoIdentificacionDTOToTipoIdentificacion(TipoIdentificacionDTO tipoIdentificacionDTO) {
		TipoIdentificacion tipoIdentificacion = new TipoIdentificacion();
		tipoIdentificacion.setTipoIdentificacionId(tipoIdentificacionDTO.getTipoIdentificacionId());
		tipoIdentificacion.setNombre(tipoIdentificacionDTO.getNombre());
		
		return tipoIdentificacion;
	}
}
