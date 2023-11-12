package com.example.timewise;

import android.location.LocationListener;
import android.location.Location;
import android.os.Bundle;
public class Localizacao  implements LocationListener {
    public static Double Latitude;
    public static Double Longitude;

    public void onLocationChanged(Location location){
        this.Latitude = location.getLatitude();
        this.Longitude = location.getLongitude();
    }

}
