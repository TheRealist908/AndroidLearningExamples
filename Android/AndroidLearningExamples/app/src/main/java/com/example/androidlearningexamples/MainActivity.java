package com.example.androidlearningexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.androidlearningexamples.basic.BasicActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the variable to the ListView widget created in the content_main.xml layout file
        ListView mListView = findViewById(R.id.lvParentListView);

        // Create the array of ListViewItem objects
        final ArrayList<ListViewItem> listViewItemsArrayList = ListViewItem.getListViewItemsFromFile(getString(R.string.JsonListViewItems), this);

        // Create a new Adapter passing in the list of items to display in the list
        ListViewItemAdapter adapter = new ListViewItemAdapter(this, listViewItemsArrayList);
        mListView.setAdapter(adapter);

        // Create Listener
        final Context context = this;
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                // Figure out which item was selected from our ArrayList
                ListViewItem selectedListViewItem = listViewItemsArrayList.get(position);

                // Determine which Activity to start based on the title
                // Todo: I would like to figure out how to dynamically map the class based on the title. Could just add it to JSON file mapping
                switch (selectedListViewItem.itemTitle) {
                    case "Basic Activity" :
                        intent.setClass(context, BasicActivity.class);
                        break;
                    default :
                        intent.setClass(context, EmptyActivity.class);
                }

                // Set some parameters that can be read by the receiving activity.
                // Then tell Android to start that activity.
                intent.putExtra("NAME",listViewItemsArrayList.get(position).itemTitle);
                startActivity(intent);
            }
        });
    }
}
