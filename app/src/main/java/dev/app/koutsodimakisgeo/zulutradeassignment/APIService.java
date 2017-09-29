package dev.app.koutsodimakisgeo.zulutradeassignment;

import java.util.List;


import dev.app.koutsodimakisgeo.zulutradeassignment.Model.ProductModel;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by koutsodimakisgeo on 28-Sep-17.
 */

public interface APIService  {

    @GET("api/rates")
    Observable<List<ProductModel>> getproductdata();

}
