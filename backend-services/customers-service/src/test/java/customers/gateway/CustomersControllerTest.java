package customers.gateway;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class CustomersControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {

		CustomerDTO[] customers = this.restTemplate.getForObject("/customers", CustomerDTO[].class);
		CustomerDTO[] expectedCustomers = new CustomerDTO[1];
		expectedCustomers[0] = new CustomerDTO(1, "John", "Jones");

		assertThat(customers).isEqualTo(expectedCustomers);
	}
}
