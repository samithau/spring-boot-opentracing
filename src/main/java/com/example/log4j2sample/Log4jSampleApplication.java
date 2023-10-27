package com.example.log4j2sample;

import com.uber.jaeger.Configuration;
import com.uber.jaeger.samplers.ProbabilisticSampler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
public class Log4jSampleApplication  {


	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("bank-service-v1", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();
	}


/*	public  static  void main(String[] args){
		SpringApplication.run(Log4jSampleApplication.class,args);
	}*/



	private static final Logger logger = LogManager.getLogger(Log4jSampleApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(Log4jSampleApplication.class, args);
	}



	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.
				build();
	}
}
