package com.example.justin.maps;

/**
 * Created by Justin on 9/23/2015.
 */
public class Weight {
    double kg;
    double pounds;
    boolean isMetric;

    Weight(double someWeight, boolean isM) {
        if (isM == true){
            this.kg = someWeight;
            MetricToImperial(someWeight);
        } else {
            this.pounds = someWeight;
            ImperialToMetric(someWeight);
        }
    }

    public double MetricToImperial(double kg){
        this.pounds = kg * 2.20462;
        return this.pounds;
    }

    public double ImperialToMetric(double p) {
        this.kg = p * 0.453592;
        return this.kg;
    }
}
