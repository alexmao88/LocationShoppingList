package com.example.alex.locationshoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private HashMap<ShoppingList, ArrayList<Item>> lists = new HashMap<>();

    private RecyclerView recyclerView;
    private ShoppingListAdapter adapter;
    private List<ShoppingList> keyList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getActionBar().setTitle("Shopping Lists");

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(view.getContext(), ShoppingListMenuActivity.class);
                startActivityForResult(i, 0);
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        keyList = new ArrayList<>();
        adapter = new ShoppingListAdapter(keyList);

        RecyclerView.LayoutManager listLayoutManager = new
                LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(listLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 0) {

            Log.d("result", "works");

            String location = data.getStringExtra("location");
            String name = data.getStringExtra("listName");

            if(location.isEmpty()) {
                ShoppingList shoppingList = new ShoppingList(name);

                lists.put(shoppingList, new ArrayList<Item>());
                keyList.add(shoppingList);
            }

            else {
                ShoppingList shoppingList = new ShoppingList(name, location);

                lists.put(shoppingList, new ArrayList<Item>());
                keyList.add(shoppingList);
            }

//            keyList.addAll(lists.keySet());
            adapter.notifyDataSetChanged();
        }
    }
}
