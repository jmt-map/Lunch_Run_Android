package com.inauzu.lunchrun.login;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.inauzu.lunchrun.MainActivity;
import com.inauzu.lunchrun.Temp;
import com.inauzu.lunchrun.R;
import com.inauzu.lunchrun.model.testModel;
import com.inauzu.lunchrun.retrofit.ApiClient;
import com.inauzu.lunchrun.retrofit.ApiInterFace;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends Activity {
    Button btnLogin;
    EditText etId, etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        btnLogin = findViewById(R.id.bt_login);
        etId = findViewById(R.id.et_id);
        etPwd = findViewById(R.id.et_pwd);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                //startActivity(intent);

                ApiInterFace apiService = ApiClient.getCliten().create(ApiInterFace.class);
                Call<testModel> call = apiService.getTestModel();
                ((Call) call).enqueue(new Callback<testModel>() {
                    @Override
                    public void onResponse(Call<testModel> call, Response<testModel> response) {
                        testModel test = response.body();
                        Log.d("OK", "hoho " + test.getToken() + " CODE =" + response.code());
                    }

                    @Override
                    public void onFailure(Call<testModel> call, Throwable t) {
                        Toast.makeText(getApplicationContext(), "Error",Toast.LENGTH_LONG);
                    }
                });

                Call<testModel> call2 = apiService.getTestModel2();
                call2.enqueue(new Callback<testModel>() {
                    @Override
                    public void onResponse(Call<testModel> call, Response<testModel> response) {
                        Toast.makeText(getApplicationContext(), "OK",Toast.LENGTH_LONG);
                        testModel test = response.body();
                        Log.d("OK", "hoho2  CODE =" + response.code());
                    }

                    @Override
                    public void onFailure(Call<testModel> call, Throwable t) {

                    }
                });
            }
        });

    }
}
