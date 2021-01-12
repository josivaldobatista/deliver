package com.jfb.deliver.services;

import java.util.List;
import java.util.stream.Collectors;

import com.jfb.deliver.dto.OrderDTO;
import com.jfb.deliver.entities.Order;
import com.jfb.deliver.repositories.OrderRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class OrderService {

  @Autowired
  private OrderRepository repository;

  @Transactional(readOnly = true)
  public List<OrderDTO> findAll() {
    List<Order> list = repository.findOrdersWithProducts();
    return list.stream().map(x -> new OrderDTO(x)).collect(Collectors.toList());
  }
}