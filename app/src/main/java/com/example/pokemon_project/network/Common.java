package com.example.pokemon_project.network;

public class Common {
    private static final String BASE_URL = "https://api.pokemontcg.io/v2/";

    public static RetrofitService getRetrofitService() {
        return RetrofitClient.getClient(BASE_URL).create(RetrofitService.class);
    }
}
