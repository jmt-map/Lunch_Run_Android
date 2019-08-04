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
import com.inauzu.lunchrun.model.Review;
import com.inauzu.lunchrun.model.User;
import com.inauzu.lunchrun.model.testModel;
import com.inauzu.lunchrun.retrofit.ApiClient;
import com.inauzu.lunchrun.retrofit.ApiInterFace;

import java.util.List;

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

                Call<testModel> call3 = apiService.postTestModel("Tiana", "1234567", etId.getText().toString(), etPwd.getText().toString());
                call3.enqueue(new Callback<testModel>() {
                    @Override
                    public void onResponse(Call<testModel> call, Response<testModel> response) {
                        Log.d("POST OK", "CODE =" + String.valueOf(response.code()));
                    }

                    @Override
                    public void onFailure(Call<testModel> call, Throwable t) {
                        Log.e("ERROR", t.toString());
                    }
                });

                Call<List<Integer>> call4 = apiService.getNumbers();
                call4.enqueue(new Callback<List<Integer>>() {
                    @Override
                    public void onResponse(Call<List<Integer>> call, Response<List<Integer>> response) {
                        List<Integer> list = response.body();
                        Log.d("POST OK", list.toString() + " CODE =" + String.valueOf(response.code()));
                    }

                    @Override
                    public void onFailure(Call<List<Integer>> call, Throwable t) {
                        Log.e("ERROR_ARRina@", t.toString());
                    }
                });

                Integer id = 1;
                Call<Review> call5 = apiService.getReview(id);
                call5.enqueue(new Callback<Review>() {
                    @Override
                    public void onResponse(Call<Review> call, Response<Review> response) {
                        Review review = response.body();
                        Log.d("GET OK", review.toString() + " CODE " + response.code());
                    }

                    @Override
                    public void onFailure(Call<Review> call, Throwable t) {
                        Log.e("ERROR_GET", t.toString());

                    }
                });
            }
        });

    }
}
