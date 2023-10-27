package com.example.log4j2sample;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/update-service")
public class LogsErrorController {

    private static final Logger logger = LoggerFactory.getLogger(LogsErrorController.class);

    @Autowired
    private RestTemplate restTemplate;

//   @Value("${spring.application.name}")
//    private String applicationName;

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${subbaseUrl}")
    private String subbaseUrl;

/*
    public LogsErrorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
*/
    @GetMapping("/hello")
    public String hello(){
    //logger.info("My Name is ");
    //logger.info("applicationName "+ applicationName);
    return "Mine";
    }

    @GetMapping("/method1")
    public ResponseEntity method1() {
        System.out.println("inside method1");
        System.out.println("ibaseUrlSub"+baseUrl);
       // System.out.println("applicationName---"+applicationName);
        logger.info("Incoming request at {} for request /method1 ");
       // logger.info("Incoming request at {} for request /method1 "+ applicationName);
        String response = restTemplate.getForObject(baseUrl, String.class);
        return ResponseEntity.ok("response from /method1 + " + response);
    }

    @GetMapping("/method2")
    public ResponseEntity method2() {
        System.out.println("method2 ");
        String response = restTemplate.getForObject(subbaseUrl, String.class);
        return ResponseEntity.ok("response from /method2 ");
    }

    @GetMapping("/method3")
    public ResponseEntity method3() {
        System.out.println("method3 ");
     //   logger.info("Incoming request at {} at /method3", applicationName);
        return ResponseEntity.ok("Hello Bank-Service-v1 successfully completed  ");
    }

}
