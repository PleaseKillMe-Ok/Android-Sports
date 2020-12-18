package com.example.giao.Api;

import com.example.giao.Bean.LoginRequest;
import com.example.giao.Bean.Verification;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface getSteps {

    @POST("auth-api/login-api")
    Call<Verification> getLoginResult(@Header("apikey") String apikey);
}
