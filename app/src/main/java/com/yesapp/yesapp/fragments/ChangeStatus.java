package com.yesapp.yesapp.fragments;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.yesapp.yesapp.R;
import com.yesapp.yesapp.activities.Settings;
import com.yesapp.yesapp.viewInflatorsAdapters.ResetPasswordListener;

import java.util.Objects;


public class ChangeStatus extends AppCompatDialogFragment {

    private EditText newStatus;
    private ChangeStatus listener;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder DialogeBilder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();
        View view =layoutInflater.inflate(R.layout.change_name_status,null);
        DialogeBilder.setView(view)
                .setTitle("Change Status").setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


            }
        }).setPositiveButton("Change", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {


                if (newStatus.getText().toString().equals("")) {
                    Toast.makeText(getContext(), "Please enter a name!", Toast.LENGTH_SHORT).show();
                    return;
                }
                FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                assert user != null;
                String userId = user.getUid();
                DatabaseReference databaseReference = firebaseDatabase.getReference().child("users").child(userId).child("status");
                databaseReference.setValue(newStatus.getText().toString().trim());

                Settings.refreshSettings(2);


            }
        });

        newStatus =(EditText)view.findViewById(R.id.changeNameStatusEditText);
        newStatus.setHint("A new awesome Status here!");
        return DialogeBilder.create();
    }

}
