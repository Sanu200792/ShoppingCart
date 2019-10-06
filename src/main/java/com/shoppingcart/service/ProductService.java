package com.shoppingcart.service;

import com.shoppingcart.domain.Product;
import com.shoppingcart.repository.ProductRepository;
import java.sql.Connection;
import java.sql.SQLException;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

  private static final Logger log = LoggerFactory.getLogger(ProductService.class);

  @Qualifier("dataSource")
  @Autowired
  DataSource dataSource;

  @Autowired private ProductRepository productRepository;

  public boolean checkDatabaseConnection() {
    boolean status;
    try {
      Connection connection = dataSource.getConnection();
      log.info(connection + " Is Up");
      status = true;
    } catch (SQLException e) {
      log.error("Database connection error");
      status = false;
    }
    return status;
  }

  public void updateProductMessage(Product product) {
    productRepository.save(product);
  }
}
