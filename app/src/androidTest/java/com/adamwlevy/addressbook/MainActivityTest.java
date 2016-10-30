package com.adamwlevy.addressbook;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.content.ComponentName;
import android.os.SystemClock;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.adamwlevy.addressbook.ViewController.ContactActivity;
import com.adamwlevy.addressbook.ViewController.MainActivity;

import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.anything;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);

    @Test
    public void addressBookStartupTest(){
        //sleep to allow time to populate address book via initial http request.
        //TODO the proper way to handle this is to implement a custom idling resource.
        SystemClock.sleep(3000);

        //Check that the address book is displayed.
        onView(withId(R.id.Title)).check(matches(withText(R.string.addressBook_label)));
    }

    @Test
    public void selectFirstContactTest() {

        //sleep to allow time to populate address book via initial http request.
        //TODO the proper way to handle this is to implement a custom idling resource.
        SystemClock.sleep(3000);

        // Directly specify the position in the adapter to click on
        onData(anything()) // We are using the position so don't need to specify a data matcher
                .inAdapterView(withId(android.R.id.list))
                .atPosition(0)
                .perform(click());

        //Sleep because no guarantee other users have disabled animations on their device/emulator.
        SystemClock.sleep(3000);

        //Check that the contact details view is displayed.
        onView(withId(R.id.DetailsLabel)).check(matches(withText(R.string.contact_label)));

    }
}

