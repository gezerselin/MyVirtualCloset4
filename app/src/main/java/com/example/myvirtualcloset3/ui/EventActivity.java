package com.example.myvirtualcloset3.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Event;
import com.example.myvirtualcloset3.data.VeriKaynagi;

public class EventActivity extends AppCompatActivity {
    private Button buttonAdd;
    private EditText eventName;
    private EditText eventType;
    private EditText eventLocation;
    private EditText eventDate;
    private Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        event = new Event();
        setContentView(R.layout.activity_event);
        VeriKaynagi veriKaynagi = new VeriKaynagi(getApplicationContext());
        veriKaynagi.open();
        eventName=findViewById(R.id.EventName);
        eventType = findViewById(R.id.EventType);
        eventLocation = findViewById(R.id.EventLocation);
        eventDate = findViewById(R.id.EventDate);
        buttonAdd = findViewById(R.id.btnAddEvent);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                event.setName(eventName.getText().toString().trim());
                event.setDate(eventDate.getText().toString().trim());
                event.setLocation(eventLocation.getText().toString().trim());
                event.setType(eventType.getText().toString().trim());
                veriKaynagi.createEvent(event);
                Toast.makeText(EventActivity.this,"Etkinlik Eklendi",Toast.LENGTH_SHORT);
                startActivity(new Intent(getApplicationContext(),EventListActivity.class));
            }
        });


    }
}