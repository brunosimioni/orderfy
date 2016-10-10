package checkout.stream;

import checkout.entities.OrderConfirmation;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;

/**
 * Created by bruno on 09/10/16.
 */
@MessagingGateway
public interface OrdersConfirmationGateway {

    @Gateway(requestChannel = OrdersConfirmationSource.OUTPUT)
    void generate(OrderConfirmation orderConfirmation);
}
