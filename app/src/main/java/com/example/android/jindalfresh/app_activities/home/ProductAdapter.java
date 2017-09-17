package com.example.android.jindalfresh.app_activities.home;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
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
    Spinner spinner;
    ArrayAdapter<Integer> adapter1;
    private List<ProductModel> listItems;
    private Context context;
    private ProductModel listItem;

    public ProductAdapter(List<ProductModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        listItem = listItems.get(position);


        holder.textViewEngName.setText(listItem.getEngName());
        holder.textViewHindiName.setText(listItem.getHindiName());
        holder.textViewQuantity.setText(Integer.toString(listItem.getTotalQuantity()));
        holder.textViewPrice.setText(Integer.toString(listItem.totalPrice()));
        //holder.textViewSpinnerValue.setText(Integer.toString(listItem.getQuantityIntervalValue()));

        Picasso.with(context).load(listItem.getCompleteImageUrl()).into(holder.imageView);


        //*********************Spinner*********************************
        ArrayList<Integer> quantityInterval = listItem.getQunatityInterval();
        adapter1 = new ArrayAdapter<Integer>(context, android.R.layout.simple_spinner_item, quantityInterval);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinner.setAdapter(adapter1);

        //*********************Spinner*********************************

        String totalQuantityDetail = Integer.toString(listItem.getTotalQuantity()) + " " + listItem.getUnit();
        holder.textViewTotalQuantity.setText(totalQuantityDetail);
        holder.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!AppData.getCartItemHandler().CheckProductInCart(listItem)) {
                    holder.buttonAddToCart.setText("Added");
                    AppData.getCartItemHandler().setProducts(listItem);
                } else {
                    Toast.makeText(context, "Already Added", Toast.LENGTH_LONG).show();
                }
            }
        });

        holder.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                listItem.doIncrement();
                notifyItemChanged(position);

            }
        });
        holder.buttonDecrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Position is" + position, Toast.LENGTH_SHORT).show();
                listItem.doDecrement();
                notifyItemChanged(position);
            }
        });


    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEngName, textViewSpinnerValue;
        public TextView textViewHindiName;
        public ImageView imageView;
        public TextView textViewQuantity;
        public Button buttonIncrement;
        public Button buttonDecrement;
        public Button buttonAddToCart;
        public TextView textViewPrice;
        public TextView textViewTotalQuantity;
        public RelativeLayout buttonSubmit;
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
            //textViewSpinnerValue=(TextView)itemView.findViewById(R.id.spinnerValue);



        }


    }
}
