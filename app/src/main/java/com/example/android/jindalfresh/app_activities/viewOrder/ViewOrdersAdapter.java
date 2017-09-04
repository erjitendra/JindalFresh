package com.example.android.jindalfresh.app_activities.viewOrder;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.app_activities.home.ProductAdapter;
import com.example.android.jindalfresh.cart.CartItemHandler;
import com.example.android.jindalfresh.cart.CartItemView;

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

        holder.orderView_textViewOrderDate.setText("Order Time: "+ listItem.getDate());
        holder.orderView_textViewQuantity.setText("Quantity: "+listItem.getToatlQuantity());
        holder.orderView_textViewPrice.setText("Paid: " + listItem.getToatlPrice()+ " Rs");


        holder.linearLayoutDetailView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(context,"Position is"+position,Toast.LENGTH_LONG).show();

                Intent in = new Intent(context, OrderDetailView.class);
                Log.v("Mumbai", "in view order adaptor");
                in.putExtra("orderItem", listItem);
                context.startActivity(in);
            }
        });
    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView orderView_textViewOrderDate;
        public TextView orderView_textViewQuantity;
        public TextView orderView_textViewPrice;
        public LinearLayout linearLayoutDetailView;


        public ViewHolder(View itemView) {
            super(itemView);

            orderView_textViewOrderDate = (TextView) itemView.findViewById(R.id.textView_Order_Date);
            orderView_textViewQuantity = (TextView) itemView.findViewById(R.id.textView_Total_Quantity_Order_View);
            orderView_textViewPrice = (TextView) itemView.findViewById(R.id.textView_Total_Price_Order_View);
            linearLayoutDetailView=(LinearLayout)itemView.findViewById(R.id.order_View_LinearLayout);


        }


    }
}
