package circuitmonitor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;

@SpringBootApplication
@EnableTurbineStream
public class CircuitMonitorApplication {

	public static void main(String[] args) {
		SpringApplication.run(CircuitMonitorApplication.class, args);
	}
}