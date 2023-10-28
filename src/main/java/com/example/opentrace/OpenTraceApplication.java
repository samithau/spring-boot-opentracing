package com.example.opentrace;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class OpenTraceApplication {

	@Value("${spring.application.name}")
	private String applicationName;
/*	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("bank-service-v2", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();

	}*/

	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration(applicationName, new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();

	}


/*	public  static  void main(String[] args){
		SpringApplication.run(Log4jSampleApplication.class,args);
	}*/



	private static final Logger logger = LogManager.getLogger(OpenTraceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(OpenTraceApplication.class, args);
	}



	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.
				build();
	}
}
