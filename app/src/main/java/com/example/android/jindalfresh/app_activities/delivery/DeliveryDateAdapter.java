package com.example.android.jindalfresh.app_activities.delivery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;

import java.util.List;

public class DeliveryDateAdapter extends RecyclerView.Adapter<DeliveryDateAdapter.ViewHolder> {

    private List<DeliveryDateModel> dateTimeList;
    private Context context;

    public DeliveryDateAdapter(List<DeliveryDateModel> dateTimeList, Context context) {
        this.dateTimeList = dateTimeList;
        this.context = context;

    }


    @Override
    public DeliveryDateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverydate_adapter_view, parent, false);
        return new DeliveryDateAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        DeliveryDateModel dateTime = dateTimeList.get(position);

        holder.textViewDate.setText(dateTime.getDate());
        holder.textViewTime.setText(dateTime.getTime());

        holder.linearLayoutrootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "Your Delivery will Be on" + dateTimeList.get(position).getDate() + dateTimeList.get(position).getTime(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return dateTimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewDate;
        public TextView textViewTime;
        public LinearLayout linearLayoutrootView;


        public ViewHolder(View itemView) {
            super(itemView);

            textViewDate = (TextView) itemView.findViewById(R.id.deliveryDate_textViewDate);
            textViewTime = (TextView) itemView.findViewById(R.id.deliveryDate_textViewTime);
            linearLayoutrootView = (LinearLayout) itemView.findViewById(R.id.delivery_date_LL_rootView);

        }
    }
}
