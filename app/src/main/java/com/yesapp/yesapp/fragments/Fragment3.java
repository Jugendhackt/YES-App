package com.yesapp.yesapp.fragments;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.yesapp.yesapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    FirebaseDatabase firebaseDatabase;



    public Fragment3() {
        // Required empty public constructor
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        //DatabaseReference friendsReference

        // TODO: get the Friends
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragment3, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

         String[] mDataset = new String[6];

         mDataset[0]="Anna";
        mDataset[1]="Charlotte";
        mDataset[2]="Anna-Lena";
        mDataset[3]="Abraham";
        mDataset[4]="Natalie";
        mDataset[5]="John";

        int[] friendsPicturesArray = new int[6];
        friendsPicturesArray[0] =R.drawable.bild15;
        friendsPicturesArray[1] =R.drawable.bild13;
        friendsPicturesArray[2] =R.drawable.bild14;
        friendsPicturesArray[3] =R.drawable.bild12;
        friendsPicturesArray[4] =R.drawable.bild16;
        friendsPicturesArray[5] =R.drawable.bild17;




        // specify an adapter (see also next example)
        mAdapter = new MyAdapter(mDataset,friendsPicturesArray);
        mRecyclerView.setAdapter(mAdapter);

    }
}
