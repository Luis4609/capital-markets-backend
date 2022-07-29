package com.optimissa.elementalarchetype.service.messaging;

/**
 * Created by pedro.uceda on 09/03/2017.
 */
public interface HelloSendMessageService {

    /**
     * Method that sends a message.
     */
    void sendHelloMessage();

    /**
     * Method that sends a message and waits for its reply
     * @return Reply
     */
    String sendAndReceiveHelloMessage();

    void sendMessages();
}
