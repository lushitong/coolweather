package com.coolweather.android;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.preference.PreferenceManager;
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
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText account_edit;
    private EditText password_edit;
    private CheckBox remember_password;
    private CheckBox show_password;
    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        account_edit=(EditText)findViewById(R.id.account_edit);//登录账号
        password_edit=(EditText) findViewById(R.id.password_edit);//登录密码
        show_password=(CheckBox)findViewById(R.id.show_password);//显示密码复选框
        remember_password=(CheckBox)findViewById(R.id.remeber_password); //记住密码复选框
        Button login_button = (Button) findViewById(R.id.login_button);//登录button
        Button reg_button=(Button)findViewById(R.id.reg_button);//注册button
        preferences= PreferenceManager.getDefaultSharedPreferences(this);
        boolean isRemember=preferences.getBoolean("remember_password",false);

        //将账号和密码都设置到文本框中
        if (isRemember){
            String account=preferences.getString("account_edit","");
            String password=preferences.getString("password_edit","");
            account_edit.setText(account);
            password_edit.setText(password);
            remember_password.setChecked(true);
        }

        //设置密码是否隐藏
        show_password.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password_edit.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//如果选中，显示密码
                }
                else password_edit.setTransformationMethod(PasswordTransformationMethod.getInstance());//否则隐藏密码

            }
        });

        //登录后跳转的Activity
        login_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String account=account_edit.getText().toString();
                String password=password_edit.getText().toString();
                if (account.equals("lushitong")&&password.equals("123456")) {
                    editor=preferences.edit();

                    //检查记住密码复选框是否被选中
                    if (remember_password.isChecked()){
                        editor.putBoolean("remember_password",true);//将remmeber_password设置为true
                        editor.putString("account",account);//将account对应的值存入到SharePreferences文件中并提交
                        editor.putString("password",password);
                    }
                    else {
                        editor.clear();
                    }

                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                   // finish();
                }
                else {
                    Toast.makeText(LoginActivity.this,"账号或者密码错误",Toast.LENGTH_SHORT).show();
                }
            }
        });

        //注册button
        reg_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

    }
}
