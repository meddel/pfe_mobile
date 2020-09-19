package com.mostdanger.drawerdemo.adapter;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.entities.Bus;

import java.util.ArrayList;
import java.util.List;

public class BusAdapter extends RecyclerView.Adapter<BusAdapter.NoteHolder> {
    private List<Bus> buses = new ArrayList<>();
    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_item, parent, false);
        return new NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, int position) {
        Bus currentBus = buses.get(position);
        holder.title.setText(String.valueOf(currentBus.getNum()));
        holder.discription.setText(currentBus.getStation());
        holder.option.setText(String.valueOf(currentBus.getDate()));
    }
    @Override
    public int getItemCount() {
        return buses.size();
    }
    public void setBuses(List<Bus> buses) {
        this.buses = buses;
        notifyDataSetChanged();
    }
    class NoteHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView discription;
        private TextView option;
        public NoteHolder(View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            discription = itemView.findViewById(R.id.discription);
            option = itemView.findViewById(R.id.option);
        }
    }
}
