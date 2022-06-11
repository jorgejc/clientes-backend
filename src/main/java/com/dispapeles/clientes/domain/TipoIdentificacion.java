package com.dispapeles.clientes.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tipo_identificacion")
public class TipoIdentificacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int tipoIdentificacionId;
	
	private String nombre;

	public int getTipoIdentificacionId() {
		return tipoIdentificacionId;
	}

	public void setTipoIdentificacionId(int tipoIdentificacionId) {
		this.tipoIdentificacionId = tipoIdentificacionId;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
