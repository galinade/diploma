package ru.iteco.fmhandroid.ui;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.IdlingRegistry;
import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.EspressoIdlingResources;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;


@RunWith(AndroidJUnit4.class)
public class HomePageOpens {
    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void appActivityTest() {
        ViewInteraction textInputEditText = onView(withId(R.id.login_text_input_layout));
        textInputEditText.check(matches(isDisplayed()));
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard());
        ViewInteraction textInputEditText2 = onView(withId(R.id.password_text_input_layout));
        textInputEditText2.check(matches(isDisplayed()));
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard());
        ViewInteraction materialButton = onView(withId(R.id.enter_button));
        materialButton.check(matches(isDisplayed()));
        materialButton.perform(click());
        ViewInteraction textView = onView(withId(R.id.container_list_news_include_on_fragment_main));
        textView.check(matches(isDisplayed()));
        textView.check(matches(withText("News")));
    }
}


