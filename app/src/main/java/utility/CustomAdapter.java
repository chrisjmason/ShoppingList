package utility;


import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.sharedshopping.chris.shoppinglist.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import itemsoverview.ItemOverviewInterface;


public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private List<Item> itemList;
    private ItemOverviewInterface.Presenter itemPresenter;
    private Context mContext;

    public void setItemList(List<Item> itemList){
        this.itemList = itemList;
    }

    public CustomAdapter(ItemOverviewInterface.Presenter presenter, Context context){
        itemList = new ArrayList<>();
        itemPresenter = presenter;
        mContext = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        private CardView cardView;

        public ViewHolder(CardView cv){
            super(cv);
            cardView = cv;
        }
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        CardView cv = (CardView) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new ViewHolder(cv);
    }

    @Override
    public void onBindViewHolder(CustomAdapter.ViewHolder holder, final int position) {
        CardView cardView = holder.cardView;
        cardView.setPreventCornerOverlap(true);

        Item item = itemList.get(position);

        TextView title = (TextView) cardView.findViewById(R.id.item_title_text);
        title.setText(item.getTitle());

        TextView date = (TextView) cardView.findViewById(R.id.date_text);
        date.setText(DateUtil.getDifference(item.getDate()));

        ImageView doneImg = (ImageView) cardView.findViewById(R.id.tick_done_img);
        doneImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPresenter.deleteItem(position);
            }
        });

        //if(itemList.get(position).getDescription()!=null) {
        //TextView desc = (TextView) cardView.findViewById(R.id.item_desc_text);
        //desc.setText(item.getDescription());
        //}

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                itemPresenter.showItem(position);
            }
        });

        cardView.setBackgroundColor(ContextCompat.getColor(mContext, item.getColour()));
    }
}
