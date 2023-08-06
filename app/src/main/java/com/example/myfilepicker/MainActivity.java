package com.example.myfilepicker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button button;
    ImageView imageView;

    TextView tv1;

    int READ_REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.btn1);
        tv1 = findViewById(R.id.tv1);

        //指定監聽的物件
        button.setOnClickListener(listener);
    }

    //監聽器
    Button.OnClickListener listener= new Button.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent picker = new Intent(Intent.ACTION_GET_CONTENT);

            /*
             * choose different path :
             * "image/*" => choose images type
             * "audio/*" => choose audio type
             * "video/*" => choose video type (ex. mp4, 3gp)
             * "video/*;image/*" => choose both video and image type
             * "*//*" => choose all type
             * */

            // picker.setType("image/*");
            picker.setType("*/*");

            startActivityForResult(picker, READ_REQUEST_CODE);
        }
    };

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent resultData) {
        super.onActivityResult(requestCode, resultCode, resultData);
        if (requestCode == READ_REQUEST_CODE && resultCode == RESULT_OK) {
            Uri selectedData = resultData.getData();
            Toast.makeText(this, selectedData.getPath().toString(), Toast.LENGTH_LONG).show();
            tv1.setText(selectedData.getPath().toString());


//            imageView.setImageURI(selectedImage);
        }
    }
}