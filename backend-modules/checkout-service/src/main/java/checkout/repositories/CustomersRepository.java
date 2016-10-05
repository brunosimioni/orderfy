package checkout.repositories;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import checkout.entities.Customer;
import checkout.repositories.CustomersRepository.CustomersRepositoryFallback;

@FeignClient(name="customers-service", path="/customers", configuration = FeignClientConfiguration.class, fallback = CustomersRepositoryFallback.class)
public interface CustomersRepository {

    @RequestMapping(method = RequestMethod.GET)
    List<Customer> getCustomers();
    
    @RequestMapping(path="{id}", method = RequestMethod.GET)
    Customer getCustomer(@PathVariable("id") int id);
    
    static class CustomersRepositoryFallback implements CustomersRepository {

		@Override
		public Customer getCustomer(int id) {
			return null;
		}

		@Override
		public List<Customer> getCustomers() {
			return null;
		}
    }
}
