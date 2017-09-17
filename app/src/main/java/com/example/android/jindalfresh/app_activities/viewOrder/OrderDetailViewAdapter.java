package com.example.android.jindalfresh.app_activities.viewOrder;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.product.ProductModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class OrderDetailViewAdapter extends RecyclerView.Adapter<OrderDetailViewAdapter.ViewHolder> {
    private List<ProductModel> listItems;

    private Context context;

    public OrderDetailViewAdapter(List<ProductModel> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_detail_adapter_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final ProductModel listItem = listItems.get(position);

        Log.v("Mumbai", "in order detail adaptor"+ position);
        Log.v("Mumbai", "in order detail adaptor" + listItem.getCompleteImageUrl());

        holder.textViewEngName.setText(listItem.getEngName());
        holder.textViewHindiName.setText(listItem.getHindiName());
        holder.textViewPrice.setText(Integer.toString(listItem.totalPrice()));

        Picasso.with(context).load(listItem.getCompleteImageUrl()).into(holder.imageView);
        String totalQuantityDetail = Integer.toString(listItem.getTotalQuantity()) + " " + listItem.getUnit();
        holder.textViewTotalQuantity.setText(totalQuantityDetail);
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewEngName;
        public TextView textViewHindiName;
        public ImageView imageView;
        public TextView textViewPrice;
        public TextView textViewTotalQuantity;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewHindiName = (TextView) itemView.findViewById(R.id.OrderedItemDetail_textViewHindiName);
            textViewEngName = (TextView) itemView.findViewById(R.id.OrderedItemDetail_textViewEngName);
            imageView = (ImageView) itemView.findViewById(R.id.OrderedItemDetail_ImageView);
            textViewPrice = (TextView) itemView.findViewById(R.id.OrderedItemDetail_TotalPrice);
            textViewTotalQuantity = (TextView) itemView.findViewById(R.id.OrderedItemDetail_TotalQuantity);
        }
    }
}
