package com.example.android.jindalfresh.app_activities.home;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

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
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        product = products.get(position);


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

        //*********************Spinner*********************************

        String totalQuantityDetail = Integer.toString(product.getTotalQuantity()) + " " + product.getUnit();
        holder.textViewTotalQuantity.setText(totalQuantityDetail);
        holder.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!AppData.getCartItemHandler().CheckProductInCart(product)) {
                    holder.buttonAddToCart.setText("Added");
                    AppData.getCartItemHandler().setProducts(product);
                } else {
                    Toast.makeText(context, "Already Added", Toast.LENGTH_LONG).show();
                }
            }
        });

        holder.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                product.doIncrement();
                notifyItemChanged(position);

            }
        });
        holder.buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Position is" + position, Toast.LENGTH_SHORT).show();
                product.doDecrement();
                notifyItemChanged(position);
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
        public Button buttonAddToCart;
        public TextView textViewPrice;
        public TextView textViewTotalQuantity;
        public Spinner spinner;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewHindiName = (TextView) itemView.findViewById(R.id.textViewHindiName);
            textViewEngName = (TextView) itemView.findViewById(R.id.textViewEngName);
            imageView = (ImageView) itemView.findViewById(R.id.productImageView);
            textViewQuantity = (TextView) itemView.findViewById(R.id.tv_Quantity);
            textViewPrice = (TextView) itemView.findViewById(R.id.TotalPrice);
            textViewTotalQuantity = (TextView) itemView.findViewById(R.id.TotalQuantity);
            buttonIncrement = (Button) itemView.findViewById(R.id.btn_Increment);
            buttonDecrement = (Button) itemView.findViewById(R.id.btn_Decrement);
            buttonAddToCart = (Button) itemView.findViewById(R.id.btn_AddToCart);
            spinner = (Spinner) itemView.findViewById(R.id.spinner);
        }


    }
}
