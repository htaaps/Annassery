package com.htlabs.annassery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class MainActivity extends Activity implements View.OnClickListener{
    ImageButton am_ib_emergency,am_ib_education,am_ib_labor,am_ib_business,
            am_ib_hospital,am_ib_blood,am_ib_auto,am_ib_taxi,am_ib_goods,
            am_ib_bus,am_ib_info,am_ib_religion,am_ib_about,am_ib_feedback,am_ib_politics,am_ib_dummy;
    Intent i;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        am_ib_emergency=(ImageButton)findViewById(R.id.am_ib_emergency);
        am_ib_education=(ImageButton)findViewById(R.id.am_ib_education);
        am_ib_labor=(ImageButton)findViewById(R.id.am_ib_labor);
        am_ib_business=(ImageButton)findViewById(R.id.am_ib_business);
        am_ib_hospital=(ImageButton)findViewById(R.id.am_ib_hospital);
        am_ib_blood=(ImageButton)findViewById(R.id.am_ib_blood);
        am_ib_auto=(ImageButton)findViewById(R.id.am_ib_auto);
        am_ib_taxi=(ImageButton)findViewById(R.id.am_ib_taxi);
        am_ib_goods=(ImageButton)findViewById(R.id.am_ib_goods);
        am_ib_bus=(ImageButton)findViewById(R.id.am_ib_bus);
        am_ib_info=(ImageButton)findViewById(R.id.am_ib_info);
        am_ib_religion=(ImageButton)findViewById(R.id.am_ib_religion);
        am_ib_about=(ImageButton)findViewById(R.id.am_ib_about);
        am_ib_feedback=(ImageButton)findViewById(R.id.am_ib_feedback);
        am_ib_politics=(ImageButton)findViewById(R.id.am_ib_politics);
        am_ib_dummy=(ImageButton)findViewById(R.id.am_ib_dummy);


        am_ib_education.setOnClickListener(this);
        am_ib_emergency.setOnClickListener(this);
        am_ib_labor.setOnClickListener(this);
        am_ib_business.setOnClickListener(this);
        am_ib_hospital.setOnClickListener(this);
        am_ib_blood.setOnClickListener(this);
        am_ib_auto.setOnClickListener(this);
        am_ib_taxi.setOnClickListener(this);
        am_ib_goods.setOnClickListener(this);
        am_ib_bus.setOnClickListener(this);
        am_ib_info.setOnClickListener(this);
        am_ib_religion.setOnClickListener(this);
        am_ib_about.setOnClickListener(this);
        am_ib_feedback.setOnClickListener(this);
        am_ib_politics.setOnClickListener(this);
        am_ib_dummy.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.am_ib_emergency:
                i= new Intent(MainActivity.this,EmergencyActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_education:
                i= new Intent(MainActivity.this,EducationActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_labor:
                i= new Intent(MainActivity.this,LaborActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_business:
                i= new Intent(MainActivity.this,BusinessActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_hospital:
                i= new Intent(MainActivity.this,HospitalActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_blood:
                i= new Intent(MainActivity.this,BloodActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_auto:
                i= new Intent(MainActivity.this,AutoActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_taxi:
                i= new Intent(MainActivity.this,TaxiActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_goods:
                i= new Intent(MainActivity.this,GoodsActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_bus:
                i= new Intent(MainActivity.this,BusActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_info:
                i= new Intent(MainActivity.this,InfoActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_religion:
                i= new Intent(MainActivity.this,ReligionActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_feedback:
                i= new Intent(MainActivity.this,FeedbackActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_politics:
                i= new Intent(MainActivity.this,PoliticsActivity.class);
                startActivity(i);
                break;
            case R.id.am_ib_dummy:
                i= new Intent(MainActivity.this,DummyActivity.class);
                startActivity(i);
                break;
        }
    }
}
