package com.example.thehighbrow.visitormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class leadDetail extends AppCompatActivity {


    EditText name;
    EditText contact;
    EditText email;

    EditText reach;
    DatabaseReference databaseVisitor;
    TextView submit;
    Calendar calendar;
    String photoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lead_detail);
        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("photourl");

        reach=findViewById(R.id.reachfield);
        name=findViewById(R.id.namefield);
        contact=findViewById(R.id.contactfield);
        email=findViewById(R.id.emailfield);
        databaseVisitor = FirebaseDatabase.getInstance().getReference("91lead");

        submit=findViewById(R.id.proceedBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addlead();
            }
        });


    }

    private void addlead()
    {
        String dname = name.getText().toString().trim();
        String dcontact = contact.getText().toString().trim();
        String demail = email.getText().toString().trim();
        String dreach = reach.getText().toString().trim();

        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dcontact) && !TextUtils.isEmpty(demail))
        {
            String id = databaseVisitor.push().getKey();

            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
            String currentDateTimeString = sdf.format(d);

            String Date = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date()).toString();
            Log.e("visitorDetail", "addVisitor: TIME = "+currentDateTimeString+"DATE = "+Date);
//            Visitor visitor = new Visitor(dname,dcontact,dhost,photoUrl);
            Lead lead = new Lead(dname,dcontact,demail,dreach,photoUrl);

//            databaseVisitor.child(id).setValue(visitor);
            databaseVisitor.child(id).setValue(lead);

            Toast.makeText(this, "Visitor Registered", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(leadDetail.this,Welcome.class);
            intent.putExtra("vname",dname);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "All Fields Mandatory", Toast.LENGTH_LONG).show();
        }
    }
}
