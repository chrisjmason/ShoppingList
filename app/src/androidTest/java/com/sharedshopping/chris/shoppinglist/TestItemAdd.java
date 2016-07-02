package com.sharedshopping.chris.shoppinglist;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import itemsoverview.ItemOverviewActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withText;



@RunWith(AndroidJUnit4.class)
@LargeTest
public class TestItemAdd {

    @Rule
    public ActivityTestRule<ItemOverviewActivity> testRule =
            new ActivityTestRule<>(ItemOverviewActivity.class);

    @Test
    public void clickAdd_opensAddItemPage(){
        onView(withId(R.id.fab_new_item)).perform(click());
        onView(withId(R.id.item_add_titletext)).check(matches(isDisplayed()));
    }

    @Test
    public void clickAdd_addItemWithTitleAndCheck(){
        String testTitle = "Item title for test";

        onView(withId(R.id.fab_new_item)).perform(click());

        onView(withId(R.id.item_add_titletext)).perform(typeText(testTitle),closeSoftKeyboard());
        onView(withId(R.id.fab_add_ok)).perform(click());

        onView(withId(R.id.item_recycler_view)).check(matches(hasDescendant(withText(testTitle))));
    }
}
