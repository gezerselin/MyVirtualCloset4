package com.example.myvirtualcloset3.ui.drawer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Drawer;
import com.example.myvirtualcloset3.ui.insideDrawer.InsideDrawerActivity;

import java.util.ArrayList;

public class DrawerAdapter extends RecyclerView.Adapter<DrawerAdapter.MyViewHolder> {
    ArrayList<Drawer> mDrawerList;
    LayoutInflater inflater;
    Context mContext;
    public DrawerAdapter(Context context, ArrayList<Drawer> drawers) {
        inflater = LayoutInflater.from(context);
        this.mDrawerList = drawers;
        mContext = context;
    }


    public void updateItems(ArrayList<Drawer> newList) {
        mDrawerList.clear();
        mDrawerList.addAll(newList);
        this.notifyDataSetChanged();
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_drawer_view, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(MyViewHolder holder, int position) {
        Drawer selectedDrawer = mDrawerList.get(position);
        holder.setData(selectedDrawer, position);
        holder.drawer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, InsideDrawerActivity.class);
                intent.putExtra("drawerID",mDrawerList.get(position).getId());
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.getApplicationContext().startActivity(intent);
            }
        });


    }


    public int getItemCount() {
        return mDrawerList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView drawerImage;
        Button drawer = itemView.findViewById(R.id.drawerButton);

        public MyViewHolder(View itemView) {
            super(itemView);

        }

        public void setData(Drawer selectedDrawer, int position) {

            //this.drawerImage.setImageResource(selectedDrawer.getClothes().get(0).getPhotoId());

            this.drawer.setText(selectedDrawer.getName());
        }



    }
        
}
