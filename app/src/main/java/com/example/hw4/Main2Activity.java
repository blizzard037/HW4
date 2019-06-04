package com.example.hw4;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

public class Main2Activity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tvResult=(TextView)findViewById(R.id.tvResult);
        showResults();
    }

    private void showResults(){
        NumberFormat nf=NumberFormat.getNumberInstance();
        Bundle bundle=getIntent().getExtras();
        int programming =bundle.getInt("programming");
        int dataStructure =bundle.getInt("dataStructure");
        int algorithm =bundle.getInt("algorithm");
        int sum =programming+dataStructure+algorithm;
        double average =sum/3.0;
        String text="programming="+programming+
                "\ndataStructure="+dataStructure+
                "\nalgorithm="+algorithm+
                "\nsum="+sum+
                "\naverage="+nf.format(average);
        tvResult.setText(text);
        alert(average);
    }

    private void alert(double average){
        String message = new String();
        String title = new String();
        //int pic=0;

        if(average==100){
            message="100";
            title="Pass";
            //pic=R.drawable.circle;
        }
        else if(average>=60){
            message="Congratulation!!";
            title="Pass";
            //pic=R.drawable.circle;
        }
        else{
            message="GG";
            title="GG";
        }

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setMessage(message);
        builder.setTitle(title);
        builder.setPositiveButton("OK",null);
        builder.setNegativeButton("Cancel",null);
        builder.setNeutralButton("Nothing",null);
        builder.show();
    }
    public void BackOnClick(View view){finish();}
}