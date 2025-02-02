package com.marvel.apidata.repositories;

import org.springframework.stereotype.Repository;

import com.marvel.apidata.models.User;

@Repository
public class UserRepository {
    public User findUserByUsername(String username){
        // Se simula que existe un listado de usuarios registrados para hacer la validación
        return new User(username);
    }
}
