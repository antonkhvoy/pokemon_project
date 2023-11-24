package com.example.lab22.Adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.lab22.Models.Pokemon;
import com.example.lab22.R;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {

    private final List<Pokemon> pokemonList;
    private final Context context;

    public PokemonAdapter(Context context, int resource, List<Pokemon> pokemonList) {
        this.pokemonList = pokemonList;
        this.context = context;
    }

    /*
    @SuppressLint("SetTextI18n")
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Получение данных о текущем покемоне
        Pokemon pokemon = getItem(position);

        // Проверка, существует ли представление (View) для повторного использования
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.pokemon_list_item, parent, false);
        }

        // Инициализация элементов представления
        ImageView imageView = convertView.findViewById(R.id.pokemonImageView);
        TextView nameTextView = convertView.findViewById(R.id.pokemonNameTextView);
        TextView hpTextView = convertView.findViewById(R.id.pokemonHpTextView);

        // Отображение данных о покемоне в элементах представления
        assert pokemon != null;
        imageView.setImageResource(pokemon.getImageResourceId());
        nameTextView.setText(pokemon.getName());
        hpTextView.setText("HP: " + pokemon.getHp());

        return convertView;
    }*/

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
        holder.pokemonImageView.setImageResource(pokemon.getImageResourceId());
        holder.pokemonHpTextView.setText(String.valueOf(pokemon.getHp()));
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    public static class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView pokemonImageView;
        public TextView pokemonNameTextView;
        public TextView pokemonHpTextView;

        public PokemonViewHolder(@NotNull View itemView) {
            super(itemView);
            pokemonImageView = itemView.findViewById(R.id.pokemonImageView);
            pokemonNameTextView = itemView.findViewById(R.id.pokemonNameTextView);
            pokemonHpTextView = itemView.findViewById(R.id.pokemonHpTextView);
        }
    }
}


