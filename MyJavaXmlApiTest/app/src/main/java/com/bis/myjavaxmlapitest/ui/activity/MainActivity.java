package com.bis.myjavaxmlapitest.ui.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.bis.myjavaxmlapitest.R;
import com.bis.myjavaxmlapitest.adapter.ExpenceAdapter;
import com.bis.myjavaxmlapitest.data.model.xmlModel.author.Author;
import com.bis.myjavaxmlapitest.data.repository.TestRepository;
import com.bis.myjavaxmlapitest.data.viewModel.TestViewModel;
import com.bis.myjavaxmlapitest.databinding.ActivityMainBinding;
import com.bis.myjavaxmlapitest.network.ApiInterface;
import com.bis.myjavaxmlapitest.network.ApiUtility;
import com.bis.myjavaxmlapitest.network.ResponseState;
import com.bis.myjavaxmlapitest.ui.base.ViewModelFactory;

public class MainActivity extends AppCompatActivity {
    TestViewModel viewModel;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        init();
        observer();
    }
    private void init(){
        ApiInterface apiInterface= new ApiUtility().getInstance().create(ApiInterface.class);
        TestRepository repository=new TestRepository(apiInterface,this);
        ViewModelFactory factory=new ViewModelFactory(repository);
        viewModel= new ViewModelProvider(this,factory).get(TestViewModel.class);
        viewModel.testData();
    }
    private void observer(){
        viewModel.getTestData().observe(this,new Observer<ResponseState<Author>>(){

            @Override
            public void onChanged(ResponseState<Author> s) {
                  /*
                <author  name="Biswajit" isbn="1234">
<title>My Books</title>
<books>
<book>
<title>b1</title>
</book>
<book>
<title>b2</title>
</book>

<book>
<title>b3</title>
</book>
<books>
</author>
                 */
                int i=0;
                /**/
                if (s.getData()!=null){
                    if (s.getData().bookList!=null) {
                        binding.regExp.setAdapter(new ExpenceAdapter(s.getData().bookList));
                        binding.regExp.setFocusable(true);
                        i = s.getData().bookList.size();
                        for (int j=0;j<i;j++){
                            Log.d("TAG_value", "onChanged: "+s.getData().bookList.get(j).title);
                        }
                    }
                    Toast.makeText(MainActivity.this, i+":"+s.getData().name, Toast.LENGTH_SHORT).show();

                }

            }


        });
    }
}