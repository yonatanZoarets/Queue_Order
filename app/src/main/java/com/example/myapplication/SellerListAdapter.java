package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class SellerListAdapter extends BuyerListAdapter {//that for avoid repeat on method writing
    public SellerListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
    }
    @NonNull
    @Override
    public View getView(int Position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        convertView = inflater.inflate(this.layoutId, parent, false);
        Medicine currentMedicine= data.get(Position);//also
        TextView itemText= convertView.findViewById(R.id.itemText);
        itemText.setText(currentMedicine.getName());
        itemText.setTextSize(25);
        TextView itemAmount=convertView.findViewById(R.id.amount);
        itemAmount.setText(""+currentMedicine.getAmount());//without ""+ it didn't work
        TextView itemOrderer=convertView.findViewById(R.id.ordererNum);
//        itemOrderer.setText(currentMedicine.);


        return convertView;
    }
    //public void setData(List<Medicine> list){
    //        this.data=list;}

}
