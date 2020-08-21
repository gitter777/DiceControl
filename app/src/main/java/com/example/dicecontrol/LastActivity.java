package com.example.dicecontrol;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class LastActivity extends AppCompatActivity {

     private int ey;
     private int mo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_last);

        Intent i=this.getIntent();
        ey=i.getIntExtra("ey",2);
        mo=i.getIntExtra("mo",1);

        Typeface type=Typeface.createFromAsset(getAssets(),"mplus.ttf");
        ((TextView)findViewById(R.id.kekka)).setTypeface(type);
        ((TextView)findViewById(R.id.txHome)).setTypeface(type);
        ((TextView)findViewById(R.id.txRetry)).setTypeface(type);

        if(ey==2){((TextView)findViewById(R.id.menmen)).setText("(コイン)");}
        else{((TextView)findViewById(R.id.txMeeen)).setText(String.valueOf(ey));}
//(結果発表)----------------------------------------------------------------
        Dice dice=new Dice(ey);
        if(ey == 2){   /*コインの時は表裏の表示*/
            switch (mo){
                case 3:
                    int[] roll3 ={dice.roll(),dice.roll(),dice.roll()};

                    if(roll3[0] == 1){((TextView) findViewById(R.id.roll1)).setText("表"); }
                    if(roll3[0] == 2){((TextView) findViewById(R.id.roll1)).setText("裏");}
                    if(roll3[1] == 1){((TextView) findViewById(R.id.roll2)).setText("表"); }
                    if(roll3[1] == 2){((TextView) findViewById(R.id.roll2)).setText("裏");}
                    if(roll3[2] == 1){((TextView) findViewById(R.id.roll3)).setText("表"); }
                    if(roll3[2] == 2){((TextView) findViewById(R.id.roll3)).setText("裏");}

                    ((TextView) findViewById(R.id.roll1)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll2)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll3)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku1)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku2)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku3)).setImageResource(R.drawable.waku2);
                    break;
                case 2:
                    int[] roll2 = {dice.roll(),dice.roll()};

                    if(roll2[0] == 1){((TextView) findViewById(R.id.roll3)).setText("表"); }
                    if(roll2[0] == 2){((TextView) findViewById(R.id.roll3)).setText("裏");}
                    if(roll2[1] == 1){((TextView) findViewById(R.id.roll2)).setText("表"); }
                    if(roll2[1] == 2){((TextView) findViewById(R.id.roll2)).setText("裏"); }

                    ((TextView) findViewById(R.id.roll2)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll3)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku1)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku3)).setImageResource(R.drawable.waku2);
                    break;
                case 1:
                    int roll1 = dice.roll();

                    if(roll1 == 1){((TextView) findViewById(R.id.roll1)).setText("表"); }
                    if(roll1 == 2){((TextView) findViewById(R.id.roll1)).setText("裏");}
                    ((TextView) findViewById(R.id.roll1)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku2)).setImageResource(R.drawable.waku2);
                    break;
            }
        }else {   /*コイン以外の時はダイス目を表示*/
            switch (mo) {
                case 3:
                    ((TextView) findViewById(R.id.roll1)).setText(String.valueOf(dice.roll()));
                    ((TextView) findViewById(R.id.roll2)).setText(String.valueOf(dice.roll()));
                    ((TextView) findViewById(R.id.roll3)).setText(String.valueOf(dice.roll()));

                    ((TextView) findViewById(R.id.roll1)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll2)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll3)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku1)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku2)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku3)).setImageResource(R.drawable.waku2);
                    break;
                case 2:
                    ((TextView) findViewById(R.id.roll2)).setText(String.valueOf(dice.roll()));
                    ((TextView) findViewById(R.id.roll3)).setText(String.valueOf(dice.roll()));

                    ((TextView) findViewById(R.id.roll2)).setTypeface(type);
                    ((TextView) findViewById(R.id.roll3)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku1)).setImageResource(R.drawable.waku2);
                    ((ImageView)findViewById(R.id.waku3)).setImageResource(R.drawable.waku2);
                    break;
                case 1:
                    ((TextView) findViewById(R.id.roll1)).setText(String.valueOf(dice.roll()));

                    ((TextView) findViewById(R.id.roll1)).setTypeface(type);
                    ((ImageView)findViewById(R.id.waku2)).setImageResource(R.drawable.waku2);
                    break;
            }
        }
    }
//(ホーム釦)------------------------------------------------------------------------
    public void goHome(View v){ this.finish(); }
//(振り直し)------------------------------------------------------------------------
    public void retry(View v){
        Intent retry = new Intent(this,AnimationActivity.class);
        retry.putExtra("reEYE",ey);
        retry.putExtra("reMORES",mo);
        retry.putExtra("from","LAST");
        this.startActivity(retry);
        this.finish();
    }
}
