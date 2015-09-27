package com.example.justin.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.location.Location;
import java.util.ArrayList;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.CameraUpdateFactory;
/*
    This submission has nothing to do with our actual app.  It was just a test to get used to Android.
    It includes very basic requirements of hte first submission, namely a single activity, google maps,
    as well as a place where you can submit information.

    The app consists of a triple section vertical layout.  The top one consists of a place where you
    can input things and submit it.

    The middle section will display the information added from the first part.

    THe last section is only there to show functionaility of google maps API, but displayed current
    location.

    Justin Hsu, Victoria Hlusko
*/

public class MapsActivity extends FragmentActivity {

    private static String listToString(ArrayList<Info> list){
        String temp = "";
        for (Info i:list) {
            temp = temp + i.toString();
        }
        return temp;
    }

    private GoogleMap mMap; // Might be null if Google Play services APK is not available.
    private Button Submit;
    private EditText Name;
    private EditText Information;
    private TextView Recent_Display;
    private ArrayList<Info> list = new ArrayList<Info>();
    String temp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        setUpUpperPane();
        setUpMapIfNeeded();

        Submit = (Button) findViewById(R.id.Location_Submit);
        Name = (EditText) findViewById(R.id.Location_Name);
        Information = (EditText) findViewById(R.id.Location_Info);
        Recent_Display = (TextView) findViewById(R.id.textView1);

        Submit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Info tInfo = new Info(Name.getText().toString(), Information.getText().toString());
                list.add(0, tInfo);
                Recent_Display.setText(listToString(list));
                Log.i("Web", "button pressed");
                Log.i("Web", Information.getText().toString());
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
        setUpUpperPane();
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map))
                    .getMap();
            // Check if we were successful in obtaining the map.
            if (mMap != null) {
                setUpMap();
            }
        }
    }

    private void setUpUpperPane() {

    }
    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {

        // Code that sets up the GPS to default and track current location of user;
        // Source: http://stackoverflow.com/questions/13756261/how-to-get-the-current-location-in-google-maps-android-api-v2
        mMap.setMyLocationEnabled(true);
        GoogleMap.OnMyLocationChangeListener myLocationChangeListener = new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                LatLng loc = new LatLng(location.getLatitude(), location.getLongitude());
                mMap.addMarker(new MarkerOptions().position(loc));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(loc, 21.0f));
            }
        };
        mMap.setOnMyLocationChangeListener(myLocationChangeListener);
    }

}

// A class just to store infomation.  Not going to be in final version

class Info {

    String Name;
    String Description;

    Info(String N, String D) {
        this.Name = N;
        this.Description = D;
    }

    public String toString() {
        String temp = "\nLocation Name: " + Name + "\nLocation Info: " + Description + "\n";
        return temp;
    }
}