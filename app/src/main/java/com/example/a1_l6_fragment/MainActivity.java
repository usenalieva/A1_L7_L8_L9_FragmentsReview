package com.example.a1_l6_fragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    public static final String KEY_TITLE = "key title";
    public static final String KEY_DESC = "key desc";
    private boolean mViewFragment = false;

    private View fragmentView;
    private FragmentManager manager;
    private FragmentTransaction transaction;

    private String title;
    private String desc;
    private String image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentView = findViewById(R.id.fragment_second);
        if (fragmentView != null) {
            mViewFragment = true;
        }

        Intent intent = getIntent();
        if (intent != null) {
            title = intent.getStringExtra(ApplicationActivity.KEY);
            desc = intent.getStringExtra(ApplicationActivity.KEY2);
            image = intent.getStringExtra(ApplicationActivity.KEY3);

            Fragment fragment = FragmentRecView.newInstance(title, desc, image);
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            // next line is for landscape view
            if (mViewFragment)
                transaction.replace(R.id.frame_container, fragment);
            else
                /* and this is for portrait view (have changed the Fragment to Dynamic
                 so it would be possible to use it here) */
                transaction.replace(R.id.fragment_first, fragment);

            transaction.commit();
        }

    }


    public void displayDetails(String title, String description) {

        if (mViewFragment) {
            manager = getSupportFragmentManager();
            transaction = manager.beginTransaction();
            transaction.replace(R.id.fragment_second, TextFragment.newInstance(title, description));
            transaction.commit();

        } else {
            Intent intent = new Intent(this, DetailsActivityForPortrait.class);
            intent.putExtra(KEY_TITLE, title);
            intent.putExtra(KEY_DESC, description);
            startActivity(intent);
        }


    }
}