package com.example.gravitycontrol;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    ImageView a[] = new ImageView[6];
    int state[] = new int[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a[0] = findViewById(R.id.imageView);
        a[1] = findViewById(R.id.imageView2);
        a[2] = findViewById(R.id.imageView3);
        a[3] = findViewById(R.id.imageView4);
        a[4] = findViewById(R.id.imageView5);
        a[5] = findViewById(R.id.imageView6);
        for (int x = 0; x < 6; x++) {
            a[x].setX((float) Math.random() * ((1000) + 1));
            a[x].setY((float) Math.random() * ((1800) + 1));
        }
        for (int i = 0; i < 6; i++) {
            state[i] = 0;
        }
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            int j=(int)(Math.random()*6);
            if (state[j] == 0) {
                        ObjectAnimator anim = ObjectAnimator.ofFloat(a[j], "y", 2000);
                        anim.setDuration(2000);
                        anim.start();
                        state[j] = 1;
            }
            else
                {
                        ObjectAnimator anim = ObjectAnimator.ofFloat(a[j], "y", 0);
                        anim.setDuration(2000);
                        anim.start();
                        state[j] = 0;
                }

        }
        return false;
    }
}

