package com.example.pokemon_project.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.pokemon_project.Models.Attack;
import com.example.pokemon_project.R;

import java.util.List;


public class AttackAdapter extends RecyclerView.Adapter<AttackAdapter.AttackViewHolder> {

    private final List<Attack> attackList;

    public AttackAdapter(List<Attack> attackList) {
        this.attackList = attackList;
    }

    @NonNull
    @Override
    public AttackViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.attack_list_item, parent, false);
        return new AttackViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AttackViewHolder holder, int position) {
        Attack attack = attackList.get(position);
        holder.nameTextView.setText(attack.getName());
        holder.descriptionTextView.setText(attack.getDescription());
        holder.damageTextView.setText(String.valueOf(attack.getDamage()));
    }

    @Override
    public int getItemCount() {
        return attackList.size();
    }

    public static class AttackViewHolder extends RecyclerView.ViewHolder {
        public TextView nameTextView;
        public TextView descriptionTextView;
        public TextView damageTextView;

        public AttackViewHolder(@NonNull View itemView) {
            super(itemView);
            nameTextView = itemView.findViewById(R.id.attackNameTextView);
            descriptionTextView = itemView.findViewById(R.id.attackDescriptionTextView);
            damageTextView = itemView.findViewById(R.id.attackDamageTextView);
        }
    }
}

