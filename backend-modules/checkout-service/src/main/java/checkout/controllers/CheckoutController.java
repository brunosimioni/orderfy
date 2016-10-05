package checkout.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import checkout.entities.Order;
import checkout.entities.OrderConfirmation;
import checkout.usecases.PlaceOrderUseCase;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	PlaceOrderUseCase placeOrderUseCase;

	@RequestMapping(path="placeorder", method = RequestMethod.POST, produces = "application/json")
	public OrderConfirmation placeOrder(@RequestBody Order anOrder) {
		return placeOrderUseCase.placesAnOrder(anOrder);
	}
}