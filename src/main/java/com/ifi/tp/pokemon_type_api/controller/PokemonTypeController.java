package com.ifi.tp.pokemon_type_api.controller;

import com.ifi.tp.pokemon_type_api.bo.PokemonType;
import com.ifi.tp.pokemon_type_api.service.PokemonTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/pokemon-types")
public class PokemonTypeController {

    PokemonTypeService service;

    public PokemonTypeController(PokemonTypeService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    PokemonType getPokemonTypeFromId(@PathVariable int id) {
        return this.service.getPokemonType(id);
    }

    @GetMapping("/")
    public List<PokemonType> getAllPokemonTypes() {
        return this.service.getAllPokemonTypes();
    }

    @GetMapping(value = "/", params = "name")
    PokemonType getPokemonTypeFromName(String name) {
        return this.service.getPokemonType(name);
    }

    @GetMapping(value = "/", params = "types")
    public List<PokemonType> getAllPokemonTypesFromTypes(String types) {
        var listSplit = types.split(",");
        var listAllPokemonTypes = Arrays.asList(listSplit);
        return this.service.getAllPokemonTypesWithTypes(listAllPokemonTypes);
    }


}
