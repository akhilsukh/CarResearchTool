package com.akhilsukh01.carresearchtool;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        jsonToArray process = new jsonToArray();
        process.execute();

        setContentView(R.layout.activity_main);

        Spinner spinner_budgets = (Spinner) findViewById(R.id.spinner_budgets);
        Spinner spinner_manu = (Spinner) findViewById(R.id.spinner_manu);
        Spinner spinner_econ = (Spinner) findViewById(R.id.spinner_econ);
        Spinner spinner_seats = (Spinner) findViewById(R.id.spinner_seats);
        Spinner spinner_years = (Spinner) findViewById(R.id.spinner_years);
        Spinner spinner_type = (Spinner) findViewById(R.id.spinner_type);

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

    }
}
