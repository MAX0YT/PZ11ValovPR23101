package com.example.pz11;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.os.Bundle;
import android.app.Activity;
import android.os.Handler;
import android.view.Menu;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView sunImageView = findViewById(R.id.sun);
        Animation sunRiseAnimation = AnimationUtils.loadAnimation(this, R.anim.sun_rise);
        sunImageView.startAnimation(sunRiseAnimation);

        ImageView rainbowDash = findViewById(R.id.rainbow_dash);
        ImageView lightning = findViewById(R.id.lightning);
        ImageView pinkiePie = findViewById(R.id.pinkie_pie);

        Animation bounceUp = AnimationUtils.loadAnimation(this, R.anim.bounce_up);
        Animation bounceDown = AnimationUtils.loadAnimation(this, R.anim.bounce);

        bounceUp.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                pinkiePie.startAnimation(bounceDown);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });

        bounceDown.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                pinkiePie.startAnimation(bounceUp);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });

        pinkiePie.startAnimation(bounceUp);

        Animation flyInAnimation = AnimationUtils.loadAnimation(this, R.anim.fly_in);
        rainbowDash.startAnimation(flyInAnimation);

        flyInAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                new Handler().postDelayed(() -> {
                    Animation lightningAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.lightning_flash);

                    lightning.startAnimation(lightningAnimation);

                    lightningAnimation.setAnimationListener(new Animation.AnimationListener() {
                        @Override
                        public void onAnimationStart(Animation animation) {}

                        @Override
                        public void onAnimationEnd(Animation animation) {
                            Animation flyOutAnimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fly_out);
                            lightning.setImageAlpha(0);
                            rainbowDash.startAnimation(flyOutAnimation);
                        }

                        @Override
                        public void onAnimationRepeat(Animation animation) {}
                    });
                }, 100);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });


    }
}
