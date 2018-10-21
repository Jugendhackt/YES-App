package com.yesapp.yesapp.activities;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yesapp.yesapp.classes.Posts;
import com.yesapp.yesapp.R;


public class Create extends AppCompatActivity {

    EditText cityName,description,action;
    DatabaseReference myRef;
    TextView text;
    Spinner citySpinner, actionspinner;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
       description = (EditText) findViewById(R.id.editText2);
         citySpinner = (Spinner) findViewById(R.id.cityname);
        actionspinner = (Spinner) findViewById(R.id.nameOfOrganization);


    }
    //to prevent going back here while trying to exit the app
    @Override
    public void onBackPressed() {
      super.onBackPressed();
        finish();
        }




    public void post(View view) {




            FirebaseDatabase database = FirebaseDatabase.getInstance();
            DatabaseReference databaseReference = database.getReference("posts");



            Posts post = new Posts();
            post.setCityName(citySpinner.getSelectedItem().toString());
            post.setAction(actionspinner.getSelectedItem().toString());
            post.setDescription(description.getText().toString().trim());



            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

            post.setAuthorsEmail(user.getUid());
            post.setName(user.getDisplayName());



            databaseReference.push().setValue(post).addOnCompleteListener(new OnCompleteListener<Void>() {
                @Override
                public void onComplete(@NonNull Task<Void> task) {
                    if (task.isSuccessful()) {

                        Toast.makeText(Create.this, "Post Add Successfully", Toast.LENGTH_SHORT).show();
                        finish();
                    } else {
                        Toast.makeText(Create.this, "Error : post not add 🙁 ", Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }//end of if


}
