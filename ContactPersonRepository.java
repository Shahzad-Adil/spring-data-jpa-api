package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ContactPerson;

public interface ContactPersonRepository extends JpaRepository<ContactPerson, Integer> {

}
