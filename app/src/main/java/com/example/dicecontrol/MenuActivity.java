package com.example.dicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

//(フォント変更)-------------------------------------------
        Typeface type=Typeface.createFromAsset(getAssets(),"mplus.ttf");

        ((TextView)findViewById(R.id.txC)).setTypeface(type);
        ((TextView)findViewById(R.id.txF)).setTypeface(type);
        ((TextView)findViewById(R.id.txS)).setTypeface(type);
        ((TextView)findViewById(R.id.txE)).setTypeface(type);
        ((TextView)findViewById(R.id.txFree)).setTypeface(type);
    }

//(クリック処理)----------------------------------------------------------------
    public void getCoin(View v){
        Intent i=new Intent(this,CountActivity.class);
        i.putExtra("diceEye",2);
        i.putExtra("diceImage",R.drawable.coins);
        startActivity(i);
    }
    public void getFour(View v){
        Intent i=new Intent(this,CountActivity.class);
        i.putExtra("diceEye",4);
        i.putExtra("diceImage",R.drawable.fours);
        startActivity(i);
    }
    public void getSix(View v){
        Intent i=new Intent(this,CountActivity.class);
        i.putExtra("diceEye",6);
        i.putExtra("diceImage",R.drawable.sixs);
        startActivity(i);
    }
    public void getEight(View v){
        Intent i=new Intent(this,CountActivity.class);
        i.putExtra("diceEye",8);
        i.putExtra("diceImage",R.drawable.eight);
        startActivity(i);
    }
    public void goMenu2(View v){
        Intent i=new Intent(this,Menu2Activity.class);
        startActivity(i);
    }
}
