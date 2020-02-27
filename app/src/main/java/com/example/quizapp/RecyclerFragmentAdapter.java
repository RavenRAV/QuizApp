package com.example.quizapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFragmentAdapter extends RecyclerView.Adapter<RecyclerFragmentAdapter.ViewHolder> {
    private ArrayList<String> countRV;

    public RecyclerFragmentAdapter() {
        countRV = new ArrayList<>();
    }

    public void addText(String t) {
        countRV.add(t);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerFragmentAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecyclerFragmentAdapter.ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerFragmentAdapter.ViewHolder holder, int position) {
        holder.onBind(countRV.get(position));
    }

    @Override
    public int getItemCount() {
        return countRV.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textview);
        }

        public void onBind(String t) {
            textView.setText(t);
        }
    }
}
