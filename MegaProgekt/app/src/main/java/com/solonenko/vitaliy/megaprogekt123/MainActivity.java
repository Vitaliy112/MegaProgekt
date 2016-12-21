package com.solonenko.vitaliy.megaprogekt123;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isTrackengNoaw;
    private FloatingActionButton floatingActionButton;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        setTitle(R.string.app_name);

         floatingActionButton = (FloatingActionButton) findViewById(R.id.btnStart);
         floatingActionButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        isTrackengNoaw = !isTrackengNoaw;
        floatingActionButton.setImageResource(isTrackengNoaw ? R.drawable.ic_stop_white_24dp : R.drawable.ic_play_arrow_white_24dp);
        Toast.makeText(this, "Button presed", Toast.LENGTH_SHORT).show();

    }
}
