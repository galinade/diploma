package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.annotation.NonNull;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.ui.AppActivity;

import static org.hamcrest.core.IsNot.not;



public class WatchScreen {
    private final ViewInteraction okButton = onView(
            allOf(withId(android.R.id.button1), withText("ОК"),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")),
                            childAtPosition(withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.ScrollView")),
                                    0),
                            3)));

    private final ViewInteraction openKeyboardButton = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatImageButton")),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")),
                            childAtPosition(withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.LinearLayout")),
                                    4),
                            0)));

    private final ViewInteraction hourField = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")), allOf(withClassName(is("android.widget.RelativeLayout")),
                                    childAtPosition(withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.TextInputTimePickerView")),
                                            1)),
                            0)));

    private final ViewInteraction minuteField = onView(
            allOf(withClassName(is("androidx.appcompat.widget.AppCompatEditText")),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")), allOf(withClassName(is("android.widget.RelativeLayout")),
                                    childAtPosition(withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.TextInputTimePickerView")),
                                            1)),
                            3)));

    public ViewInteraction getOkButton() {
        return okButton;
    }
    public ViewInteraction getOpenKeyboardButton() {
        return openKeyboardButton;
    }
    public ViewInteraction getHourField() {
        return hourField;
    }
    public ViewInteraction getMinuteField() {
        return minuteField;
    }
    // Нажатие на кнопку ОК
    public void clickOnOkButton() {
        getOkButton().perform(click());
    }

    // Нажатие на кнопку клавиатуры для изенения вида часов
    public void clickOnOpenKeyboardButton() {
        getOpenKeyboardButton().perform(click());
    }

    // Установка часа
    public void settingHour(String hour) {
        getHourField().perform(replaceText(hour));
    }

    // Установка минут
    public void settingMinute(String minute) {
        getMinuteField().perform(replaceText(minute));
    }

    //"Проверка отображения валидации поля"
    public void checkValidationInvalidTimeIsDisplayed(@NonNull AppActivity activity, String text) {
        onView(withText(text)).inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}


