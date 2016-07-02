package data;

import java.util.ArrayList;
import java.util.List;

import utility.Item;

/**
 * Created by Chris on 27/02/2016.
 */
public interface ModelInterface {

    interface Repository {
        List<Item> getData();

        void addItem(String title, String desc, int colour);

        void deleteItem(int position);

        Item getItem(int position);
    }

    interface DB{
        List<Item> getData();

        void addItem(String title, String desc, int colour);

        void deleteItem(int position);

        Item getItem(int position);
    }
}
