package com.dispapeles.clientes.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dispapeles.clientes.controller.converter.ClienteConverter;
import com.dispapeles.clientes.controller.dto.ClienteDTO;
import com.dispapeles.clientes.domain.Cliente;
import com.dispapeles.clientes.service.ClienteService;



@RestController
@RequestMapping("/cliente")
@CrossOrigin("*")
public class ClienteController {

	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private ClienteConverter clienteConverter;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void crearInventario(@RequestBody ClienteDTO clienteDTO) throws Exception {
		try {
			clienteService.createCliente(clienteConverter.clienteDTOToCliente(clienteDTO));	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@GetMapping
	public List<ClienteDTO> getClientes() {
		List<ClienteDTO> clientesDTO = new ArrayList<>();
		for (Cliente cliente : clienteService.getClientes()) {
			ClienteDTO clienteDTO = clienteConverter.clienteToClienteDTO(cliente);
			clientesDTO.add(clienteDTO);
		}
		return clientesDTO;
	}
	
	@PutMapping("/{clienteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCliente(@PathVariable int clienteId, @RequestBody Cliente cliente) throws Exception {
		try {
			clienteService.updateCliente(clienteId, cliente);	
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	@DeleteMapping("/{ClineteId}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCliente(@PathVariable int clienteId) throws Exception {
		try {
			clienteService.deleteCliente(clienteId);
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
}
