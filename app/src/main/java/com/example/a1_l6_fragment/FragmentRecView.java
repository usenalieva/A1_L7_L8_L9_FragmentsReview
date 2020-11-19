package com.example.a1_l6_fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class FragmentRecView extends Fragment implements IFragments {

    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    private ArrayList<DestinationModel> list;

    public static final String ARG_TITLE = "title2";
    public static final String ARG_DESC = "desc2";
    public static final String ARG_IMAGE = "image2";


    private static String mTitle;
    private static String mDesc;
    private  static String  mImage;



    public static  FragmentRecView newInstance(String title, String desc, String image) {
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESC, desc);
        args.putString(ARG_IMAGE, image );

        FragmentRecView fragment = new FragmentRecView();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mDesc = getArguments().getString(ARG_DESC);
            mImage = getArguments().getString(ARG_IMAGE);
        }
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_rec_view, container, false);
       setUpRecyclerView(view);


        return view;
    }
    void setUpRecyclerView(View view) {
        list = new ArrayList<>();
        list.add( new DestinationModel(mTitle, mDesc,  mImage));
        list.add( new DestinationModel("Title2", "Desc2", mImage));

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new RecyclerAdapter(list, getContext());
        adapter.setOnCLickListener(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void displayDetails(String title, String desc) {
        MainActivity activity  = (MainActivity) getActivity();
        activity.displayDetails(title, desc );

    }


}