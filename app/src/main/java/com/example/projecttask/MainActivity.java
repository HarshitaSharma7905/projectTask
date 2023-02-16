package com.example.projecttask;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
 Button btnView,btnFetch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnView=findViewById(R.id.btnView);
        btnFetch=findViewById(R.id.btnFetch);
//        BTNFETCH:---
        btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iMain=new Intent(MainActivity.this,MainActivity2.class);
                startActivity(iMain);
            }
        });

//        BTNVIEW:=---------
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                APIData apiData= RetrofitClient.retrofitInstance().create(APIData.class);
                Call<DataModel> dataList= apiData.getData();
                dataList.enqueue(new Callback<DataModel>() {
                    @Override
                    public void onResponse(Call<DataModel> call, Response<DataModel> response) {
                        DataModel dataModel=new DataModel(response.body().getId(),response.body().getImage().getMedium(),
                                response.body().getName(),response.body().getType(),response.body().getLanguage(),
                                response.body().getStatus(),response.body().getRuntime(),response.body().getAverageRuntime(),
                                response.body().getPremiered(),response.body().getEnded(),response.body().getOfficialSite());
                        DatabaseHelper databaseHelper=new DatabaseHelper(MainActivity.this);
                        databaseHelper.addData(dataModel);
                    }

                    @Override
                    public void onFailure(Call<DataModel> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Error", Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });



    }
}