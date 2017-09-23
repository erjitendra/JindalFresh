package com.example.android.jindalfresh.cart;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;
import com.example.android.jindalfresh.product.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.ViewHolder> {
    private List<ProductModel> listItems;

    private Context context;

    public CartItemAdapter(List<ProductModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_item_adapter_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final ProductModel listItem = listItems.get(position);

        holder.textViewEngName.setText(listItem.getEngName());
        holder.textViewHindiName.setText(listItem.getHindiName());
        holder.textViewPrice.setText(Integer.toString(listItem.totalPrice()));
        Picasso.with(context).load(listItem.getCompleteImageUrl()).into(holder.imageView);
        String totalQuantityDetail = Integer.toString(listItem.getTotalQuantity()) + " " + listItem.getUnit();
        holder.textViewTotalQuantity.setText(totalQuantityDetail);

        holder.imageViewDeleteItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listItems.remove(listItems.get(position));
                AppData.getCartItemHandler().updateCartQuantityNumberText();
                notifyItemRemoved(position);


            }
        });
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEngName;
        public TextView textViewHindiName;
        public ImageView imageView;
        public ImageView imageViewDeleteItem;
        public TextView textViewPrice;
        public TextView textViewTotalQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewHindiName = (TextView) itemView.findViewById(R.id.cartItem_textViewHindiName);
            textViewEngName = (TextView) itemView.findViewById(R.id.cartItem_textViewEngName);
            imageView = (ImageView) itemView.findViewById(R.id.cartItem_ImageView);
            imageViewDeleteItem = (ImageView) itemView.findViewById(R.id.imageView_cartItem_delete);
            textViewPrice = (TextView) itemView.findViewById(R.id.cartItem_TotalPrice);
            textViewTotalQuantity = (TextView) itemView.findViewById(R.id.cartItem_TotalQuantity);
        }
    }
}
