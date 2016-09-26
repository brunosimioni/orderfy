package checkout.gateway;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import checkout.entities.ProductDTO;
import checkout.usecase.PlaceOrderUseCase;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	PlaceOrderUseCase placeOrderUseCase;
	
	@RequestMapping(path="placeorder", method = RequestMethod.POST, produces = "application/json")
	public List<ProductDTO> placeOrder() {
		return placeOrderUseCase.placesAnOrder();
	}
}