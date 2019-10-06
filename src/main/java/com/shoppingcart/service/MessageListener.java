package com.shoppingcart.service;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.shoppingcart.domain.Product;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.TextMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
@EnableJms
public class MessageListener {

  private static final Logger log = LoggerFactory.getLogger(MessageListener.class);

  @Autowired ProductService productService;

  @JmsListener(destination = "ProductQueue", containerFactory = "myFactory")
  public void receiveMessage(final Message jsonMessage) {
    String messageData;
    log.info("Received message " + jsonMessage);
    Product product = null;
    if (jsonMessage instanceof TextMessage) {
      TextMessage textMessage = (TextMessage) jsonMessage;
      try {
        messageData = textMessage.getText();
        product = new Gson().fromJson(messageData, Product.class);
      } catch (JMSException e) {
        log.error("Input message is not from MESSAGE QUEUE");
      } catch (JsonParseException e) {
        log.error("Please check input message");
      }
      log.info(product.toString());
    }
    if (productService.checkDatabaseConnection()) {
      productService.updateProductMessage(product);
    }
  }
}
