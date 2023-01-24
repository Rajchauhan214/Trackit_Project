package com.example.proj;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class profile extends AppCompatActivity {
    String userid;
    EditText f_name,email,number;
    Button btn_save,view,pass;
    DatabaseReference reff;
    Button chooseImg, uploadImg;
    ImageView imgView,profile_img;
    member member;
    ProgressDialog pd;
    int PICK_IMAGE_REQUEST = 111;
    Uri filePath;
    //FETCH
//    EditText editText;
//    Button submit, fetch;
//    DatabaseReference rootRef, demoRef;
    TextView demoValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        f_name = (EditText)findViewById(R.id.f_name);
        email = (EditText)findViewById(R.id.email);
        number = (EditText)findViewById(R.id.number);
        profile_img = (ImageView)findViewById(R.id.profile_image);

        chooseImg = (Button)findViewById(R.id.chooseImg);
        uploadImg = (Button)findViewById(R.id.uploadImg);
       // imgView = (ImageView)findViewById(R.id.imgView);

        btn_save = (Button) findViewById(R.id.btn_save);
       // view = (Button) findViewById(R.id.view);
        //FETCH
//        editText = (EditText) findViewById(com.google.firebase.database.R.id.etValue);
//        demoValue = (TextView) findViewById(com.google.firebase.database.R.id.tvValue);
//        submit = (Button) findViewById(com.google.firebase.database.R.id.btnSubmit);
//        fetch = (Button) findViewById(com.google.firebase.database.R.id.btnFetch);

        //database reference pointing to root of database
//        rootRef = FirebaseDatabase.getInstance().getReference();

        //database reference pointing to demo node
//        demoRef = rootRef.child("demo");

//        submit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                String value = editText.getText().toString();
//
//                //push creates a unique id in database
//                demoRef.child("value").setValue(value);
//            }
//        });

        FirebaseStorage storage = FirebaseStorage.getInstance();
        StorageReference storageRef = storage.getReferenceFromUrl("gs://proj-4a703.appspot.com");    //change the url according to your firebase app


        pd = new ProgressDialog(this);
        pd.setMessage("Uploading....");


        chooseImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setType("image/*");
                intent.setAction(Intent.ACTION_PICK);
                startActivityForResult(Intent.createChooser(intent, "Select Image"), PICK_IMAGE_REQUEST);
            }
        });

        uploadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(filePath != null) {
                    pd.show();

                    StorageReference childRef = storageRef.child("image.jpg");

                    //uploading the image
                    UploadTask uploadTask = childRef.putFile(filePath);

                    uploadTask.addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            pd.dismiss();
                            Toast.makeText(profile.this, "Upload successful", Toast.LENGTH_SHORT).show();
                        }
                    }).addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            pd.dismiss();
                            Toast.makeText(profile.this, "Upload Failed -> " + e, Toast.LENGTH_SHORT).show();
                        }
                    });
                }
                else {
                    Toast.makeText(profile.this, "Select an image", Toast.LENGTH_SHORT).show();
                }
            }
        });

        pass = (Button)findViewById(R.id.pass);

        pass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                demo.message = f_name.getText().toString();
                demo.message2 = email.getText().toString();
                demo.message3 = number.getText().toString();

                Intent intent = new Intent(getApplicationContext(), pass.class);
                startActivity(intent);
            }
        });



        member = new member();
        reff = FirebaseDatabase.getInstance().getReference().child("member");
        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //int num=Integer.parseInt(number.getText().toString().trim());
                Long num=Long.parseLong(number.getText().toString().trim());
                member.setF_name(f_name.getText().toString().trim());
                member.setEmail(email.getText().toString().trim());
                member.setNumber(num);

                reff.push().setValue(member);
                Toast.makeText(profile.this,"inserted !!!",Toast.LENGTH_LONG).show();
            }
        });

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                reff.child("member").addListenerForSingleValueEvent(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NotNull DataSnapshot dataSnapshot) {
//                        String value = dataSnapshot.getValue(String.class);
//                        demoValue.setText(value);
//                        demoValue.setText(value);
//                        demoValue.setText(value);
//                        demoValue.setText(value);
//                    }
//
//                    @Override
//                    public void onCancelled(DatabaseError databaseError) {
//                    }
//                });
//            }
//        });

//        view.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(profile.this ,ProfileActivity.class);
//                startActivity(i);
//            }
//        });







    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            filePath = data.getData();

            try {
                //getting image from gallery
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);

                //Setting image to ImageView
//                imgView.setImageBitmap(bitmap);
                profile_img.setImageBitmap(bitmap);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void save(View view) {
//        int num=Integer.parseInt(number.getText().toString().trim());
        Long num=Long.parseLong(number.getText().toString().trim());
        member.setF_name(f_name.getText().toString().trim());
        member.setEmail(email.getText().toString().trim());
        member.setNumber(num);
        reff.push().setValue(member);
        Toast.makeText(profile.this,"Inserted !!!",Toast.LENGTH_LONG).show();
    }
}
