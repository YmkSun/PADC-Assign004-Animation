package com.androidapp.yemyokyaw.animationapp.activities;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.androidapp.yemyokyaw.animationapp.R;
import com.androidapp.yemyokyaw.animationapp.adapter.RvItemAdapter;
import com.androidapp.yemyokyaw.animationapp.delegates.RvItemDelegates;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements RvItemDelegates {

    @BindView(R.id.main_layout)
    CoordinatorLayout mainLayout;

    @BindView(R.id.rv)
    RecyclerView rv;

    public static Intent newIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this, this);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        RvItemAdapter newsAdapter = new RvItemAdapter(getApplicationContext(), this);
        rv.setAdapter(newsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        animateAction(0f, 1.0f, 1.0f);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_profile) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void clickProfile(View v){
        animateAction(-300f, 0.7f, 0.7f);
        Intent intent = ProfileActivity.newIntent(this);
        startActivity(intent);
        overridePendingTransition(R.anim.enter, R.anim.exit);
    }

    public void animateAction(float tx, float sx, float sy) {
        ObjectAnimator animX = ObjectAnimator.ofFloat(mainLayout, "translationX", tx);
        ObjectAnimator animScX = ObjectAnimator.ofFloat(mainLayout, "scaleX", sx);
        ObjectAnimator animScY = ObjectAnimator.ofFloat(mainLayout, "scaleY", sy);
        AnimatorSet animSetXY = new AnimatorSet();
        animSetXY.playTogether(animScX, animScY, animX);
        animSetXY.setDuration(500);
        animSetXY.start();
    }

    @Override
    public void onTapItem() {

    }
}
