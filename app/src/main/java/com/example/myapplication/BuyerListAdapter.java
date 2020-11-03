package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class BuyerListAdapter extends ArrayAdapter {
    public List<Medicine> data,listedMedicines;
    public int layoutId;
    public Context activity;
    private int flags;
    private Button button;
    public TextView totalPriceView;
   // private float totalCost;


    public BuyerListAdapter(@NonNull Context context, int resource, @NonNull List objects, Button button,TextView totalPriceView) {
        super(context, resource, objects);
        this.layoutId=resource;
        this.activity=context;
        this.data=objects;
        this.flags=0;
        this.button=button;
        this.totalPriceView =totalPriceView;
        this.listedMedicines=new ArrayList<>();
       // this.totalCost=0;
    }
    public BuyerListAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.layoutId=resource;
        this.activity=context;
        this.data=objects;
    }

    @Override
    public View getView(final int mPosition, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(this.activity);
        convertView = inflater.inflate(this.layoutId, parent, false);
        final CheckBox listedMedicine= convertView.findViewById(R.id.medicines);//need to use in external methods
        final Spinner amount=convertView.findViewById(R.id.amountSpinner);//final for onckeck method
        amount.setEnabled(false);
        final Medicine currentMedicine= data.get(mPosition);//also
        //final float specificCost=listedMedicines.get(listedMedicines.indexOf(currentMedicine)).amount*currentMedicine.price;
        //1*price

//        final int position;
        listedMedicine.setChecked(currentMedicine.getSlected());//thats if coming back after going down
        listedMedicine.setText(currentMedicine.getName());

        listedMedicine.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                amount.setEnabled(listedMedicine.isChecked());//for the moment of clicking
                currentMedicine.setSelected();
                if (listedMedicine.isChecked()) {
                    listedMedicines.add(currentMedicine);
                    flags++;
                } else {
                    listedMedicines.remove(listedMedicines.indexOf(currentMedicine));
                    flags--;
                   // totalCost-=specificCost;//if unselected//
                }//tried to do listedMedicine.isChecked()?flags++:flags--; for one row
                button.setEnabled(flags>0);//if flags>0 set enable to true, otherwise, to false
                calculateDisplayPrice();
            }

        });
        //button.setEnabled(flags>0);//for coming back after
        amount.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (currentMedicine.getSlected()) {//only if selected
                    int amount = Integer.parseInt(parent.getSelectedItem().toString());
                    currentMedicine.indexOnAmountSpinner = position;//keep on position of user choise
                    listedMedicines.get(listedMedicines.indexOf(currentMedicine)).amount = amount;
                    calculateDisplayPrice();//necessary here, not before

                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        amount.setEnabled(listedMedicine.isChecked()||currentMedicine.getSlected());//if coming back after going down
        amount.setSelection(currentMedicine.indexOnAmountSpinner);

        return convertView;
    }
    public void setData(List<Medicine> list){
        this.data=list;
    }
    //public void getChecked (){}
    public void calculateDisplayPrice(){
        float totalPrice=0;
        for (int i=0;i<listedMedicines.size();i++)
            totalPrice+=listedMedicines.get(i).price*listedMedicines.get(i).amount;
        totalPriceView.setText(totalPrice+"");
    }
    public void unCheckAll(){//used after medicines ordered
        for (int i=0;i<data.size();i++){
            if (data.get(i).getSlected())
                data.get(i).setSelected();//return to start
            data.get(i).indexOnAmountSpinner=0;
        }
        flags=0;//to reset
        button.setEnabled(false);//also
        listedMedicines.clear();
    }
 //   public List listedMedicine(){return this.listedMedicines;}

}
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                System.out.println("something");
//            }
//        });


//    public void alphaNumericMerge(List<Medicine> list){
//        Medicine temp=new Medicine("");
//
//        for (int i=0;i<list.size();i++){
//
//
//        }
//    }

//    public Adapter(@NonNull Context context, int resource, int textViewResourceId, @NonNull List objects) {
//        super(context, resource, textViewResourceId, objects);
//    }