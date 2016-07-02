package itemdetail;

import utility.Item;

public interface ItemDetailInterface{
    interface Presenter {
        void getItem(int position);
    }

    interface View{
        void setUpDetail(Item item);
    }
}
