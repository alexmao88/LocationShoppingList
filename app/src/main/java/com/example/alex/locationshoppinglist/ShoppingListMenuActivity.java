package com.example.alex.locationshoppinglist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.common.api.Status;
import com.google.android.gms.location.places.GeoDataClient;
import com.google.android.gms.location.places.Place;
import com.google.android.gms.location.places.Places;
import com.google.android.gms.location.places.ui.PlaceAutocompleteFragment;
import com.google.android.gms.location.places.ui.PlaceSelectionListener;

public class ShoppingListMenuActivity extends AppCompatActivity implements PlaceSelectionListener, View.OnClickListener {

    protected GeoDataClient mGeoDataClient;
    private Button setListButton;
    private EditText listName;
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_list_menu);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        getActionBar().setTitle("New List");

        // Construct a PlaceDetectionClient.
        mGeoDataClient = Places.getGeoDataClient(this, null);

        PlaceAutocompleteFragment autocompleteFragment = (PlaceAutocompleteFragment)
                getFragmentManager().findFragmentById(R.id.place_autocomplete_fragment);

        autocompleteFragment.setOnPlaceSelectedListener(this);


        setListButton = (Button) findViewById(R.id.setListButton);
        listName = (EditText) findViewById(R.id.editText);
        location = "";

        setListButton.setOnClickListener(this);
    }

    @Override
    public void onPlaceSelected(Place place) {
        // TODO: Get info about the selected place.
        Log.i("", "Place: " + place.getName());
        location = place.getName().toString();
    }

    @Override
    public void onError(Status status) {
        // TODO: Handle the error.
        Log.i("", "An error occurred: " + status);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent();
        intent.putExtra("listName", listName.getText().toString());
        intent.putExtra("location", location);
        setResult(0, intent);
        finish();
    }
}
