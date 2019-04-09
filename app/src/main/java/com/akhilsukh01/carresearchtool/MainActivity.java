package com.akhilsukh01.carresearchtool;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner_budgets = (Spinner) findViewById(R.id.spinner_budgets);
        Spinner spinner_manu = (Spinner) findViewById(R.id.spinner_manu);

        ArrayAdapter<CharSequence> adapter_budgets = ArrayAdapter.createFromResource(this, R.array.budgets, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter_manu = ArrayAdapter.createFromResource(this, R.array.manufacturers, android.R.layout.simple_spinner_item);

        adapter_budgets.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adapter_manu.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner_budgets.setAdapter(adapter_budgets);
        spinner_manu.setAdapter(adapter_manu);

    }
}
