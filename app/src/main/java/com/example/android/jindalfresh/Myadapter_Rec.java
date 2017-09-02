package com.example.android.jindalfresh;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by Jindal on 9/1/2017.
 */

public class Myadapter_Rec extends RecyclerView.Adapter<Myadapter_Rec.ViewHolder> {
    private List<Rec_ListItem> listItems;
    private Context context;


    public Myadapter_Rec(List<Rec_ListItem> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycle_list_item, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {

        final Rec_ListItem listItem = listItems.get(position);

        holder.textViewHead.setText(listItem.getHead());
        holder.textViewDesc.setText(listItem.getDesc());
        holder.quantity.setText(Integer.toString(listItem.getTotalQuantity()));
        Picasso.with(context).load(listItem.getImageUrl()).into(holder.imageView);

        holder.increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Position is" + position, Toast.LENGTH_SHORT).show();
                listItem.setTotalQuantity(listItem.getTotalQuantity() + 1);
                notifyItemChanged(position);
            }
        });

    }


    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        public LinearLayout linearLayout;
        public TextView quantity;
        public Button increment;

        public ViewHolder(View itemView) {
            super(itemView);
            textViewDesc = (TextView) itemView.findViewById(R.id.textViewDesc);
            textViewHead = (TextView) itemView.findViewById(R.id.textViewHeading);
            imageView = (ImageView) itemView.findViewById(R.id.imageRec);
            linearLayout = (LinearLayout) itemView.findViewById(R.id.linearRecView);
            quantity = (TextView) itemView.findViewById(R.id.Quantity);
            increment = (Button) itemView.findViewById(R.id.increment);
            Log.v("Jit", "Hi" + imageView);
        }

        @Override
        public void onClick(View v) {
//            int position=getAdapterPosition();
//            //Log.v("dheere"ASDF"+position);
//            Log.v("ERT","ASDF"+position);
//            Log.v("shyam","ASDF"+v.getId());
//
//            switch ((v.getId()))
//            {
//                case R.id.increment:
//                    quantity.setText("HI");
//                    Log.v("ram","ASDF");
//
//            }

        }
    }
}
