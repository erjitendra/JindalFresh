package com.example.android.jindalfresh.app_activities.viewOrder;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.android.jindalfresh.R;
import com.example.android.jindalfresh.generic.AppData;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ViewOrderFragment extends AppCompatActivity {
    private static final String urlData = "http://lit-dusk-68336.herokuapp.com/api/v1/product/userorder/";
    Context context = this;
    private RecyclerView.Adapter adapter;
    private RecyclerView recyclerView;
    private List<ViewOrderGetter> listItems = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView_order_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl(AppData.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        OrderClient client = retrofit.create(OrderClient.class);


        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();

        Call<List<ViewOrderGetter>> call = client.getOrders(accessToken);

        call.enqueue(new Callback<List<ViewOrderGetter>>() {
            @Override
            public void onResponse(Call<List<ViewOrderGetter>> call, retrofit2.Response<List<ViewOrderGetter>> response) {

                if (response.body() != null) {
                    listItems = response.body();
                    adapter = new ViewOrdersAdapter(listItems, context);
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(context, "No orders", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<ViewOrderGetter>> call, Throwable t) {

                Toast.makeText(context, "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();


            }

        });

    }
}


//    //    @Override
////    public View onCreateView(LayoutInflater inflater, ViewGroup container,
////                             Bundle savedInstanceState) {
////        View rootView = inflater.inflate(R.layout.fragment_search, container, false);
//        recyclerView = (RecyclerView)findViewById(R.id.recyclerView_order_view);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
//
//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl(AppData.BASE_URL)
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        OrderClient client = retrofit.create(OrderClient.class);
//
////        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();
//        String accessToken = "Bearer " + AppData.getUserModelToken().getAccessToken();
//
//        Call<List<ViewOrderGetter>> call = client.getOrders(accessToken);
//
//        call.enqueue(new Callback<List<ViewOrderGetter>>() {
//            @Override
//            public void onResponse(Call<List<ViewOrderGetter>> call, retrofit2.Response<List<ViewOrderGetter>> response) {
//
//                if (response.body() != null) {
//                    listItems = response.body();
//                    adapter = new ViewOrdersAdapter(listItems, getContext());
//                    recyclerView.setAdapter(adapter);
//                } else {
//                    Toast.makeText(getContext(), "No orders", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<List<ViewOrderGetter>> call, Throwable t) {
//
//                Toast.makeText(getContext(), "Failed, went wrong" + t.getMessage(), Toast.LENGTH_SHORT).show();
//
//
//            }
//        });
//
//        return rootView;
//    }
//}
