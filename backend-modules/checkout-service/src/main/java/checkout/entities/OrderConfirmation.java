package checkout.entities;

import java.util.List;

import lombok.Data;

@Data
public class OrderConfirmation {
	public Integer id;
	public Customer customer;
	public List<Product> products;

	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public OrderConfirmation() {
	};
}
