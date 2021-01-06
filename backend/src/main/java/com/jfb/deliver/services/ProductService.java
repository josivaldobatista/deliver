package com.jfb.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jfb.deliver.dto.ProductDTO;
import com.jfb.deliver.entities.Product;
import com.jfb.deliver.repositories.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

  @Autowired
  private ProductRepository repository;

  @Transactional(readOnly = true)
  public List<ProductDTO> findAll() {
    List<Product> list = repository.findAllByOrderByNameAsc();
    return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
  }
}
