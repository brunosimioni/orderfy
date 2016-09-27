package catalog.entities;

import lombok.Data;

@Data
public class Product {
	public Integer id;
	public String name;
	public String category;

	public Product() {
	};

	public Product(Integer id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
}
