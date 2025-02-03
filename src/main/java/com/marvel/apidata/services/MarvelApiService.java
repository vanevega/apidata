package com.marvel.apidata.services;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.marvel.apidata.models.Access;
import com.marvel.apidata.repositories.AccessRepository;
import com.marvel.collection.services.ConsumeMarvelApiImpl;

@Service
public class MarvelApiService {

    @Autowired
    AccessRepository accessRepository;

    @Value("${puk_marvel}")
    private String puk_marvel;

    @Value("${pik_marvel}")
    private String pik_marvel;

    public String getAllCharacters() throws URISyntaxException, IOException, InterruptedException {
        createAccessItem(1);
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return consume.getAllCharacters(getParameters());
    }
    public String getCharacterById(int id) throws URISyntaxException, IOException, InterruptedException {
        createAccessItem(2);
        ConsumeMarvelApiImpl consume= new ConsumeMarvelApiImpl();
        return consume.getCharacterById(getParameters(), id);
    }

    public String getParameters() {
        Long tsL = System.currentTimeMillis();
        String ts = tsL.toString().substring(0, tsL.toString().length() - 3);
        String data =  ts + pik_marvel + puk_marvel;

        MessageDigest md;
        try {
            md = MessageDigest.getInstance("MD5");
            md.update(data.getBytes());
            byte[] digest = md.digest();
            String hashMarvel =  DatatypeConverter
            .printHexBinary(digest).toLowerCase();
            return "ts=" + ts + "&apikey=" + puk_marvel + "&hash="+ hashMarvel;
        } catch (NoSuchAlgorithmException ex) {
            return "";
        }
    }

    private void createAccessItem(int type) throws IOException {
        Access itemAccess = new Access();
        itemAccess.setAccessAt(LocalDateTime.now());
        itemAccess.setAccessType(type);
        accessRepository.save(itemAccess);
    }

    public List<Access> findAllAccess() {
        return accessRepository.findAll();
    }
}
