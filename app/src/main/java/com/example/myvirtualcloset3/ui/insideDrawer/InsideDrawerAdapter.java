package com.example.myvirtualcloset3.ui.insideDrawer;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Clothing;
import com.example.myvirtualcloset3.data.VeriKaynagi;
import com.example.myvirtualcloset3.ui.addclothing.AddClothingActivity;
import com.example.myvirtualcloset3.ui.clothingDetails.ClothingDetailActivity;

import java.util.ArrayList;

public class InsideDrawerAdapter extends RecyclerView.Adapter<InsideDrawerAdapter.MyViewHolder> {
    ArrayList<Clothing> mClothingList;
    LayoutInflater inflater;
    Context mContext;
    public InsideDrawerAdapter(Context context, ArrayList<Clothing> clothings) {
        mContext= context;
        inflater = LayoutInflater.from(context);
        this.mClothingList = clothings;
    }



    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_inside_drawer_view, parent, false);
        InsideDrawerAdapter.MyViewHolder holder = new InsideDrawerAdapter.MyViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(InsideDrawerAdapter.MyViewHolder holder, int position) {
        Clothing selectedClothing = mClothingList.get(position);
        holder.setData(selectedClothing, position);
        holder.clothing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, ClothingDetailActivity.class);
                intent.putExtra("clothing",mClothingList.get(position).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }
        });
        holder.btnSil.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
                builder.setTitle("Uyarı!!!");
                builder.setMessage("Ürünü silmek istediğinize emin misiniz?");
                builder.setIcon(android.R.drawable.ic_menu_delete);
                builder.setCancelable(false);
                builder.setPositiveButton("Evet", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VeriKaynagi veriKaynagi = new VeriKaynagi(mContext);
                        veriKaynagi.open();
                        int result=veriKaynagi.urunSil(selectedClothing.getId());
                        if(result>0){
                            Toast.makeText(mContext, "Ürün Silindi ", Toast.LENGTH_SHORT).show();
                            mClothingList.remove(selectedClothing);
                            notifyDataSetChanged();
                        }else{
                            Toast.makeText(mContext, "Ürün silinirken hata oluştu ", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                builder.setNegativeButton("Hayır",null);
                builder.show();
            }
        });

    }


    public int getItemCount() {
        return mClothingList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //ImageView drawerImage;
        ImageView clothing = itemView.findViewById(R.id.drawerImageView);
        Button btnSil = itemView.findViewById(R.id.btnSil);
        public MyViewHolder(View itemView) {
            super(itemView);

        }

        public void setData(Clothing selectedClothing, int position) {

            //this.drawerImage.setImageResource(selectedDrawer.getClothes().get(0).getPhotoId());
            if(selectedClothing.getImage() == null){

            }
            else{
                Bitmap bitmap = BitmapFactory.decodeByteArray(selectedClothing.getImage(),0,selectedClothing.getImage().length);
                this.clothing.setImageBitmap(bitmap);
            }


        }


        @Override
        public void onClick(View v) {


        }


    }
}