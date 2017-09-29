package dev.app.koutsodimakisgeo.zulutradeassignment.Activity;


import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import dev.app.koutsodimakisgeo.zulutradeassignment.APIService;
import dev.app.koutsodimakisgeo.zulutradeassignment.Adapter.RecyclerAdapter;
import dev.app.koutsodimakisgeo.zulutradeassignment.Model.ProductModel;
import dev.app.koutsodimakisgeo.zulutradeassignment.R;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;


/**
 * Created by koutsodimakisgeo on 28-Sep-17.
 */


public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<ProductModel> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerview);

        // Writing data to SharedPreferences


        getProductData();
    }


    public void getProductData() {
        final ProgressDialog loading = ProgressDialog.show(this, "Fetching Data", "Please wait...", false, false);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://massignment.zulutrade.com")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
        APIService apiService = retrofit.create(APIService.class);

        Observable<List<ProductModel>> observable =
                apiService.getproductdata()
                        .repeatWhen(completed -> completed.delay(5, TimeUnit.SECONDS))
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread());


        observable.subscribe(new Observer<List<ProductModel>>() {
            @Override
            public void onCompleted() {
            }

            @Override
            public void onError(Throwable e) {
            }

            @Override
            public void onNext(List<ProductModel> products) {
                list = new ArrayList<>();
                for (int i = 0; i < products.size(); i++) {

                    ProductModel productModel = new ProductModel();
                    productModel.setName(products.get(i).getName());
                    productModel.setSell(products.get(i).getSell());
                    productModel.setBuy(products.get(i).getBuy());
                    list.add(productModel);
                    loading.dismiss();

                    System.out.println(products.get(i).getSell());


                }
                RecyclerAdapter recyclerAdapter = new RecyclerAdapter(list);
                RecyclerView.LayoutManager recycle = new LinearLayoutManager(MainActivity.this);
                recyclerView.setLayoutManager(recycle);
                recyclerView.setAdapter(recyclerAdapter);

            }


        });

    }


}






