package com.example.mobdevtasks.prac5;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mobdevtasks.R;

import java.util.ArrayList;
import java.util.List;

public class CustomAdapter extends BaseAdapter {

    Context context;
    List<Item> mDataSet;
    LayoutInflater myLft;

    public CustomAdapter(Context context, List<Item> mDataSet) {
        this.context = context;
        this.myLft = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        this.mDataSet = mDataSet;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Item getItem(int i) {
        return mDataSet.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = myLft.inflate(android.R.layout.simple_list_item_multiple_choice, viewGroup, false);

        ((TextView) view.findViewById(android.R.id.text1)).setText(getItem(i).name + " - " + getItem(i).price + "p\n" + getItem(i).description + ", code - " + getItem(i).markCode);
//        ((TextView) view.findViewById(R.id.el_price)).setText(getItem(i).price + "p");
//        ((TextView) view.findViewById(R.id.el_description)).setText(getItem(i).description);
//        ((TextView) view.findViewById(R.id.el_markCode)).setText("code - " + getItem(i).markCode);
        return view;
    }

}
