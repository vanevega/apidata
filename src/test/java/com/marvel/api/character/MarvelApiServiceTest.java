package com.marvel.api.character;

import java.io.IOException;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

import com.marvel.apidata.models.Access;
import com.marvel.apidata.repositories.AccessRepository;
import com.marvel.apidata.services.MarvelApiService;

@ExtendWith(MockitoExtension.class)
public class MarvelApiServiceTest {

  @Mock
  MarvelApiService marvelService;

  @InjectMocks
  MarvelApiService marvelServiceInject;

  @Mock
  AccessRepository accessRepository;

  @Test
  void testFindAllAccessLogs() {
    List<Access> list = new ArrayList<>();
    list.add(new Access(1, LocalDateTime.now(), 1));
    list.add(new Access(2, LocalDateTime.now(), 2));
    list.add(new Access(3, LocalDateTime.now(), 1));
    when(accessRepository.findAll()).thenReturn(list);
    List<Access> accessList = marvelServiceInject.findAllAccess();
    assertEquals(3, accessList.size());
    verify(accessRepository, times(1)).findAll();
  }

  @Test
  void testFindAllCharacters() throws URISyntaxException, IOException, InterruptedException {
    String response = "\"code\": 200, \"data\": { }";
    when(marvelService.getAllCharacters()).thenReturn(response);
    String characters = marvelService.getAllCharacters();
    assertEquals(characters, response);
    verify(marvelService, times(1)).getAllCharacters();
  }

  @Test
  void testFindCharacterById() throws URISyntaxException, IOException, InterruptedException {
    String response = "\"code\": 200, \"data\": { }";
    when(marvelService.getCharacterById(1)).thenReturn(response);
    String characterById = marvelService.getCharacterById(1);
    assertEquals(characterById, response);
    verify(marvelService, times(1)).getCharacterById(1);
  }
}