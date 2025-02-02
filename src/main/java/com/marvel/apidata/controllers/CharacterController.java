package com.marvel.apidata.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.marvel.collection.services.ConsumeMarvelApiImpl;

@Controller
public class CharacterController {

    @GetMapping("/characters")
    public ResponseEntity<String> getAllCharacters() throws URISyntaxException, IOException, InterruptedException{
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return ResponseEntity
      .status(HttpStatus.ACCEPTED)
      .header(HttpHeaders.CONTENT_TYPE, "application/json") //
      .body( consume.getAllCharacters(""));
    }
    
    @GetMapping("/characters/{id}")
    public ResponseEntity<String> getCharacterById(@PathVariable int id) throws URISyntaxException, IOException, InterruptedException {
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return ResponseEntity
      .status(HttpStatus.ACCEPTED)
      .header(HttpHeaders.CONTENT_TYPE, "application/json") //
      .body( consume.getCharacterById("", id));
    }
}
