package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {

    /* 설명. 1. 필드 주입 */
//    @Autowired
//    @Qualifier("squirtle")
//    private Pokemon pokemon;

    /* 설명. 2. 생성자 주입 */
    private final Pokemon pokemon;

    @Autowired
    public PokemonService(@Qualifier("charmander") Pokemon pokemon) {
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        this.pokemon.attack();
    }
}
