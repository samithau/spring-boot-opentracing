package com.example.opentrace;

import com.uber.jaeger.Tracer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {

    @Bean
    public Tracer jaegerTracer() {
        // Set your custom Jaeger tracing URL
        String jaegerAgentUrl = "http://your-custom-jaeger-url:14268/api/traces";

        Configuration.class senderConfiguration = new Configuration.SenderConfiguration()
                .withAgentHost(jaegerAgentUrl)
                .withAgentPort(0); // Use 0 to indicate that the port should be parsed from the URL

        Configuration.ReporterConfiguration reporterConfiguration = new Configuration.ReporterConfiguration()
                .withLogSpans(true)
                .withSender(senderConfiguration);

        Configuration.SamplerConfiguration samplerConfiguration = new Configuration.SamplerConfiguration()
                .withType(ProbabilisticSampler.TYPE)
                .withParam(1);

        Configuration config = new Configuration(applicationName)
                .withSampler(samplerConfiguration)
                .withReporter(reporterConfiguration);

        return config.getTracer();
    }
}
