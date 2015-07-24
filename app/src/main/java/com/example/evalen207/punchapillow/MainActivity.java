package com.example.evalen207.punchapillow;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.media.MediaPlayer;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageButton;
import android.widget.Toast;
import android.os.Handler;


public class MainActivity extends ActionBarActivity {

    ImageButton button;
    int counter;
    MediaPlayer mp;
    MediaPlayer bkgd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (ImageButton) findViewById(R.id.pillow);

        // animation
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f,
                0.0f, 50.0f);          //  new TranslateAnimation(xFrom,xTo, yFrom,yTo)
        animation.setDuration(400);  // animation duration
        animation.setRepeatCount(Animation.INFINITE);  // animation repeat count
        animation.setRepeatMode(2);   // repeat animation (left to right, right to left )
        //animation.setFillAfter(true);
        button.startAnimation(animation);  // start animation

        button.setOnClickListener(imgButtonHandler);

        //bkgd music
        bkgd = MediaPlayer.create(MainActivity.this, R.raw.snowystreet);
        bkgd.setLooping(true);
        bkgd.start();
        //test
    }

    View.OnClickListener imgButtonHandler = new View.OnClickListener() {
        public void onClick(View v) {
            //sound
            //change image
            if (counter == 0) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.punch);
                mp.start();
                button.setImageResource(R.drawable.pillow1);
                counter++;
            } else if (counter == 1) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.punch);
                mp.start();
                button.setImageResource(R.drawable.pillow2);
                counter++;
            } else if (counter == 2) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.punch);
                mp.start();
                button.setImageResource(R.drawable.pillow3);
                counter++;
            } else if (counter == 3) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.punch);
                mp.start();
                button.setImageResource(R.drawable.pillow4);
                counter++;
            } else if (counter == 4) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.punch);
                mp.start();
                button.setImageResource(R.drawable.pillow5);
                counter++;
            } else if (counter == 5) {
                mp = MediaPlayer.create(MainActivity.this, R.raw.explosion);
                mp.start();
                button.setImageResource(R.drawable.explosion1);

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.explosion2);
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.explosion3);
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.explosion4);
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.explosion5);
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.explosion6);
                    }
                }, 500);
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        button.setImageResource(R.drawable.playagain);
                    }
                }, 1000);

                counter++;
            } else if (counter == 6) {
                //restart current activity (for back button)
                bkgd.stop();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }
            /*
            Toast.makeText(MainActivity.this,
                    "Pillow has been punched " + counter + " times!", Toast.LENGTH_SHORT).show();
            */
        }
    };



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
        switch(item.getItemId()) {
            case R.id.about:
                Intent intent = new Intent(MainActivity.this, AboutActivity.class);
                finish();
                startActivity(intent);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }

        return true;
    }
}
