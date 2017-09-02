package com.example.android.jindalfresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by Jindal on 8/24/2017.
 */

public class Search_Items_Adapter extends ArrayAdapter<Search_Items> {
    public Search_Items_Adapter(@NonNull Context context, ArrayList<Search_Items> earthquakes) {
        super(context, 0, earthquakes);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.search_list_item, parent, false);
        }
        // Find the earthquake at the given position in the list of earthquakes
        Search_Items currentEarthquake = getItem(position);

        // Find the TextView with view ID magnitude
        TextView magnitudeView = (TextView) listItemView.findViewById(R.id.magnitude);
        // Display the magnitude of the current earthquake in that TextView
        magnitudeView.setText(currentEarthquake.getMagnitude());

        // Find the TextView with view ID location
        TextView locationView = (TextView) listItemView.findViewById(R.id.location);
        // Display the location of the current earthquake in that TextView
        locationView.setText(currentEarthquake.getLocation());
        //........................................

        Date dateObject = new Date(currentEarthquake.getTimeInMIliSeconds());
        //date
        TextView dateView = (TextView) listItemView.findViewById(R.id.date);
        String formattedDate = formatDate(dateObject);
        dateView.setText(formattedDate);
        //......................................................
        //time
        TextView timeView = (TextView) listItemView.findViewById(R.id.time);
        String formattedTime = formatTime(dateObject);
        timeView.setText(formattedTime);
        //


        return listItemView;
    }

    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("h:mm a");
        return timeFormat.format(dateObject);
    }
}
