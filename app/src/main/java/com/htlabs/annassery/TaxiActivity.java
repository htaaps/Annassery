package com.htlabs.annassery;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

/**
 * Created by tap on 06/02/2016.
 */
public class TaxiActivity extends Activity {

    private TaxiDbAdapter dbHelper;
    private SimpleCursorAdapter dataAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.taxi_activity);

        dbHelper = new TaxiDbAdapter(this);
        dbHelper.open();

        //Clean all data
        dbHelper.deleteAllNames();
        //Add some data
        dbHelper.insertSomeNames();

        //Generate ListView from SQLite Database
        displayListView();

    }

    private void displayListView() {


        Cursor cursor = dbHelper.fetchAllNames();

        // The desired columns to be bound
        String[] columns = new String[] {
                TaxiDbAdapter.KEY_PIC,
                TaxiDbAdapter.KEY_NAME,
                TaxiDbAdapter.KEY_MOBILE,
        };

        // the XML defined views which the data will be bound to
        int[] to = new int[] {
                R.id.tncr_pic,
                R.id.tncr_name,
                R.id.tncr_mobile,
        };

        // create the adapter using the cursor pointing to the desired data
        //as well as the layout information
        dataAdapter = new SimpleCursorAdapter(
                this, R.layout.taxi_name_contact_row,
                cursor,
                columns,
                to,
                0);

        ListView listView = (ListView) findViewById(R.id.list_taxi);

         // Assign adapter to ListView
        listView.setAdapter(dataAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                // Get the cursor, positioned to the corresponding row in the result set
                Cursor cursor = (Cursor) listView.getItemAtPosition(position);

                // Get the state's capital from this row in the database.
                String mobileNo = cursor.getString(cursor.getColumnIndexOrThrow("mobile"));
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                callIntent.setData(Uri.parse("tel:" + mobileNo));
                startActivity(callIntent);
            }
        });
    }
}
