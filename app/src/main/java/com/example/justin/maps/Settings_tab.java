package com.example.justin.maps;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by hp1 on 21-01-2015.
 */
public class Settings_tab extends Fragment {

    private EditText heightFTEdit;
    private EditText heightInEdit;
    private EditText weightEdit;
    private Button submitButton;
    DataPassListener pass;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            pass = (DataPassListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement onButtonPressed");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.fragment_settings,container,false);

        heightFTEdit = (EditText) v.findViewById(R.id.settings_heightInfo_FT);
        heightInEdit = (EditText) v.findViewById(R.id.settings_heightInfo_INCHES);
        weightEdit = (EditText) v.findViewById(R.id.settings_weightInfo);
        submitButton = (Button) v.findViewById(R.id.settings_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Height h = new Height(Integer.parseInt(heightFTEdit.getText().toString()), Integer.parseInt(heightInEdit.getText().toString()));
                Weight w = new Weight((double) Integer.parseInt(weightEdit.getText().toString()), false);
                Settings_info s = new Settings_info(w, h);
                System.out.println("YOU HAVE MADE IT THIS FAR-------------------------");
                heightFTEdit.setText(Integer.toString(s.height.feet), TextView.BufferType.EDITABLE);
                heightInEdit.setText(Integer.toString(s.height.inches), TextView.BufferType.EDITABLE);
                weightEdit.setText(Integer.toString((int) s.weight.pounds), TextView.BufferType.EDITABLE);
                System.out.println(s.toString());
                pass.passData(s);
                Log.i("Web", "button pressed");
            }
        });

        return v;
    }
}