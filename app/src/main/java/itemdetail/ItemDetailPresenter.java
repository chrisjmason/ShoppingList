package itemdetail;

import android.content.Context;
import android.os.AsyncTask;

import data.ItemRepository;
import utility.Item;

/**
 * Created by Chris on 05/03/2016.
 */
public class ItemDetailPresenter implements ItemDetailInterface.Presenter {
    private Context mContext;
    private ItemRepository itemRepository;
    private ItemDetailInterface.View view;

    public ItemDetailPresenter(ItemDetailInterface.View view){
        itemRepository = new ItemRepository();
        this.view = view;
    }

    @Override
    public void getItem(int position) {
        new getItemAsync().execute(position);
    }

    private class getItemAsync extends AsyncTask<Integer,Void,Item>{
        @Override
        protected Item doInBackground(Integer... params) {
            return itemRepository.getItem(params[0]);
        }

        @Override
        protected void onPostExecute(Item item) {
            view.setUpDetail(item);
        }
    }

}
