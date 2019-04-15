package com.akhilsukh01.carresearchtool;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends Activity {

    public static String prefManu;
    public static int prefBudget;
    public static int prefEcon;
    public static int prefSeats;
    public static int prefYear ;
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

                budgetAlgorithm(prefManu);

                Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                startActivity(intent);
            }
        });

    }

    public void budgetAlgorithm(String tempPrefManu){
        int arrayLength = jsonToArray.array_manu.size();
        for (int i = 0; i < arrayLength; i++){
            if (!tempPrefManu.equalsIgnoreCase(jsonToArray.array_manu.get(i))){
                jsonToArray.array_manu.remove(i);
                jsonToArray.array_price.remove(i);
                jsonToArray.array_econ.remove(i);
                jsonToArray.array_year.remove(i);
                jsonToArray.array_seats.remove(i);
                jsonToArray.array_type.remove(i);
            }
        }
        Log.i("DEBUG MANU", jsonToArray.array_manu.toString());
        return;
    }
}
