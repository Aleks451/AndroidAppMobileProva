package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.ViewHolder> {

    public interface ItemCllicked{
        void onItemClicked(int index);
    }

    ItemCllicked activity;

    private ArrayList<Person> people;

    public PersonAdapter (Context context, ArrayList<Person> list){

        activity = (ItemCllicked) context;
        people = list;
    }

    //rapresent every item plased in the view, we need to define all members of liste's item
    //collega il modello di Person con layout item_list
    //A ViewHolder describes an item view and metadata about its place within the RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvName, tvSurname;
        ImageView ivPref;

        ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = itemView.findViewById(R.id.tvName);
            tvSurname = itemView.findViewById(R.id.tvSurname);
            ivPref = itemView.findViewById(R.id.ivPref);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.onItemClicked(people.indexOf(v.getTag()));
                }
            });
        }
    }

    //get a connection to a layout and returns a new ViewHolders object
    @NonNull
    @Override
    public PersonAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.layout_item, parent, false);

        return new ViewHolder(v);
    }

    //will run for the amount of items that we have in our list
    @Override
    public void onBindViewHolder(@NonNull PersonAdapter.ViewHolder holder, int position) {

        holder.itemView.setTag(people.get(position));
        holder.tvName.setText(people.get(position).getName());
        holder.tvSurname.setText(people.get(position).getSurname());

        if (people.get(position).getPref().equals("bus")){
            holder.ivPref.setImageResource(R.drawable.bus);
        }
        else{
            holder.ivPref.setImageResource(R.drawable.plane);
        }
    }

    @Override
    public int getItemCount() {
        return people.size();
    }
}