package com.dispapeles.clientes.controller.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dispapeles.clientes.controller.dto.ClienteDTO;
import com.dispapeles.clientes.domain.Cliente;

@Component
public class ClienteConverter {

	@Autowired
	private TipoIdentificacionConverter tipoIdentificacionConverter;

	public ClienteDTO clienteToClienteDTO(Cliente cliente) {
		ClienteDTO clienteDTO = new ClienteDTO();
		clienteDTO.setClienteId(cliente.getClienteId());
		clienteDTO.setNumeroDocumento(cliente.getNumeroDocumento());
		clienteDTO.setNombre(cliente.getNombre());
		clienteDTO.setApellidos(cliente.getApellidos());
		clienteDTO.setEdad(cliente.getEdad());
		clienteDTO.setTelefono(cliente.getTelefono());
		clienteDTO.setDireccion(cliente.getDireccion());
		clienteDTO.setFechaCreacion(cliente.getFechaCreacion());
		clienteDTO.setFechaActualizacion(cliente.getFechaActualizacion());
		clienteDTO.setTipoIdentificacion(tipoIdentificacionConverter.tipoIdentificacionToTipoIdentificacionDTO(cliente.getTipoIdentificacion()));
		return clienteDTO;
		
	}
	
	public Cliente clienteDTOToCliente(ClienteDTO clienteDTO) {
		Cliente cliente = new Cliente();
		cliente.setClienteId(clienteDTO.getClienteId());
		cliente.setNumeroDocumento(clienteDTO.getNumeroDocumento());
		cliente.setNombre(clienteDTO.getNombre());
		cliente.setApellidos(clienteDTO.getApellidos());
		cliente.setEdad(clienteDTO.getEdad());
		cliente.setTelefono(clienteDTO.getTelefono());
		cliente.setFechaCreacion(clienteDTO.getFechaCreacion());
		cliente.setDireccion(clienteDTO.getDireccion());
		cliente.setFechaActualizacion(clienteDTO.getFechaActualizacion());
		cliente.setTipoIdentificacion(tipoIdentificacionConverter.tipoIdentificacionDTOToTipoIdentificacion(clienteDTO.getTipoIdentificacion()));
		return cliente;
	}
	
}
