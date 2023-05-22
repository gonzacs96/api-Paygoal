package com.apipaygoal.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apipaygoal.service.ProductService;
import com.apipaygoal.shared.dto.ProductDto;
import com.apipaygoal.entity.ProductEntity;
import com.apipaygoal.exception.ProductServiceException;
import com.apipaygoal.model.response.ErrorMessagesProduct;
import com.apipaygoal.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Override
	public ProductDto createProduct(ProductDto product) throws ProductServiceException {

		ProductEntity checkStoredProduct = productRepository.findByNombre(product.getNombre());
		if (checkStoredProduct != null)
			throw new ProductServiceException(ErrorMessagesProduct.RECORD_ALREADY_EXISTS.getErrorMessage());

		ModelMapper modelMapper = new ModelMapper();
		ProductEntity productEntity = modelMapper.map(product, ProductEntity.class);

		ProductEntity storedProduct = productRepository.save(productEntity);
		ProductDto productDto = modelMapper.map(storedProduct, ProductDto.class);

		return productDto;
	}

	@Override
	public ProductDto getProductByiD(UUID id) throws ProductServiceException {
		ModelMapper modelMapper = new ModelMapper();
		ProductEntity productEntity = productRepository.findByProductoId(id);
		if (productEntity == null)
			throw new ProductServiceException(ErrorMessagesProduct.NO_RECORD_FOUND.getErrorMessage());
		ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
		return productDto;
	}

	@Override
	public List<ProductDto> getProducts() {
		ModelMapper modelMapper = new ModelMapper();
		List<ProductDto> productsDto = new ArrayList<>();
		List<ProductEntity> productsEntity = productRepository.findAllByOrderByPrecioAsc();
		for (ProductEntity productEntity : productsEntity) {
			ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
			productsDto.add(productDto);
		}
		return productsDto;
	}

	@Override
	public List<ProductDto> getProductsByName(String name) {
		ModelMapper modelMapper = new ModelMapper();
		List<ProductDto> productsDto = new ArrayList<>();
		List<ProductEntity> productsEntity = productRepository.findAllByNombreContainingIgnoreCase(name);
		for (ProductEntity productEntity : productsEntity) {
			ProductDto productDto = modelMapper.map(productEntity, ProductDto.class);
			productsDto.add(productDto);
		}
		return productsDto;
	}

	@Override
	public ProductDto updateProduct(UUID id, ProductDto product) {
		ModelMapper modelMapper = new ModelMapper();
		ProductEntity productEntity = productRepository.findByProductoId(id);
		if (productEntity == null)
			throw new ProductServiceException(ErrorMessagesProduct.NO_RECORD_FOUND.getErrorMessage());
		productEntity.setNombre(product.getNombre());
		productEntity.setPrecio(product.getPrecio());
		productEntity.setDescripcion(product.getDescripcion());
		productEntity.setCantidad(product.getCantidad());
		ProductEntity updatedProduct = productRepository.save(productEntity);
		ProductDto productDto = modelMapper.map(updatedProduct, ProductDto.class);
		return productDto;
	}

	@Override
	public void deleteProduct(UUID id) throws ProductServiceException {
		ProductEntity productEntity = productRepository.findByProductoId(id);
		if (productEntity == null)
			throw new ProductServiceException(ErrorMessagesProduct.NO_RECORD_FOUND.getErrorMessage());
		productRepository.delete(productEntity);
	}
}
