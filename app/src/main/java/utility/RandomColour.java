package utility;


import com.sharedshopping.chris.shoppinglist.R;

import java.util.Random;


public class RandomColour {

    public static int[] colours = {R.color.color1,R.color.color2,R.color.color3,R.color.color4,
            R.color.color5,R.color.color6,R.color.color7,R.color.color8};

    private RandomColour(){}

    public static int getColour(){
        Random rand = new Random();
        return colours[rand.nextInt(8)];
    }
}
