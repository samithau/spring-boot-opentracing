package com.example.opentrace;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TracingConfiguration {

 /*   @Bean
    public Tracer jaegerTracer() {

        String jaegerAgentUrl = "http://localhost:4318/v1/traces";

       Configuration.class senderConfiguration = new Configuration.SenderConfiguration()
               .withAgentHost(jaegerAgentUrl)
                .withAgentPort(0);

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
        return null;
    }*/
}
