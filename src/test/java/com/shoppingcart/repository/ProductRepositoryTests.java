package com.shoppingcart.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import com.shoppingcart.domain.Product;
import com.shoppingcart.items.ItemsApplication;
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
public class ProductRepositoryTests {

  @Autowired ProductRepository productRepository;

  @Test
  public void testSaveProduct() {
    Product product = new Product("Test", 1);
    productRepository.save(product);
    Product product1 = productRepository.findByProductName("Test");
    assertNotNull(product);
    assertEquals(product1.getProductName(), product.getProductName());
    assertEquals(product1.getQuantity(), product.getQuantity());
  }

  @Test
  public void testGetProduct() {
    Product product = new Product("Test", 1);
    productRepository.save(product);
    Product product1 = productRepository.findByProductName("Test");
    assertNotNull(product);
    assertEquals(product1.getProductName(), product.getProductName());
    assertEquals(product1.getQuantity(), product.getQuantity());
  }

  @Test
  public void testDeleteProduct() {
    Product product = new Product("Test", 1);
    productRepository.save(product);
    productRepository.delete(product);
  }
}
