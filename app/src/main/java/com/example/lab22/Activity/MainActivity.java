package com.example.lab22.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab22.Adapters.PokemonAdapter;
import com.example.lab22.Adapters.RecyclerViewClickListener;
import com.example.lab22.Models.Pokemon;
import com.example.lab22.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    int[] rowImages = {R.drawable.bulba, R.drawable.ivi, R.drawable.venu,
            R.drawable.charmander, R.drawable.charmeleon, R.drawable.charizard,
            R.drawable.squirtle, R.drawable.wartortle, R.drawable.blastoise, R.drawable.caterpie};


    //@SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация списка покемонов и адаптера
        List<Pokemon> pokemonList = createPokemonList();
        PokemonAdapter adapter = new PokemonAdapter(this, R.layout.pokemon_list_item, pokemonList);

        // Настройка RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(this, recyclerView, new RecyclerViewClickListener.ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Pokemon selectedPokemon = pokemonList.get(position);
                openPokemonDetailActivity(selectedPokemon, position);
            }

            @Override
            public void onLongClick(View view, int position) {

            }
        }));
    }

    private List<Pokemon> createPokemonList() {
        ArrayList<Pokemon> PokemonList = new ArrayList<>();
        String[] names = getResources().getStringArray(R.array.pokemon_names_arr);
        //int[] imagesId = getResources().getIntArray(R.array.pokemon_image_id_arr);
        int[] hp = getResources().getIntArray(R.array.pokemon_hp_arr);
        for (int i = 0; i < names.length; i++) {
            PokemonList.add(new Pokemon(names[i], rowImages[i], hp[i], null));
        }
        return PokemonList;
    }

    private void openPokemonDetailActivity(Pokemon pokemon, int position) {
        Intent intent = new Intent(this, PokemonDetailActivity.class);
        intent.putExtra("pokemonName", pokemon.getName());
        intent.putExtra("pokemonHp", pokemon.getHp());
        intent.putExtra("pokemonImage", pokemon.getImageResourceId());
        intent.putExtra("position", position);
        //intent.putA("pokemonAttacks", pokemon.getAttacks());
        startActivity(intent);
    }
}