package com.example.nti.assignment1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends ActionBarActivity {

    Random rnd = new Random();
    int rndNbr;

    public void buttonOnClick(View v){

        rndNbr = rnd.nextInt(3) +1;

        Log.i("Assignment_1","Button Pressed");


            TextView t1 = (TextView) findViewById(R.id.textView);


        switch(rndNbr){

            case 1: t1.setText(getResources().getString(R.string.quote1));
                break;

            case 2: t1.setText(getResources().getString(R.string.quote2));
                break;

            case 3: t1.setText(getResources().getString(R.string.quote3));
                break;

            default: t1.setText(getResources().getString(R.string.error));
                break;
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i("Assignment_1","onCreate called");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Assignment_1","onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Assignment_1","onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Assignment_1","onPause called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Assignment_1","onDestroy called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Assignment_1","onStop called");
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
