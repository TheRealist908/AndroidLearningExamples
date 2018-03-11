package com.example.androidlearningexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Set the variable to the ListView widget created in the content_main.xml layout file
        mListView = findViewById(R.id.lvParentListView);

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
                // Figure out which item was selected from our ArrayList
                ListViewItem selectedListViewItem = listViewItemsArrayList.get(position);
                // Create a new Activity page based on the Activity that the click should go to
                // Todo: Build in functionality to use a switch/case to determine the activity to go to as the below is defaulted for now
                Intent detailIntent = new Intent(context, EmptyActivity.class);

                // Pass in the name of the item selected just to show we got the read thing
                detailIntent.putExtra("NAME",listViewItemsArrayList.get(position).itemTitle);
                // Then tell Android to start that activity.
                startActivity(detailIntent);
            }
        });
    }
}
