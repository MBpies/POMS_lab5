package com.example.myfirstapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ListItemViewHolder>{
    private ArrayList<ListItemH> listThing = new ArrayList<ListItemH>();;
    ListAdapter(){
        listThing = new ArrayList<>();
    }

    public void initialize(ArrayList<ListItemH> list){
        this.listThing = list;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.list_item, viewGroup, false);
        return new ListItemViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder ItemViewHolder, int i) {
        ItemViewHolder.doThing(listThing.get(i));
    }

    @Override
    public int getItemCount() {
        return listThing.size();
    }
    class ListItemViewHolder extends RecyclerView.ViewHolder {

        private TextView text;

        ListItemViewHolder(View itemView) {
            super(itemView);
            text = itemView.findViewById(R.id.textVu);
        }
        void doThing(ListItemH historyItem) {
            text.setText(historyItem.asStringText());
        }
    }
}
