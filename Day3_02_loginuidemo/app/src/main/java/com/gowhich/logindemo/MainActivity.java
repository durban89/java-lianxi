package com.gowhich.logindemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.gowhich.logindemo.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editText1 = (EditText) findViewById(R.id.editText1);
        EditText editText2 = (EditText) findViewById(R.id.editText2);
        CheckBox checkBox = (CheckBox) findViewById(R.id.login_save_checked);
        Button loginButton = (Button) findViewById(R.id.login_btn);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!checkBox.isChecked()) {
                    Toast.makeText(MainActivity.this, "请勾选", Toast.LENGTH_LONG).show();
                    return;
                }

                String userName = editText1.getText().toString();
                String password = editText2.getText().toString();

                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(MainActivity.this, "请输入用户名", Toast.LENGTH_LONG).show();
                    return;
                }


                if (TextUtils.isEmpty(password)) {
                    Toast.makeText(MainActivity.this, "请输入密码", Toast.LENGTH_LONG).show();
                    return;
                }

                Log.i("Login", "userName:"+userName);
                Log.i("Login", "password:"+password);

//                boolean saveInfo = Utils.saveInfo(userName, password);
//                boolean saveInfo = Utils.saveInfoByContext(MainActivity.this, userName, password);
                boolean saveInfo = Utils.saveInfoToSDCard(MainActivity.this, userName, password);
                if (saveInfo) {
                    Toast.makeText(MainActivity.this, "保存成功", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(MainActivity.this, "保存失敗", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        String[] userInfo = Utils.readInfo();
//        String[] userInfo = Utils.readInfoByContext(MainActivity.this);
        String[] userInfo = Utils.readInfoFromSDCard(MainActivity.this);
        if (userInfo != null) {
            editText1.setText(userInfo[0]);
            editText2.setText(userInfo[1]);
        }

    }
}