package com.example.myvirtualcloset3.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.VeriKaynagi;
import com.example.myvirtualcloset3.ui.drawer.DrawerAdapter;
import com.example.myvirtualcloset3.ui.drawer.DrawerViewModel;

public class EventListActivity extends AppCompatActivity {
    private DrawerViewModel drawerViewModel;
    private RecyclerView recyclerView;
    private Button addDrawerButton;
    private VeriKaynagi veriKaynagi;
    private EditText addDrawerText;
    private int clickPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_list);
        veriKaynagi = new VeriKaynagi(getApplicationContext());
        veriKaynagi.open();
        recyclerView = findViewById(R.id.event_view);
        addDrawerButton= findViewById(R.id.addDrawerBtn);
        addDrawerText = findViewById(R.id.addDrawerEditText);
        EventListAdapter eventListAdapter = new EventListAdapter(getApplicationContext(), veriKaynagi.getAllEvents());
        recyclerView.setAdapter(eventListAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        Button etkinlikEkle = findViewById(R.id.addEventBtn);
        etkinlikEkle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),EventActivity.class);
                startActivity(intent);
            }
        });
    }
}