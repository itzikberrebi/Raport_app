package com.example.itzik.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    public static final String msg_key = "msg_key";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = new Intent(this,RAportIntentService.class);
        startService(i);
    }

    public void pressButton (View view) {
        
        EditText editText = (EditText)findViewById(R.id.edit_text);
        String msg = editText.getText().toString();
        Intent intent = new Intent(this, intentActivity.class);
        intent.putExtra(msg_key, msg);
        startActivity(intent);
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();

    }

    public void gotoSettings (View view) {
        Intent intent = new Intent(this, SettingsActivity.class);
        startActivity(intent);
    }

    public void gotoListview (View view) {
        Intent intent = new Intent(this, ListViewActivity.class);
        startActivity(intent);
    }

}
