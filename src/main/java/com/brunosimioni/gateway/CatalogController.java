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
		
		return products;
	}
}