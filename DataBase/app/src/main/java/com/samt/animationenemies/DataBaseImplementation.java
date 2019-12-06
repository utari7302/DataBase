package com.samt.animationenemies;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DataBaseImplementation extends AppCompatActivity implements View.OnClickListener {
    EditText ed1,ed2,ed3;
    Button btni,btns,btnv,btnd,btnu;
    SQLiteDataBase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_implementation);

        ed1=(EditText) findViewById(R.id.edit1);
        ed2=(EditText) findViewById(R.id.edit2);
        ed3=(EditText) findViewById(R.id.edit3);

        btni=(Button) findViewById(R.id.btni);
        btns=(Button) findViewById(R.id.btns);
        btnv=(Button) findViewById(R.id.btnv);
        btnd=(Button) findViewById(R.id.btnd);
        btnu=(Button) findViewById(R.id.btnu);
        //context means call reference
        //onclicklistner
        btni.setOnClickListener(this);
        btnv.setOnClickListener(this);
        btns.setOnClickListener(this);
        btnu.setOnClickListener(this);
        btnd.setOnClickListener(this);

        //Context is used to refer the class
        db=new SQLiteDataBase(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.btni:
                boolean fine=true;
                try{
                    String firstname=ed1.getText().toString();
                    String lastname=ed2.getText().toString();
                    db.insertStudent(firstname,lastname);

                }catch (Exception e)
                {
                    fine=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv=new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally{
                    if(fine)
                    {
                        Dialog d=new Dialog(this);
                        d.setTitle("AT LAST WE DID IT");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }

                break;
            case R.id.btnv:
                Intent it=new Intent(getApplicationContext(),DataBaseView.class);
                startActivity(it);

                break;
            case R.id.btns:
                boolean fine1=true;
                try{

                    String id=ed3.getText().toString();
                    long l=Long.parseLong(id);
                    String fname=db.getstudentfirstname(l);
                    String lname=db.getstudentlastname(l);
                    ed1.setText(fname);
                    ed2.setText(lname);

                }catch (Exception e)
                {
                    fine1=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv=new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally{
                    if(fine1)
                    {
                        Dialog d=new Dialog(this);
                        d.setTitle("AT LAST WE DID IT");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }

                break;
            case R.id.btnu:
                boolean fine2=true;
                try{
                    String firstname=ed1.getText().toString();
                    String lastname=ed2.getText().toString();
                    String id=ed3.getText().toString();
                    long l=Long.parseLong(id);
                    db.UpdateStudent(l,firstname,lastname);

                }catch (Exception e)
                {
                    fine2=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv=new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally{
                    if(fine2)
                    {
                        Dialog d=new Dialog(this);
                        d.setTitle("AT LAST WE DID IT");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }

                break;
            case R.id.btnd:
                boolean fine3=true;
                try{

                    String id=ed3.getText().toString();
                    long l=Long.parseLong(id);
                    db.deletestudentname(l);



                }catch (Exception e)
                {
                    fine3=false;
                    String error=e.toString();
                    Dialog d=new Dialog(this);
                    d.setTitle("Sorry");
                    TextView tv=new TextView(this);
                    tv.setText(error);
                    d.setContentView(tv);
                    d.show();
                }
                finally{
                    if(fine3)
                    {
                        Dialog d=new Dialog(this);
                        d.setTitle("AT LAST WE DID IT");
                        TextView tv=new TextView(this);
                        tv.setText("Success");
                        d.setContentView(tv);
                        d.show();
                    }

                }


                break;
        }
    }
}
