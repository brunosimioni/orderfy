package customers.controllers;

import java.util.ArrayList;
import java.util.List;

import orders.entities.OrderConfirmation;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	@RequestMapping(path= "/{id}", method = RequestMethod.GET, produces = "application/json")
	public OrderConfirmation getOrderById(@PathVariable Integer id) {
		return new OrderConfirmation();
	}
}