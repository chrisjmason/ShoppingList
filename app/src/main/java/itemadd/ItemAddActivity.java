package itemadd;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.sharedshopping.chris.shoppinglist.R;

/**
 * Created by Chris on 19/03/2016.
 */
public class ItemAddActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_add);

        Fragment fragment = ItemAddFragment.newInstance();
        initFragment(fragment);
    }

    void initFragment(Fragment fragment){
        if(fragment!=null) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.add_fragment_frame, fragment);
            ft.commit();
        }
    }
}
