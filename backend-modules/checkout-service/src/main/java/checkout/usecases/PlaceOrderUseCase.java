package checkout.usecases;

import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import checkout.entities.Customer;
import checkout.entities.Order;
import checkout.entities.OrderConfirmation;
import checkout.entities.Product;
import checkout.repositories.CatalogRepository;
import checkout.repositories.CustomersRepository;

@Component
public class PlaceOrderUseCase {

	private static final Logger logger = LoggerFactory.getLogger(PlaceOrderUseCase.class);
	
	@Autowired
	CatalogRepository catalogClient;
	
	@Autowired
	CustomersRepository customersClient;
	
	public OrderConfirmation placesAnOrder(Order anOrder) {

		OrderConfirmation oc = new OrderConfirmation();
		oc.setProducts(new ArrayList<Product>());
		
		anOrder.getIdsProducts().forEach(o -> {
			logger.info("Processing product {}", o);
			Product p = catalogClient.getProduct(o.intValue());
			logger.info("Got product from catalog: {}", p);
			oc.addProduct(p);
		});
		
		logger.info("Processing customer id {}", anOrder.getIdCustomer());
		Customer c = customersClient.getCustomer(anOrder.getIdCustomer());
		oc.setCustomer(c);
		logger.info("Got customer from customers: {}", c);
		
		oc.setId((int)(Math.random()*100));
		return oc;
	}
}
