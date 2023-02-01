package com.example.moves;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    ProgressDialog progressDialog;
    RecyclerView recyclerView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView1=findViewById(R.id.rv1);
        progressDialog =mydiDialog();
        progressDialog.show();
        getData();
        
    }

    private void getData(){

        Call<List<User>> call = Retrofitclinte.getInstance().getApi().getusers();
        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(!response.isSuccessful()){
                    Toast.makeText(MainActivity.this, ""+response.code(), Toast.LENGTH_SHORT).show();
                }else{

                    List<User> users = response.body();
                    AdapterForRV adapterForRV=new AdapterForRV(users,MainActivity.this);
                    RecyclerView.LayoutManager layoutManager1=new LinearLayoutManager(MainActivity.this,LinearLayoutManager.HORIZONTAL,false);
                    StaggeredGridLayoutManager staggeredGridLayoutManager=new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
                    recyclerView1.setAdapter(adapterForRV);
                    recyclerView1.setLayoutManager(layoutManager1);
                    recyclerView1.setHasFixedSize(true);

                }

                progressDialog.dismiss();

            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {

                progressDialog.dismiss();
            }
        });

    }


    private ProgressDialog mydiDialog(){
        ProgressDialog progressDialog=new ProgressDialog(this);
        progressDialog.setTitle("on fetching");
        progressDialog.setMessage("loading your data");
        progressDialog.setProgressStyle(progressDialog.STYLE_SPINNER);
        progressDialog.setCancelable(false);
        return progressDialog;
    }

}







