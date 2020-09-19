package com.mostdanger.drawerdemo.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mostdanger.drawerdemo.R;
import com.mostdanger.drawerdemo.entities.Station;

import java.util.ArrayList;
import java.util.List;

public class StationAdapter extends RecyclerView.Adapter<StationAdapter.NoteHolder> {
    private List<Station> stations = new ArrayList<>();
    @NonNull
    @Override
    public StationAdapter.NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.bus_item, parent, false);
        return new StationAdapter.NoteHolder(itemView);
    }
    @Override
    public void onBindViewHolder(@NonNull StationAdapter.NoteHolder holder, int position) {
        Station currentBus = stations.get(position);
        holder.title.setText(String.valueOf(currentBus.getName()));
        holder.discription.setText(currentBus.getAddress());
    }
    @Override
    public int getItemCount() {
        return stations.size();
    }
    public void setBuses(List<Station> stations) {
        this.stations = stations;
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
