package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

   // public SellerActivity sellerActivity;
    public int queueNum,nowServiced;
    public static final int visible=View.VISIBLE;
    public static final int invisible=View.INVISIBLE;
    public static final int phoneNumLength=10;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final View click1 = findViewById(R.id.click1);
        final View click2 = findViewById(R.id.click2);
        final ListView medicinesListView = findViewById(R.id.medicines);
        final Button order = findViewById(R.id.order);
        final Button next = findViewById(R.id.next);
        final Button cancel = findViewById(R.id.cancel);
        final EditText searchMedicine = findViewById(R.id.searchMedicine);
        TextView priceView=findViewById(R.id.priceTextView);

//        final TextView timeToSchedule = findViewById(R.id.hourTimeOrder);//it's all final for the onClick methods
//        final TextView minutesTimeToSchedule = findViewById(R.id.minutesTimeOrder);
        final TextView phoneNum=findViewById(R.id.phoneNum);
        phoneNum.setVisibility(invisible);
        setTwoViewsVisible(phoneNum,cancel,invisible);
        setTwoViewsVisible(order,next,invisible);
        order.setEnabled(false);
        // timeToSchedule.setVisibility(View.INVISIBLE);
        queueNum=0;

        //doing'=' and not '+1' because it initialized null
//        final Calendar calendar = Calendar.getInstance();
//        phoneNum.setKeyboardNavigationCluster(true);
        final List<Medicine> medicinesList = new ArrayList<>();
        final List<Medicine> tempList = new ArrayList<>();//for searching
        addAndSort(medicinesList, new Medicine("paramol",13));
        addAndSort(medicinesList, new Medicine("dexamol",15));
        addAndSort(medicinesList, new Medicine("zovirex",15));
        addAndSort(medicinesList, new Medicine("optalgin",15));
        addAndSort(medicinesList, new Medicine("parafin",15));
        addAndSort(medicinesList, new Medicine("advil",15));
        addAndSort(medicinesList, new Medicine("sibosil",15));
        addAndSort(medicinesList, new Medicine("sinofed",15));
        addAndSort(medicinesList, new Medicine("clonex",15));
        addAndSort(medicinesList, new Medicine("paramol",15));
        addAndSort(medicinesList, new Medicine("dexamol",15));
        addAndSort(medicinesList, new Medicine("zovirex",15));
        addAndSort(medicinesList, new Medicine("hicomitsin",15));
        addAndSort(medicinesList, new Medicine("parafin",15));
        addAndSort(medicinesList, new Medicine("genotropad",15));
        addAndSort(medicinesList, new Medicine("ritalin",15));
        addAndSort(medicinesList, new Medicine("sinofed",21));
        addAndSort(medicinesList, new Medicine("cipralex",21));
        addAndSort(medicinesList, new Medicine("paramol",21));
        addAndSort(medicinesList, new Medicine("dexamol",21));
        addAndSort(medicinesList, new Medicine("zapata",21));
        addAndSort(medicinesList, new Medicine("optalgin",26));
        addAndSort(medicinesList, new Medicine("parafin",26));
        addAndSort(medicinesList, new Medicine("rescue",26));
        addAndSort(medicinesList, new Medicine("peramol",26));
        addAndSort(medicinesList, new Medicine("sinofed",26));
        addAndSort(medicinesList, new Medicine("cipralex",31));
        addAndSort(medicinesList, new Medicine("paramol",31));
        addAndSort(medicinesList, new Medicine("melron",31));
        addAndSort(medicinesList, new Medicine("zovirex",31));
        addAndSort(medicinesList, new Medicine("optalgin",31));
        addAndSort(medicinesList, new Medicine("parafin",31));
        addAndSort(medicinesList, new Medicine("stilla",31));
        addAndSort(medicinesList, new Medicine("peramol",31));
        addAndSort(medicinesList, new Medicine("sinofed",31));
        addAndSort(medicinesList, new Medicine("canabis",31));
        addAndSort(medicinesList, new Medicine("favoxil",34));
        addAndSort(medicinesList, new Medicine("dexamol",34));
        addAndSort(medicinesList, new Medicine("zovirex",34));
        addAndSort(medicinesList, new Medicine("optalgin",34));
        addAndSort(medicinesList, new Medicine("parafin",34));
        addAndSort(medicinesList, new Medicine("nusidex",34));
        addAndSort(medicinesList, new Medicine("peramol",34));
        addAndSort(medicinesList, new Medicine("sinofed",34));
        addAndSort(medicinesList, new Medicine("esto",34));
        addAndSort(medicinesList, new Medicine("paramol",34));
        addAndSort(medicinesList, new Medicine("dexamol cold",37));
        addAndSort(medicinesList, new Medicine("etopan",37));
        addAndSort(medicinesList, new Medicine("agispor",37));
        addAndSort(medicinesList, new Medicine("parafin",37));
        addAndSort(medicinesList, new Medicine("viagra",37));
        addAndSort(medicinesList, new Medicine("nurofen",37));
        addAndSort(medicinesList, new Medicine("histafed",37));
        addAndSort(medicinesList, new Medicine("cipralex",37));
        addAndSort(medicinesList, new Medicine("paramol",37));
        addAndSort(medicinesList, new Medicine("dexamol",37));
        addAndSort(medicinesList, new Medicine("zovirex",37));
        addAndSort(medicinesList, new Medicine("optalgin",39));
        addAndSort(medicinesList, new Medicine("parafin",39));
        addAndSort(medicinesList, new Medicine("alrin",39));
        addAndSort(medicinesList, new Medicine("peramol",39));
        addAndSort(medicinesList, new Medicine("sinofed",39));
        addAndSort(medicinesList, new Medicine("cipralex",39));
        addAndSort(medicinesList, new Medicine("paramol",39));
        addAndSort(medicinesList, new Medicine("dermaxol",39));
        addAndSort(medicinesList, new Medicine("zovirex",39));
        addAndSort(medicinesList, new Medicine("hidroagisten",41));
        addAndSort(medicinesList, new Medicine("parafin",41));
        addAndSort(medicinesList, new Medicine("acamol",41));
        addAndSort(medicinesList, new Medicine("aflumitsin",41));
        addAndSort(medicinesList, new Medicine("agisten",41));
        addAndSort(medicinesList, new Medicine("coldex",41));

        setTwoViewsVisible(searchMedicine,medicinesListView,invisible);
        ;//to be visible just after clicking//
        // its all final for be used in onclick methods

        final BuyerListAdapter listAdapter = new BuyerListAdapter(this, R.layout.checkboxstruct, medicinesList, order,priceView);
        medicinesListView.setAdapter(listAdapter);
        //sellerActivity=new SellerActivity(listAdapter.listedMedicines);
        searchMedicine.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                String input = searchMedicine.getText().toString();
                listTransfer(medicinesList, tempList, input, false);//transfer if the beggining NOT equals
                listTransfer(tempList, medicinesList, input, true);//if contains
                listAdapter.setData(medicinesList);
                medicinesListView.setAdapter(listAdapter);//readapt for displaying
            }
        });
        click1.setOnClickListener ( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTwoViewsVisible(click1,click2,invisible);
                setTwoViewsVisible(searchMedicine,medicinesListView,visible);
                setTwoViewsVisible(order,cancel,visible);
                setVisibilities(searchMedicine,medicinesListView,order,next);//METHOD TO AVOID REPEATED ROWS
            }
        });

        click2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setTwoViewsVisible(click1,click2,invisible);
                setTwoViewsVisible(next,phoneNum,visible);
                cancel.setVisibility(visible);
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (phoneNum.getText().toString().length() != phoneNumLength)
                    makeToast("invalid phone number");
                else {
                    setVisibilities(searchMedicine, medicinesListView, order, next);
                    phoneNum.setVisibility(invisible);
                    phoneNum.setText("");//reset
                }
            }//ANOTHER LISTENER BECAUSE WAS PROBLEMATIC TO DO IT TOGHTER WIT "listener"
        });
        //his last char are not 1}
        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                queueNum++;
              //  sellerActivity.queueNext();
                resetAll(click1, click2,  searchMedicine, medicinesListView
                        ,order, next, tempList, medicinesList, listAdapter,cancel, phoneNum);
                String pre;
                if (queueNum<10)
                    pre="00";
                else if (queueNum<100)
                    pre="0";
                else pre="";
                makeToast("your queue num is "+pre+queueNum);


            }
        });
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetAll(click1, click2,  searchMedicine, medicinesListView
                        ,order, next, tempList, medicinesList, listAdapter,cancel, phoneNum);
            }
        });
        //its all in onCreate because the objects
//
    }

    public void listTransfer(List<Medicine> arrayList1, List<Medicine> arrayList2, String input, boolean matches) {
        for (int i = 0; i < arrayList1.size(); i++) {
            if ((arrayList1.get(i).getName().substring(0, input.length()).equals(input)) == matches) {
                addAndSort(arrayList2, arrayList1.get(i));
                arrayList1.remove(i);
                i--;//index i removed, then the next came back, and after i++, it skip what became index i
            }
        }//to avoid repeated rows
    }

    public void addAndSort(List<Medicine> arrayList, Medicine medicine) {//alphanumeric sort after entering
        arrayList.add(medicine);
        for (int i = arrayList.indexOf(medicine); i > 0 && (arrayList.get(i).getName().compareTo(arrayList.get(i - 1).getName()) < 0); i--) {
            Collections.swap(arrayList, i, i - 1);//make sure it start from index 1, and stop when it previous is have to be previous
        }
    }
    public void makeToast(String message){
        Context context = getApplicationContext();
        int duration = Toast.LENGTH_SHORT;
        Toast toast = Toast.makeText(context, message, duration);
        toast.show();
    }
    public void setVisibilities(View view1, View view2, View view3, View view4){
        view1.setVisibility(visible);
        view2.setVisibility(visible);
        view3.setVisibility(visible);//thats wht it final
        view4.setVisibility(invisible);//for case of next button clicked
    }
    public void setTwoViewsVisible(View primeView1, View primeView2, int visible){//thats because there's several doubles of Views together
        primeView1.setVisibility(visible);
        primeView2.setVisibility(visible);
    }
    public void resetAll(View click1, View click2, EditText searchMedicine, View medicinesListView
            ,View order, View next, List tempList, List medicinesList, BuyerListAdapter listAdapter, Button cancel,TextView phoneNum){//to avoid repeated code rows
        setTwoViewsVisible(click1,click2,visible);
        setTwoViewsVisible(searchMedicine,medicinesListView,invisible);
        setTwoViewsVisible(order,next,invisible);//thats why it final
        //restart all
        listTransfer(tempList,medicinesList,searchMedicine.getText().toString(),false);//return all
        searchMedicine.setText("");
        listAdapter.unCheckAll();//after all came back from temp to prime list
        cancel.setVisibility(invisible);
        phoneNum.setVisibility(invisible);
        phoneNum.setText("");//for next user
        listAdapter.totalPriceView.setText("");//thats why its public
    }

//    public void goToSellerActivity(View view){
//        Intent intent=new Intent(this, sellerActivity.getClass());
//        startActivity(intent);
//
//    }

    //ArrayAdapter arrayAdapter =new ArrayAdapter(seller)
}

//                   SimpleDateFormat timeParser = new SimpleDateFormat("HH:mm", Locale.US);
//                    try {
//                        clTime1 = timeParser.parse(time1);
//                    } catch (ParseException e) {
//                    }

//what i thought to do with schedule time ordering:

//                    Calendar now = Calendar.getInstance();
//                    clTime1.setYear(now.get(Calendar.YEAR) - 1900);
//                    clTime1.setMonth(now.get(Calendar.MONTH));
//                    clTime1.setDate(now.get(Calendar.DAY_OF_MONTH));
//                    System.out.println(clTime1.toString());
//                    int scheduledHour,scheduledMinutes;
//                    Calendar today=Calendar.getInstance();
//                    Date scheduled=new Date();
//                    scheduledHour=Integer.parseInt(timeToSchedule.getText().toString());
//                    scheduledMinutes=Integer.parseInt(minutesTimeToSchedule.getText().toString());
//                    hour=calendar.get(Calendar.HOUR_OF_DAY);
//                    minutes=calendar.get(Calendar.MINUTE);
//                    scheduled.setHours(scheduledHour);
//                    scheduled.setMinutes(scheduledMinutes);
// if (clTime1.after(scheduled))

//                    timeToSchedule.setText(hour+":"+minutes);

//                    timeToSchedule.setVisibility(View.VISIBLE);
//                    minutesTimeToSchedule.setVisibility(View.VISIBLE);


//if (timeToSchedule.getText())

//

//        public void resetAll(){
//                setTwoViewsVisible(click1, click2, View.VISIBLE);
//        setTwoViewsVisible(searchMedicine, medicinesListView, View.INVISIBLE);
//        setTwoViewsVisible(order, next, View.INVISIBLE);//thats why it final
//        //restart all
//        listTransfer(tempList, medicinesList, searchMedicine.getText().toString(), false);//return all
//        searchMedicine.setText("");
//        listAdapter.unCheckAll();//after all came back from temp to prime list
//        }

//  sellerActivity.listedMedicines=listAdapter.listedMedicines;
//System.out.println(listAdapter.listedMedicines.get(queueNum-1).getName());
//                sellerActivity.addAndSet(listAdapter.listedMedicines);