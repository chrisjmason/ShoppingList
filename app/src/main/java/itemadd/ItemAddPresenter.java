package itemadd;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;

import data.ItemRepository;
import utility.DateUtil;
import utility.Item;

public class ItemAddPresenter implements ItemAddInterface.Presenter {
    private ItemRepository itemRepository;
    private ItemAddInterface.View view;

    public ItemAddPresenter(ItemAddInterface.View view){
        itemRepository = new ItemRepository();
        this.view = view;
    }

    @Override
    public void add(String title, String desc, int colour) {
        if(title != null) {
            new addAsync().execute(new Item(title,desc,colour, DateUtil.getDate()));
        }
    }

    private class addAsync extends AsyncTask<Item,Void,Void>{
        @Override
        protected void onPostExecute(Void aVoid) {
            view.finishActivity();
        }

        @Override
        protected Void doInBackground(Item... params) {
            Item itemToAdd = params[0];
            itemRepository.addItem(itemToAdd.getTitle(),itemToAdd.getDescription(),itemToAdd.getColour());
            return null;
        }
    }
}
