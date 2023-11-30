package com.example.pokemon_project.Adapters;


import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokemon_project.Models.Pokemon;
import com.example.pokemon_project.R;
import com.example.pokemon_project.utils.DownloadImageTask;
import com.example.pokemon_project.utils.Util;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private final List<Pokemon> pokemonList;
    private final List<Bitmap> imageList;
    //private final Context context;

    public PokemonAdapter(List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        //this.context = context;
        this.imageList = new ArrayList<>(pokemonList.size());
        for (Pokemon pokemon:pokemonList) {
            imageList.add(null);
        }
    }

    @NotNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.pokemon_list_item, parent, false);
        return new PokemonAdapter.PokemonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NotNull PokemonViewHolder holder, int position) {
        Pokemon pokemon = pokemonList.get(position);
        holder.pokemonNameTextView.setText(pokemon.getName());
        //holder.pokemonImageView.setImageResource(Util.getResId(pokemon.getImages().getSmall(), R.drawable.class));
        holder.pokemonHpTextView.setText(String.valueOf(pokemon.getHp()));
        if (imageList.get(position) != null)
            holder.pokemonImageView.setImageBitmap(imageList.get(position));
        else {
            holder.downloadImageTask = new DownloadImageTask(holder.pokemonImageView, (bitmap -> imageList.set(position, bitmap)));
            holder.downloadImageTask.execute(pokemon.getImages().getSmall());
        }
    }

    @Override
    public void onViewRecycled(@NonNull PokemonViewHolder holder) {
        if (holder.downloadImageTask != null)
            holder.downloadImageTask.cancel(true);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView pokemonImageView;
        public TextView pokemonNameTextView;
        public TextView pokemonHpTextView;
        public DownloadImageTask downloadImageTask;

        public PokemonViewHolder(@NotNull View itemView) {
            super(itemView);
            pokemonImageView = itemView.findViewById(R.id.pokemonImageView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
            pokemonHpTextView = itemView.findViewById(R.id.pokemonHpTextView);
        }
    }
}


