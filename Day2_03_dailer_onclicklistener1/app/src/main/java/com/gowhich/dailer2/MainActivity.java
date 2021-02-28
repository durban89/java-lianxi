package com.gowhich.dailer2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText et_number = (EditText) findViewById(R.id.editTextTextPersonName);

        Button et_button = (Button) findViewById(R.id.button);

        et_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String number = et_number.getText().toString().trim();

                if (TextUtils.isEmpty(number)) {
                    Toast.makeText(MainActivity.this, "电话号码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);

                    Uri data = Uri.parse("tel:"+number);
                    intent.setData(data);

                    startActivity(intent);
                }
            }
        });
    }
}