package com.example.myvirtualcloset3.ui;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.myvirtualcloset3.R;
import com.example.myvirtualcloset3.data.Drawer;
import com.example.myvirtualcloset3.data.Event;
import com.example.myvirtualcloset3.ui.insideDrawer.InsideDrawerActivity;

import java.util.ArrayList;

public class EventListAdapter extends RecyclerView.Adapter<EventListAdapter.MyViewHolder> {
    ArrayList<Event> mEventList;
    LayoutInflater inflater;
    Context mContext;
    public EventListAdapter(Context context, ArrayList<Event> events) {
        inflater = LayoutInflater.from(context);
        this.mEventList = events;
        mContext = context;
    }


    public void updateItems(ArrayList<Event> newList) {
        mEventList.clear();
        mEventList.addAll(newList);
        this.notifyDataSetChanged();
    }

    public EventListAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_event_view, parent, false);
        EventListAdapter.MyViewHolder holder = new EventListAdapter.MyViewHolder(view);
        return holder;
    }


    public void onBindViewHolder(EventListAdapter.MyViewHolder holder, int position) {
        Event selectedEvent = mEventList.get(position);
        holder.setData(selectedEvent, position);

    }


    public int getItemCount() {
        return mEventList.size();
    }


    class MyViewHolder extends RecyclerView.ViewHolder{

        //ImageView drawerImage;
        TextView eventName = itemView.findViewById(R.id.textName);
        TextView eventType = itemView.findViewById(R.id.textType);
        TextView eventDate = itemView.findViewById(R.id.textDate);
        TextView eventLocation = itemView.findViewById(R.id.textLocation);

        public MyViewHolder(View itemView) {
            super(itemView);

        }

        public void setData(Event selectedEvent, int position) {

            //this.drawerImage.setImageResource(selectedDrawer.getClothes().get(0).getPhotoId());

            this.eventName.setText(selectedEvent.getName());
            this.eventLocation.setText(selectedEvent.getLocation());
            this.eventDate.setText(selectedEvent.getDate());
            this.eventType.setText(selectedEvent.getType());
        }



    }

}
