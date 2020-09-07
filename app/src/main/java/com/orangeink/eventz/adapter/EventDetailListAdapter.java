package com.orangeink.eventz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orangeink.eventz.R;
import com.orangeink.eventz.databinding.ItemEventListCardBinding;

import java.util.List;

public class EventDetailListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<String> mList;
    public EventListInterface eventListInterface;

    public EventDetailListAdapter(List<String> mList) {
        this.mList = mList;
    }

    public interface EventListInterface {
        void onClick();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_list_card, parent, false);
        return new EventListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ((EventListViewHolder) holder).bind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class EventListViewHolder extends RecyclerView.ViewHolder {

        ItemEventListCardBinding binding;

        public EventListViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemEventListCardBinding.bind(itemView);
        }

        public void bind(String string) {
        }
    }
}
