package com.example.quizapp;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerFragmentAdapter extends RecyclerView.Adapter<RecyclerFragmentAdapter.ViewHolder> {

    ArrayList<String> countRV = new ArrayList<>();



//    public RecyclerFragmentAdapter() {
//
//        countRV = new ArrayList<>();
//        Log.d("ololo", "RecyclerFragmentAdapter: "+countRV);
//    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_history, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(countRV.get(position));
    }

    @Override
    public int getItemCount() {
        return countRV.size();
    }
    public void addText(String t) {
        countRV.add(t);
        notifyDataSetChanged();
    }
//    public void addText2(String list ){
//        this.countRV=list;
//    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.item_textview);
        }

        public void bind(String s) {
            textView.setText(s);
        }
    }
}
