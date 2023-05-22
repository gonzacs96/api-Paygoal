package com.apipaygoal.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apipaygoal.model.request.ProductCreateRequestModel;
import com.apipaygoal.model.response.ProductResponseModel;
import com.apipaygoal.service.ProductService;
import com.apipaygoal.shared.dto.ProductDto;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

	@Autowired
	ProductService productService;

	@GetMapping(path = "/{id}")
	public ResponseEntity<ProductResponseModel> getProduct(@PathVariable UUID id) {
		ModelMapper modelMapper = new ModelMapper();

		ProductDto productDto = productService.getProductByiD(id);
		ProductResponseModel responseProduct = modelMapper.map(productDto, ProductResponseModel.class);

		return new ResponseEntity<>(responseProduct, HttpStatus.OK);
	}

	@PostMapping()
	public ResponseEntity<ProductResponseModel> createProduct(
			@RequestBody @Valid ProductCreateRequestModel productCreatePayload) {
		ModelMapper modelMapper = new ModelMapper();

		ProductDto productDto = modelMapper.map(productCreatePayload, ProductDto.class);

		ProductDto productCreated = productService.createProduct(productDto);
		ProductResponseModel responseProduct = modelMapper.map(productCreated, ProductResponseModel.class);

		return new ResponseEntity<>(responseProduct, HttpStatus.CREATED);
	}

	@PutMapping(path = "/{id}")
	public ResponseEntity<ProductResponseModel> updateProduct(@PathVariable UUID id,
			@RequestBody @Valid ProductCreateRequestModel productUpdatePayload) {
		ModelMapper modelMapper = new ModelMapper();
		ProductDto productDto = modelMapper.map(productUpdatePayload, ProductDto.class);
		ProductDto productUpdated = productService.updateProduct(id, productDto);
		ProductResponseModel responseProduct = modelMapper.map(productUpdated, ProductResponseModel.class);
		return new ResponseEntity<>(responseProduct, HttpStatus.OK);
	}

	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Void> deleteProduct(@PathVariable UUID id) {
		productService.deleteProduct(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	@GetMapping()
	public ResponseEntity<List<ProductResponseModel>> getProducts(
			@RequestParam(value = "nombre", required = false, defaultValue = "") String nombre) {
		ModelMapper modelMapper = new ModelMapper();
		List<ProductDto> products;
		if (!nombre.isEmpty())
			products = productService.getProductsByName(nombre);
		else
			products = productService.getProducts();
		List<ProductResponseModel> responseProducts = new ArrayList<>();
		for (ProductDto productDto : products) {
			ProductResponseModel responseProduct = modelMapper.map(productDto, ProductResponseModel.class);
			responseProducts.add(responseProduct);
		}
		return new ResponseEntity<>(responseProducts, HttpStatus.OK);
	}
}
