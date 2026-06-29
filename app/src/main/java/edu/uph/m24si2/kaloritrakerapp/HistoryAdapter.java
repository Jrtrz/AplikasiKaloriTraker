package edu.uph.m24si2.kaloritrakerapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private ArrayList<Food> foodList;

    public HistoryAdapter(ArrayList<Food> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Food food = foodList.get(position);

        holder.txtNama.setText(food.getNamaMakanan());
        holder.txtKalori.setText("Kalori : " + food.getKalori() + " kkal");
        holder.txtProtein.setText("Protein : " + food.getProtein() + " gram");
        holder.txtLemak.setText("Lemak : " + food.getLemak() + " gram");
        holder.txtKarbo.setText("Karbohidrat : " + food.getKarbohidrat() + " gram");
    }

    @Override
    public int getItemCount() {
        return foodList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtNama;
        TextView txtKalori;
        TextView txtProtein;
        TextView txtLemak;
        TextView txtKarbo;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtNama = itemView.findViewById(R.id.txtNama);
            txtKalori = itemView.findViewById(R.id.txtKalori);
            txtProtein = itemView.findViewById(R.id.txtProtein);
            txtLemak = itemView.findViewById(R.id.txtLemak);
            txtKarbo = itemView.findViewById(R.id.txtKarbo);
        }
    }
}