package checkout.repositories;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import feign.Feign;
import feign.Response;
import feign.codec.ErrorDecoder;

@Component
public class FeignClientConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(FeignClientConfiguration.class);
	
	@Bean
	public Feign.Builder feignBuilder() {
		return Feign.builder().errorDecoder(new FeignCustomErrorDecoder());
	}
	
	class FeignCustomErrorDecoder implements ErrorDecoder {

	    @Override
	    public Exception decode(String methodKey, Response response) {
	    	logger.error("Error. Status {} ; Reason: {}", response.status(), response.reason());
	        return new Exception("ops");
	    }
	}
}
