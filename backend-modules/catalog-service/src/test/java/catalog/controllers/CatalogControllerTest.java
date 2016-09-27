package catalog.controllers;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import catalog.entities.Product;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)

public class CatalogControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void test() {

		Product[] catalog = this.restTemplate.getForObject("/catalog", Product[].class);
		Product[] expectedCatalog = new Product[1];
		expectedCatalog[0] = new Product(1, "Product 1", "Category A");

		assertThat(catalog).isEqualTo(expectedCatalog);
	}
}
