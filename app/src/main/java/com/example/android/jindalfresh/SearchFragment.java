package com.example.android.jindalfresh;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment {


    public SearchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
        ArrayList<Search_Items> earthquakes = new ArrayList<>();
        earthquakes.add(new Search_Items("7.2", "San Francisco", "Feb 2, 2016"));
        earthquakes.add(new Search_Items("6.1", "London", "July 20, 2015"));
        earthquakes.add(new Search_Items("3.9", "Tokyo", "Nov 10, 2014"));
        earthquakes.add(new Search_Items("5.4", "Mexico City", "May 3, 2014"));
        earthquakes.add(new Search_Items("2.8", "Moscow", "Jan 31, 2013"));
        earthquakes.add(new Search_Items("4.9", "Rio de Janeiro", "Aug 19, 2012"));
        earthquakes.add(new Search_Items("1.6", "Paris", "Oct 30, 2011"));

        // Find a reference to the {@link ListView} in the layout


        // Create a new {@link ArrayAdapter} of earthquakes
        Search_Items_Adapter adapter = new Search_Items_Adapter(getContext(), earthquakes);
        ListView earthquakeListView = (ListView) rootView.findViewById(R.id.search_listView_id);
        // Set the adapter on the {@link ListView}
        // so the list can be populated in the user interface
        earthquakeListView.setAdapter(adapter);
        return rootView;
    }

}
