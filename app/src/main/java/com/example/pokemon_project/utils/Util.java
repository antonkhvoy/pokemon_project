package com.example.pokemon_project.utils;

import android.content.Context;
import com.example.pokemon_project.Models.Pokemon;
import com.example.pokemon_project.R;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Util {
    public static int getResId(String resName, Class<?> c) {
        try {
            Field idField = c.getDeclaredField(resName);
            return idField.getInt(idField);
        } catch (Exception e) {
            return -1;
        }
    }

    public static List<Pokemon> createPokemonList(Context context) {
        try(InputStream stream = context.getResources().openRawResource(R.raw.pokemon)){
            String json = new String(stream.readAllBytes(), StandardCharsets.UTF_8);
            ObjectMapper mapper = new ObjectMapper();
            Pokemon[] pokemon = mapper.readValue(json, Pokemon[].class);
            return Arrays.asList(pokemon);
        } catch (IOException ignored) {
            return new ArrayList<>();
        }
    }
}
