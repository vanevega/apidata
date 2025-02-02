package com.marvel.apidata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.marvel.apidata.models.Access;

public interface  AccessRepository extends JpaRepository<Access, Integer>{ }
