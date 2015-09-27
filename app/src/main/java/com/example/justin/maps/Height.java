package com.example.justin.maps;

/**
 * Created by Justin on 9/23/2015.
 */

public class Height {
    int feet;
    int inches;
    int centimetres;
    boolean isMetric = false;

    Height(int f, int i){
        this.feet = f;
        this.inches = i;
        convertImperialToMetric(f, i);
    }

    Height(int c) {
        this.centimetres = c;
        convertMetricToImperial(c);
    }

    public void convertMetricToImperial(int metric){
        double temp = metric * 0.393701;
        this.feet = (int) temp / 12;
        this.inches = (int) temp % 12;
    }

    public void convertImperialToMetric(int f, int i) {
        double temp = f * 12 + i;
        this.centimetres = (int) (temp * 2.54);
    }
}
