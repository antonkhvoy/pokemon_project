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
import com.example.pokemon_project.network.Common;
import com.example.pokemon_project.network.PokemonCardDetail;
import com.example.pokemon_project.utils.DownloadImageTask;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_detail);

        ImageView imageView = findViewById(R.id.detailImageView);
        TextView nameTextView = findViewById(R.id.detailNameTextView);
        RecyclerView recyclerView = findViewById(R.id.detailRecyclerView);

        String id = getIntent().getStringExtra("id");
        Common.getRetrofitService().getCardDetail(id).enqueue(new Callback<PokemonCardDetail>() {

            @Override
            public void onResponse(Call<PokemonCardDetail> call, Response<PokemonCardDetail> response) {
                Pokemon pokemon = response.body().getData();

                // Отображение данных на втором экране
                new DownloadImageTask(imageView, (bitmap) -> {}).execute(pokemon.getImages().getLarge());
                nameTextView.setText(pokemon.getName());

                // Установка адаптера для RecyclerView
                AttackAdapter attackAdapter = new AttackAdapter(pokemon.getAttacks());
                recyclerView.setAdapter(attackAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onFailure(Call<PokemonCardDetail> call, Throwable t) {}
        });
    }
}
