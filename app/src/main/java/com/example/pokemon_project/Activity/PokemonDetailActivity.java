package com.example.pokemon_project.Activity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokemon_project.Adapters.AttackAdapter;
import com.example.pokemon_project.Models.Pokemon;
import com.example.pokemon_project.R;
import com.example.pokemon_project.utils.Util;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        ImageView imageView = findViewById(R.id.detailImageView);
        TextView nameTextView = findViewById(R.id.detailNameTextView);
        RecyclerView recyclerView = findViewById(R.id.detailRecyclerView);

        // Получение данных о выбранном покемоне
        Pokemon pokemon = getPokemon();


        // Отображение данных на втором экране
        imageView.setImageResource(Util.getResId(pokemon.getImageResourceId(), R.drawable.class));
        nameTextView.setText(pokemon.getName());

        // Установка адаптера для RecyclerView
        AttackAdapter attackAdapter = new AttackAdapter(pokemon.getAttacks());
        recyclerView.setAdapter(attackAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    private Pokemon getPokemon() {
        int position = getIntent().getIntExtra("position", 0);

        return Util.createPokemonList(this).get(position);
    }
}
