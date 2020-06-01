package com.lab.taxi.data;

import android.content.Context;
import android.content.SharedPreferences;

import com.lab.taxi.App;
import com.lab.taxi.common.consts.Const;

public class MyPreferences {

    private static SharedPreferences storageInstance;

    public static MyPreferences getPreferences(){
        storageInstance = App.getAppContext().getSharedPreferences(Const.PREFERENCES_NAME, Context.MODE_PRIVATE);
        return new MyPreferences();
    }

    public void setName(String name) {
        storageInstance.edit().putString(Const.NAME, name).apply();
    }

    public void setSurName(String surName) {
        storageInstance.edit().putString(Const.SURNAME, surName).apply();
    }

    public void setNumber(String number) {
        storageInstance.edit().putString(Const.NUMBER, number).apply();
    }

    public String getNumber() {
        return storageInstance.getString(Const.NUMBER, "");
    }

    public String getName() {
        return storageInstance.getString(Const.NAME, "");
    }

    public String getSurName() {
        return storageInstance.getString(Const.SURNAME, "");
    }
}
