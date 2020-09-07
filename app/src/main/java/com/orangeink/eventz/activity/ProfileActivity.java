package com.orangeink.eventz.activity;

import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.orangeink.eventz.databinding.ActivityProfileBinding;
import com.orangeink.eventz.utility.KeyboardActivity;

public class ProfileActivity extends KeyboardActivity {

    ActivityProfileBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getSupportActionBar().hide();
        binding.loginToggle.setOnClickListener(v -> {
            if(binding.name.getVisibility() == View.VISIBLE)
                toggle(true);
            else
                toggle(false);
        });
        attachKeyboardListeners();
    }

    private void toggle(boolean isLogin) {
        if(isLogin) {
            binding.name.setVisibility(View.GONE);
            binding.phoneNumber.setVisibility(View.GONE);
            binding.roll.setVisibility(View.GONE);
            binding.createProfile.setText("Login");
            binding.loginToggle.setText("Don't have a profile? Create Profile");
        } else {
            binding.name.setVisibility(View.VISIBLE);
            binding.phoneNumber.setVisibility(View.VISIBLE);
            binding.roll.setVisibility(View.VISIBLE);
            binding.createProfile.setText("Create");
            binding.loginToggle.setText("Already have a profile? Login");
        }
    }

    @Override
    protected void onShowKeyboard(int keyboardHeight) {
        if (keyboardHeight < 300)
            binding.bottomLayout.setVisibility(View.VISIBLE);
        else
            binding.bottomLayout.setVisibility(View.GONE);
    }

    @Override
    public void onBackPressed() {
        ActivityCompat.finishAfterTransition(this);
    }
}