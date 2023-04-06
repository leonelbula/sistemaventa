package com.leonelbg.sistemaventa.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode

@Entity
@Table(name="cliente")
public class Cliente implements Serializable{

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCliente;
	
	@Column
	private String nombre;
	
	@Column
	private String nit;
	
	@Column
	private String direccion;
	
	@Column
	private String ciudad;
	
	@Column
	private String departamento;
	
	@Column
	private String telefono;
	
	@Column
	private String email;
	

}
