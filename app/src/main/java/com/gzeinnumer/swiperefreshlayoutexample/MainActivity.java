package com.gzeinnumer.swiperefreshlayoutexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private SwipeRefreshLayout swipeRefreshLayout;
    private TextView textView;

    private void initView() {
        swipeRefreshLayout = findViewById(R.id.swipeRefreshLayout);
        textView = findViewById(R.id.tv);

        swipeRefreshLayout.setOnRefreshListener(() -> {
            swipeRefreshLayout.setRefreshing(true);

            new Handler().postDelayed(() -> {
                Random r = new Random();
                int randomNumber = r.nextInt(100);
                textView.setText(randomNumber+"");
                swipeRefreshLayout.setRefreshing(false);
            }, 1000);
        });
    }
}