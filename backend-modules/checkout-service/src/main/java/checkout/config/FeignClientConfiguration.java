package checkout.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class FeignClientConfiguration {

	private static final Logger logger = LoggerFactory.getLogger(FeignClientConfiguration.class);
	
	@Bean
	public ErrorDecoder customErrorDecoder() {
		return new FeignCustomErrorDecoder();
	}
	
	class FeignCustomErrorDecoder implements ErrorDecoder {

	    @Override
	    public Exception decode(String methodKey, Response response) {
	    	logger.error("Error. Status {} ; Reason: {}", response.status(), response.reason());
	        return new Exception("ops");
	    }
	}
}
