package customers.gateway;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customers")
public class CustomersController {

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public List<CustomerDTO> getAllCustomers() {

		List<CustomerDTO> customers = new ArrayList<CustomerDTO>();
		customers.add(new CustomerDTO(1, "John", "Jones"));

		return customers;
	}
}