package com.akhilsukh01.carresearchtool;

import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class jsonToArray extends AsyncTask<Void, Void, Void> {

    String data = "";
    public static int counter = 0;

    public static ArrayList<String> array_manu = new ArrayList<>();
    public static ArrayList<String> array_make = new ArrayList<>();
    public static ArrayList<Integer> array_price = new ArrayList<>();
    public static ArrayList<Integer> array_econ = new ArrayList<>();
    public static ArrayList<Integer> array_seats = new ArrayList<>();
    public static ArrayList<Integer> array_year = new ArrayList<>();
    public static ArrayList<String> array_type = new ArrayList<>();

    @Override
    protected Void doInBackground(Void... voids) {

        array_manu.clear();
        array_make.clear();
        array_price.clear();
        array_econ.clear();
        array_seats.clear();
        array_year.clear();
        array_type.clear();

        try {
            //the link below is where the json file mentioned is hosted online
            URL url = new URL("https://raw.githubusercontent.com/akhilsukh01/CarResearchTool/master/data.json");
            //proprietary code for creating a copy of an online file
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null){
                line = bufferedReader.readLine();
                data = data + line;
            }
            
            //PARSING JSON
            //searching through the json file to reach the correct                                                                                                                     
            JSONObject root = new JSONObject(data);
            JSONArray car_object = root.getJSONArray("cars");
            
            //loop to go through each object in the json file and add each property to an indivisual array
            //car_object is an object in the json file and it has the value of the number of properties in it
            for (int i = 0; i < car_object.length(); i++) {
                JSONObject properties = car_object.getJSONObject(i);
                
                //temporarily saved the property to a string or int as shown below after the proprty is searched in quotes
                String getManu = properties.getString("Manufacturer");
                String getMake = properties.getString("Make");
                Integer getPrice = properties.getInt("Price");
                Integer getEcon = properties.getInt("Economy");
                Integer getSeats = properties.getInt("Seats");
                Integer getYear = properties.getInt("Year");
                String getType = properties.getString("Type");

                //the temporary variable is added to the indivisual arrays
                array_manu.add(getManu);
                array_make.add(getMake);
                array_price.add(getPrice);
                array_econ.add(getEcon);
                array_seats.add(getSeats);
                array_year.add(getYear);
                array_type.add(getType);

            }
        Log.i("DEBUG MANU", "jsonToArray: "+String.valueOf(array_make));
        //END OF PARSING

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);


    }


}
