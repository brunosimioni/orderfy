package checkout.usecases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import checkout.entities.Product;
import checkout.repositories.CatalogRepository;

@Component
public class PlaceOrderUseCase {

	@Autowired
	CatalogRepository catalogClient;
	
	public List<Product> placesAnOrder() {
		
		List<Product> products = catalogClient.getProducts();
		products.forEach(o -> System.out.println(o.toString()));
		
		return products;
	}
	
}
