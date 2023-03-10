//package com.example.proj;
//
//
//import android.Manifest;
//import android.app.Activity;
//import android.app.AlertDialog;
//import android.app.Service;
//import android.content.Context;
//import android.content.DialogInterface;
//import android.content.Intent;
//import android.content.pm.PackageManager;
//import android.location.Location;
//import android.location.LocationListener;
//import android.location.LocationManager;
//import android.os.Build;
//import android.os.Bundle;
//import android.os.IBinder;
//import android.provider.Settings;
//
//import androidx.annotation.RequiresApi;
//
///**
// * Created by tulsi on 4/7/2018.
// */
//public class gpstrack extends Service implements LocationListener {
//
//    private final Context mContext;
//
//    // flag for GPS status
//    boolean isGPSEnabled = false;
//    // flag for GPS status
//    boolean canGetLocation = false;
//    Location location; // location
//    double latitude; // latitude
//    double longitude; // longitude
//
//    // The minimum distance to change Updates in meters
//    private static final long MIN_DISTANCE_CHANGE_FOR_UPDATES = 10; // 10 meters
//
//    // The minimum time between updates in milliseconds
//    private static final long MIN_TIME_BW_UPDATES = 1000 * 60 * 1; // 1 minute
//
//    // Declaring a Location Manager
//    protected LocationManager locationManager;
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public gpstrack(Context context) {
//        this.mContext = context;
//        getLocation();
//    }
//
//    @RequiresApi(api = Build.VERSION_CODES.M)
//    public Location getLocation() {
//        try {
//            locationManager = (LocationManager) mContext
//                    .getSystemService(LOCATION_SERVICE);
//            // getting GPS status
//            isGPSEnabled = locationManager
//                    .isProviderEnabled(LocationManager.GPS_PROVIDER);
//
//            // if GPS Enabled get lat/long using GPS Services
//            if (isGPSEnabled) {
//                this.canGetLocation = true;
//                if (location == null) {
//                    if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                         //TODO: Consider calling
//                        //Activity#requestPermissions
//                        // here to request the missing permissions, and then overriding
////                           public void onRequestPermissionsResult(int requestCode, String[] permissions,
////                                                                  int[] grantResults);
//                        // to handle the case where the user grants the permission. See the documentation
//                        // for Activity#requestPermissions for more details.
////                        return TODO;
//                    }
//                    locationManager.requestLocationUpdates(
//                            LocationManager.GPS_PROVIDER, MIN_TIME_BW_UPDATES,
//                            MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
//                    if (locationManager != null) {
//                        location = locationManager
//                                .getLastKnownLocation(LocationManager.GPS_PROVIDER);
//                        if (location != null) {
//                            latitude = location.getLatitude();
//                            longitude = location.getLongitude();
//                        }
//                    }
//                }
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return location;
//    }
//
//    /**
//     * Stop using GPS listener Calling this function will stop using GPS in your
//     * app
//     * */
//    public void stopUsingGPS() {
//        if (locationManager != null) {
//            locationManager.removeUpdates(gpstrack.this);
//        }
//    }
//
//    /**
//     * Function to get latitude
//     * */
//    public double getLatitude() {
//        if (location != null) {
//            latitude = location.getLatitude();
//        }
//
//        // return latitude
//        return latitude;
//    }
//
//    /**
//     * Function to get longitude
//     * */
//    public double getLongitude() {
//        if (location != null) {
//            longitude = location.getLongitude();
//        }
//
//        // return longitude
//        return longitude;
//    }
//
//    /**
//     * Function to check GPS/wifi enabled
//     *
//     * @return boolean
//     * */
//    public boolean canGetLocation() {
//        return this.canGetLocation;
//    }
//
//    /**
//     * Function to show settings alert dialog On pressing Settings button will
//     * lauch Settings Options
//     * */
//    public void showSettingsAlert() {
//        AlertDialog.Builder alertDialog = new AlertDialog.Builder(mContext);
//
//        // Setting Dialog Title
//        alertDialog.setTitle("GPS is settings");
//
//        // Setting Dialog Message
//        alertDialog
//                .setMessage("GPS is not enabled. Do you want to go to settings menu?");
//
//        // On pressing Settings button
//        alertDialog.setPositiveButton("Settings",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        Intent intent = new Intent(
//                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
//                        mContext.startActivity(intent);
//                    }
//                });
//
//        // on pressing cancel button
//        alertDialog.setNegativeButton("Cancel",
//                new DialogInterface.OnClickListener() {
//                    public void onClick(DialogInterface dialog, int which) {
//                        dialog.cancel();
//                    }
//                });
//
//        // Showing Alert Message
//        alertDialog.show();
//    }
//
//    @Override
//    public void onLocationChanged(Location arg0) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onProviderDisabled(String arg0) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onProviderEnabled(String arg0) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
//        // TODO Auto-generated method stub
//
//    }
//
//    @Override
//    public IBinder onBind(Intent arg0) {
//        // TODO Auto-generated method stub
//        return null;
//    }
//
//}
////import androidx.appcompat.app.AppCompatActivity;
////
////import android.os.Bundle;
////
////public class gpstrack extends AppCompatActivity {
////
////    @Override
////    protected void onCreate(Bundle savedInstanceState) {
////        super.onCreate(savedInstanceState);
////        setContentView(R.layout.activity_gpstrack);
////    }
////}
