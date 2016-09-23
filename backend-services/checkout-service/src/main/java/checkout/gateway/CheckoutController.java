package checkout.gateway;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@RequestMapping(path="/placeoder", method = RequestMethod.POST, produces = "application/json")
	public void placeOrder() {
	}
}