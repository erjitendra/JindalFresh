package com.example.android.jindalfresh;


import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {
    View rootView;
    ArrayList<Product> resultProductArray;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView = inflater.inflate(R.layout.fragment_home, container, false);

// Create default options which will be used for every
//  displayImage(...) call if no options will be passed to this method
        DisplayImageOptions defaultOptions = new DisplayImageOptions.Builder()

                .cacheInMemory(true)
                .cacheOnDisk(true)

                .build();
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getContext())

                .defaultDisplayImageOptions(defaultOptions)

                .build();
        ImageLoader.getInstance().init(config); // Do it on Application start

        String productsUrl = "http://lit-dusk-68336.herokuapp.com/api/v1/product/products/";

        ProductAsyncTask task = new ProductAsyncTask();
        task.execute(productsUrl);

        return rootView;

    }

    private class ProductAsyncTask extends AsyncTask<String, Void, String> {

        /**
         * This method is invoked (or called) on a background thread, so we can perform
         * long-running operations like making a network request.
         * <p>
         * It is NOT okay to update the UI from a background thread, so we just return an
         */
        protected String doInBackground(String... urls) {
            // Don't perform the request if there are no URLs, or the first URL is null.
            if (urls.length < 1 || urls[0] == null) {
                return null;
            }

            ProductResponseHandler p = new ProductResponseHandler();
            String response = p.getProductJsonData(urls[0]);
            resultProductArray = p.getProductArray(response);
            Log.v("pune", "At The Do in BC Method");

            return response;
        }

        /**
         * This method is invoked on the main UI thread after the background work has been
         * completed.
         * (which was returned from the doInBackground() method) and update the views on the screen.
         */
        protected void onPostExecute(String result) {
            // If there is no result, do nothing.
            Log.v("Dehli", "At The Do in Start post Method");
            Home_Items_Adapter arrayAdapter = new Home_Items_Adapter(getContext(), resultProductArray);
            ListView listView = (ListView) rootView.findViewById(R.id.home_listView_id);
            listView.setAdapter(arrayAdapter);
            Log.v("mumbai", "At The Do in  End post Method" + listView);


        }
    }


}
