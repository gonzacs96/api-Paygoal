package com.apipaygoal.model.response;

import java.math.BigDecimal;
import java.util.UUID;

public class ProductResponseModel {

	private UUID productoId;
	private String nombre;
	private String descripcion;
	private BigDecimal precio;
	private Integer cantidad;

	public UUID getProductoId() {
		return productoId;
	}

	public void setProductoId(UUID productoId) {
		this.productoId = productoId;
	}

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
