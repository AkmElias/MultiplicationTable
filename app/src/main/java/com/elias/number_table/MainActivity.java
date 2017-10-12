package com.elias.number_table;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button one,two,three,four,five,six,seven,eight,nine,ten;
    //buttons of first column
    Button c1r1,c1r2,c1r3,c1r4,c1r5,c1r6,c1r7,c1r8,c1r9,c1r10;
    Button c5r1,c5r2,c5r3,c5r4,c5r5,c5r6,c5r7,c5r8,c5r9,c5r10;
    String  check= "a";

    private static final int SecondActivityResultCode = 0;
    @Override
    public void onBackPressed(){

        final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Are you sure want to close this?");
        builder.setCancelable(true);
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();

            }
        }) ;
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    TextToSpeech tt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent intent=new Intent(MainActivity.this,About.class);
                startActivityForResult(intent,  SecondActivityResultCode); //suppose resultCode == 2;

            }
        });

       tt1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
           @Override
           public void onInit(int status) {

               if(status != TextToSpeech.ERROR) {
                   tt1.setLanguage(Locale.UK);
               }
           }
       });
        //en = in.getStringExtra("enn");

        //Statring...............NumberToMultiply...
        one  = (Button)findViewById(R.id.One);
        two  = (Button)findViewById(R.id.Two);
        three  = (Button)findViewById(R.id.Three);
        four  = (Button)findViewById(R.id.Four);
        five = (Button)findViewById(R.id.Five);
        six  = (Button)findViewById(R.id.Six);
        seven  = (Button)findViewById(R.id.Seven);
        eight  = (Button)findViewById(R.id.Eight);
        nine  = (Button)findViewById(R.id.Nine);
        ten  = (Button)findViewById(R.id.Ten);
        //buttons for first column.......
        c1r1 = (Button)findViewById(R.id.C1r1);
        c1r2 = (Button)findViewById(R.id.C1r2);
        c1r3 = (Button)findViewById(R.id.C1r3);
        c1r4 = (Button)findViewById(R.id.C1r4);
        c1r5 = (Button)findViewById(R.id.C1r5);
        c1r6 = (Button)findViewById(R.id.C1r6);
        c1r7 = (Button)findViewById(R.id.C1r7);
        c1r8 = (Button)findViewById(R.id.C1r8);
        c1r9 = (Button)findViewById(R.id.C1r9);
        c1r10 = (Button)findViewById(R.id.C1r10);
        //Buttons of fifth columns....
        c5r1 = (Button)findViewById(R.id.C5r1);
        c5r2 = (Button)findViewById(R.id.C5r2);
        c5r3 = (Button)findViewById(R.id.C5r3);
        c5r4 = (Button)findViewById(R.id.C5r4);
        c5r5 = (Button)findViewById(R.id.C5r5);
        c5r6 = (Button)findViewById(R.id.C5r6);
        c5r7 = (Button)findViewById(R.id.C5r7);
        c5r8 = (Button)findViewById(R.id.C5r8);
        c5r9 = (Button)findViewById(R.id.C5r9);
        c5r10 = (Button)findViewById(R.id.C5r10);

    }




    // Call Back method  to get the Message form other Activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);
        tt1 = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {

                if(status != TextToSpeech.ERROR) {
                    tt1.setLanguage(Locale.UK);
                }
            }
        });
        if(requestCode==SecondActivityResultCode)
        {
            if(resultCode==RESULT_OK) {
                check = data.getStringExtra("about");
               // Bundle bundle = data.getExtras("about");
                if(check.equals("clear")){

                    c1r1.setText("0");  c1r2.setText("0");  c1r3.setText("0");  c1r4.setText("0");  c1r5.setText("0");
                    c1r6.setText("0");  c1r7.setText("0");  c1r8.setText("0");  c1r9.setText("0");  c1r10.setText("0");
                    c5r1.setText("0");  c5r2.setText("0");  c5r3.setText("0");  c5r4.setText("0");  c5r5.setText("0");
                    c5r6.setText("0");  c5r7.setText("0");  c5r8.setText("0");  c5r9.setText("0");  c5r10.setText("0");

                }
                else {
                    int number = Integer.parseInt(check);
                    //Toast.makeText(getApplicationContext(), "clear", Toast.LENGTH_LONG).show();


                    int result;
                    String fi = "";
                    String se = "", th = "", fo = "", fiv = "", si = "", sev = "", ei = "", ni = "", te = "";

                    temp = number * 1;
                    fi = Integer.toString(temp);
                    c5r1.setText(fi);
                    temp = number * 2;
                    se = Integer.toString(temp);
                    c5r2.setText(se);
                    temp = number * 3;
                    th = Integer.toString(temp);
                    c5r3.setText(th);
                    temp = number * 4;
                    fo = Integer.toString(temp);
                    c5r4.setText(fo);
                    temp = number * 5;
                    fiv = Integer.toString(temp);
                    c5r5.setText(fiv);
                    temp = number * 6;
                    si = Integer.toString(temp);
                    c5r6.setText(si);
                    temp = number * 7;
                    sev = Integer.toString(temp);
                    c5r7.setText(sev);
                    temp = number * 8;
                    ei = Integer.toString(temp);
                    c5r8.setText(ei);
                    temp = number * 9;
                    ni = Integer.toString(temp);
                    c5r9.setText(ni);
                    temp = number * 10;
                    te = Integer.toString(temp);
                    c5r10.setText(te);


                    c1r1.setText(check);
                    c1r2.setText(check);
                    c1r3.setText(check);
                    c1r4.setText(check);
                    c1r5.setText(check);
                    c1r6.setText(check);
                    c1r7.setText(check);
                    c1r8.setText(check);
                    c1r9.setText(check);
                    c1r10.setText(check);

                }

            }

        }
    }
    int temp,temp2;
    public void OnClick(View v){

        if(v.getId()==R.id.One){

          int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 1*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 1*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 1*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 1*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 1*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 1*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 1*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 1*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 1*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 1*10;
            te = Integer.toString(temp);
            c5r10.setText(te);


            c1r1.setText("1");  c1r2.setText("1");  c1r3.setText("1");  c1r4.setText("1");  c1r5.setText("1");
            c1r6.setText("1");  c1r7.setText("1");  c1r8.setText("1");  c1r9.setText("1");  c1r10.setText("1");


        }
        if(v.getId()==R.id.Two){

            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 2*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 2*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 2*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 2*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 2*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 2*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 2*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 2*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 2*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 2*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("2");  c1r2.setText("2");  c1r3.setText("2");  c1r4.setText("2");  c1r5.setText("2");
            c1r6.setText("2");  c1r7.setText("2");  c1r8.setText("2");  c1r9.setText("2");  c1r10.setText("2");
        }
        if(v.getId()==R.id.Three){

            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 3*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 3*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 3*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 3*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 3*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 3*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 3*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 3*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 3*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 3*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("3");  c1r2.setText("3");  c1r3.setText("3");  c1r4.setText("3");  c1r5.setText("3");
            c1r6.setText("3");  c1r7.setText("3");  c1r8.setText("3");  c1r9.setText("3");  c1r10.setText("3");
        }
        if(v.getId()==R.id.Four){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 4*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 4*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 4*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 4*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 4*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 4*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 4*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 4*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 4*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 4*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("4");  c1r2.setText("4");  c1r3.setText("4");  c1r4.setText("4");  c1r5.setText("4");
            c1r6.setText("4");  c1r7.setText("4");  c1r8.setText("4");  c1r9.setText("4");  c1r10.setText("4");

        }
        if(v.getId()==R.id.Five){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 5*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 5*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 5*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 5*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 5*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 5*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 5*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 5*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 5*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 5*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("5");  c1r2.setText("5");  c1r3.setText("5");  c1r4.setText("5");  c1r5.setText("5");
            c1r6.setText("5");  c1r7.setText("5");  c1r8.setText("5");  c1r9.setText("5");  c1r10.setText("5");

        }
        if(v.getId()==R.id.Six){

            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 6*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 6*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 6*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 6*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 6*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 6*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 6*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 6*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 6*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 6*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("6");  c1r2.setText("6");  c1r3.setText("6");  c1r4.setText("6");  c1r5.setText("6");
            c1r6.setText("6");  c1r7.setText("6");  c1r8.setText("6");  c1r9.setText("6");  c1r10.setText("6");
        }
        if(v.getId()==R.id.Seven){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 7*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 7*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 7*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 7*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 7*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 7*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 7*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 7*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 7*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 7*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("7");  c1r2.setText("7");  c1r3.setText("7");  c1r4.setText("7");  c1r5.setText("7");
            c1r6.setText("7");  c1r7.setText("7");  c1r8.setText("7");  c1r9.setText("7");  c1r10.setText("7");

        }
        if(v.getId()==R.id.Eight){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 8*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 8*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 8*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 8*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 8*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 8*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 8*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 8*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 8*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 8*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("8");  c1r2.setText("8");  c1r3.setText("8");  c1r4.setText("8");  c1r5.setText("8");
            c1r6.setText("8");  c1r7.setText("8");  c1r8.setText("8");  c1r9.setText("8");  c1r10.setText("8");

        }
        if(v.getId()==R.id.Nine){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 9*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 9*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 9*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 9*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 9*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 9*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 9*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 9*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 9*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 9*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("9");  c1r2.setText("9");  c1r3.setText("9");  c1r4.setText("9");  c1r5.setText("9");
            c1r6.setText("9");  c1r7.setText("9");  c1r8.setText("9");  c1r9.setText("9");  c1r10.setText("9");

        }
        if(v.getId()==R.id.Ten){
            int result;
            String fi = "";String se = "",th = "",fo = "",fiv = "",si = "",sev = "",ei = "",ni = "",te = "";

            temp = 10*1;
            fi = Integer.toString(temp);
            c5r1.setText(fi);
            temp = 10*2;
            se = Integer.toString(temp);
            c5r2.setText(se);
            temp = 10*3;
            th = Integer.toString(temp);
            c5r3.setText(th);
            temp = 10*4;
            fo = Integer.toString(temp);
            c5r4.setText(fo);
            temp = 10*5;
            fiv = Integer.toString(temp);
            c5r5.setText(fiv);
            temp = 10*6;
            si = Integer.toString(temp);
            c5r6.setText(si);
            temp = 10*7;
            sev = Integer.toString(temp);
            c5r7.setText(sev);
            temp = 10*8;
            ei = Integer.toString(temp);
            c5r8.setText(ei);
            temp = 10*9;
            ni = Integer.toString(temp);
            c5r9.setText(ni);
            temp = 10*10;
            te = Integer.toString(temp);
            c5r10.setText(te);
            c1r1.setText("10");  c1r2.setText("10");  c1r3.setText("10");  c1r4.setText("10");  c1r5.setText("10");
            c1r6.setText("10");  c1r7.setText("10");  c1r8.setText("10");  c1r9.setText("10");  c1r10.setText("10");

        }
    }

    public void textClick(View v){

        if(v.getId()==R.id.C1r1){

            String toSpeak = "";
            toSpeak+=c1r1.getText().toString();
            toSpeak+="times, 1 is, ";
            toSpeak+=c5r1.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r2){

            String toSpeak = "";
            toSpeak+=c1r2.getText().toString();
            toSpeak+="times, 2 is, ";
            toSpeak+=c5r2.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r3){

            String toSpeak = "";
            toSpeak+=c1r3.getText().toString();
            toSpeak+="times, 3 is, ";
            toSpeak+=c5r3.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r4){

            String toSpeak = "";
            toSpeak+=c1r4.getText().toString();
            toSpeak+="times, 4 is, ";
            toSpeak+=c5r4.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r5){

            String toSpeak = "";
            toSpeak+=c1r5.getText().toString();
            toSpeak+="times, 5 is, ";
            toSpeak+=c5r5.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r6){

            String toSpeak = "";
            toSpeak+=c1r6.getText().toString();
            toSpeak+="times, 6 is, ";
            toSpeak+=c5r6.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r7){

            String toSpeak = "";
            toSpeak+=c1r7.getText().toString();
            toSpeak+="times, 7 is, ";
            toSpeak+=c5r7.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r8){

            String toSpeak = "";
            toSpeak+=c1r8.getText().toString();
            toSpeak+="times, 8 is, ";
            toSpeak+=c5r8.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r9){

            String toSpeak = "";
            toSpeak+=c1r9.getText().toString();
            toSpeak+="times, 9 is, ";
            toSpeak+=c5r9.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
        if(v.getId()==R.id.C1r10){

            String toSpeak = "";
            toSpeak+=c1r10.getText().toString();
            toSpeak+="times, 10 is, ";
            toSpeak+=c5r10.getText().toString();
            Toast.makeText(getApplicationContext(), toSpeak,Toast.LENGTH_SHORT).show();
            tt1.speak(toSpeak,TextToSpeech.QUEUE_FLUSH, null);
            //tt1.speak(toSpeak,TextToSpeech.QUEUE_ADD,null,null);
        }
    }


    public void onPause(){
        if(tt1 !=null){
            tt1.stop();
            tt1.shutdown();
        }
        super.onPause();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            final AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            builder.setMessage("This is a little app of multiplication table for all specially for kids!! Initialy multiplication table of 1 to 10 are given but you can get table of any number by clicking the bottom-corner floating (pink)button!! And you can hear the quality sound for table read by software.");
            builder.setCancelable(true);

            builder.setPositiveButton("GOT IT!", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog alertDialog = builder.create();
            alertDialog.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
