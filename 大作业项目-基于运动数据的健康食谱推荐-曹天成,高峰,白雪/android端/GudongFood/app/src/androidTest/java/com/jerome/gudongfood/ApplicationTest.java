package com.jerome.gudongfood;

import android.os.Bundle;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

import com.R;
import com.jerome.gudongfood.view.UserLoginActivity;

import android.app.Application;
import android.test.ApplicationTestCase;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
@RunWith(AndroidJUnit4.class)
public class ApplicationTest extends ApplicationTestCase<Application> {
    private static final String STRING_USERNAME = "gaofeng";
    private static final String STRING_PASSWORD = "123456";

    @Rule
    public ActivityTestRule<UserLoginActivity> mActivityRule = new ActivityTestRule<>(
            UserLoginActivity.class);

    public ApplicationTest() {
        super(Application.class);
        onView(withId(R.id.username)).perform(typeText(STRING_USERNAME), closeSoftKeyboard()); //line 1
        onView(withId(R.id.password)).perform(typeText(STRING_PASSWORD), closeSoftKeyboard()); //line 1

        onView(withText("登录")).perform(click()); //line 2

        onView(withId(R.id.username)).check(matches(withText(STRING_USERNAME)));
    }
}