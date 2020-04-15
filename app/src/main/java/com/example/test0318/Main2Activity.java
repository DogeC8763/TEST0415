package com.example.test0318;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Bundle bundle = this.getIntent( ).getExtras( );
        String h = bundle.getString("height");
        String w = bundle.getString("weight");
        String n = bundle.getString("name");

        public void NEXT(View view){
            String h = height.getText( ).toString( );
            String w = weight.getText( ).toString( );
            String name1 = name.getText( ).toString( );
            Bundle bundle = new Bundle( );
            bundle.putString("height",h);
            bundle.putString("weight",w);
            bundle.putString("name",name1);

            Intent intent = new Intent( this, Main2Activity.class);
            startActivity(intent);
    }
}
