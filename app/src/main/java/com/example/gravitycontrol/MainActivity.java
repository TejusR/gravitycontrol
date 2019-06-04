package com.example.gravitycontrol;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView a[]=new ImageView[6];
    int state=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        a[0]=findViewById(R.id.imageView);
        a[1]=findViewById(R.id.imageView2);
        a[2]=findViewById(R.id.imageView3);
        a[3]=findViewById(R.id.imageView4);
        a[4]=findViewById(R.id.imageView5);
        a[5]=findViewById(R.id.imageView6);
        for(int x=0;x<6;x++)
        {
            a[x].setX((float)Math.random()*((1000)+1));
            a[x].setY((float)Math.random()*((1800)+1));
        }
    }
    public boolean onTouchEvent(MotionEvent event)
    {
        if(event.getAction()==MotionEvent.ACTION_DOWN)
        {
            if(state==0)
            {
                for(int i=0;i<6;i++) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(a[i],"y",2000);
                    anim.setDuration(2000);
                    anim.start();
                }
                state=1;
            }
            else
            {
                for(int i=0;i<6;i++) {
                    ObjectAnimator anim = ObjectAnimator.ofFloat(a[i],"y",0);
                    anim.setDuration(2000);
                    anim.start();
                }
                state=0;
            }
        }
        return false;
    }
}
