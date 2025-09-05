package com.ohgiraffers.section02.annotation.subsection01.primary;

import com.ohgiraffers.section02.annotation.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("pokemonServicePrimary")
public class PokemonService {

    private final Pokemon pokemon;

    @Autowired
    public PokemonService(Pokemon pokemon) {    // 동일 타입이 여러개 있으면 에러 -> 원하는 클래스에 @Primary 를 달아서 올 것을 지정가능
        this.pokemon = pokemon;
    }

    public void pokemonAttack() {
        this.pokemon.attack();
    }
}
