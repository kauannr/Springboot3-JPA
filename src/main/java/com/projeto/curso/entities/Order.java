package com.projeto.curso.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import com.projeto.curso.entities.Enums.StatusOrder;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_Order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Instant date;
    private int statusOrder;

    @ManyToOne
    @JoinColumn(name = "client_Id")
    private User client;

    @OneToMany(mappedBy = "id.order", fetch = FetchType.EAGER)
    private Set<OrderItem> items = new HashSet<>();

    @OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
    private Payment payment;

    public Order(Long id, Instant date, StatusOrder statusOrder, User client) {
        this.id = id;
        this.date = date;
        setStatusOrder(statusOrder);
        this.client = client;
    }

    public Double getTotal() {
        Double total = 0d;
        for (OrderItem orderItem : items) {
            total = total + orderItem.getSubTotal();
        }
        return total;
    }

    public Order() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDate() {
        return date;
    }

    public void setDate(Instant date) {
        this.date = date;
    }

    public User getUser() {
        return client;
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public StatusOrder getStatusOrder() {
        return StatusOrder.valueOf(this.statusOrder);
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        if (statusOrder != null) {
            this.statusOrder = statusOrder.getcode();
        }
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Order other = (Order) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Order [id=" + getId() + ", date=" + getDate() + ", user=" + getUser() + "]";
    }

}
