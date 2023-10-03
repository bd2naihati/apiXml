package com.bis.myjavaxmlapitest.data.repository;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.bis.myjavaxmlapitest.data.model.xmlModel.author.Author;
import com.bis.myjavaxmlapitest.network.ApiInterface;
import com.bis.myjavaxmlapitest.network.ResponseState;
import com.bis.myjavaxmlapitest.ui.base.BaseRepository;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TestRepository extends BaseRepository {
    ApiInterface apiInterface;
    Context ctx;

    public TestRepository(ApiInterface apiInterface, Context ctx) {
        this.apiInterface = apiInterface;
        this.ctx = ctx;
    }

    private MutableLiveData<ResponseState<Author>> _testData = new MutableLiveData<>();

    public LiveData<ResponseState<Author>> testData() {
        return _testData;
    }

    public void getTestData() {
        // Show loading state
        _testData.postValue(ResponseState.loading());

        Call<Author> call = apiInterface.getTestData();
        call.enqueue(new Callback<Author>() {
            @Override
            public void onResponse(Call<Author> call, Response<Author> response) {
                if (response.isSuccessful() && response.body() != null) {
                    // Successful response
                    _testData.postValue(ResponseState.success(response.body()));
                } else {
                    // Error response
                    String errorMessage = "API request failed";
                    if (response.errorBody() != null) {
                        try {
                            errorMessage = response.errorBody().string();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    _testData.postValue(ResponseState.error(errorMessage));
                }
            }

            @Override
            public void onFailure(Call<Author> call, Throwable t) {
                // API request failed
                String errorMessage = t.getMessage();
                _testData.postValue(ResponseState.error(errorMessage));
                Log.d("TAG_e1", "onChanged: " + errorMessage);
                Toast.makeText(ctx, "" + errorMessage, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
