package com.example.a1_l6_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class DetailsActivityForPortrait extends AppCompatActivity {
    private String  title;
    private String  desc;
    private FragmentManager fragmentManager;
    private FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details_for_portrait);

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(MainActivity.KEY_TITLE);
            desc = intent.getStringExtra(MainActivity.KEY_DESC);

        }

        fragmentManager = getSupportFragmentManager();
        TextFragment fragment = (TextFragment) fragmentManager.findFragmentById(R.id.fragment_text);
        transaction = fragmentManager.beginTransaction();
        fragment.displayDetails(title, desc);
        transaction.commit();

    }
}