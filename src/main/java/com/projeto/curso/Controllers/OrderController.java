package com.projeto.curso.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.curso.Services.OrderService;
import com.projeto.curso.entities.Order;

@RestController
@RequestMapping(value = "/order")
public class OrderController {
    
    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll(){
        List<Order> listOrder = orderService.findAll();
        return ResponseEntity.ok().body(listOrder);        
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Order> finById(@PathVariable Long id){
        Order order = orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
