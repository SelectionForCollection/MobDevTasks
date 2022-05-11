package com.example.mobdevtasks.prac5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mobdevtasks.R;

import java.util.ArrayList;
import java.util.List;

public class FirstActivity_P5 extends AppCompatActivity{

    String[] item_names;
    int[] item_prices;
    String[] item_descriptions;
    int[] item_markCodes;

    List<Boolean> selectedItems = new ArrayList<>();
    List<Item> mDataSet = new ArrayList<>();
    ListView listView;
    Button cartButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prac5_first_page);

        item_names = getResources().getStringArray(R.array.item_names);
        item_prices = getResources().getIntArray(R.array.item_prices);
        item_descriptions = getResources().getStringArray(R.array.item_description);
        item_markCodes = getResources().getIntArray(R.array.item_markCodes);

        for (int i = 0; i < item_names.length; i++) {
            mDataSet.add(new Item(item_names[i], item_prices[i], item_descriptions[i], item_markCodes[i], false));
            selectedItems.add(false);
        }

        listView = findViewById(R.id.list_view);
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);

        CustomAdapter adapter = new CustomAdapter(this, mDataSet);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {
                TextView footer = findViewById(R.id.footer_text_view);

                CheckedTextView checkedTextView = (CheckedTextView) v;
                selectedItems.set(position, checkedTextView.isChecked());

                String footerItems="";
                for(int i = 0; i < item_names.length; i++) {
                    if(selectedItems.get(i))
                        footerItems += item_names[i] + "\n";
                }
                footer.setText(footerItems);
            }
        });

        listView.addFooterView(getLayoutInflater().inflate(R.layout.footer, null));

        cartButton = findViewById(R.id.to_cart);
        cartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView footer = findViewById(R.id.footer_text_view);
                String[] cartList = footer.getText().toString().split("\n");
                int cartPrice = 0;
                for (String e: cartList) {
                    for (int i = 0; i < selectedItems.size(); i++) {
                        if (selectedItems.get(i)) {
                            if (e.equals(mDataSet.get(i).name)) {
                                cartPrice += mDataSet.get(i).price;
                            }
                        }
                    }
                }

                Intent cartIntent = new Intent(FirstActivity_P5.this, SecondActivity_P5.class);
                cartIntent.putExtra("mDataSet", footer.getText().toString().split("\n"));
                cartIntent.putExtra("price", cartPrice);

                startActivity(cartIntent);
            }
        });

    }
}
