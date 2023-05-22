package com.apipaygoal.service;

import java.util.List;
import java.util.UUID;

import com.apipaygoal.shared.dto.ProductDto;

public interface ProductService {

	ProductDto createProduct(ProductDto product);

	ProductDto getProductByiD(UUID id);

	List<ProductDto> getProducts();

	List<ProductDto> getProductsByName(String name);

	ProductDto updateProduct(UUID id, ProductDto product);

	void deleteProduct(UUID id);
}
