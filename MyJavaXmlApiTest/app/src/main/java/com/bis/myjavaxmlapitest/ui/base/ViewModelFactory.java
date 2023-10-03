package com.bis.myjavaxmlapitest.ui.base;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.bis.myjavaxmlapitest.data.repository.TestRepository;
import com.bis.myjavaxmlapitest.data.viewModel.TestViewModel;

public class ViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    BaseRepository repository;

    public ViewModelFactory(BaseRepository repository) {
        this.repository = repository;
    }

    @Override
    public <T extends ViewModel> T create(Class<T> modelClass) {
        if (modelClass.isAssignableFrom(TestViewModel.class)){
            return (T) new TestViewModel((TestRepository) repository);
        }
        else{
            throw new IllegalArgumentException("ViewModelClass Not found");
        }
}
}
