package com.example.myvirtualcloset3.ui.clothingDetails;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Clothing;
import com.example.myvirtualcloset3.data.VeriKaynagi;

public class ClothingDetailActivity extends AppCompatActivity {
    private Button buttonAdd;
    private TextView clothesName;
    private TextView clothesColor;
    private TextView clothesTexture;

    private TextView clothesPrice;
    private TextView clothesType;

    private Button btnDeleteClothes;
    private ImageView clothesImageView;
    private  Clothing cloth;
    private boolean isDateSet = false;
    private String buyDate;

    private VeriKaynagi veriKaynagi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clothing_detail);

        Bundle intentBundle = getIntent().getExtras();
        veriKaynagi = new VeriKaynagi(getApplication());
        veriKaynagi.open();
        buttonAdd = findViewById(R.id.btnAdd);
        clothesImageView = findViewById(R.id.ClothesImageViewer);
        clothesName = findViewById(R.id.ClothesNameViewer);
        clothesColor = findViewById(R.id.ClothesColorViewer);
        clothesTexture = findViewById(R.id.ClothesTextureViewer);

        clothesPrice = findViewById(R.id.ClothesPriceViewer);
        clothesType = findViewById(R.id.ClothesTypeViewer);
        btnDeleteClothes = findViewById(R.id.btnKiyafetSil);
        int clothingId;

        if(intentBundle != null){
           clothingId= intentBundle.getInt("clothing");
          cloth= veriKaynagi.getClothingById(clothingId);
          if(cloth.getImage() !=null){
              Bitmap bitmap = BitmapFactory.decodeByteArray(cloth.getImage(),0,cloth.getImage().length);
              clothesImageView.setImageBitmap(bitmap);
          }

            clothesName.setText(cloth.getName());
            clothesColor.setText(cloth.getColor());
            clothesTexture.setText(cloth.getTexture());
            clothesPrice.setText(String.valueOf(cloth.getPrice()));
            clothesType.setText(cloth.getType());

        }
        btnDeleteClothes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ClothingDetailActivity.this);
                builder.setTitle("Uyarı!!!");
                builder.setMessage("Resmi silmek istediğinize emin misiniz?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        int result= veriKaynagi.deleteClothesImage(cloth);;
                        if(result>0){
                            int id = getResources().getIdentifier("com.example.myvirtualcloset3:drawable/ic_baseline_no_photography_24", null, null);
                            clothesImageView.setImageResource(id);
                            Toast.makeText(ClothingDetailActivity.this, "Resim Silindi ", Toast.LENGTH_SHORT).show();

                        }else{
                            Toast.makeText(ClothingDetailActivity.this, "Resim silinirken hata oluştu ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Hayır",null);
                builder.show();



            }
        });







    }
}