package com.apipaygoal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apipaygoal.entity.ProductEntity;
import java.util.UUID;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, UUID> {
	ProductEntity findByNombre(String nombre);

	ProductEntity findByProductoId(UUID productoId);

	List<ProductEntity> findAllByOrderByPrecioAsc();

	List<ProductEntity> findAllByNombreContainingIgnoreCase(String nombre);
}
