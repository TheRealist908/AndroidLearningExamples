package com.example.androidlearningexamples;

import android.content.Context;
import android.support.annotation.Nullable;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.InputStream;

/**
 * Holds List View Parent Items created from the JSON file.
 * Code modified from its original source: com.raywenderlich.alltherecipes
 */

class ListViewItem {

    public String itemTitle;
    public String itemSubtitle;
    public String itemDesc;

    public static ArrayList<ListViewItem> getListViewItemsFromFile(String filename, Context context) {

        final ArrayList<ListViewItem> listViewItemsList = new ArrayList<>();

        try {
            // Load the data from the JSON file that was created with the list view items.
            String jsonString = loadJsonFromAsset(filename,context);
            JSONObject json = new JSONObject(jsonString);
            JSONArray listViewItems = json.getJSONArray("listviewitems");

            // Get ListViewItem objects from data
            for (int i = 0; i < listViewItems.length(); i++) {
                ListViewItem listViewItem = new ListViewItem();
                listViewItem.itemTitle = listViewItems.getJSONObject(i).getString("itemTitle");
                listViewItem.itemSubtitle = listViewItems.getJSONObject(i).getString("itemSubtitle");
                listViewItem.itemDesc = listViewItems.getJSONObject(i).getString("itemDesc");
                listViewItemsList.add(listViewItem);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return listViewItemsList;
    }

    @Nullable
    private static String loadJsonFromAsset(String filename, Context context) {
        String json = null;

        try {
            InputStream is = context.getAssets().open(filename);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}
