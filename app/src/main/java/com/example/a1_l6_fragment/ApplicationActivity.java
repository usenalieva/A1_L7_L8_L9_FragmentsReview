package com.example.a1_l6_fragment;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class ApplicationActivity extends AppCompatActivity {

    private static final int REQUEST_CODE_ADDING = 200;
    private EditText etTitle;
    private EditText etDesc;
    private ImageView image;
    private Button btnSave;


    static final String KEY = "key1";
    static final String KEY2 = "key2";
    static final String KEY3 = "key3";



    // have modified the project by adding an ImageView  
    static Uri uriOfImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application);
        init();
    }

    private void init() {
        etTitle = findViewById(R.id.et_title);
        etDesc = findViewById(R.id.et_desc);
        image = findViewById(R.id.iconAdd);
        btnSave = findViewById(R.id.btn_save);

        image.setOnClickListener(view -> {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction(Intent.ACTION_GET_CONTENT );
            startActivityForResult(Intent.createChooser(intent, "choose an image"), REQUEST_CODE_ADDING);

        });

        btnSave.setOnClickListener(view -> {
         Intent intent = new Intent(ApplicationActivity.this, MainActivity.class);
         intent.putExtra(KEY, etTitle.getText().toString());
         intent.putExtra(KEY2, etDesc.getText().toString());
         intent.putExtra(KEY3, uriOfImage.toString());
         intent.setData(uriOfImage);
         startActivity(intent);
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_ADDING && resultCode == RESULT_OK) {
            if (data != null) {
                uriOfImage = data.getData();
                image.setImageURI(uriOfImage);
            }

        }
    }
}