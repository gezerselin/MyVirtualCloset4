package com.example.myvirtualcloset3.ui.drawer;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Drawer;
import com.example.myvirtualcloset3.data.VeriKaynagi;
import com.example.myvirtualcloset3.databinding.ActivityDrawerBinding;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class DrawerActivity extends AppCompatActivity {
    private DrawerViewModel drawerViewModel;
    private RecyclerView recyclerView;
    private Button addDrawerButton;
    private VeriKaynagi veriKaynagi;
    private EditText addDrawerText;
    private int clickPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);
        drawerViewModel =
                new ViewModelProvider(this).get(DrawerViewModel.class);

        veriKaynagi = new VeriKaynagi(getApplicationContext());
        veriKaynagi.open();
        recyclerView = findViewById(R.id.drawer_view);
        addDrawerButton= findViewById(R.id.addDrawerBtn);
        addDrawerText = findViewById(R.id.addDrawerEditText);
        DrawerAdapter drawerAdapter = new DrawerAdapter(getApplicationContext(), veriKaynagi.getAllDrawers());
        recyclerView.setAdapter(drawerAdapter);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        addDrawerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawer drawer = new Drawer();
                if(addDrawerText.getText().toString().trim().equals("")  ){
                    Toast.makeText(getApplicationContext(),"Lütfen Çekmece Adı Giriniz",Toast.LENGTH_SHORT).show();
                }
                else{
                  int drawerID = veriKaynagi.getDrawerIdByName(addDrawerText.getText().toString().trim());
                    if(drawerID == -1){
                        drawer.setName(addDrawerText.getText().toString().trim());
                        veriKaynagi.createDrawer(drawer);
                        Toast.makeText(getApplicationContext(),"Çekmece Eklendi",Toast.LENGTH_SHORT);
                        drawerAdapter.updateItems(veriKaynagi.getAllDrawers());
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Girmiş Olduğunuz isimde bir çekmece mevcuttur. Lütfen ismini değiştirin",Toast.LENGTH_SHORT).show();
                    }

                }

            }
        });
    }
}