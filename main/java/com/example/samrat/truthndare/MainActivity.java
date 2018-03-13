package com.example.samrat.truthndare;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView i1;
    Button b1;
    Random r;
    int angle;
    boolean restart=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        r=new Random();
        i1=(ImageView)findViewById(R.id.imageView);
        b1=(Button)findViewById(R.id.button);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(restart){
                    angle=angle%360;
                    angle=r.nextInt()+360;
                    RotateAnimation rotateAnimation= new RotateAnimation(angle,0,RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                    i1.startAnimation(rotateAnimation);
                    restart=false;
                    b1.setText("GO");
                }
                else{
                    angle=r.nextInt()+360;
                    RotateAnimation rotateAnimation= new RotateAnimation(0,angle,RotateAnimation.RELATIVE_TO_SELF,
                            0.5f, RotateAnimation.RELATIVE_TO_SELF,0.5f);
                    rotateAnimation.setFillAfter(true);
                    rotateAnimation.setDuration(1000);
                    rotateAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
                    i1.startAnimation(rotateAnimation);
                    restart=true;
                    b1.setText("RESET");
                }

            }
        });
    }
}
