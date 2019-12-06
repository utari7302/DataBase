package com.samt.animationenemies;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class DataBaseView extends AppCompatActivity {
    TextView tvView;
    SQLiteDataBase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_base_view2);
        tvView=(TextView) findViewById(R.id.tvview);
        db=new SQLiteDataBase(this);
        String data=db.getData();
        tvView.setText(data);
    }
}
