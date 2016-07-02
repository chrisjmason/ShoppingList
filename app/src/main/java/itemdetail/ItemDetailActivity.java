package itemdetail;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.sharedshopping.chris.shoppinglist.R;

import utility.Item;

public class ItemDetailActivity extends AppCompatActivity {

    private int position;
    public static final String EXTRA_POSITION = "position";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        Bundle bundle = getIntent().getExtras();
        position = bundle.getInt(EXTRA_POSITION);
        initFragment(ItemDetailFragment.newInstance(position));

    }

    public void initFragment(Fragment fragment){
        if(fragment!=null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.contentFrame, fragment);
            ft.commit();
        }
    }
}
