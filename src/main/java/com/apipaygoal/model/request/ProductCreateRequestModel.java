package com.apipaygoal.model.request;

import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProductCreateRequestModel {

	@NotNull
	@NotBlank
	private String nombre;

	@NotNull
	@NotBlank
	private String descripcion;

	@NotNull
	@Digits(integer = 10, fraction = 2, message = "El precio debe tener 2 decimales")
	private BigDecimal precio;

	@NotNull
	private Integer cantidad;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

}
