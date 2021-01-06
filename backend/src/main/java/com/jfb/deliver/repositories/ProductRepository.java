package com.jfb.deliver.repositories;

import java.util.List;

import com.jfb.deliver.entities.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

  List<Product> findAllByOrderByNameAsc();

}
