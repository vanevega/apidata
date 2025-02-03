package com.marvel.apidata.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.apidata.services.MarvelApiService;

@RestController
@RequestMapping("/inside")
public class CharacterController {
    @Autowired
    MarvelApiService marvelApiService;

    @GetMapping("/characters")
    public ResponseEntity<String> getAllCharacters() throws URISyntaxException, IOException, InterruptedException {
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body(marvelApiService.getAllCharacters());
    }
    
    @GetMapping("/characters/{id}")
    public ResponseEntity<String> getCharacterById(@PathVariable int id) throws URISyntaxException, IOException, InterruptedException {
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body(marvelApiService.getCharacterById(id));
    }
}
