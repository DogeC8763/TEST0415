package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private EditText height;
    private EditText weight;
    private TextView b;
    private ImageView view1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.ed_name);
        height = (EditText) findViewById(R.id.ed_height);
        weight = (EditText) findViewById(R.id.ed_weight);
        b = findViewById(R.id.tv_sowebmi);
        view1 = (ImageView) findViewById(R.id.imageView2);


    }

    public void Show(View view) {
     weight.addTextChangedListener(new TextWatcher() {
         @Override
         public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

         }

         @Override
         public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

         }

         @Override
         public void afterTextChanged(Editable editable) {

         }
     });
        String h = height.getText().toString();
        String w = weight.getText().toString();
        double bmi = Double.parseDouble(w)/(Double.parseDouble(h)/100*Double.parseDouble(h)/100);
        b.setText(String.valueOf(bmi));
        DecimalFormat df = new DecimalFormat ( "#.##" );

        String msg="";
        if (bmi<18.5){
            msg="過輕";
            view1. setImageResource(R.drawable.a1);
        }else if (bmi>25) {
            msg="過重";
            view1. setImageResource(R.drawable.a2);
        }else {
            msg="標準";
            view1. setImageResource(R.drawable.a3);
        }
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        b.setText(name.getText( ).toString( )+"您的BMI是"+df.format(bmi));
    }

    public void NEXT(View view){
    String h = height.getText( ).toString( );
    String w = weight.getText( ).toString( );
    String name1 = name.getText( ).toString( );
    Bundle bundle = new Bundle( );
    bundle.putString("height",h);
    bundle.putString("weight",w);
    bundle.putString("name",name1);

    Intent intent = new Intent( this, Main2Activity.class);
    intent.putExtras(bundle);
    startActivity(intent);
}
}