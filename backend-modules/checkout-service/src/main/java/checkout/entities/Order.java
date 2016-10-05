package checkout.entities;

import java.util.List;

import lombok.Data;

@Data
public class Order {
	public List<Integer> idsProducts;
	public Integer idCustomer;

	public Order() {
	};
}
