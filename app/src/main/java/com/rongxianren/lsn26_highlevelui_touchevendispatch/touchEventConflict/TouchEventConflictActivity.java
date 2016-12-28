package com.rongxianren.lsn26_highlevelui_touchevendispatch.touchEventConflict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.rongxianren.lsn26_highlevelui_touchevendispatch.R;

public class TouchEventConflictActivity extends AppCompatActivity {


    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_touch_event_conflict);

        listView = (ListView) findViewById(R.id.listview);


        String[] items = new String[8];
        for (int i = 0; i < items.length; i++) {
            items[i] = "item - " + i;
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, items);
        listView.setAdapter(adapter);

    }
}
