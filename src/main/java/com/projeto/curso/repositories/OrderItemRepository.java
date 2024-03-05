package com.projeto.curso.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projeto.curso.entities.OrderItem;
import com.projeto.curso.entities.PK.OrderItemPk;

public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPk> {

}
