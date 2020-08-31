package com.alekzmr.core.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="persona")
public class Persona {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer IdPersona;
	
	@NotNull(message="{not.null}")
	@Size(min=3, max=70, message="{nombres.size}")
	@Column(name="apellidos", nullable=false, length=70)
	private String apellidos;
	
	@NotNull(message="{not.null}")
	@Size(min=3, max=50, message="{apellidos.size}")
	@Column(name="nombres", nullable=false, length=50)
	private String nombres;
	
	public Integer getIdPersona() {
		return IdPersona;
	}
	public void setIdPersona(Integer idPersona) {
		IdPersona = idPersona;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
}
