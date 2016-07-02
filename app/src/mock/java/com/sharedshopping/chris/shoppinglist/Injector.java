package com.sharedshopping.chris.shoppinglist;

import android.content.Context;


import com.sharedshopping.chris.shoppinglist.data.FakeItemData;

import data.ModelInterface;

public class Injector{

    public static ModelInterface.DB provideItemData(Context context){
        return FakeItemData.getInstance();
    }
}