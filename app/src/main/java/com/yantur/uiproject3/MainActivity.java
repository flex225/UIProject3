package com.yantur.uiproject3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<RowData> rowData;
    private ListView listView;
    private MyAdapter myAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rowData = new ArrayList<>();
        addItem();
        listView = (ListView) findViewById(R.id.listview);
        myAdapter = new MyAdapter(this, rowData);
        listView.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.action_hide:
                showHiddenItems();
                Log.d("ART", "show");
                break;
            case R.id.action_delete:
                for (int i = 0; i < rowData.size(); i++) {
                    if (rowData.get(i).isChecked()) {
                        rowData.remove(i);
                        --i;
                        myAdapter.notifyDataSetChanged();
                        Log.d("ART", "Delete");
                    }
                }

                break;
        }
        return false;
    }

    private void addItem() {
        RowData rowData1 = new RowData("item 1", false, false, false);
        RowData rowData2 = new RowData("item 2", false, false, false);
        RowData rowData3 = new RowData("item 3", false, false, false);
        RowData rowData4 = new RowData("item 4", false, false, false);
        RowData rowData5 = new RowData("item 5", false, false, false);
        RowData rowData6 = new RowData("item 6", false, false, false);
        this.rowData.add(rowData1);
        this.rowData.add(rowData2);
        this.rowData.add(rowData3);
        this.rowData.add(rowData4);
        this.rowData.add(rowData5);
        this.rowData.add(rowData6);
    }

    private void showHiddenItems() {
        for (RowData d :
                rowData) {
            if (d.isHidden()) {
                d.setHidden(false);
            }
            myAdapter.notifyDataSetChanged();
        }
    }


}
