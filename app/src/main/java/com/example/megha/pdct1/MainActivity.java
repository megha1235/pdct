package com.example.megha.pdct1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1,b2;
    String s1,s2,s3,s4,s5,s6,s7;
    dbhelper dbhelper4;
    dbhelper dbhelper5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.nm);
        e2=(EditText)findViewById(R.id.rn);
        e3=(EditText)findViewById(R.id.ano);
        e4=(EditText)findViewById(R.id.clg);
        e5=(EditText)findViewById(R.id.DS);
        e6=(EditText)findViewById(R.id.SAL);
        e7=(EditText)findViewById(R.id.CMP);
        b1=(Button)findViewById(R.id.subm);
        b2=(Button)findViewById(R.id.sr);
        dbhelper4=new dbhelper(this);
        dbhelper4.getWritableDatabase();
        dbhelper5=new dbhelper(this);
        dbhelper5.getWritableDatabase();
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                Log.d("name",s1);
                Log.d("nam",s2);
                Log.d("na",s3);
                Log.d("n",s4);
                Log.d("ame",s5);
                Log.d("me",s6);
                Log.d("e",s7);
                boolean status=dbhelper4.insertdata(s1,s2,s3,s4,s5,s6,s7);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"inserted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent f=new Intent(getApplicationContext(),search.class);
                startActivity(f);

            }
        });

    }
}
