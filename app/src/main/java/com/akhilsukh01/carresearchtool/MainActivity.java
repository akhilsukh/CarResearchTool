package com.akhilsukh01.carresearchtool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;

public class MainActivity extends Activity {

    public static String prefManu;
    public static int prefBudget;
    public static int prefEcon;
    public static int prefSeats;
    public static int prefYear;
    public static int prefType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        jsonToArray process = new jsonToArray();
        process.execute();

        setContentView(R.layout.activity_main);

        final Spinner spinner_budgets = (Spinner) findViewById(R.id.spinner_budgets);
        final Spinner spinner_manu = (Spinner) findViewById(R.id.spinner_manu);
        final Spinner spinner_econ = (Spinner) findViewById(R.id.spinner_econ);
        final Spinner spinner_seats = (Spinner) findViewById(R.id.spinner_seats);
        final Spinner spinner_years = (Spinner) findViewById(R.id.spinner_years);
        final Spinner spinner_type = (Spinner) findViewById(R.id.spinner_type);

        Button continueButton = (Button) findViewById(R.id.continueButton);

        ArrayAdapter<CharSequence> adapter_budgets = ArrayAdapter.createFromResource(this, R.array.budgets, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_manu = ArrayAdapter.createFromResource(this, R.array.manufacturers, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_econ = ArrayAdapter.createFromResource(this, R.array.economy, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_seats = ArrayAdapter.createFromResource(this, R.array.seats, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_years = ArrayAdapter.createFromResource(this, R.array.years, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_type = ArrayAdapter.createFromResource(this, R.array.type, android.R.layout.simple_spinner_item);

        adapter_budgets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_manu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_econ.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_seats.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_years.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_type.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_budgets.setAdapter(adapter_budgets);
        spinner_manu.setAdapter(adapter_manu);
        spinner_econ.setAdapter(adapter_econ);
        spinner_seats.setAdapter(adapter_seats);
        spinner_years.setAdapter(adapter_years);
        spinner_type.setAdapter(adapter_type);


        continueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                prefManu = spinner_manu.getSelectedItem().toString();
                prefBudget = spinner_budgets.getSelectedItemPosition();
                prefEcon = spinner_econ.getSelectedItemPosition();
                prefSeats = spinner_seats.getSelectedItemPosition();
                prefYear = spinner_years.getSelectedItemPosition();
                prefType = spinner_type.getSelectedItemPosition();

                manuAlgorithm(prefManu);
                priceAlgorithm(prefBudget);

                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void manuAlgorithm(String tempPrefManu) {
        int arrayLength = jsonToArray.array_manu.size();

        for (int i = 0; i < arrayLength; i++) {
            if (!tempPrefManu.equals(jsonToArray.array_manu.get(i))) {
                jsonToArray.array_manu.set(i, null);
                jsonToArray.array_price.set(i, null);
                jsonToArray.array_econ.set(i, null);
                jsonToArray.array_year.set(i, null);
                jsonToArray.array_seats.set(i, null);
                jsonToArray.array_type.set(i, null);
            }
        }
        while(jsonToArray.array_price.remove(null));
        while(jsonToArray.array_manu.remove(null));
        while(jsonToArray.array_econ.remove(null));
        while(jsonToArray.array_year.remove(null));
        while(jsonToArray.array_seats.remove(null));
        while(jsonToArray.array_type.remove(null));
//        Log.i("DEBUG MANU", String.valueOf(arrayLength));
//        Log.i("DEBUG MANU", "MainActivity: " + jsonToArray.array_manu.toString())
    }

    public void priceAlgorithm(int tempPrefPrice) {
        int arrayLength1 = jsonToArray.array_manu.size();
        int min = 0;
        int max=0;

        switch (tempPrefPrice)
        {
            case 0:
                min=5000;
                max=20000;
                Log.i("DEBUG MANU", "MainActivity: 000-" + jsonToArray.array_manu.toString());
                break;
            case 1:
                min=20000;
                max=35000;
                Log.i("DEBUG MANU", "MainActivity: 111-" + jsonToArray.array_manu.toString());
                break;
            case 2:
                min=35000;
                max=50000;
                Log.i("DEBUG MANU", "MainActivity: 222-" + jsonToArray.array_manu.toString());
                break;
            case 3:
                min=50000;
                max=65000;
                Log.i("DEBUG MANU", "MainActivity: 333-" + jsonToArray.array_manu.toString());
                break;
            case 4:
                min=65000;
                max=80000;
                Log.i("DEBUG MANU", "MainActivity: 444-" + jsonToArray.array_manu.toString());
                break;
            case 5:
                min=80000;
                max=999999;
                Log.i("DEBUG MANU", "MainActivity: 555-" + jsonToArray.array_manu.toString());
                break;
        }
        for (int i = 0; i < arrayLength1; i++) {
            if (!(jsonToArray.array_price.get(i) > min) && !(jsonToArray.array_price.get(i) < max)) {
                jsonToArray.array_manu.set(i, null);
                jsonToArray.array_price.set(i, null);
                jsonToArray.array_econ.set(i, null);
                jsonToArray.array_year.set(i, null);
                jsonToArray.array_seats.set(i, null);
                jsonToArray.array_type.set(i, null);
            }
        }
        while(jsonToArray.array_price.remove(null));
        while(jsonToArray.array_manu.remove(null));
        while(jsonToArray.array_econ.remove(null));
        while(jsonToArray.array_year.remove(null));
        while(jsonToArray.array_seats.remove(null));
        while(jsonToArray.array_type.remove(null));

//        Log.i("DEBUG MANU", String.valueOf(arrayLength));
        Log.i("DEBUG MANU", "MainActivity: Manu-" + jsonToArray.array_manu.toString());
        Log.i("DEBUG MANU", "MainActivity: Make-" + jsonToArray.array_make.toString());
        Log.i("DEBUG MANU", "MainActivity: Price-" + jsonToArray.array_price.toString());

    }
}
