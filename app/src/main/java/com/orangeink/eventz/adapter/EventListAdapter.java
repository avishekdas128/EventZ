package com.orangeink.eventz.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.orangeink.eventz.R;
import com.orangeink.eventz.databinding.ItemEventCardBinding;
import com.orangeink.eventz.utility.Utility;

import java.util.List;

public class EventListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public List<String> mList;
    public EventListInterface eventListInterface;

    public EventListAdapter(List<String> mList, EventListInterface eventListInterface) {
        this.mList = mList;
        this.eventListInterface = eventListInterface;
    }

    public interface EventListInterface {
        void onClick();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_event_card, parent, false);
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

        ItemEventCardBinding binding;

        public EventListViewHolder(@NonNull View itemView) {
            super(itemView);
            binding = ItemEventCardBinding.bind(itemView);
        }

        public void bind(String string) {
            if(getAdapterPosition() == mList.size() - 1)
                Utility.setupBottomMargin(binding.eventCard, itemView.getContext(), 10);
            else
                Utility.setupBottomMargin(binding.eventCard, itemView.getContext(), 0);
            itemView.setOnClickListener(v -> eventListInterface.onClick());
        }
    }
}
