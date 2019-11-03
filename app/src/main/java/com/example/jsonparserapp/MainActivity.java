package com.example.jsonparserapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {


    ListView listView;

    String data = "{ \"users\" :[" +
            "{\"name\":\"Ram\",\"designation\":\"Software Developer\",\"location\":\"Hyderabad\"}" +
            ",{\"name\":\"Sham\",\"designation\":\"Mamanger\",\"location\":\"Gurgaon\"}" +
            ",{\"name\":\"Tanu\",\"designation\":\"IT Officer\",\"location\":\"Banglore\"}" +
            ",{\"name\":\"Pooja\",\"designation\":\"Human Resource\",\"location\":\"Goa\"}" +
            ",{\"name\":\"Teena\",\"designation\":\"Charted Accountant\",\"location\":\"Delhi\"}] }";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        parseJsonData();
    }

    void parseJsonData()
    {
        try
        {
        ArrayList arrayList = new ArrayList();
        JSONObject jObj = new JSONObject(data);
        JSONArray jsonArry = jObj.getJSONArray("users");
        for(int i=0;i<jsonArry.length();i++)
        {
            JSONObject obj = jsonArry.getJSONObject(i);
            String name = obj.getString("name");
            String designation = obj.getString("designation");
            String location = obj.getString("location");
            arrayList.add(name+" , "+designation+" , "+location);
        }
            ArrayAdapter adapter = new ArrayAdapter(MainActivity.this,android.R.layout.simple_list_item_1,arrayList);
            listView.setAdapter(adapter);
        }
        catch (JSONException je)
        {
            je.printStackTrace();
        }
    }
}
