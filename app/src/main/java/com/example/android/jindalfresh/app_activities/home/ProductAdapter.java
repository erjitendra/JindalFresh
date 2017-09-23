package com.example.android.jindalfresh.app_activities.home;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private ArrayAdapter<Integer> spinnerQuantityIntervalAdaptor;
    private List<ProductModel> products;
    private Context context;
    private ProductModel product;

    public ProductAdapter(List<ProductModel> products, Context context) {
        this.products = products;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
        return new ViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position, List payloads) {
        if (payloads.size() > 0) {
            product = products.get(position);
            Log.i(this.getClass().getSimpleName(), "Payload provided" + payloads);
            holder.textViewQuantity.setText(Integer.toString(product.getTotalQuantity()));
            holder.textViewPrice.setText(Integer.toString(product.totalPrice()));
        } else {
            Log.i(this.getClass().getSimpleName(), "No Payload" + payloads);
            super.onBindViewHolder(holder, position, payloads);
        }
    }


    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        product = products.get(position);
        product.setDefaultQuantity();
        product.setDefaultSelectedPackSize();

        holder.textViewEngName.setText(product.getEngName());
        holder.textViewHindiName.setText(product.getHindiName());
        holder.textViewQuantity.setText(Integer.toString(product.getTotalQuantity()));
        holder.textViewPrice.setText(Integer.toString(product.totalPrice()));

        Picasso.with(context).load(product.getCompleteImageUrl()).into(holder.imageView);


        //*********************Spinner*********************************
        ArrayList<Integer> quantityInterval = product.getQunatityInterval();
        spinnerQuantityIntervalAdaptor = new ArrayAdapter<Integer>(context, android.R.layout.simple_spinner_item, quantityInterval);
        spinnerQuantityIntervalAdaptor.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner.setAdapter(spinnerQuantityIntervalAdaptor);

        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int spinnerPosition, long id) {
                products.get(position).setSelectedPackSize((Integer) parent.getItemAtPosition(spinnerPosition));
                ProductAdapter.this.notifyItemChanged(position, new Boolean(true));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        //*********************Spinner*********************************


        holder.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                products.get(position).doIncrement();
                if (!AppData.getCartItemHandler().CheckProductInCart(products.get(position))) {
                    AppData.getCartItemHandler().setProducts(products.get(position));
                }
                ProductAdapter.this.notifyItemChanged(position, new Boolean(true));

            }
        });
        holder.buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                products.get(position).doDecrement();
                if (products.get(position).getTotalQuantity() == 0) {
                    if (AppData.getCartItemHandler().CheckProductInCart(products.get(position))) {
                        AppData.getCartItemHandler().removeProducts(products.get(position));
                    }
                }
                ProductAdapter.this.notifyItemChanged(position, new Boolean(true));
            }
        });

    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEngName;
        public TextView textViewHindiName;
        public ImageView imageView;
        public TextView textViewQuantity;
        public Button buttonIncrement;
        public Button buttonDecrement;
        public TextView textViewPrice;
        public Spinner spinner;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewHindiName = (TextView) itemView.findViewById(R.id.textViewHindiName);
            textViewEngName = (TextView) itemView.findViewById(R.id.textViewEngName);
            imageView = (ImageView) itemView.findViewById(R.id.productImageView);
            textViewQuantity = (TextView) itemView.findViewById(R.id.tv_Quantity);
            textViewPrice = (TextView) itemView.findViewById(R.id.TotalPrice);

            buttonIncrement = (Button) itemView.findViewById(R.id.btn_Increment);
            buttonDecrement = (Button) itemView.findViewById(R.id.btn_Decrement);

            spinner = (Spinner) itemView.findViewById(R.id.spinner);
        }


    }
}
