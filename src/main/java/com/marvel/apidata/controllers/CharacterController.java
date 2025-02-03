package com.marvel.apidata.controllers;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.marvel.apidata.models.Access;
import com.marvel.apidata.repositories.AccessRepository;
import com.marvel.collection.services.ConsumeMarvelApiImpl;

@RestController
@RequestMapping("/inside")
public class CharacterController {
    @Autowired
    AccessRepository accessRepository;

    @Value("${puk_marvel}")
    private String puk_marvel;
    @Value("${pik_marvel}")
    private String pik_marvel;

    @GetMapping("/characters")
    public ResponseEntity<String> getAllCharacters() throws URISyntaxException, IOException, InterruptedException {
        createAccessItem(1);
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body(consume.getAllCharacters(getParameters()));
    }
    
    @GetMapping("/characters/{id}")
    public ResponseEntity<String> getCharacterById(@PathVariable int id) throws URISyntaxException, IOException, InterruptedException {
        createAccessItem(2);
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return ResponseEntity
        .status(HttpStatus.ACCEPTED)
        .header(HttpHeaders.CONTENT_TYPE, "application/json")
        .body(consume.getCharacterById(getParameters(), id));
    }

    private void createAccessItem(int type) throws IOException {
        Access itemAccess = new Access();
        itemAccess.setAccessAt(LocalDateTime.now());
        itemAccess.setAccessType(type);
        System.out.println(itemAccess.getAccessAt());
        accessRepository.save(itemAccess);
    }

    private String getParameters() {
        Long tsL = System.currentTimeMillis();
        String ts = tsL.toString().substring(0, tsL.toString().length() - 3);
        String data =  ts + pik_marvel + puk_marvel;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
            System.out.println(DatatypeConverter
            .printHexBinary(digest).toLowerCase());
            String hashMarvel =  DatatypeConverter
            .printHexBinary(digest).toLowerCase();
            return "ts=" + ts + "&apikey=" + puk_marvel + "&hash="+ hashMarvel;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }
}
