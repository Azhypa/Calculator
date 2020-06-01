package com.lab.minishop.models;

import android.os.Parcel;
import android.os.Parcelable;

public class Good implements Parcelable {
    private int number;
    private String name;
    private int price;
    private boolean checked;

    public Good(int number, String name, int price) {
        this.number = number;
        this.name = name;
        this.price = price;
        checked = false;
    }

    protected Good(Parcel in) {
        number = in.readInt();
        name = in.readString();
        price = in.readInt();
        checked = in.readByte() != 0;
    }

    public static final Creator<Good> CREATOR = new Creator<Good>() {
        @Override
        public Good createFromParcel(Parcel in) {
            return new Good(in);
        }

        @Override
        public Good[] newArray(int size) {
            return new Good[size];
        }
    };

    public int getNumber() {
        return number;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(name);
        dest.writeInt(price);
        dest.writeByte((byte) (checked ? 1 : 0));
    }
}
