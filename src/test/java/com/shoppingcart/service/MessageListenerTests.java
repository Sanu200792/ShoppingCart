package com.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import com.google.gson.Gson;
import com.shoppingcart.domain.Product;
import com.shoppingcart.items.ItemsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemsApplication.class)
@AutoConfigureWebMvc
public class MessageListenerTests {

  @Autowired MessageListener messageListener;

  @Autowired JmsTemplate jmsTemplate;

  @Test
  public void testJMSSendAndReceive() {
    Product product = new Product("Test", 1);
    String productJson = new Gson().toJson(product);
    jmsTemplate.convertAndSend("Test", productJson);
    assertEquals(productJson, this.jmsTemplate.receiveAndConvert("Test"));
  }
}
