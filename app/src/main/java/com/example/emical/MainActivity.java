package com.example.emical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
     EditText e,e1,e2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                e=(EditText)findViewById(R.id.editText);
                e1=(EditText)findViewById(R.id.editText3);
                e2=(EditText)findViewById(R.id.editText4);
                TextView result = (TextView) findViewById(R.id.textView5);
                int amt= Integer.parseInt(e.getText().toString());
                double install=Double.parseDouble(e1.getText().toString());
                double rate=Double.parseDouble(e2.getText().toString());
                double r=calEmi(amt,install,rate);
                System.out.println("CALCULATED EMI IS:");
                result.setText(String.valueOf(r));
            }
        });
    }
    public double calEmi(int amt,double install,double rate)
    {
        double r=rate;
        r=rate/(12*100);
        double emi=(amt*r*Math.pow((1+r),install)/(Math.pow((1+r),(install))-1));
        return emi;
    }
}
