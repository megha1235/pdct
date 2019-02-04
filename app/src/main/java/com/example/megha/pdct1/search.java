package com.example.megha.pdct1;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity {
    dbhelper dbhelper5;
    EditText e1,e2,e3,e4,e5,e6,e7;
    Button b1,b2,b3;
    String s1,s2,s3,s4,s5,s6,s7,id,update1,update2,update3,update4,update5,update6;
    TextView a,b,c,d,e,f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        final dbhelper dbhelper5;
        dbhelper5=new dbhelper(this);
        dbhelper5.getWritableDatabase();
        e1=(EditText)findViewById(R.id.nm);
        e2=(EditText)findViewById(R.id.ed);
        e3=(EditText)findViewById(R.id.ed1);
        e4=(EditText)findViewById(R.id.ed2);
        e5=(EditText)findViewById(R.id.ed3);
        e6=(EditText)findViewById(R.id.ed4);
        e7=(EditText)findViewById(R.id.ed5);
        a=(TextView) findViewById(R.id.s1);
        b=(TextView) findViewById(R.id.s2);
        c=(TextView) findViewById(R.id.s3);
        d=(TextView) findViewById(R.id.s4);
        e=(TextView) findViewById(R.id.s5);
        f=(TextView) findViewById(R.id.s6);
        b3=(Button)findViewById(R.id.dlt);



        b1=(Button)findViewById(R.id.sr);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                Cursor cur=dbhelper5.searchdata(s1);
                if (cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no result",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        id=cur.getString(0);
                        s2=cur.getString(2);
                        s3=cur.getString(3);
                        s4=cur.getString(4);
                        s5=cur.getString(5);
                        s6=cur.getString(6);
                        s7=cur.getString(7);
                        //Toast.makeText(getApplicationContext(),s2,Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),s3,Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),s4,Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),s5,Toast.LENGTH_LONG).show();
                        //Toast.makeText(getApplicationContext(),s6,Toast.LENGTH_LONG).show();
                       // Toast.makeText(getApplicationContext(),s7,Toast.LENGTH_LONG).show();

                    }
                    e2.setVisibility(View.VISIBLE);
                    e2.setText(s2);
                    e3.setVisibility(View.VISIBLE);
                    e3.setText(s3);
                    e4.setVisibility(View.VISIBLE);
                    e4.setText(s4);
                    e5.setVisibility(View.VISIBLE);
                    e5.setText(s5);
                    e6.setVisibility(View.VISIBLE);
                    e6.setText(s6);
                    e7.setVisibility(View.VISIBLE);
                    e7.setText(s7);
                    a.setVisibility(View.VISIBLE);

                    b.setVisibility(View.VISIBLE);

                    c.setVisibility(View.VISIBLE);

                    d.setVisibility(View.VISIBLE);

                    e.setVisibility(View.VISIBLE);

                    f.setVisibility(View.VISIBLE);
                    b2.setVisibility(View.VISIBLE);

                }



            }
        });
        b2=(Button)findViewById(R.id.up);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                update1=e2.getText().toString();
                update2=e3.getText().toString();
                update3=e4.getText().toString();
                update4=e5.getText().toString();
                update5=e6.getText().toString();
                update6=e7.getText().toString();
                boolean status=dbhelper5.updatedata(id,update1,update2,update3,update4,update5,update6);
                if (status==true)
                {
                    Toast.makeText(getApplicationContext(),"UPDATE",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                }

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean status=dbhelper5.dlt(id);
                {
                    if (status==true)
                    {
                        Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(),"failed",Toast.LENGTH_LONG).show();
                    }

                }
            }
        });


    }
}
