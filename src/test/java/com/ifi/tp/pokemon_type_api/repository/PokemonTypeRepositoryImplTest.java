package com.ifi.tp.pokemon_type_api.repository;

import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class PokemonTypeRepositoryImplTest {

    private PokemonTypeRepositoryImpl repository = new PokemonTypeRepositoryImpl();

    @Test
    void findPokemonTypeById_with25_shouldReturnPikachu(){
        var pikachu = repository.findPokemonTypeById(25);
        assertNotNull(pikachu);
        assertEquals("pikachu", pikachu.getName());
        assertEquals(25, pikachu.getId());
    }

    @Test
    void findPokemonTypeById_with145_shouldReturnZapdos(){
        var zapdos = repository.findPokemonTypeById(145);
        assertNotNull(zapdos);
        assertEquals("zapdos", zapdos.getName());
        assertEquals(145, zapdos.getId());
    }

    @Test
    void findPokemonTypeByName_withEevee_shouldReturnEevee(){
        var eevee = repository.findPokemonTypeByName("eevee");
        assertNotNull(eevee);
        assertEquals("eevee", eevee.getName());
        assertEquals(133, eevee.getId());
    }

    @Test
    void findPokemonTypeByName_withMewTwo_shouldReturnMewTwo(){
        var mewtwo = repository.findPokemonTypeByName("mewtwo");
        assertNotNull(mewtwo);
        assertEquals("mewtwo", mewtwo.getName());
        assertEquals(150, mewtwo.getId());
    }

    @Test
    void findAllPokemonType_shouldReturn151Pokemons(){
        var pokemons = repository.findAllPokemonType();
        assertNotNull(pokemons);
        assertEquals(151, pokemons.size());
    }

    @Test
    void findAllPokemonTypeByTypes_withDragon_shouldReturn3Dragon(){
        var list = new ArrayList<String>();
        list.add("dragon");
        var pokemons = repository.findAllPokemonTypeByTypes(list);
        assertNotNull(pokemons);
        assertEquals(3, pokemons.size());
    }

    @Test
    void findAllPokemonTypeByTypes_withDragonFlying_shouldReturn1Dragon(){
        var list = new ArrayList<String>();
        list.add("dragon");
        list.add("flying");
        var pokemons = repository.findAllPokemonTypeByTypes(list);
        assertNotNull(pokemons);
        assertEquals(1, pokemons.size());
        assertEquals("dragonite", pokemons.get(0).getName());
    }

    @Test
    void applicationContext_shouldLoadPokemonRepository() {

        var context = new AnnotationConfigApplicationContext("com.ifi.tp.pokemon_type_api.repository");
        var repoByName = context.getBean("pokemonTypeRepositoryImpl");
        var repoByClass = context.getBean(PokemonTypeRepository.class);

        assertEquals(repoByName, repoByClass);
        assertNotNull(repoByName);
        assertNotNull(repoByClass);
    }

}
