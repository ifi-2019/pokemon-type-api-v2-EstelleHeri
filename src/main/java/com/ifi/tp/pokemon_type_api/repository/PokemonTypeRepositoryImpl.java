package com.ifi.tp.pokemon_type_api.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class PokemonTypeRepositoryImpl implements PokemonTypeRepository {

    private List<PokemonType> pokemons;

    public PokemonTypeRepositoryImpl() {
        try {
            var pokemonsStream = new ClassPathResource("pokemons.json").getInputStream();

            var objectMapper = new ObjectMapper();
            var pokemonsArray = objectMapper.readValue(pokemonsStream, PokemonType[].class);
            this.pokemons = Arrays.asList(pokemonsArray);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PokemonType findPokemonTypeById(int id) {
        System.out.println("Loading Pokemon information for Pokemon id " + id);
        PokemonType pokemonType = pokemons.stream()
                .filter(pokemon -> pokemon.getId() == id)
                .findAny()
                .orElse(null);
        return pokemonType;
    }

    @Override
    public PokemonType findPokemonTypeByName(String name) {
        System.out.println("Loading Pokemon information for Pokemon name " + name);
        PokemonType pokemonType = pokemons.stream()
                .filter(pokemon -> name.equals(pokemon.getName()))
                .findAny()
                .orElse(null);
        return pokemonType;
    }

    @Override
    public List<PokemonType> findAllPokemonType() {
        return this.pokemons;
    }

    @Override
    public List<PokemonType> findAllPokemonTypeByTypes(List<String> types) {
        var allPokemonTypeWithTypes = new ArrayList<PokemonType>();

        for (PokemonType p : pokemons) {
            if (p.getTypes().containsAll(types)) {
                allPokemonTypeWithTypes.add(p);
            }
        }
        return allPokemonTypeWithTypes;
    }
}