package com.example.administrator.handlertest_03_35;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends ActionBarActivity {

    int[] imageIds = new int[]{
            R.drawable.java,
            R.drawable.javaee,
            R.drawable.ajax,
            R.drawable.android,
            R.drawable.swift,
    };
    int currentImageId = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ImageView show = (ImageView) findViewById(R.id.show);
        final Handler myHandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                if(msg.what==0x123){
                    show.setImageResource(imageIds[currentImageId++%imageIds.length]);
                }
            }
        };
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                myHandler.sendEmptyMessage(0x123);
            }
        }, 0, 1200);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
