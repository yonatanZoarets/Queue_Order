package com.example.myapplication;

public class Medicine {
    private String name;
   // private boolean preciptionRequired;
    public int amount;
    public float price;
    private boolean selected;
    public int indexOnAmountSpinner;
    public Medicine(String name, float price)
    {
        this.name=name;
        this.selected=false;
        this.amount=1;
        this.indexOnAmountSpinner =0;
        this.price=price;
    }
    public void setSelected(){
        this.selected=(!this.selected);//do the opposite
    }
    public boolean getSlected(){
        return this.selected;
    }
    public String getName(){ return this.name; }
    public int getAmount(){ return this.amount; }

}
