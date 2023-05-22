package com.apipaygoal.shared.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

public class ProductDto implements Serializable {

	private static final long serialVersionUID = -2292823883460298421L;
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
		this.nombre = nombre.toLowerCase().trim();
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion.trim();
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
