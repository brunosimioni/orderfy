package orders.repositories;

import orders.entities.OrderConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by bruno on 07/10/16.
 */

public class OrdersConfirmationReceiver {

    private static Logger logger = LoggerFactory.getLogger(OrdersConfirmationReceiver.class);

    public void receiveMessage(OrderConfirmation oc) {
        logger.info("Received: " + oc.toString());
    }
}