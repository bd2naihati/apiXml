package com.bis.myjavaxmlapitest.data.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.bis.myjavaxmlapitest.data.model.xmlModel.author.Author;
import com.bis.myjavaxmlapitest.data.repository.TestRepository;
import com.bis.myjavaxmlapitest.network.ResponseState;

public class TestViewModel extends ViewModel {
    TestRepository testRepository;

    public TestViewModel(TestRepository testRepository) {
        this.testRepository = testRepository;
    }

    public void testData(){
        testRepository.getTestData();
    }

    public LiveData<ResponseState<Author>>getTestData(){
        return testRepository.testData();
    }



}
