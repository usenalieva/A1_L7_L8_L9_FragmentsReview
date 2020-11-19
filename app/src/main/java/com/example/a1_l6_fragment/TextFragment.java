package com.example.a1_l6_fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class TextFragment extends Fragment {
    TextView tvTitle;
    TextView tvDescription;

    public static final String ARG_TITLE = "title";
    public static final String ARG_DESC = "desc";

    private String mTitle;
    private String mDesc;


    public static TextFragment newInstance(String title, String desc) {

        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_DESC, desc);

        TextFragment fragment = new TextFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mTitle = getArguments().getString(ARG_TITLE);
            mDesc = getArguments().getString(ARG_DESC);
        }

    }
    public TextFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_text, container, false);

        tvTitle = view.findViewById(R.id.txvTitle);
        tvDescription = view.findViewById(R.id.txvDescription);

        if (mTitle != null && mDesc != null) {
            tvTitle.setText(mTitle);
            tvDescription.setText(mDesc);
        }
        return view;
    }

    void displayDetails(String title, String desc) {
        tvTitle.setText(title);
        tvDescription.setText(desc);
    }
}