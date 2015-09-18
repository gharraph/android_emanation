package com.ohiohealth.lab3withrecyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

public class RecyclerViewActivity extends AppCompatActivity {

    private RecyclerView _recyclerView;
    private RecyclerView.Adapter _adapter;
    private RecyclerView.LayoutManager _layoutManager;
    private int numberOfCells;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        numberOfCells = getIntent().getIntExtra(MainActivity.NUMBER_OF_CELLS, 0);

        //Get the RecyclerView object from xml
        _recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // Defined Array values to show in ListView
        String[] values = new String[numberOfCells];
        for (int i=0; i<numberOfCells; i++) {
            values[i] = "cell number " + String.valueOf(i+1);
        }

        //use a liner layout manager
        _layoutManager = new LinearLayoutManager(this);
        _recyclerView.setLayoutManager(_layoutManager);

        _adapter = new MyAdapter(values);
        _recyclerView.setAdapter(_adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_recycler_view, menu);
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
