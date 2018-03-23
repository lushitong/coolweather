package com.coolweather.android;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    private CheckBox show_password1;
    private EditText password_reg1;
    private EditText password_reg2;
    private Button reg_button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        reg_button1=(Button)findViewById(R.id.reg_button1);
        show_password1=(CheckBox)findViewById(R.id.show_password1);
        password_reg1=(EditText)findViewById(R.id.password_reg1);
        password_reg2=(EditText)findViewById(R.id.password_reg2);


        //设置密码是否隐藏
        show_password1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password_reg1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//如果选中，显示密码
                    password_reg2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    password_reg1.setTransformationMethod(PasswordTransformationMethod.getInstance());//否则隐藏密码
                    password_reg2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        show_password1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    password_reg1.setTransformationMethod(HideReturnsTransformationMethod.getInstance());//如果选中，显示密码
                    password_reg2.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    password_reg1.setTransformationMethod(PasswordTransformationMethod.getInstance());//否则隐藏密码
                    password_reg2.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }

            }
        });

        reg_button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(RegisterActivity.this,LoginActivity.class);
                startActivity(intent);
                //finish();
            }
        });
    }
}
