package orders.entities;

import lombok.Data;

import java.util.List;

@Data
public class OrderConfirmation {
	public Integer id;
	public Customer customer;
	public List<Product> products;

	public OrderConfirmation() {
	};
}
