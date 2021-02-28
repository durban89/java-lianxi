package com.gowhich.dailer;

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

    private EditText phoneNumberText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        phoneNumberText = (EditText) findViewById(R.id.editText);
        Button call_buttom = (Button) findViewById(R.id.call_button);

        call_buttom.setOnClickListener(new CallPhoneOnclickListener());
    }

    private class CallPhoneOnclickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            String phoneNumber = phoneNumberText.getText().toString();

            if (TextUtils.isEmpty(phoneNumber)) {
                System.out.println("电话号码是空的");
                Toast.makeText(MainActivity.this, "电话号码不能为空", Toast.LENGTH_LONG).show();
            } else {
                System.out.println("电话号码是"+phoneNumber);

                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_CALL);
                Uri data = Uri.parse("tel:"+phoneNumber);
                intent.setData(data);
                startActivity(intent);
            }
        }
    }
}