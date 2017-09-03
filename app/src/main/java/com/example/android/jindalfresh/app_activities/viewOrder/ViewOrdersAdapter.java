package com.example.android.jindalfresh.app_activities.viewOrder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.jindalfresh.R;

import java.util.List;


public class ViewOrdersAdapter extends RecyclerView.Adapter<ViewOrdersAdapter.ViewHolder> {

    private List<ViewOrderGetter> listItems;
    private Context context;

    public ViewOrdersAdapter(List<ViewOrderGetter> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
        Log.v("PQRS", "HIIIIII" + listItems.size());

    }


    @Override
    public ViewOrdersAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.order_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewOrdersAdapter.ViewHolder holder, final int position) {

        final ViewOrderGetter listItem = listItems.get(position);
        Log.v("PQRS", "HIIIIII" + listItems.get(position));

        holder.orderView_textViewOrderDate.setText(listItem.getDate());
        holder.orderView_textViewQuantity.setText(listItem.getToatlQuantity());
        holder.orderView_textViewPrice.setText(listItem.getToatlPrice());
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView orderView_textViewOrderDate;
        public TextView orderView_textViewQuantity;
        public TextView orderView_textViewPrice;


        public ViewHolder(View itemView) {
            super(itemView);

            orderView_textViewOrderDate = (TextView) itemView.findViewById(R.id.textView_Order_Date);
            orderView_textViewQuantity = (TextView) itemView.findViewById(R.id.textView_Total_Quantity_Order_View);
            orderView_textViewPrice = (TextView) itemView.findViewById(R.id.textView_Total_Price_Order_View);


        }


    }
}
