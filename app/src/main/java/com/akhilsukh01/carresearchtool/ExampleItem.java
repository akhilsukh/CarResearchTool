package com.akhilsukh01.carresearchtool;

public class ExampleItem {
    private String mManu;
    private String mMake;
    private int mYear;
    private int mPrice;
    private int mEcon;
    private int mSeats;
    private String mType;

    public ExampleItem(String manu, String make, int year, int price, int econ, int seats, String type){
        mManu = manu;
        mMake = make;
        mYear = year;
        mPrice = price;
        mEcon = econ;
        mSeats = seats;
        mType = type;
    }

    public String getmManu(){
        return mManu;
    }
    public String getmMake(){
        return mMake;
    }
    public int getmYear(){
        return mYear;
    }
    public int getmPrice(){
        return mPrice;
    }
    public int getmEcon(){
        return mEcon;
    }
    public int getmSeats(){
        return mSeats;
    }
    public String getmType(){
        return mType;
    }


}
