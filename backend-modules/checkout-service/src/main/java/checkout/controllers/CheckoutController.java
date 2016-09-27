package checkout.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import checkout.entities.Product;
import checkout.usecases.PlaceOrderUseCase;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	PlaceOrderUseCase placeOrderUseCase;
	
	@RequestMapping(path="placeorder", method = RequestMethod.POST, produces = "application/json")
	public List<Product> placeOrder() {
		return placeOrderUseCase.placesAnOrder();
	}
}