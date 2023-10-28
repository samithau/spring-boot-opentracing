package com.example.opentrace;



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

//	@Value("${spring.application.name}")
//	private String applicationName;
/*	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		return new Configuration("bank-service-v2", new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1),
				new Configuration.ReporterConfiguration())
				.getTracer();

	}*/
//	@Bean
//	public io.opentracing.Tracer jaegerTracer() {
//		return new Configuration(applicationName, new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1.0,"http://localhostsss:431ss8/vss1/tracess"),
//				new Configuration.ReporterConfiguration())
//				.getTracer();
//
//
//	}

/*	@Bean
	public io.opentracing.Tracer jaegerTracer() {
		Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1);
		Configuration.ReporterConfiguration reporterConfig = new Configuration.ReporterConfiguration();
		reporterConfig.setAgentHost("localhost");
		reporterConfig.setAgentPort(4318);
		reporterConfig.setLogSpans(true);
		reporterConfig.getSenderConfiguration().setEndpoint("/v1/traces");

		Configuration configuration = new Configuration(applicationName, samplerConfig, reporterConfig);
		return configuration.getTracer();
	}*/


/*	@Bean
	public Tracer jaegerTracer() {
		Configuration.SamplerConfiguration samplerConfig = new Configuration.SamplerConfiguration(ProbabilisticSampler.TYPE, 1);

		Configuration.ReporterConfiguration reporterConfig = new Configuration.ReporterConfiguration()
				.withLogSpans(true)
				.withAgentHost("your-jaeger-agent-host")
				.withAgentPort(6831);

		// Set your trace URL in the reporter configuration
		reporterConfig.withEndpoint("http://your-jaeger-collector:14268/api/traces");

		Configuration config = new Configuration(applicationName, samplerConfig, reporterConfig);
		return config.getTracer();
	}*/


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
