package itemadd;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.sharedshopping.chris.shoppinglist.R;

import utility.RandomColour;


public class ItemAddFragment extends Fragment implements ItemAddInterface.View {

    private ItemAddInterface.Presenter presenter;
    private EditText title;
    private EditText desc;
    private int colour;


    public static ItemAddFragment newInstance(){
        return new ItemAddFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        presenter = new ItemAddPresenter(this);
        colour = RandomColour.getColour();
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View fragView = inflater.inflate(R.layout.fragment_item_add, container, false);
        fragView.setBackgroundColor(ContextCompat.getColor(getActivity(), colour));
        title = (EditText) fragView.findViewById(R.id.item_add_titletext);
        desc = (EditText) fragView.findViewById(R.id.item_add_desctext);
        setUpFab();
        return fragView;
    }

    public void setUpFab(){
        FloatingActionButton addOkButton = (FloatingActionButton)  getActivity().
                findViewById(R.id.fab_add_ok);

        addOkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String titleInput = title.getText().toString();
                String descInput = desc.getText().toString();
                presenter.add(titleInput,descInput,colour);
            }
        });
    }

    @Override
    public void finishActivity(){
        this.getActivity().finish();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
    }
}
