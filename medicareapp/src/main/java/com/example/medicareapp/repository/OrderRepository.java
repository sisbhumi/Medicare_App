package com.example.medicareapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicareapp.entity.Orders;

public interface OrderRepository extends JpaRepository<Orders,Long> {

}
