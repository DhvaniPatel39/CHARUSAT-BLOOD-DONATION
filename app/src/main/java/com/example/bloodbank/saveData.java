package com.example.bloodbank;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class saveData {

    private static final String LIST_KEY = "list_key";

    public static void writeListInPref(Context context, ArrayList<Member> list)
    {
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(LIST_KEY,jsonString);
        editor.apply();
    }

    public static ArrayList<Member> readListFromPref(Context context)
    {
        SharedPreferences pref  = PreferenceManager.getDefaultSharedPreferences(context);
        String jsonString = pref.getString(LIST_KEY,"");

        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Member>>(){}.getType();
        ArrayList<Member> list = gson.fromJson(jsonString,type);
        return list;

    }
}
