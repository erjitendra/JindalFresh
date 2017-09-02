package com.example.android.jindalfresh;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

/**
 * Created by Jindal on 8/23/2017.
 */

public class Home_Items_Adapter extends ArrayAdapter<Product> {


    TextView quantityDisplay;
    int quantity = 1;

    public Home_Items_Adapter(@NonNull Context context, ArrayList<Product> resultProductArray) {
        super(context, 0, resultProductArray);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Product product = getItem(position);

        TextView EngNameTextView = (TextView) listItemView.findViewById(R.id.engName_text_view);
        EngNameTextView.setText(product.getProductEnglishName());

        TextView HindiNameTextView = (TextView) listItemView.findViewById(R.id.Hindi_text_view);
        HindiNameTextView.setText(product.getProductHindiName());

        TextView Price = (TextView) listItemView.findViewById(R.id.TotalPrice);
        Price.setText(" " + product.getProductRate());

        TextView Unit = (TextView) listItemView.findViewById(R.id.TotalQuantity);
        Unit.setText(" " + "50" + " " + product.getProductUnit());


        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        ImageLoader.getInstance().displayImage(product.getProductImageUrl(), imageView);


        //Toast.makeText(getContext(),"Quantity outside"+quantity,Toast.LENGTH_LONG).show();
        quantityDisplay = (TextView) listItemView.findViewById(R.id.Quantity);


        //quantityDisplay.setText(newq);

        quantityDisplay.setText("1");
        //Log.v("AajTak",""+quantityDisplay+"jjjjjj"+Integer.toString(quantity));


        return listItemView;

    }


}