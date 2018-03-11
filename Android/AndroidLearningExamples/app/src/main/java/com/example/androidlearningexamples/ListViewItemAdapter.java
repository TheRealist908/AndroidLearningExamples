package com.example.androidlearningexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;

/**
 * Creates a ListView Adapter for the Data in ListViewItem that will display in the Activity
 */

class ListViewItemAdapter extends BaseAdapter {

    private final LayoutInflater mInflater;
    private final ArrayList<ListViewItem> mDataSource;

    ListViewItemAdapter(Context context, ArrayList<ListViewItem> items) {
        mDataSource = items;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get view for activity_main_lv_row item
        View rowView = mInflater.inflate(R.layout.activity_main_lv_row, parent, false);
        TextView titleTextView = rowView.findViewById(R.id.tvTitleText);
        TextView subtitleTextView = rowView.findViewById(R.id.tvSubTitleText);
        TextView detailsTextView = rowView.findViewById(R.id.tvDetailsText);

        ListViewItem lvi = (ListViewItem) getItem(position);
        titleTextView.setText(lvi.itemTitle);
        subtitleTextView.setText(lvi.itemSubtitle);
        detailsTextView.setText(lvi.itemDesc);

        return rowView;
    }
}
