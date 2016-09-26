package checkout.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import checkout.entities.ProductDTO;
import checkout.gateway.CatalogClient;

@Component
public class PlaceOrderUseCase {

	@Autowired
	CatalogClient catalogClient;
	
	public List<ProductDTO> placesAnOrder() {
		
		List<ProductDTO> products = catalogClient.getProducts();
		products.forEach(o -> System.out.println(o.toString()));
		
		return products;
	}
	
}
