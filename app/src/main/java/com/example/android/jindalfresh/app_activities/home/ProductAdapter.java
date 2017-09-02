package com.example.android.jindalfresh.app_activities.home;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.product.Product;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {
    private List<Product> listItems;
    private Context context;

    public ProductAdapter(List<Product> listItems, Context context) {
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

        final Product listItem = listItems.get(position);

        holder.textViewEngName.setText(listItem.getEngName());
        holder.textViewHindiName.setText(listItem.getHindiName());
        holder.textViewQuantity.setText(Integer.toString(listItem.getTotalQuantity()));
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

        holder.buttonIncrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context, "Position is" + position, Toast.LENGTH_SHORT).show();
                listItem.setTotalQuantity(listItem.getTotalQuantity() + 1);
                notifyItemChanged(position);
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
        public TextView textViewQuantity;
        public Button buttonIncrement;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewHindiName = (TextView) itemView.findViewById(R.id.textViewHindiName);
            textViewEngName = (TextView) itemView.findViewById(R.id.textViewEngName);
            imageView = (ImageView) itemView.findViewById(R.id.productImageView);
            textViewQuantity = (TextView) itemView.findViewById(R.id.tv_Quantity);
            buttonIncrement = (Button) itemView.findViewById(R.id.btn_Increment);

        }
    }
}
