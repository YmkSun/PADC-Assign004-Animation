package com.androidapp.yemyokyaw.animationapp.activities;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.androidapp.yemyokyaw.animationapp.R;

public class ProfileActivity extends AppCompatActivity {

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, ProfileActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.back_enter, R.anim.back_exit);
    }
}
