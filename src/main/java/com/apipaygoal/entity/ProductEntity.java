package com.apipaygoal.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;

@Entity(name = "products")
public class ProductEntity implements Serializable {

	private static final long serialVersionUID = -9063560670519243629L;

	@Id
	@GeneratedValue
	@Column(nullable = false, columnDefinition = "BINARY(16)")
	private UUID productoId;

	@Column(nullable = false, length = 50, unique = true)
	private String nombre;

	@Column(nullable = false, length = 50)
	private String descripcion;

	@Column(nullable = false, scale = 2, precision = 10)
	@DecimalMin(value = "0.00", inclusive = false, message = "El precio debe ser mayor a 0")
	private BigDecimal precio;

	@Column(nullable = false)
	@Min(value = 0, message = "La cantidad debe ser mayor o igual a 0")
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
