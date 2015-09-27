package com.example.justin.maps;

/**
 * Created by Justin on 9/23/2015.
 */
public class Unit {
    public String Name;
    public String Discription;
    public int calories;
    public boolean isDiscrete;

    Unit(String N, String D, int C, boolean isD){
        this.Name = N;
        this.Discription = D;
        this.calories = C;
        this.isDiscrete = isD;
    }
}
