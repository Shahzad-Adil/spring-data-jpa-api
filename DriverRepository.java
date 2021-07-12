package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Driver;

public interface DriverRepository extends JpaRepository<Driver, Integer> {

}
