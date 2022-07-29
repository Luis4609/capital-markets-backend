package com.optimissa.elementalarchetype.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.optimissa.elementalarchetype.service.messaging.HelloSendMessageService;

/**
 * Created by pedro.uceda on 10/03/2017.
 */
@RestController
@RequestMapping(value = "/sendMessage")
public class SendMessageController implements InitializingBean{

    private Logger logger = LogManager.getLogger(this.getClass());

    @Autowired
    private HelloSendMessageService helloSendMessageService;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public ResponseEntity sendMessage() {
        this.helloSendMessageService.sendAndReceiveHelloMessage();
        return new ResponseEntity(HttpStatus.OK);
    }


    public void afterPropertiesSet() throws Exception {
        this.logger.info("SendMessageController created");
    }
}
