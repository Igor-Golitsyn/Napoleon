package com.example.golit.napoleonproject.bins;

import com.example.golit.napoleonproject.bins.ActionRes;
import com.example.golit.napoleonproject.bins.DataRes;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by golit on 28.04.2017.
 */

public interface GetBinsFromSite {
    @GET("ziw29")
    Call<List<DataRes>> getDataResList();

    @GET("16jt01")
    Call<List<ActionRes>> getActionResList();
}
