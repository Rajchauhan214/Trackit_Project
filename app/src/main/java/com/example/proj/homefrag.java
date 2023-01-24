package com.example.proj;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class homefrag extends Fragment {
    Button see_all;
@Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.activity_home2, container, false);


    Button set = (Button) view.findViewById(R.id.seeall);

    set.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            Intent intent = new Intent(getActivity(), trackit_seall_parent.class);
            startActivity(intent);
            // First go to container class-Activity

        }
    });
    return view;
}

}
//        int image[] = {R.drawable.nav_menu_header_bg, R.drawable.images3, R.drawable.compass1};
//        v_flipper = findViewById(R.id.v_flipper);
//
//
//        for (int image : images) {
//            flipperImages(images);
//        }
//
//    }
//
//
//    private ViewFlipper findViewById(int flipper) {
//    }
//
//    public void flipperImages(int image){
//        findViewById(R.id.parent_registerp).setOnClickListener(this);
////        ImageView imageView = new ImageView (this);
//        imageView.setBackgroundResource(image);
//
//        v_flipper.addView(imageView);
//        v_flipper.setFlipInterval(4000);
//        v_flipper.setAutoStart(true);
//
//
//        v_flipper.setInAnimation(this, android.R.anim.slide_in_left);
//        v_flipper.setInAnimation(this, android.R.anim.slide_out_right);
//    }
//

//        permissions.add(ACCESS_FINE_LOCATION);
//        permissions.add(ACCESS_COARSE_LOCATION);
//        btn = btn.findViewById(R.id.btn);
//        permissionsToRequest = findUnAskedPermissions(permissions);
//        //get the permissions we have asked for before but are not granted..
//        //we will store this in a global list to access later.
//
//
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//
//
//            if (permissionsToRequest.size() > 0)
//                requestPermissions(permissionsToRequest.toArray(new String[permissionsToRequest.size()]), ALL_PERMISSIONS_RESULT);
//        }
//
//
//
//
//
//        btn.setOnClickListener(new View.OnClickListener() {
//            @SuppressLint("RestrictedApi")
//            @Override
//            public void onClick(View view) {
//
//                locationTrack = new LocationTrack(homefrag.this);
//
//
//                if (locationTrack.canGetLocation()) {
//
//
//                    double longitude = locationTrack.getLongitude();
//                    double latitude = locationTrack.getLatitude();
//
//                    Toast.makeText(getApplicationContext(), "Longitude:" + Double.toString(longitude) + "\nLatitude:" + Double.toString(latitude), Toast.LENGTH_SHORT).show();
//                } else {
//
//                    locationTrack.showSettingsAlert();
//                }
//
//            }
//        });
//
//    }
//
//    private ArrayList<String> findUnAskedPermissions(ArrayList<String> wanted) {
//        ArrayList<String> result = new ArrayList<String>();
//
////        for (String perm : wanted) {
////            if (!hasPermission(perm)) {
////                result.add(perm);
////            }
////        }
//
//        return result;
//    }
////    private boolean hasPermission(String permission) {
////        if (canMakeSmores()) {
////            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
////                return (checkSelfPermission(permission) == PackageManager.PERMISSION_GRANTED);
////            }
////        }
////        return true;
////    }
//
//    private boolean canMakeSmores() {
//        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
//    }
//
//
//    @TargetApi(Build.VERSION_CODES.M)
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//
//        switch (requestCode) {
//
//            case ALL_PERMISSIONS_RESULT:
//                for (String perms : permissionsToRequest) {
////                    if (!hasPermission(perms)) {
////                        permissionsRejected.add(perms);
////                    }
//                }
//
//                if (permissionsRejected.size() > 0) {
//
//
//                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                        if (shouldShowRequestPermissionRationale(permissionsRejected.get(0))) {
//                            //showMessageOKCancel("These permissions are mandatory for the application. Please allow access.",
//
//                                    new DialogInterface.OnClickListener() {
//                                        @Override
//                                        public void onClick(DialogInterface dialog, int which) {
//                                            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                                                requestPermissions(permissionsRejected.toArray(new String[permissionsRejected.size()]), ALL_PERMISSIONS_RESULT);
//                                            }
//                                        }
//                                    };
//                            return;
//                        }
//                    }
//
//                }
//
//                break;
//        }
//
//    }
//
////    private void showMessageOKCancel(String message, DialogInterface.OnClickListener okListener) {
////        new AlertDialog.Builder(homefrag.this)
////                .setMessage(message)
////                .setPositiveButton("OK", okListener)
////                .setNegativeButton("Cancel", null)
////                .create()
////                .show();
////    }
//
//    @Override
//    public void onDestroy() {
//        super.onDestroy();
//        locationTrack.stopListener();
//    }


