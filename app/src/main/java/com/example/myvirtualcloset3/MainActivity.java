package com.example.myvirtualcloset3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.myvirtualcloset3.ui.EventActivity;
import com.example.myvirtualcloset3.ui.EventListActivity;
import com.example.myvirtualcloset3.ui.addclothing.AddClothingActivity;
import com.example.myvirtualcloset3.ui.drawer.DrawerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button kombinBtn = findViewById(R.id.btnCombines);
        Button cabineBtn = findViewById(R.id.btnCabine);
        Button addClothing = findViewById(R.id.btnClothingAdd);
        Button drawersBtn = findViewById(R.id.btnDrawers);
        kombinBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(), AddClothingActivity.class);
//                startActivity(intent);
            }
        });
        addClothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AddClothingActivity.class);
                startActivity(intent);
            }
        });
        drawersBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), DrawerActivity.class);
                startActivity(intent);
            }
        });
        cabineBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), EventListActivity.class);
                startActivity(intent);
            }
        });

    }
}