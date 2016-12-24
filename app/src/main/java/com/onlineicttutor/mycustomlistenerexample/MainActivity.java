package com.onlineicttutor.mycustomlistenerexample;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.onlineicttutor.mycustomlistenerexample.mylisteners.OnUseremailAvailableListener;
import com.onlineicttutor.mycustomlistenerexample.utility.CheckUseremailEditText;

public class MainActivity extends AppCompatActivity {

    private CheckUseremailEditText checkUseremailEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Check user email available or not!", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        checkUseremailEditText = (CheckUseremailEditText)findViewById(R.id.editTextEmail);
        checkUseremailEditText.setOnUseremailAvailableListener(new OnUseremailAvailableListener() {
            @Override
            public void onAvailableChecked(String useremail, boolean available) {
                Log.e("check user 2", " 2 here-->" + available);
                if (!available) {
                    checkUseremailEditText.setTextColor(Color.WHITE);
                    checkUseremailEditText.setError("This email is already used. Choose another one.");
                    checkUseremailEditText.setBackgroundColor(Color.RED);
                } else {
                    checkUseremailEditText.setTextColor(Color.WHITE);
                    checkUseremailEditText.setBackgroundColor(Color.GREEN);
                }
            }
        });


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
