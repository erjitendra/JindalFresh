package com.example.android.jindalfresh.app_activities.home;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.cart.CartItemHandler;
import com.example.android.jindalfresh.product.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    public static CartItemHandler cartItemHanlder = new CartItemHandler();
    Spinner spinner;
    ArrayAdapter<CharSequence> adapter1;
    private List<Product> listItems;
    private Context context;

    public ProductAdapter(List<Product> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    public static CartItemHandler getCartItemHandlerFromAdaptor() {

        return cartItemHanlder;
    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Product listItem = listItems.get(position);
        adapter1 = ArrayAdapter.createFromResource(context, R.array.country_names, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        holder.textViewEngName.setText(listItem.getEngName());
        holder.textViewHindiName.setText(listItem.getHindiName());
        holder.textViewQuantity.setText(Integer.toString(listItem.getTotalQuantity()));
        holder.textViewPrice.setText(Integer.toString(listItem.totalPrice()));
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);
        holder.spinner.setAdapter(adapter1);
        holder.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(context, parent.getItemAtPosition(position) + "Selected", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String totalQuantityDetail = Integer.toString(listItem.getTotalQuantity()) + " " + listItem.getUnit();
        holder.textViewTotalQuantity.setText(totalQuantityDetail);
        holder.buttonAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (!cartItemHanlder.CheckProductInCart(listItem)) {
                    holder.buttonAddToCart.setText("Added");
                    cartItemHanlder.setProducts(listItem);
                    holder.cartItems_No_display.setText(Integer.toString(cartItemHanlder.getCartsize()));

                    Toast.makeText(context, "New CartSize:" + cartItemHanlder.getCartsize(), Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(context, "Already Added", Toast.LENGTH_LONG).show();
                }
            }
        });

        holder.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Position is" + position, Toast.LENGTH_SHORT).show();
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
        public TextView textViewEngName, cartItems_No_display;
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
            buttonSubmit = (RelativeLayout) itemView.findViewById(R.id.btn_submit);
            spinner = (Spinner) itemView.findViewById(R.id.spinner);
            cartItems_No_display = (TextView) itemView.findViewById(R.id.cart_items_no_display);



        }


    }
}
