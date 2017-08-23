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
public class HomeFragment extends Fragment {


    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<Home_Items> words = new ArrayList<Home_Items>();

        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));
        words.add(new Home_Items(R.drawable.ic_home_black_24dp, "Home"));


//        Log.v("NumbersActivity", "Word at index 0: " + words.get(0));
//        Log.v("NumbersActivity", "Word at index 1: " + words.get(1));
//        Log.v("NumbersActivity", "Word at index 2: " + words.get(2));
//        Log.v("NumbersActivity", "Word at index 3: " + words.get(3));
//        Log.v("NumbersActivity", "Word at index 4: " + words.get(4));
//        Log.v("NumbersActivity", "Word at index 5: " + words.get(5));
//        Log.v("NumbersActivity", "Word at index 6: " + words.get(6));
//        Log.v("NumbersActivity", "Word at index 7: " + words.get(7));
//        Log.v("NumbersActivity", "Word at index 8: " + words.get(8));
//        Log.v("NumbersActivity", "Word at index 9: " + words.get(9));
        Home_Items_Adapter arrayAdapter = new Home_Items_Adapter(getContext(), words);
        ListView listView = (ListView) rootView.findViewById(R.id.home_listView_id);
        listView.setAdapter(arrayAdapter);
        return rootView;

    }

}
