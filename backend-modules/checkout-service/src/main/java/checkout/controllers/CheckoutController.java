package checkout.controllers;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import checkout.entities.Order;
import checkout.entities.OrderConfirmation;
import checkout.usecases.PlaceOrderUseCase;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	PlaceOrderUseCase placeOrderUseCase;

	@RequestMapping(path="placeorder", method = RequestMethod.POST, produces = "application/json")
	public DeferredResult<OrderConfirmation> placeOrder(@RequestBody Order anOrder) {
		DeferredResult<OrderConfirmation> deferred = new DeferredResult<>();
		
		CompletableFuture.supplyAsync(() -> placeOrderUseCase.placesAnOrder(anOrder)).	
        	whenCompleteAsync((result, throwable) -> deferred.setResult(result));
		
		return deferred;
	}
}