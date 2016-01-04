package edu.purdue.iwoodbur.cs180;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    }*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);        // Inflate the GUI

        Button throwButton = (Button) findViewById(R.id.bu_throw); // Retrieve the Button throw
        Button clearButton = (Button) findViewById(R.id.bu_clear);
        TextView dieDisplay = (TextView) findViewById(R.id.tw_die);
        TextView sumDisplay = (TextView) findViewById(R.id.tw_sum);

        throwButton.setOnClickListener(new ThrowListener(dieDisplay, sumDisplay));
        clearButton.setOnClickListener(new ClearListener());
    }
}
