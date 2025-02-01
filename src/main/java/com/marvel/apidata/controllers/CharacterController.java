package com.marvel.apidata.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class CharacterController {

    @GetMapping("/characters")
    public String getAllCharacters() throws URISyntaxException, IOException, InterruptedException{
        return "finish getAllCharacters";
    }
    
    @GetMapping("/characters/{id}")
    public String getCharacterById(@PathVariable String id) {
        return "finish getCharacterById";
    }
    

}
