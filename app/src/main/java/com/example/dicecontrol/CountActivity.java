package com.example.dicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class CountActivity extends AppCompatActivity {

    private int eye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count);

//(ダイスの種類 & イメージ「インテント」読み取り)-----------------------------------
        Intent i=this.getIntent();
        eye=i.getIntExtra("diceEye",2);

        int diceimage=i.getIntExtra("diceImage",2);
        ((ImageView)findViewById(R.id.theDice)).setImageResource(diceimage);
//(文字情報の読み取り)----------------------------------------------------------
        Typeface face1 = Typeface.createFromAsset(getAssets(), "mplus.ttf");

        ((TextView) findViewById(R.id.what)).setTypeface(face1);
        ((TextView) findViewById(R.id.x)).setTypeface(face1);
        ((TextView) findViewById(R.id.y)).setTypeface(face1);
        ((TextView) findViewById(R.id.z)).setTypeface(face1);

    }







//(クリック処理)--------------------------------------------------------------------------------------
    public void oneMore(View v){
        AnimationActivity ani=new AnimationActivity();
        ani.reset();

        Intent i=new Intent(this,AnimationActivity.class);
        i.putExtra("eye",eye);
        i.putExtra("mores",1);
        i.putExtra("from","COUNT");
        this.startActivity(i);
        this.finish();
    }
    public void twoMore(View v){
        AnimationActivity ani=new AnimationActivity();
        ani.reset();

        Intent i=new Intent(this,AnimationActivity.class);
        i.putExtra("eye",eye);
        i.putExtra("mores",2);
        i.putExtra("from","COUNT");
        this.startActivity(i);
        this.finish();
    }
    public void threeMore(View v){
        AnimationActivity ani=new AnimationActivity();
        ani.reset();

        Intent i=new Intent(this,AnimationActivity.class);
        i.putExtra("eye",eye);
        i.putExtra("mores",3);
        i.putExtra("from","COUNT");
        this.startActivity(i);
        this.finish();
    }
}
