package customers.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import customers.entities.Customer;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<Customer> getAllCustomers() {

		List<Customer> customers = new ArrayList<Customer>();
		customers.add(new Customer(1, "John", "Jones"));

		return customers;
	}
	
	@RequestMapping(path= "/{id}", method = RequestMethod.GET, produces = "application/json")
	public Customer getCustomerById(@PathVariable Integer id) {
		return new Customer(id, ("FirstName" + id), ("LastName" + id));
	}
}