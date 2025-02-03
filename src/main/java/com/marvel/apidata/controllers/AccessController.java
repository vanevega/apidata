package com.marvel.apidata.controllers;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.apidata.models.Access;
import com.marvel.apidata.services.MarvelApiService;

@RestController
@RequestMapping("/inside")
public class AccessController {
    @Autowired
     MarvelApiService marvelApiService;

    @GetMapping("/access")
    public Iterable<Access> getAllAccess() throws URISyntaxException, IOException, InterruptedException {
        return marvelApiService.findAllAccess();
    }
}
