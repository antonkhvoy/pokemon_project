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
import com.example.pokemon_project.network.Common;
import com.example.pokemon_project.network.PokemonCardsList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rvItems = findViewById(R.id.recyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvItems.setLayoutManager(linearLayoutManager);

        // Инициализация списка покемонов и адаптера
        //List<Pokemon> pokemonList = Util.createPokemonList(this);
        Common.getRetrofitService().getPokemonCardsList().enqueue(new Callback<PokemonCardsList>() {
            @Override
            public void onResponse(Call<PokemonCardsList> call, Response<PokemonCardsList> response) {
                List<Pokemon> pokemonList = response.body().getData();
                PokemonAdapter adapter = new PokemonAdapter(pokemonList);
                // Настройка RecyclerView
                RecyclerView recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

                recyclerView.addOnItemTouchListener(new RecyclerViewClickListener(getApplicationContext(), recyclerView, new RecyclerViewClickListener.ClickListener() {
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

            @Override
            public void onFailure(Call<PokemonCardsList> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private void openPokemonDetailActivity(Pokemon pokemon, int position) {
        Intent intent = new Intent(this, PokemonDetailActivity.class);
        intent.putExtra("id", pokemon.getId());
        startActivity(intent);
    }
}