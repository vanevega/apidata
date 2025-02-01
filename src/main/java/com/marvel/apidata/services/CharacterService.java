package com.marvel.apidata.services;
import java.util.Optional;

import com.marvel.apidata.models.CharacterMarvel;

public interface CharacterService {
    public Optional<CharacterMarvel[]> findAllCharacters();
    public Optional<CharacterMarvel> findByCharacter(int id);
}
