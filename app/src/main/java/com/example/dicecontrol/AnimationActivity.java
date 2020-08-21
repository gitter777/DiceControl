package com.example.dicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimationActivity extends AppCompatActivity {

    private int eye;
    private int mores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);

        RotateAnimation rta = new RotateAnimation
                (0.0f,1080.0f, Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        rta.setDuration(2300);
        this.findViewById(R.id.raisin).startAnimation(rta);
//(ダイス情報、回数読み取り)ーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーーー
        Intent i = this.getIntent();
        String from = i.getStringExtra("from");

        if(from.equals("COUNT")) {
            eye = i.getIntExtra("eye", 2);
            mores = i.getIntExtra("mores", 1);
        }
        if(from.equals("LAST")){
            eye = i.getIntExtra("reEYE",2);
            mores = i.getIntExtra("reMORES",1);
        }


        Typeface face = Typeface.createFromAsset(getAssets(), "mplus.ttf");
        ((TextView) findViewById(R.id.rolling)).setTypeface(face);
//(最終画面へダイスの目、振る回数を転送)-----------------------------------------------------
        final Intent lastIntent=new Intent(this,LastActivity.class);
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                lastIntent.putExtra("ey",eye);
                lastIntent.putExtra("mo",mores);
                startActivity(lastIntent);
                finish();
            }
        };
        handler.postDelayed(runnable,3000);
    }

//--------------------------------------------------------------------------------------------------
    public void reset(){
        this.eye=0;
        this.mores=0;
    }
}
