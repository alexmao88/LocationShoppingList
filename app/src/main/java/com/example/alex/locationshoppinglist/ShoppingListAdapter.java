package com.example.alex.locationshoppinglist;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Alex on 8/25/17.
 */

public class ShoppingListAdapter extends RecyclerView.Adapter<ShoppingListAdapter.MyViewHolder> {

    private List<ShoppingList> shoppingLists;

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView listName, location;

        public MyViewHolder(View view) {
            super(view);
            listName = (TextView) view.findViewById(R.id.listName);
            location = (TextView) view.findViewById(R.id.location);
        }

        @Override
        public void onClick(View view) {

        }
    }

    public ShoppingListAdapter(List<ShoppingList> lists) {
        shoppingLists = lists;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R
                .layout.shopping_list_row, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        ShoppingList shoppingList = shoppingLists.get(position);
        holder.listName.setText(shoppingList.getName());
        holder.location.setText(shoppingList.getLocation());
    }

    @Override
    public int getItemCount() {

        Log.d("list size", String.valueOf(shoppingLists.size()));
        return shoppingLists.size();
    }
}
