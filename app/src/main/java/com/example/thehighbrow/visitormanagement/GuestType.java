package com.example.thehighbrow.visitormanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;

public class GuestType extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_type);


        CardView visitorcard = findViewById(R.id.visitor_card);
        CardView leadcard = findViewById(R.id.lead_card);
        CardView vendorcard = findViewById(R.id.vendor_card);
        CardView daycard = findViewById(R.id.day_card);

        visitorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestType.this,visitorActivity.class));
            }
        });

        leadcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestType.this,leadActivity.class));
            }
        });

        daycard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestType.this,dayActivity.class));
            }
        });

        vendorcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GuestType.this,vendorActivity.class));
            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(GuestType.this,MainActivity.class);
        intent.putExtra("Visitor","visitorEnd");
        startActivity(intent);
    }
}
