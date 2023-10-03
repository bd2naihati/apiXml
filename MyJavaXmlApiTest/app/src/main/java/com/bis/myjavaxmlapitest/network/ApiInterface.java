package com.bis.myjavaxmlapitest.network;

import com.bis.myjavaxmlapitest.data.model.xmlModel.author.Author;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("xmltest.php")
    Call<Author> getTestData();
}
