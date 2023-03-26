package com.leonelbg.sistemaventa.models;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Entity
@Table(name="producto")
public class Producto implements Serializable{


	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idProducto;
	
	@Column
	private String nombre;
	
	@Column
	private Float costo;
	
	@Column
	private String codigo;
	
	@Column
	private Float precioUno;
	
	@Column
	private Float precioDos;
	
	@Column 
	private Float precioTres;
	
	@Column
	private Float utilidadUno;
	
	@Column
	private Float utilidadDos;
	
	@Column 
	private Float utilidadTres;
	
	@Column
	private String descripcion;
	
	@Column
	private Float cantidad;
	
	@Column
	private Float stock_minimo;
	
	@Column
	private String imagen;
	
	
	@ManyToOne
	private Categoria categoria;
	
	
	

}
