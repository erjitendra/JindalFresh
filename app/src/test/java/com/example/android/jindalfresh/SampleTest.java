package com.example.android.jindalfresh;

import android.util.Log;

import com.example.android.jindalfresh.tests.SampleModel;
import com.example.android.jindalfresh.tests.SampleModelClient;

import org.junit.Test;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static org.junit.Assert.assertEquals;

/**
 * Created by Djindal on 05-09-2017.
 */

public class SampleTest {
    @Test
    public void getRequest(){

        System.out.print("hello");


        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("http://lit-dusk-68336.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();

        SampleModelClient client = retrofit.create(SampleModelClient.class);

        Call<ArrayList<SampleModel>> call = client.getTest();

        System.out.print("hello2");

        call.enqueue(new Callback<ArrayList<SampleModel>>() {
            @Override
            public void onResponse(Call<ArrayList<SampleModel>> call, Response<ArrayList<SampleModel>> response) {
                Log.v("ABCDE", "test"+ response.body());
                System.out.print("hello");
                assertEquals(8, response.body().size());
            }

            @Override
            public void onFailure(Call<ArrayList<SampleModel>> call, Throwable t) {
                System.out.print("hello 3");

            }
        });

    }
}
