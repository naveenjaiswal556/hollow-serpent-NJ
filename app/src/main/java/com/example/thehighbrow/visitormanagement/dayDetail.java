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

public class dayDetail extends AppCompatActivity {


    EditText name;
    EditText contact;
    EditText email;
    EditText gst;
    EditText invoice;
    DatabaseReference databaseVisitor;
    TextView submit;
    Calendar calendar;
    String photoUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_detail);

        Intent intent = getIntent();
        photoUrl = intent.getStringExtra("photourl");

        gst=findViewById(R.id.gstfield);
        invoice = findViewById(R.id.invoicefield);
        name=findViewById(R.id.namefield);
        contact=findViewById(R.id.contactfield);
        email=findViewById(R.id.emailfield);
        databaseVisitor = FirebaseDatabase.getInstance().getReference("dayVisitor");

        submit=findViewById(R.id.proceedBtn);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDayVisitor();
            }
        });
    }

    private void addDayVisitor()
    {
        String dname = name.getText().toString().trim();
        String dcontact = contact.getText().toString().trim();
        String demail = email.getText().toString().trim();
        String dgst = gst.getText().toString().trim();
        String dinvoice = invoice.getText().toString().trim();
        if (!TextUtils.isEmpty(dname) && !TextUtils.isEmpty(dcontact) && !TextUtils.isEmpty(demail))
        {
            String id = databaseVisitor.push().getKey();

            Date d=new Date();
            SimpleDateFormat sdf=new SimpleDateFormat("hh:mm a");
            String currentDateTimeString = sdf.format(d);

            String Date = DateFormat.getDateInstance(DateFormat.DATE_FIELD).format(new Date()).toString();
            Log.e("visitorDetail", "addVisitor: TIME = "+currentDateTimeString+"DATE = "+Date);
//            Visitor visitor = new Visitor(dname,dcontact,dhost,photoUrl);
            DayVisitor dayVisitor = new DayVisitor(dname,dcontact,demail,dgst,dinvoice,photoUrl);

//            databaseVisitor.child(id).setValue(visitor);
            databaseVisitor.child(id).setValue(dayVisitor);

            Toast.makeText(this, "Visitor Registered", Toast.LENGTH_SHORT).show();
            Intent intent= new Intent(dayDetail.this,Welcome.class);
            intent.putExtra("vname",dname);
            startActivity(intent);
        }
        else
        {
            Toast.makeText(this, "All Fields Mandatory", Toast.LENGTH_LONG).show();
        }
    }
}
