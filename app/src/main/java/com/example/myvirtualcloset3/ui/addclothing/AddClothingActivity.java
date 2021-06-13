package com.example.myvirtualcloset3.ui.addclothing;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Clothing;
import com.example.myvirtualcloset3.data.VeriKaynagi;

import java.io.ByteArrayOutputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import static java.security.AccessController.getContext;

public class AddClothingActivity extends AppCompatActivity {

    private Button buttonAdd;
    private EditText clothesName;
    private EditText clothesColor;
    private EditText clothesTexture;
    private EditText buyDateEditText;
    private EditText clothesPrice;
    private EditText clothesType;
    private EditText clothesDrawerName;
    private Clothing clothing;
    private ImageView clothesImageView;

    private boolean isDateSet = false;
    private String buyDate;

    private VeriKaynagi veriKaynagi;
    public byte[] getImageFromImageView(ByteArrayOutputStream baos, Bitmap bitmap){
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();
        return  data;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_clothing);
        veriKaynagi = new VeriKaynagi(getApplication());
        veriKaynagi.open();
        clothing = new Clothing();


        buttonAdd = findViewById(R.id.btnAdd);
        clothesImageView = findViewById(R.id.ClothesImage);
        clothesName = findViewById(R.id.ClothesName);
        clothesColor = findViewById(R.id.ClothesColor);
        clothesTexture = findViewById(R.id.ClothesTexture);
        clothesDrawerName = findViewById(R.id.ClothesDrawerName);
        clothesPrice = findViewById(R.id.ClothesPrice);
        clothesType = findViewById(R.id.ClothesType);




        ActivityResultLauncher<String> mGetContent = registerForActivityResult(new ActivityResultContracts.GetContent(),
                new ActivityResultCallback<Uri>() {
                    @Override
                    public void onActivityResult(Uri uri) {
                        clothesImageView.setImageURI(uri);
                        clothesImageView.setDrawingCacheEnabled(true);
                        clothesImageView.buildDrawingCache();
                        Bitmap bitmap = ((BitmapDrawable) clothesImageView.getDrawable()).getBitmap();
                        ByteArrayOutputStream baos = new ByteArrayOutputStream();
                        byte[] data = getImageFromImageView(baos,bitmap);
                        clothing.setImage(data);

                    }
                });

        clothesImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mGetContent.launch("image/*");
            }
        });
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    if(clothesDrawerName.getText().toString().trim().equals("")){
                        Toast.makeText(getApplicationContext(),"Lütfen Eklemek İstediğiniz Çekmecenin Adını Giriniz",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        int drawerID = veriKaynagi.getDrawerIdByName(clothesDrawerName.getText().toString().trim());
                        if(drawerID == -1){
                            Toast.makeText(getApplicationContext(),"Lütfen Mevcut Çekmecelerden Birinin Adını giriniz",Toast.LENGTH_SHORT).show();
                        }
                        else{

                             clothing.setName(clothesName.getText().toString().trim());
                             clothing.setColor(clothesColor.getText().toString().trim());
                             clothing.setType(clothesType.getText().toString().trim());
                              clothing.setTexture(clothesTexture.getText().toString().trim());
                              clothing.setPrice(Float.parseFloat(clothesPrice.getText().toString().trim()));

                            clothing.setDrawerID(drawerID);
                            veriKaynagi.createClothing(clothing);
                            Toast.makeText(getApplicationContext(),"Kıyafet Eklendi",Toast.LENGTH_SHORT).show();
                        }

                    }





            }
        });
    }

}