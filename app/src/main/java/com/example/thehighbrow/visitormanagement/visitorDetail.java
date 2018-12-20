package com.example.thehighbrow.visitormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class visitorDetail extends AppCompatActivity {

    EditText name;
    EditText contact;
    EditText host;
    DatabaseReference databaseVisitor;
    TextView submit;
    Calendar calendar;
    String photoUrl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visitordetail);

        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("photourl");

        name=findViewById(R.id.namefield);
        contact=findViewById(R.id.contactfield);
        host=findViewById(R.id.hostfield);
        databaseVisitor = FirebaseDatabase.getInstance().getReference("visitor");

        submit=findViewById(R.id.proceedBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addVisitor();
            }
        });

    }

//    public void submitbtn(View view)
//    {
//        addVisitor();
//
//    }



    private void addVisitor()
    {
        String vname = name.getText().toString().trim();
        String vcontact = contact.getText().toString().trim();
        String vhost = host.getText().toString().trim();

        if (!TextUtils.isEmpty(vname) && !TextUtils.isEmpty(vcontact) && !TextUtils.isEmpty(vhost))
            {
            String id = databaseVisitor.push().getKey();

                Date d=new Date();
                SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
                String currentDateTimeString = sdf.format(d);

                String Date = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date()).toString();
                Log.e("visitorDetail", "addVisitor: TIME = "+currentDateTimeString+"DATE = "+Date);
            Visitor visitor = new Visitor(vname,vcontact,vhost,photoUrl);


                databaseVisitor.child(id).setValue(visitor);


            Toast.makeText(this, "Visitor Registered", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(visitorDetail.this,Welcome.class);
            intent.putExtra("vname",vname);
            startActivity(intent);
            }
        else
            {
            Toast.makeText(this, "All Fields Mandatory", Toast.LENGTH_LONG).show();
            }
    }
}