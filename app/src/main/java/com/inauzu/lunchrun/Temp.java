package com.inauzu.lunchrun;

import android.animation.Animator;
import android.os.CountDownTimer;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewPropertyAnimator;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;

public class Temp extends AppCompatActivity {
    private ImageView bookIconImageView;
    private TextView bookITextView;
    private ProgressBar loadingProgressBar;
    private RelativeLayout rootView, afterAnimationView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);
        initViews();
        new CountDownTimer(5000, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                bookITextView.setVisibility(GONE);
                loadingProgressBar.setVisibility(GONE);
                rootView.setBackgroundColor(ContextCompat.getColor(Temp.this, R.color.colorSplashText));
                bookIconImageView.setImageResource(R.drawable.logo_colored);
                startAnimation();
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    private void initViews() {
        bookIconImageView = findViewById(R.id.bookIconImageView);
        bookITextView = findViewById(R.id.bookITextView);
        loadingProgressBar = findViewById(R.id.loadingProgressBar);
        rootView = findViewById(R.id.rootView);
        afterAnimationView = findViewById(R.id.afterAnimationView);
    }

    private void startAnimation() {
        ViewPropertyAnimator viewPropertyAnimator = bookIconImageView.animate();
        viewPropertyAnimator.x(50f);
        viewPropertyAnimator.y(100f);
        viewPropertyAnimator.setDuration(1000);
        viewPropertyAnimator.setListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                afterAnimationView.setVisibility(VISIBLE);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
