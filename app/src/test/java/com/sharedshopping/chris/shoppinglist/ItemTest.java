package com.sharedshopping.chris.shoppinglist;

import android.test.suitebuilder.annotation.SmallTest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;

import utility.DateUtil;
import utility.Item;

/**
 * Created by Chris on 11/04/2016.
 */

@SmallTest
@RunWith(MockitoJUnitRunner.class)
public class ItemTest {
    private static final String TEST_TITLE = "test title";
    private static final String TEST_DESC = "test description";
    private static final String TEST_DESC_NULL = null;
    private static final String TEST_DATE = DateUtil.getDate();
    private static final int TEST_COLOUR = 100;

    @Test
    public void Item_createAndCheck(){
        Item item = new Item(TEST_TITLE,TEST_DESC,TEST_COLOUR,TEST_DATE);

        assertThat("Check title", item.getTitle(), is(TEST_TITLE));
        assertThat("Check desc", item.getDescription(), is(TEST_DESC));
        assertThat("Check colour", item.getColour(), is(TEST_COLOUR));
    }
}
