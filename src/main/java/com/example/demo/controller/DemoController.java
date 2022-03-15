package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller; 
import org.springframework.web.bind.annotation.RequestMapping; 
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.net.InetAddress; 

import java.net.UnknownHostException;

@Controller 
public class DemoController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @RequestMapping(value = "/demo") 
    public String demo(){ 
        return "index.html"; 
    }
    
    @ResponseBody 
    @RequestMapping("/valueTest") 
    public String valueTest(){
         String value = "테스트 String"; 
         return value; 
    }

    @RequestMapping(value = "/logback") 
    public ModelAndView test() throws Exception{ 
        logger.trace("Trace Level 테스트");
        logger.debug("DEBUG Level 테스트");
        logger.info("INFO Level 테스트"); 
        logger.warn("Warn Level 테스트"); 
        logger.error("ERROR Level 테스트"); 
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/hostname") 
    public String getHostname(){ 
        String hostname=null;
        String hostAddress=null;
        try{ 
            hostname = InetAddress.getLocalHost().getHostName();
            hostAddress = InetAddress.getLocalHost().getHostAddress();
            System.out.println( "sysout ::: " + hostname ); 
            System.out.println( "sysout ::: " + hostAddress ); 
            logger.debug("logger {}", hostname);
            logger.debug("logger {}", hostAddress);
        } catch( UnknownHostException e ){
             e.printStackTrace(); 
        } 
        return hostname + ", " + hostAddress;
    } 

    @ResponseBody
    @RequestMapping(value = "/countdown") 
    public Integer countdown(){ 
        int i = 0;
        try {
            while(i<100){
                System.out.println("sysout ::: " + Integer.toString(i));
                logger.debug("debug ::: {}", i);
                i++;
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }  
        return i;
    } 
}
