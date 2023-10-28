package com.example.opentrace;


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
@RequestMapping("/service")
public class Controller {

    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    @Autowired
    private RestTemplate restTemplate;

   @Value("${spring.application.name}")
    private String applicationName;

    @Value("${baseUrl}")
    private String baseUrl;

    @Value("${subbaseUrl}")
    private String subbaseUrl;

    String emoji = "😀";
    /*
    public LogsErrorController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
    */
    @GetMapping("/hello")
    public String hello() {
        logger.info("My Name is khan " + emoji);
        logger.info("applicationName " + applicationName);
        return "My Name is khan " + emoji;
    }

    @GetMapping("/method1")
    public ResponseEntity method1() {
        System.out.println("inside method1");
        System.out.println("ibaseUrlSub"+baseUrl);
        System.out.println("applicationName---"+applicationName);
        logger.info("Incoming request at {} for request /method1 ");
        logger.info("Incoming request at {} for request /method1 "+ applicationName);
        String response = restTemplate.getForObject(baseUrl, String.class);
        return ResponseEntity.ok("response from /method1 + " + response);
    }

    @GetMapping("/method2")
    public ResponseEntity method2() {
        System.out.println("method2 ");
        String response = restTemplate.getForObject(subbaseUrl+"/method3", String.class);
        return ResponseEntity.ok("response of method----" + response);
        //return ResponseEntity.ok("response from /method2 ");
    }

    @GetMapping("/method3")
    public ResponseEntity method3() {
        System.out.println("method3 ");
        logger.info("Incoming request at {} at /method3", applicationName);
        return ResponseEntity.ok("Hello Bank-Service-v1 successfully completed  ");
    }

}
