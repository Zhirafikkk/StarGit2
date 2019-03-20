package com.example.stargit2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemClickListener  {
    TextView mainTextView;
    Button mainButton;
    EditText mainEditText;
    ListView mainListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mNameList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainTextView = findViewById(R.id.main_textview);
        mainTextView.setText("Set in Java!");
        mainButton = findViewById(R.id.main_button);
        mainButton.setOnClickListener(this);
        mainEditText = (EditText) findViewById(R.id.main_edittext);
        mainListView = findViewById(R.id.main_listview);
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mNameList);
        mainListView.setAdapter(mArrayAdapter);
        mainListView.setOnItemClickListener(this);
    }


    @Override
    public void onClick(View v) {   mainTextView.setText(mainEditText.getText().toString()
            + " is learning Android development!");
        mNameList.add(mainEditText.getText().toString());
        Collections.sort(mNameList);

        Object[] st = mNameList.toArray();
        System.out.println("Duplicates List "+mNameList);
        for (Object s : st) {
            if (mNameList.indexOf(s) != mNameList.lastIndexOf(s)) {
                mNameList.remove(mNameList.lastIndexOf(s));
            }
        }

        System.out.println("List "+mNameList);
        mArrayAdapter.notifyDataSetChanged();

    }



    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mNameList.get(position));
        mainTextView.setText(mNameList.get(position).toString()
                + " Удалена");
        mArrayAdapter.remove(mArrayAdapter.getItem(position));
    }





}
