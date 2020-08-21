package com.example.dicecontrol;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dice {

    private int maxEye;
//(constract)-------------------------------
    public  Dice(int eye){
        if(eye>1){ this.maxEye=eye; }
    }

//(ダイスロール)------------------------------
    public int roll(){
           int res=new Random().nextInt(maxEye);
           res++;
           return res;
    }




}
