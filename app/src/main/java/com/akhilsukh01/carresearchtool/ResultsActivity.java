package com.akhilsukh01.carresearchtool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;

import java.util.ArrayList;

public class ResultsActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    ArrayList<ExampleItem> exampleList = new ArrayList<>();
    int n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ImageView sorry_message = findViewById(R.id.sorry_message);
        mRecyclerView = findViewById(R.id.recycler_View);
        ScrollView scrolly = findViewById(R.id.scrollLayout);

        exampleList.clear();
        final int counter = jsonToArray.array_manu.size();
        if (counter == 0){
            sorry_message.setVisibility(View.VISIBLE);
            mRecyclerView.setVisibility(View.GONE);
            scrolly.setVisibility(View.GONE);
        }
        else {
            for (n = 0; n < counter; n++) {
                exampleList.add(new ExampleItem(jsonToArray.array_manu.get(n), jsonToArray.array_make.get(n), jsonToArray.array_year.get(n), jsonToArray.array_price.get(n), jsonToArray.array_econ.get(n), jsonToArray.array_seats.get(n), jsonToArray.array_type.get(n)));
            }
            mRecyclerView.setHasFixedSize(true);
            mLayoutManager = new LinearLayoutManager(this);
            mAdapter = new ExampleAdapter(exampleList);
            mRecyclerView.setLayoutManager(mLayoutManager);
            mRecyclerView.setAdapter(mAdapter);
        }


        Log.i("DEBUG MANU", "ResultsActivity has run");


    }

    @Override
    public void onBackPressed() {
        jsonToArray process = new jsonToArray();
        process.execute();

        super.onBackPressed();
    }
}
