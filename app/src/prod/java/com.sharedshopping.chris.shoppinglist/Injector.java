package com.sharedshopping.chris.shoppinglist;

import android.content.Context;

import data.ItemDBHelper;
import data.ModelInterface;
import utility.MyApplication;


public class Injector{

    public static ModelInterface.DB provideItemData(Context context){
        return new ItemDBHelper(MyApplication.getContext());
    }
}