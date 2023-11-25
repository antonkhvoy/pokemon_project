package com.example.pokemon_project.network;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;


public interface RetrofitService {
    @GET("cards?select=id,name,hp,images")
    public Call<PokemonCardsList> getPokemonCardsList();

    @GET("cards/{pokemonId}?select=id,name,hp,images,attacks")
    public Call<PokemonCardDetail> getCardDetail(@Path("pokemonId")String pokemonId);
}
