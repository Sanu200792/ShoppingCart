package com.shoppingcart.service;

import static org.junit.Assert.assertEquals;

import com.shoppingcart.domain.Product;
import com.shoppingcart.items.ItemsApplication;
import com.shoppingcart.repository.ProductRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ItemsApplication.class)
@AutoConfigureWebMvc
@Transactional
public class ProductServiceTests {

  @Autowired ProductService productService;

  @Autowired ProductRepository productRepository;

  @Test
  public void testCheckDatabaseConnection() {
    boolean status = productService.checkDatabaseConnection();
    assertEquals(true, status);
  }

  @Test
  public void testUpdateProductMessage() {
    Product product = new Product("Test", 1);
    productService.updateProductMessage(product);
    Product product1 = productRepository.findByProductName("Test");
    assertEquals(1, product1.getQuantity());
  }
}
