package data;


import com.sharedshopping.chris.shoppinglist.Injector;

import java.util.List;
import utility.Item;
import utility.MyApplication;


//Interactor between model/data layer and presenter

public class ItemRepository implements ModelInterface.Repository {
    private ModelInterface.DB itemData;

    public ItemRepository() {
        itemData =  Injector.provideItemData(MyApplication.getContext());
    }

    @Override
    public List<Item> getData() {
        return itemData.getData();
    }

    @Override
    public void addItem(String title, String desc, int colour) {
        itemData.addItem(title,desc,colour);
    }

    @Override
    public Item getItem(int position) {
        return itemData.getItem(position);
    }

    @Override
    public void deleteItem(int position) {
        itemData.deleteItem(position);
    }


}
