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
		
		// check this out:
		// https://stackoverflow.com/questions/42730881/how-do-you-allow-400-errors-to-propagate-when-using-feign-with-hystrix/44664050#44664050
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
