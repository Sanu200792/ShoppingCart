package com.shoppingcart.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.shoppingcart.items.ItemsApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemsApplication.class)
@AutoConfigureWebMvc
public class ProductTests {

  @Test
  public void testCreateProduct() {
    Product product = new Product("Test", 1);
    assertNotNull(product);
  }

  @Test
  public void testSetProductName() {
    Product product = new Product();
    product.setProductName("Test");
    assertEquals(product.getProductName(), "Test");
  }

  @Test
  public void testSetQuantity() {
    Product product = new Product();
    product.setQuantity(1);
    assertEquals(product.getQuantity(), 1);
  }
}
