package com.example.mobdevtasks.prac5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobdevtasks.R;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity_P5 extends AppCompatActivity {

    String[] mDataSet;
    int cartPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac5_second_page);

        mDataSet = getIntent().getStringArrayExtra("mDataSet");
        cartPrice = getIntent().getIntExtra("price", 0);

        ListView listView = findViewById(R.id.cart_list_view);

        ArrayAdapter<String> adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mDataSet);

        listView.setAdapter(adapter);

        TextView footer = findViewById(R.id.cartTotalPrice);
        footer.setText("Всего: " + cartPrice + "р");
    }
}