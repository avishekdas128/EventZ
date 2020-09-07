package com.orangeink.eventz.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.orangeink.eventz.adapter.EventDetailListAdapter;
import com.orangeink.eventz.adapter.EventListAdapter;
import com.orangeink.eventz.databinding.ActivityMainBinding;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements EventListAdapter.EventListInterface {

    ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        setupAdapter();
        binding.profileImage.setOnClickListener(v -> {
            Intent intent = new Intent(this, ProfileActivity.class);
            ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(MainActivity.this, binding.profileImage, "transitionName");
            ActivityCompat.startActivity(MainActivity.this, intent, options.toBundle());
        });
    }

    private void setupAdapter() {
        EventListAdapter adapter = new EventListAdapter(Arrays.asList("asda","ada","asdasd","asdasd","adsasd"), this);
        binding.eventsRv.setLayoutManager(new GridLayoutManager(this, 2));
        binding.eventsRv.setAdapter(adapter);
    }

    private void setupNewAdapter() {
        EventDetailListAdapter adapter = new EventDetailListAdapter(Arrays.asList("asda","ada","asdasd","asdasd","adsasd"));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);
        binding.eventsDetailsRv.setLayoutManager(linearLayoutManager);
        SnapHelper snapHelper = new LinearSnapHelper();
        binding.eventsDetailsRv.setOnFlingListener(null);
        snapHelper.attachToRecyclerView(binding.eventsDetailsRv);
        binding.eventsDetailsRv.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE) {
                    View centerView = snapHelper.findSnapView(linearLayoutManager);
                    if(centerView != null) {
                        int pos = linearLayoutManager.getPosition(centerView);
                        Log.e("Snapped Item Position:", "" + pos);
                    }
                }
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
            }
        });
        binding.eventsDetailsRv.setAdapter(adapter);
    }

    @Override
    public void onClick() {
        binding.homepageBottomLayout.setVisibility(View.GONE);
        binding.eventpageBottomLayout.setVisibility(View.VISIBLE);
        binding.eventsRv.setVisibility(View.GONE);
        binding.eventsDetailsRv.setVisibility(View.VISIBLE);
        setupNewAdapter();
    }

    @Override
    public void onBackPressed() {
        if(binding.eventpageBottomLayout.getVisibility() == View.VISIBLE) {
            binding.homepageBottomLayout.setVisibility(View.VISIBLE);
            binding.eventpageBottomLayout.setVisibility(View.GONE);
            binding.eventsRv.setVisibility(View.VISIBLE);
            binding.eventsDetailsRv.setVisibility(View.GONE);
            setupAdapter();
        } else
            super.onBackPressed();
    }
}