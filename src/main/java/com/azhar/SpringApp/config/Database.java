package com.azhar.SpringApp.config;

import com.azhar.SpringApp.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Database extends JpaRepository<Product, Integer> {

}
