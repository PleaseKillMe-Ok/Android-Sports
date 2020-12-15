package com.example.giao.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.giao.Beansss;
import com.example.giao.R;
import com.example.giao.utils.Retrofit;
import com.example.giao.Test;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private Button mButton;
    private Retrofit retrofit;
    private Test service;
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Button btn = findViewById(R.id.btn);
//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent it = new Intent();
//                it.setClass(MainActivity.this, SkipActivity.class);
//                MainActivity.this.startActivity(it);
//            }
//        });
        mButton = (Button)findViewById(R.id.button);
        retrofit = Retrofit.getRetrofit();
        mTextView = (TextView) findViewById(R.id.tv_2);
        service = retrofit.getService();

        Button btn = findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(MainActivity.this, LoginActivity.class);
                MainActivity.this.startActivity(it);
            }
        });
    }

    public void ttt(View view) {
        Call<Beansss> call = service.getMenuById();
        call.enqueue(new Callback<Beansss>() {
            @Override
            public void onResponse(Call<Beansss> call, Response<Beansss> response) {
                if (response.isSuccessful()) {
                    Beansss result = response.body();//关键
                    if (result != null) {

                        int counts = result.getAll_notes_counts();
                        int praise = result.getAll_notes_praise();
                        int visit = result.getAll_notes_visit();
                        mTextView.setText("counts"+counts+"praise"+praise+"visit"+visit);
                        System.out.println("请求成功");
                    }
                }
            }

            @Override
            public void onFailure(Call<Beansss> call, Throwable t) {
                System.out.println("请求失败");
            }
        });

    }

    public void giao(View view) {
        Intent it = new Intent();
        it.setClass(MainActivity.this, ChartsActivity.class);
        MainActivity.this.startActivity(it);

    }

    public void bottom(View view) {
        // 测试底部导航栏
        Intent it = new Intent();
        it.setClass(MainActivity.this, BottomMenuActivity.class);
        MainActivity.this.startActivity(it);

    }
}
