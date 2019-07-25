package com.inauzu.lunchrun.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.inauzu.lunchrun.MainActivity;
import com.inauzu.lunchrun.Temp;
import com.inauzu.lunchrun.R;

public class LoginActivity extends Activity {
    Button btnLogin;
    EditText etId, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.bt_login);
        etId = findViewById(R.id.et_id);
        etPwd = findViewById(R.id.et_pwd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
