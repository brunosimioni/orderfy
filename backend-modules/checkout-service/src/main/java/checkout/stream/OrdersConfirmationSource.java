package checkout.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

/**
 * Created by bruno on 09/10/16.
 */
public interface OrdersConfirmationSource {

    String OUTPUT = "output";

    @Output(OrdersConfirmationSource.OUTPUT)
    MessageChannel output();
}
