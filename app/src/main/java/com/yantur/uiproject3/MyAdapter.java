package com.yantur.uiproject3;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Artur on 3/21/2016.
 */
public class MyAdapter extends ArrayAdapter<RowData> {
    private Context context;
    private List<RowData> rowData;

    public MyAdapter(Context context, List<RowData> rowData) {
        super(context, R.layout.list_row, R.id.title, rowData);
        this.context = context;
        this.rowData = rowData;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_row, parent, false);
        TextView textView = (TextView) rowView.findViewById(R.id.text);
        CardView cardView = (CardView) rowView.findViewById(R.id.card_view);
        final CheckBox checkBox = (CheckBox) rowView.findViewById(R.id.checkbox);
        textView.setTextColor(Color.BLACK);
        if (rowData.get(position).isHidden()) {
            cardView.setVisibility(View.GONE);
        }
        if (rowData.get(position).isColor()) {
            textView.setTextColor(Color.GRAY);
        }
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox cb = (CheckBox) v;
                if (!rowData.get(position).isChecked()) {
                    rowData.get(position).setChecked(true);
                    Log.d("ADAPTER", "is checked");
                } else {
                    rowData.get(position).setChecked(false);
                    Log.d("ADAPTER", "is unchecked");
                }
                checkBox.setSelected(cb.isChecked());
            }
        });
        textView.setText(rowData.get(position).getTitle());
        textView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                rowData.get(position).setHidden(true);
                rowData.get(position).setColor(true);
                notifyDataSetChanged();
                Log.d("ART", "Click");
                return false;
            }
        });

        return rowView;
    }

}
