package Barista;

import java.util.ArrayList;

public class Order {
    private String name;
    private boolean ready;
    private ArrayList<Item> items;

    public Order(){
        this.name = "guest";
        this.items = new ArrayList<Item>();
    }

    public Order(String name){
        this.name = name;
        this.items = new ArrayList<Item>();
    }

    public void setName(String name){
        this.name = name;
    }

    public void setReady(boolean ready){
        this.ready = ready;
    }
    
    public void setItems(ArrayList<Item> items){
        this.items = items;
    }

    public String getName(){
        return this.name;
    }

    public boolean getReady(){
        return this.ready;
    }

    public ArrayList<Item> getItems(){
        return this.items;
    }

    public void addItem(Item item){
        this.items.add(item);
    }

    public String getStatusMessage(){
        if(this.ready)
            return "Your order is ready";
        else
            return "Thank you for waiting. Your order will be ready soon.";
    }

    public double getOrderTotal(){
        double total = 0;
        for(int i=0;i<this.items.size();i++){
            total += this.items.get(i).getPrice();
        }
        return total;
    }

    public void display(){
        System.out.println(this.name);
        double total = 0;
        for(int i=0;i<this.items.size();i++){
            System.out.printf("%s - %d",this.items.get(i).getName(),this.items.get(i).getPrice());
            total += this.items.get(i).getPrice();
        }
        System.out.println(total);
    }
}
