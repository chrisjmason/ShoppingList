package itemsoverview;


import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.sharedshopping.chris.shoppinglist.Injector;

import java.util.List;

import data.ItemRepository;
import data.ModelInterface;
import itemadd.ItemAddActivity;
import itemdetail.ItemDetailActivity;
import utility.Item;
import utility.MyApplication;

public class ItemOverviewPresenter implements ItemOverviewInterface.Presenter{

    private Context mContext;
    private ModelInterface.Repository itemRepository;
    ItemOverviewInterface.View view;

    public ItemOverviewPresenter(ItemOverviewInterface.View view) {
        this.view = view;
        itemRepository = new ItemRepository();
    }

    //for tests
    //public ItemOverviewPresenter(){
    //    itemRepository = new ItemRepository();
    // }

    @Override
    public void addNewItem() {
        view.goToAdd();
    }

    @Override
    public void showItem(int position) {
        view.goToDetail(position);
    }

    @Override
    public void deleteItem(int position) {
        new deleteAsync().execute(position);
    }

    @Override
    public void loadItems() {
        new getDataAsync().execute();
    }

    private class getDataAsync extends AsyncTask<Void,Void,List<Item>>{
        @Override
        protected void onPostExecute(List<Item> list) {
            view.updateView(list);
        }

        @Override
        protected List<Item> doInBackground(Void... params) {
            return itemRepository.getData();
        }
    }

    private class deleteAsync extends AsyncTask<Integer,Void,Void>{
        @Override
        protected Void doInBackground(Integer... params) {
            int position = params[0];
            itemRepository.deleteItem(position);
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            new getDataAsync().execute();
        }
    }

}