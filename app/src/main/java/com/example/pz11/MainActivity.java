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

        ImageView pp = findViewById(R.id.pp);
        Animation ppAnim = AnimationUtils.loadAnimation(this, R.anim.pp);
        pp.startAnimation(ppAnim);
        Animation ppFallAnim = AnimationUtils.loadAnimation(this, R.anim.pp_fall);

        ImageView magic = findViewById(R.id.magic);
        Animation magicAnim = AnimationUtils.loadAnimation(this, R.anim.magic);
        magic.startAnimation(magicAnim);
        Animation magicDelAnim = AnimationUtils.loadAnimation(this, R.anim.magic_del);

        magicAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationEnd(Animation animation) {
                magic.startAnimation(magicDelAnim);
                magicDelAnim.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationEnd(Animation animation) {
                        pp.startAnimation(ppFallAnim);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }

                    @Override
                    public void onAnimationStart(Animation animation) {

                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        });
    }
}
