package com.dispapeles.clientes.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dispapeles.clientes.data.ClienteRepository;
import com.dispapeles.clientes.domain.Cliente;


@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	
	
	public void createCliente(Cliente cliente) throws Exception {
		Cliente clienteExiste = clienteRepository.findByNumeroDocumentoAndTipoIdentificacion(cliente.getNumeroDocumento(), cliente.getTipoIdentificacion());
		if (clienteExiste == null ) {
			LocalDateTime fechaGuardado = LocalDateTime.now();
			cliente.setFechaCreacion(fechaGuardado);
			cliente.setFechaActualizacion(fechaGuardado);
			clienteRepository.save(cliente);
			
		} else {
			throw new Exception("El tipo y numero de documento ya existen");
		}
		
	}
	
	public List<Cliente> getClientes() {
		List<Cliente> clientes = (List<Cliente>) clienteRepository.findAll();
		return clientes;
	}
	
	public void updateCliente(int clienteId, Cliente cliente) throws Exception {
		Cliente clienteExiste = clienteRepository.findById(clienteId).orElse(null);
		
		if (clienteExiste != null) {
			
			Cliente clienteExistePorDocumento = clienteRepository.findByNumeroDocumentoAndTipoIdentificacion(cliente.getNumeroDocumento(), cliente.getTipoIdentificacion());
			
			if (clienteExistePorDocumento == null 
					|| clienteExistePorDocumento.getClienteId() == clienteId) {
				
				clienteExiste.setNumeroDocumento(cliente.getNumeroDocumento());
				clienteExiste.setNombre(cliente.getNombre());
				clienteExiste.setApellidos(cliente.getApellidos());
				clienteExiste.setEdad(cliente.getEdad());
				clienteExiste.setTelefono(cliente.getTelefono());
				clienteExiste.setDireccion(cliente.getDireccion());
				clienteExiste.setTipoIdentificacion(cliente.getTipoIdentificacion());
				clienteExiste.setFechaActualizacion(LocalDateTime.now());
				clienteRepository.save(clienteExiste);
				
			} else {
				throw new Exception("El tipo y numero de documento existen");
			}
		} else {
			throw new Exception("Cliente no existe");
		}
	}
	
	public void deleteCliente(int clienteId) throws Exception {
		Cliente clienteExiste = clienteRepository.findById(clienteId).orElse(null);
		if(clienteExiste != null) {
			clienteRepository.delete(clienteExiste);
		} else {
			throw new Exception("Cliente no existe");
		}
	}
}
