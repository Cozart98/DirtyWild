package fr.wcs.blablacrade;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by wilder on 13/09/17.
 */


public class TripResultAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<TripResultModel> items;


    public TripResultAdapter(Context context, ArrayList<TripResultModel> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.trip_item, parent, false);
        }


        TripResultModel currentItem = (TripResultModel) getItem(position);


        TextView departure = (TextView)
                convertView.findViewById(R.id.textViewDeparture);
        TextView firstname = (TextView)
                convertView.findViewById(R.id.textViewName);
        TextView price = (TextView)
                convertView.findViewById(R.id.textViewPrice);


        departure.setText(currentItem.getDeparture().toString());
        firstname.setText(currentItem.getName());
        price.setText(String.valueOf(currentItem.getPrice()));


        return convertView;
    }
}