package com.example.medicareapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.medicareapp.entity.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
