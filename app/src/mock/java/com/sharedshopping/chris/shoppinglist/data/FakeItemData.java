package com.sharedshopping.chris.shoppinglist.data;

import java.util.ArrayList;


import data.ModelInterface;
import utility.DateUtil;
import utility.Item;


/**
 * Created by Chris on 27/02/2016.
 */
public class FakeItemData implements ModelInterface.DB {

    private static ArrayList<Item> itemList = new ArrayList<Item>();

    private static FakeItemData instance;

    private FakeItemData(){}

    public static FakeItemData getInstance(){
        if(instance== null) {
            instance = new FakeItemData();
            //itemList.add(new Item("testmock","testdesc", randomColour.getColour()));
            //itemList.add(new Item("test2mock","testdesc2", randomColour.getColour()));
        }
        return instance;
    }

    @Override
    public void addItem(String title, String description, int colour){
        itemList.add(new Item(title,description,colour, DateUtil.getDate()));
    }

    @Override
    public Item getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public ArrayList<Item> getData() {
        return itemList;
    }

    @Override
    public void deleteItem(int position) {
        itemList.remove(position);
    }
}
