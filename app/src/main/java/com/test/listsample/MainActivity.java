package com.test.listsample;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends ActionBarActivity implements View.OnClickListener{

    static final String TAG = "listsample";
    static List<String> dataList = new ArrayList<String>();
    static ArrayAdapter<String> adapter;

    ListView listView;
    Button addButton;
    Button clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListners();
        setAdapters();
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

    protected void findViews(){
        listView = (ListView) findViewById(R.id.listView);
        addButton = (Button) findViewById(R.id.button);
        clearButton = (Button) findViewById(R.id.button2);
    }

    protected void setListners(){
        addButton.setOnClickListener(this);
        clearButton.setOnClickListener(this);
    }

    protected void addItem(){
        adapter.add("Hello android!!");
    }

    protected void clearItem(){
        adapter.clear();
    }

    protected void setAdapters(){
        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                dataList);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button :
                addItem();
                break;
            case R.id.button2 :
                clearItem();
                break;
        }
    }
}
