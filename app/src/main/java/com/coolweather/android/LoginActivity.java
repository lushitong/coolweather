package com.coolweather.android;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.CompoundButton.OnCheckedChangeListener;

public class LoginActivity extends AppCompatActivity {

    private EditText account_edit;
    private TextView password_edit;
    private CheckBox checkbox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        password_edit=(TextView)findViewById(R.id.password_edit);
        checkbox=(CheckBox)findViewById(R.id.checkbox);
        checkbox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else password_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());
            }
        });

                //登录按键
                Button login_button = (Button) findViewById(R.id.login_button);
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });

        //注册按键,点击后会调用浏览器打开指定网址,
        Button reg_button=(Button)findViewById(R.id.reg_button);
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://lib.glut.edu.cn/"));//Uri.parse()将网址字符串解析成一个Uri对象，setData()负责接收对象
                startActivity(intent);
            }
        });

    }
}
