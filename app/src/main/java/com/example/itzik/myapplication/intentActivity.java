package com.example.itzik.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.os.Handler;
import android.os.Message;

public class intentActivity extends Activity
        implements GestureDetector.OnGestureListener,GestureDetector.OnDoubleTapListener {

    public int a = 1;
    public GestureDetectorCompat gestureDetector;

    Handler h = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            Toast.makeText(getApplicationContext(), String.valueOf(a), Toast.LENGTH_SHORT).show();
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);
        getActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#5B5BE5")));

        Button button = (Button) findViewById(R.id.button_id);
        button.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View view){

                        Runnable r = new Runnable() {
                            @Override
                            public void run() {
                                a++;
                                h.sendEmptyMessage(0);
                            }
                        };
                        Thread t = new Thread(r);
                        t.start();
                    }
                }

        );

        button.setOnLongClickListener(
                new Button.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        Toast.makeText(getApplicationContext(), String.valueOf(a), Toast.LENGTH_SHORT).show();
                        a--;
                        return true;
                    }
                }

        );

        Intent intent = getIntent();
        String msg = intent.getStringExtra(MainActivity.msg_key);
        TextView t = (TextView) findViewById(R.id.msg);
        t.setText(msg);

        this.gestureDetector = new GestureDetectorCompat(this,this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event){
        this.gestureDetector.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onSingleTapConfirmed", Toast.LENGTH_SHORT).show();
        hideSoftKeyboard(this);
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onDoubleTap", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onDoubleTapEvent", Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        Toast.makeText(getApplicationContext(), "onLongPress", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        return false;
    }

    public static void hideSoftKeyboard(Activity activity) {
        InputMethodManager inputMethodManager =
                (InputMethodManager) activity.getSystemService(
                        Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(
                activity.getCurrentFocus().getWindowToken(), 0);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.one: {
                Toast.makeText(getApplicationContext(), "one", Toast.LENGTH_SHORT).show();
            }
            case R.id.two: {
                Toast.makeText(getApplicationContext(), "two", Toast.LENGTH_SHORT).show();
            }
        }
        return true;
    }

}
