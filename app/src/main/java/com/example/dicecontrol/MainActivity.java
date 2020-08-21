package com.example.dicecontrol;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Chronometer;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//(タイトルテキストにフォントデータを挿入)-------------------------
        Typeface face1 = Typeface.createFromAsset(getAssets(), "amatic1.ttf");

        TextView title = (TextView) findViewById(R.id.titleText);
        title.setTypeface(face1);
        TextView subtitle = (TextView) findViewById(R.id.subTitle);
        subtitle.setTypeface(face1);
//(4秒後にmenu画面へ)------------------------------------------
        final Intent gotoMenu=new Intent(this,MenuActivity.class);
        Handler handler=new Handler();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                startActivity(gotoMenu);
                finish();
            }
        };
        handler.postDelayed(runnable,4000);




    }
}