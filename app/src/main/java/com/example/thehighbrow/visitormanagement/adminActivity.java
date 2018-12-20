package com.example.thehighbrow.visitormanagement;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class adminActivity extends AppCompatActivity {

    RecyclerView recyclerView ;
    RecyclerView.Adapter adapter;
    DatabaseReference databaseVisitor;
    ArrayList<Visitor>visitors = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        Toast.makeText(getApplicationContext(),"sFound",Toast.LENGTH_SHORT).show();

        databaseVisitor = FirebaseDatabase.getInstance().getReference("visitor");
        //databaseVisitor = FirebaseDatabase.getInstance().getReference("photos");
        recyclerView= findViewById(R.id.recyclerView);




 //       Visitor visitor = new Visitor("","","","");
  //      visitors.add(visitor);

        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        LinearLayoutManager mlm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(mlm);
        mlm.setReverseLayout(true);
        mlm.setStackFromEnd(true);
        adapter=new VisitorAdapter(visitors);
        recyclerView.setAdapter(adapter);
        /*databaseVisitor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot visitorSnapshot : dataSnapshot.getChildren() ){
                    Visitor visitor = visitorSnapshot.getValue(Visitor.class);
                    visitors.add(visitor);
                    Log.e("MainActivity", "onDataChange: added visitor to visitors");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(adminActivity.this, "Problem fetching databse", Toast.LENGTH_SHORT).show();

            }
        });
*/
    }

    @Override
    protected void onStart() {
        super.onStart();
        databaseVisitor.addValueEventListener(new ValueEventListener() {



            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot visitorSnapshot : dataSnapshot.getChildren() ){
                    Visitor visitor = visitorSnapshot.getValue(Visitor.class);
                    visitors.add(visitor);
                    adapter.notifyDataSetChanged();

                    //recreate();
                    Log.e("MainActivity", "onDataChange: added visitor to visitors");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(adminActivity.this, "Problem fetching databse", Toast.LENGTH_SHORT).show();

            }
        });

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(adminActivity.this,MainActivity.class);
        intent.putExtra("Visitor","adminEnd");
        startActivity(intent);
    }
    /*@Override
    protected void onResume() {
        super.onResume();
        databaseVisitor.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {


                for (DataSnapshot visitorSnapshot : dataSnapshot.getChildren() ){
                    Visitor visitor = visitorSnapshot.getValue(Visitor.class);
                    visitors.add(visitor);
                    Log.e("MainActivity", "onDataChange: added visitor to visitors");

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(adminActivity.this, "Problem fetching databse", Toast.LENGTH_SHORT).show();

            }
        });
    }*/
}
