package com.shoppingcart.repository;

import com.shoppingcart.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  Product findByProductName(String ProductName);
}
