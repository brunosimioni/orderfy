package customers.entities;

import lombok.Data;

@Data
public class Customer {
	public Integer id;
	public String firstName;
	public String lastName;

	public Customer() {
	};

	public Customer(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
