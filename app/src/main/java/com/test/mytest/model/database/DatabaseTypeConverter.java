package com.test.mytest.model.database;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;

public class DatabaseTypeConverter {

    Gson gson ;

    public DatabaseTypeConverter() {
        this.gson = new Gson();
    }

    @TypeConverter
    public String StringListTypeConverter(StringList strings){
        return gson.toJson(strings);
    }

    @TypeConverter
    public StringList getStringList(String s){
        Type type = new TypeToken<StringList>(){}.getType();
        return gson.fromJson(s,type);
    }
}
