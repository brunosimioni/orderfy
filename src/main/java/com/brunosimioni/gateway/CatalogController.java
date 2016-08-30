package com.brunosimioni.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<ProductDTO> getAllProducts() {
		
		List<ProductDTO> products = new ArrayList<ProductDTO>();
		products.add(new ProductDTO(1, "Product 1", "Category A"));
		products.add(new ProductDTO(2, "Product 2", "Category A"));
		products.add(new ProductDTO(3, "Product 3", "Category A"));
		products.add(new ProductDTO(4, "Product 4", "Category B"));
		products.add(new ProductDTO(5, "Product 5", "Category B"));
		products.add(new ProductDTO(6, "Product 6", "Category B"));
		
		return products;
	}
}