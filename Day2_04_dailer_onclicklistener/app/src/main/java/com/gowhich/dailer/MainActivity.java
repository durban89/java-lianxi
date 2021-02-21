package com.gowhich.dailer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.TextureView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText numberText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numberText = (EditText) findViewById(R.id.numberText);
        Button btn = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        btn.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.button:
                String number = numberText.getText().toString().trim();

                if (TextUtils.isEmpty(number)) {
                    Toast.makeText(this, "电话号码不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent();
                    intent.setAction(Intent.ACTION_CALL);
                    Uri data = Uri.parse("tel:"+number);
                    intent.setData(data);

                    startActivity(intent);
                }

                break;
            case R.id.button2:
                Toast.makeText(this, "button2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.button3:
                Toast.makeText(this, "button3", Toast.LENGTH_LONG).show();
                break;
        }

    }
}