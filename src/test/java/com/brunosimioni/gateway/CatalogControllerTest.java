package com.brunosimioni.gateway;

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

public class CatalogControllerTest {

	@Autowired
	private TestRestTemplate restTemplate;


	@Test
	public void test() {

		ProductDTO[] catalog = this.restTemplate.getForObject("/catalog", ProductDTO[].class);
		ProductDTO[] expectedCatalog = new ProductDTO[1];
		expectedCatalog[0] = new ProductDTO(1, "Product 1", "Category A");
		
        assertThat(catalog).isEqualTo(expectedCatalog);
	}
}
