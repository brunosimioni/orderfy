package customers.gateway;

import lombok.Data;

@Data
public class CustomerDTO {
	public Integer id;
	public String firstName;
	public String lastName;

	public CustomerDTO() {
	};

	public CustomerDTO(Integer id, String firstName, String lastName) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}
}
