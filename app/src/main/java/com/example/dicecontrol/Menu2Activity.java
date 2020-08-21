package com.example.dicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.NumberPicker;
import android.widget.TextView;

public class Menu2Activity extends AppCompatActivity {

    NumberPicker num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu2);

        Typeface type=Typeface.createFromAsset(getAssets(),"mplus.ttf");

        ((TextView)findViewById(R.id.huru)).setTypeface(type);
        ((TextView)findViewById(R.id.txNext)).setTypeface(type);
        ((TextView)findViewById(R.id.txMen)).setTypeface(type);

        num=findViewById(R.id.num);
        num.setMaxValue(100);
        num.setMinValue(3);
    }

    public void next(View v){
        Intent i=new Intent(this,CountActivity.class);
        i.putExtra("diceEye",num.getValue());
        i.putExtra("diceImage",R.drawable.earth);
        startActivity(i);
        this.finish();
    }
}
