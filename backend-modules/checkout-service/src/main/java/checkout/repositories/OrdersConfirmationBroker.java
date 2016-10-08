package checkout.repositories;

import checkout.config.FeignClientConfiguration;
import checkout.entities.OrderConfirmation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.annotation.InboundChannelAdapter;

/**
 * Created by bruno on 07/10/16.
 */
public class OrdersConfirmationBroker {

    private static final Logger logger = LoggerFactory.getLogger(FeignClientConfiguration.class);

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${orderfy.orders.exchange-name}")
    private String exchangeName;

    public void publish(OrderConfirmation orderConfirmation) {
        logger.info("Method[publish] Parameters[{}]", orderConfirmation.getId());
        logger.debug("Publishing on Order Confirmation - Message[{}]", orderConfirmation);
        rabbitTemplate.convertAndSend(exchangeName, orderConfirmation);
        logger.debug("Publishing on Order Confirmation - Message[{}]", orderConfirmation);
    }


}