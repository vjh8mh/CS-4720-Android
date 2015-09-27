package com.example.justin.maps;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Home_tab extends Fragment {
    View v;
    private TextView distanceTextView;
    private TextView caloriesTextView;
    private TextView unitTextView;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        v =inflater.inflate(R.layout.fragment_home,container,false);
        return v;
    }

    void setFragmentTest(Settings_info o){
        TextView txt=(TextView) v.findViewById(R.id.FragmentPassTest);
        txt.setText(o.toString());
    }
}

class home_info{

    int distance = 0;
    int calories_burned = 0;
    Unit unit;

    home_info(int d, int c, Unit u){
        this.distance = d;
        this.calories_burned = c;
        this.unit = u;
    }
}