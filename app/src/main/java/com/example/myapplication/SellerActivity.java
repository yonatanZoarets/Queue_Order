package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SellerActivity extends AppCompatActivity {

    public int ordererQueueNum;
    public List <Medicine> listedMedicines;

    //MainActivity mainActivity;//to keep on data
//
//    public SellerActivity(List<Medicine> listedMedicines){
//        this.ordererQueueNum=0;
//        this.listedMedicines=listedMedicines;
//    }


    //public
//    public SellerActivity(int queueNum){
//        this.ordererQueueNum =queueNum;
//       // medicinesNames=new ArrayList<>();
//    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        List<Medicine> listedMedicines=new ArrayList<>();
        ListView medicines= findViewById(R.id.tobring);
       // listedMedicines.add(new Medicine("first"));
        SellerListAdapter medicineListAdapter=new SellerListAdapter(this,R.layout.item_to_bring,listedMedicines);
        medicines.setAdapter(medicineListAdapter);

    }
    public void queueNext(){
        this.ordererQueueNum++;
    }
    public void addAndSet(List<Medicine> listedMedicines1,List<Medicine> listedMedicines2){
        listedMedicines1.addAll(listedMedicines2);
//       this.listedMedicines.add(listedMedicines.get(0));
//       medicineListAdapter.setData(this.listedMedicines);
//       medicines.setAdapter(medicineListAdapter);

    }
//    public void goToSellerActivity(){
//        Intent intent=new Intent(this, mainActivity.getClass());
//        startActivity(intent);
//    }

}
