package com.example.mobdevtasks.prac5;

import android.os.Parcel;
import android.os.Parcelable;

public class Item implements Parcelable {
    String name;
    int price;
    String description;
    int markCode;
    boolean isSelected;

    public Item(String name, int price, String description, int markCode, boolean isSelected) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.markCode = markCode;
        this.isSelected = isSelected;
    }

    protected Item(Parcel in) {
        name = in.readString();
        price = in.readInt();
        description = in.readString();
        markCode = in.readInt();
        isSelected = in.readByte() != 0;
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(price);
        parcel.writeString(description);
        parcel.writeInt(markCode);
        parcel.writeByte((byte) (isSelected ? 1 : 0));
    }
}
