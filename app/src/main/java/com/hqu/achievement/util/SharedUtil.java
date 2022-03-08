package com.hqu.achievement.util;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class  SharedUtil{
    private volatile static SharedPreferences sharadPreferences;
    public static SharedPreferences getInstance(Context context){
        if (sharadPreferences==null){
            sharadPreferences=context.getSharedPreferences("user_info", Context.MODE_PRIVATE);
        }
        return sharadPreferences;
    }

    public Map<String, ?> getAll() {
        return null;
    }

    public static String getString(String key, String defValue) {
        return sharadPreferences.getString(key,defValue);
    }

    public static Set<String> getStringSet(String key,Set<String> defValues) {
        return sharadPreferences.getStringSet(key, defValues);
    }

    public static int getInt(String key, int defValue) {
        return sharadPreferences.getInt(key,defValue);
    }

    public static long getLong(String key, long defValue) {
        return sharadPreferences.getLong(key, defValue);
    }

    public static float getFloat(String key, float defValue) {
        return sharadPreferences.getFloat(key, defValue);
    }

    public static boolean getBoolean(String key, boolean defValue) {
        return sharadPreferences.getBoolean(key, defValue);
    }

    public static boolean contains(String key) {
        return sharadPreferences.contains(key);
    }

    public static SharedPreferences.Editor edit() {
        return sharadPreferences.edit();
    }

    public static <T> void put(String key, T value){
        if (value instanceof String){
            sharadPreferences.edit().putString(key,(String) value).apply();
        }else if (value instanceof Integer){
            sharadPreferences.edit().putInt(key,(Integer)value).apply();
        }else if (value instanceof Float){
            sharadPreferences.edit().putFloat(key,(Float) value).apply();
        }else if(value instanceof Boolean){
            sharadPreferences.edit().putBoolean(key,(Boolean) value).apply();
        }else if (value instanceof Long){
            sharadPreferences.edit().putLong(key,(Long) value).apply();
        }
    }

    public static void remove(String key){
        sharadPreferences.edit().remove(key).apply();
    }


}
