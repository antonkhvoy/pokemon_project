package com.example.pokemon_project.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokemon_project.Adapters.PokemonAdapter;
import com.example.pokemon_project.Adapters.RecyclerViewClickListener;
import com.example.pokemon_project.Models.Pokemon;
import com.example.pokemon_project.R;
import com.example.pokemon_project.utils.Util;

import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Инициализация списка покемонов и адаптера
        List<Pokemon> pokemonList = Util.createPokemonList(this);
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

    private void openPokemonDetailActivity(Pokemon pokemon, int position) {
        Intent intent = new Intent(this, PokemonDetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);
    }
}