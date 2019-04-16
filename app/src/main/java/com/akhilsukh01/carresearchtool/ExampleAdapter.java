package com.akhilsukh01.carresearchtool;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private ArrayList<ExampleItem> mExampleList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{
        public TextView tManu;
        public TextView tMake;
        public TextView tPrice;
        public TextView tEcon;
        public TextView tSeats;
        public TextView tYear;
        public TextView tType;

        public ExampleViewHolder(View itemView, final OnItemClickListener listener) {
            super(itemView);
            tManu = itemView.findViewById(R.id.textviewManu);
            tMake = itemView.findViewById(R.id.textviewMake);
            tPrice = itemView.findViewById(R.id.textviewPrice);
            tEcon = itemView.findViewById(R.id.textviewEcon);
            tSeats = itemView.findViewById(R.id.textviewSeats);
            tYear = itemView.findViewById(R.id.textviewYear);
            tType = itemView.findViewById(R.id.textviewType);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            listener.onItemClick(position);
                        }
                    }
                }
            });

        }
    }

    public ExampleAdapter(ArrayList<ExampleItem> exampleList){
        mExampleList = exampleList;

    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v, mListener);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
        ExampleItem currentItem = mExampleList.get(position);

        holder.tManu.setText(currentItem.getmManu());
        holder.tMake.setText(currentItem.getmMake());
        holder.tYear.setText(String.valueOf(currentItem.getmYear()));
        holder.tPrice.setText(String.valueOf(currentItem.getmPrice()));
        holder.tEcon.setText(String.valueOf(currentItem.getmEcon()));
        holder.tSeats.setText(String.valueOf(currentItem.getmSeats()));
        holder.tType.setText(currentItem.getmType());
    }

    @Override
    public int getItemCount() {
        return (mExampleList.size());
    }
}
