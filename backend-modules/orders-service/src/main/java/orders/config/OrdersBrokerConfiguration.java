package orders.config;

import orders.repositories.OrdersConfirmationReceiver;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.amqp.rabbit.listener.adapter.MessageListenerAdapter;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created by bruno on 07/10/16.
 */
@Configuration
public class OrdersBrokerConfiguration {

    @Value(value = "${orderfy.orders.exchange-name}")
    private String exchangeName;


    @Value(value = "${orderfy.orders.queue-name}")
    private String queueName;

    @Autowired
    private CachingConnectionFactory connectionFactory;

    @Bean
    Queue ordersQueue() {
        return new Queue(queueName, false);
    }

    @Bean
    TopicExchange ordersExchange() {
        return new TopicExchange(exchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(ordersQueue()).to(ordersExchange()).with(queueName);
    }

    @Bean
    SimpleMessageListenerContainer container(ConnectionFactory connectionFactory,
                                             MessageListenerAdapter listenerAdapter) {
        SimpleMessageListenerContainer container = new SimpleMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        container.setQueueNames(queueName);
        container.setMessageListener(listenerAdapter);
        container.setMessageListener(listenerAdapter);
        return container;
    }

    @Bean
    public OrdersConfirmationReceiver orderconfirmationReceiver() {
        return new OrdersConfirmationReceiver();
    }

    @Bean
    MessageListenerAdapter listenerAdapter(OrdersConfirmationReceiver receiver) {
        final MessageListenerAdapter adapter = new MessageListenerAdapter(receiver);
        adapter.setMessageConverter(new Jackson2JsonMessageConverter());
        return adapter;
    }
}