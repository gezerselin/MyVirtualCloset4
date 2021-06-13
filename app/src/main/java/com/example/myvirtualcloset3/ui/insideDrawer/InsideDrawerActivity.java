package com.example.myvirtualcloset3.ui.insideDrawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Clothing;
import com.example.myvirtualcloset3.data.VeriKaynagi;
import com.example.myvirtualcloset3.ui.addclothing.AddClothingActivity;

public class InsideDrawerActivity extends AppCompatActivity {
    private  RecyclerView recyclerView;
    private  VeriKaynagi veriKaynagi;
    private Button butn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inside_drawer);
        recyclerView = (RecyclerView) findViewById(R.id.inside_drawer_view);
        Intent intent = getIntent();
        int drawerID = intent.getExtras().getInt("drawerID");
        veriKaynagi = new VeriKaynagi(getApplicationContext());
        veriKaynagi.open();
        InsideDrawerAdapter insideDrawerAdapter = new InsideDrawerAdapter(this, veriKaynagi.getClothingByDrawerId(drawerID));
        butn = findViewById(R.id.btnAddClothes);
        butn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), AddClothingActivity.class));
            }
        });

        recyclerView.setAdapter(insideDrawerAdapter);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),2);

        recyclerView.setLayoutManager(gridLayoutManager);
    }
}