package com.example.thehighbrow.visitormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class vendorDetail extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    EditText name;
    EditText contact;
    String host;
    Spinner spinner;
    DatabaseReference databaseVisitor;
    TextView submit;
    Calendar calendar;
    String photoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vendor_detail);
        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("photourl");


        spinner = (Spinner) findViewById(R.id.spinner);
        name=findViewById(R.id.namefield);
        contact=findViewById(R.id.contactfield);
        databaseVisitor = FirebaseDatabase.getInstance().getReference("vendor");


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_options, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(vendorDetail.this);

        submit=findViewById(R.id.proceedBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addvendor();
            }
        });



    }

    private void addvendor()
    {
        String dname = name.getText().toString().trim();
        String dcontact = contact.getText().toString().trim();

        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dcontact))
        {
            String id = databaseVisitor.push().getKey();

            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
            String currentDateTimeString = sdf.format(d);

            String Date = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date()).toString();
            Log.e("visitorDetail", "addVisitor: TIME = "+currentDateTimeString+"DATE = "+Date);
//            Visitor visitor = new Visitor(dname,dcontact,dhost,photoUrl);
            Vendor vendor = new Vendor(dname,dcontact,host,photoUrl);

//            databaseVisitor.child(id).setValue(visitor);
            databaseVisitor.child(id).setValue(vendor);

            Toast.makeText(this, "Visitor Registered", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(vendorDetail.this,Welcome.class);
            intent.putExtra("vname",dname);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "All Fields Mandatory", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        TextView spinnerDialogText = (TextView) view;
        host = spinnerDialogText.getText().toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
