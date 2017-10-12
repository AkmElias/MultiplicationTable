package com.elias.number_table;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class About extends AppCompatActivity {
    EditText getnumber;
    Button clear,okka;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
        getnumber = (EditText)findViewById(R.id.getNumber);
        clear = (Button)findViewById(R.id.Clear);
        okka = (Button)findViewById(R.id.Okka);

    }
    String nm = "";
    public void OnClick(View v){

        if(v.getId()==R.id.Okka){
            Intent intent = new Intent(About.this,MainActivity.class);
            intent.putExtra("about",getnumber.getText().toString());
            setResult(RESULT_OK, intent);
            finish();
        }
        if(v.getId()==R.id.Clear){
            getnumber.setText("");
            Intent intent = new Intent(About.this,MainActivity.class);
            intent.putExtra("about","clear");
            setResult(RESULT_OK, intent);
            finish();
        }
    }
}
