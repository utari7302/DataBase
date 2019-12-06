package com.samt.animationenemies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnfadein,btnfadeout,btnblink,btnzoomin,btnzoomout,btnmove,btnrotate,btnslideup,btnslidedown,btnbounce,
    btnsequential;
    TextView textfadein,textfadeout,textblink,textzoomin,textzoomout,textmove,textrotate,textslideup,textslidedown,
    textbounce,textsequenttial;

    Animation fadeing,fadeouting,blinking,zoomin,zoomout,move,rotate,slideup,slidedown,bounce,sequence;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnfadein=(Button) findViewById(R.id.btnfi);
        btnfadeout=(Button) findViewById(R.id.btnfadeo);
        btnblink=(Button) findViewById(R.id.btnblink);
        btnzoomin=(Button) findViewById(R.id.btnzoomin);
        btnzoomout=(Button) findViewById(R.id.btnzoomout);
        btnmove=(Button) findViewById(R.id.btnmove);
        btnrotate=(Button) findViewById(R.id.btnrotate);
        btnslideup=(Button) findViewById(R.id.btnslideup);
        btnslidedown=(Button) findViewById(R.id.btnslidedown);
        btnbounce=(Button) findViewById(R.id.btnbounce);
        btnsequential=(Button) findViewById(R.id.btnsequential);

        textfadein=(TextView) findViewById(R.id.tvfi);
        textfadeout=(TextView) findViewById(R.id.tvfo);
        textblink=(TextView) findViewById(R.id.tvblink);
        textzoomin=(TextView) findViewById(R.id.tvzoomin);
        textzoomout=(TextView) findViewById(R.id.tvzoomout);
        textmove=(TextView) findViewById(R.id.tvmove);
        textrotate=(TextView) findViewById(R.id.tvrotate);
        textslideup=(TextView) findViewById(R.id.tvslideup);
        textslidedown=(TextView) findViewById(R.id.tvslidedown);
        textbounce=(TextView) findViewById(R.id.tvbouncetext);
        textsequenttial=(TextView) findViewById(R.id.tvsequential);

        fadeing= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        fadeouting=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        blinking=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.blink);
        zoomin=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
        zoomout=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_out);
        move=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.move);
        rotate=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.rotate);
        slideup=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_up);
        slidedown=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.slide_down);
        bounce=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.bounce);
        sequence=AnimationUtils.loadAnimation(getApplicationContext(),R.anim.sequential);

        btnfadein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textfadein.setVisibility(View.VISIBLE);
                textfadein.startAnimation(fadeing);
            }
        });

        btnfadeout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textfadeout.setVisibility(View.VISIBLE);
                textfadeout.startAnimation(fadeouting);
            }
        });
        btnblink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textblink.setVisibility(View.VISIBLE);
                textblink.startAnimation(blinking);
            }
        });
        btnzoomin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textzoomin.setVisibility(View.VISIBLE);
                textzoomin.startAnimation(zoomin);
            }
        });
        btnzoomout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textzoomout.setVisibility(View.VISIBLE);
                textzoomout.startAnimation(zoomout);
            }
        });
        btnmove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textmove.setVisibility(View.VISIBLE);
                textmove.startAnimation(move);
            }
        });
        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textrotate.setVisibility(View.VISIBLE);
                textrotate.startAnimation(rotate);
            }
        });
        btnslideup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textslideup.setVisibility(View.VISIBLE);
                textslideup.startAnimation(slideup);
            }
        });
        btnslidedown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textslidedown.setVisibility(View.VISIBLE);
                textslidedown.startAnimation(slidedown);
            }
        });
        btnbounce.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textbounce.setVisibility(View.VISIBLE);
                textbounce.startAnimation(bounce);
            }
        });
        btnsequential.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                textsequenttial.setVisibility(View.VISIBLE);
                textsequenttial.startAnimation(sequence);
            }
        });
    }
}
