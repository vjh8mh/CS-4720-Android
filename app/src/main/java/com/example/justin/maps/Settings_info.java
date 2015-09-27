package com.example.justin.maps;

import java.io.Serializable;

/**
 * Created by Justin on 9/23/2015.
 */
public class Settings_info {
    Weight weight;
    Height height;
    Unit unit;

    Settings_info(Weight w, Height h){
        this.weight = w;
        this.height = h;
    }

    Settings_info(Weight w, Height h, Unit u){
        this.weight = w;
        this.height = h;
        this.unit = u;
    }

    public String toString(){
        String temp = "";
        temp = temp + "your Weight is: " + this.weight.pounds + "\n";
        if (this.height.isMetric == false){
            temp = temp + "your height is " + this.height.feet + " ft and " + this.height.inches + "inches\n";
        }
        return temp;
    }
}
