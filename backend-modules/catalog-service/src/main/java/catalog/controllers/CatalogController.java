package catalog.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import catalog.entities.Product;

@RestController
@RequestMapping("/catalog")
public class CatalogController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Product> getAllProducts() {

		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1, "Product 1", "Category A"));

		return products;
	}
}