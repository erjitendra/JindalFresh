package com.example.android.jindalfresh.app_activities.delivery;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.android.jindalfresh.R;

import java.util.ArrayList;
import java.util.List;

public class DeliveryDateAdapter extends RecyclerView.Adapter<DeliveryDateAdapter.ViewHolder> {
    private ArrayAdapter<String> spinnerDateTimeAdapter;
    private List<DeliveryDateModel> dateTimeList;
    private Context context;

    public DeliveryDateAdapter(List<DeliveryDateModel> dateTimeList, Context context) {
        this.dateTimeList = dateTimeList;
        this.context = context;

    }


//    @Override
//    public DeliveryDateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.deliverydate_adapter_view, parent, false);
//        return new DeliveryDateAdapter.ViewHolder(v);
//    }
//
//    @Override
//    public void onBindViewHolder(final ViewHolder holder, int position) {
//
//        DeliveryDateModel dateTime = dateTimeList.get(position);
//
//        holder.textViewDate.setText(dateTime.getDate());
//        holder.textViewTime.setText(dateTime.getTime());
//
//        holder.linearLayoutrootView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Toast.makeText(context, "Your Delivery will Be on" + dateTimeList.get(holder.getAdapterPosition()).getDate() + dateTimeList.get(holder.getAdapterPosition()).getTime(), Toast.LENGTH_LONG).show();
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return dateTimeList.size();
//    }
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView textViewDate;
//        public TextView textViewTime;
//        public LinearLayout linearLayoutrootView;
//
//
//        public ViewHolder(View itemView) {
//            super(itemView);
//
//            textViewDate = (TextView) itemView.findViewById(R.id.deliveryDate_textViewDate);
//            textViewTime = (TextView) itemView.findViewById(R.id.deliveryDate_textViewTime);
//            linearLayoutrootView = (LinearLayout) itemView.findViewById(R.id.delivery_date_LL_rootView);
//
//        }
//    }

    @Override
    public DeliveryDateAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.delivery_date_time_spinner_view, parent, false);
        return new DeliveryDateAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {

        //DeliveryDateModel dateTime = dateTimeList.get(position);

        ArrayList<String> deliveryTime = new ArrayList<String>();
        deliveryTime.add("17 Sep 7:00-9:00");
        deliveryTime.add("17 Sep 9:00-11:00");
        deliveryTime.add("17 Sep 11:00-13:00");
        deliveryTime.add("17 Sep 13:00-15:00");
        deliveryTime.add("18 Sep 7:00-9:00");
        deliveryTime.add("18 Sep 9:00-11:00");
        deliveryTime.add("18 Sep 11:00-13:00");
        deliveryTime.add("18 Sep 13:00-15:00");

        spinnerDateTimeAdapter = new ArrayAdapter<String>(context, android.R.layout.simple_spinner_item, deliveryTime);
        spinnerDateTimeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        holder.spinnerDate.setAdapter(spinnerDateTimeAdapter);
    }

    @Override
    public int getItemCount() {
        return dateTimeList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public Spinner spinnerDate;



        public ViewHolder(View itemView) {
            super(itemView);

            spinnerDate = (Spinner) itemView.findViewById(R.id.delivery_date_spinner);


        }
    }

}
