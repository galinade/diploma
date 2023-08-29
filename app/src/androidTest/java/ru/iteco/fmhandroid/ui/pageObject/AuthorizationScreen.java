package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;


public class AuthorizationScreen {

    private final ViewInteraction loginField = onView(withHint("Логин"));
    private final ViewInteraction passwordField = onView(withHint("Пароль"));
    private final ViewInteraction loginButton = onView(withId(R.id.enter_button));
    private final ViewInteraction authorizationHeader = onView(withText("Авторизация"));

    public ViewInteraction getLoginField() {
        return loginField;
    }
    public ViewInteraction getPasswordField() {
        return passwordField;
    }
    public ViewInteraction getLoginButton() {
        return loginButton;
    }
    public ViewInteraction getAuthorizationHeader() {
        return authorizationHeader;
    }


    //"Проверка отображения экрана Авторизации"//
    public void checkAuthorizationScreenIsDisplayed() {
        getAuthorizationHeader().check(matches(isDisplayed()));
    }

    //"Проверка отображения полей Логин и Пароль"//
    public void checkLoginAndPasswordFieldsAreDisplayed() {
        getLoginField().check(matches(isDisplayed()));
        getPasswordField().check(matches(isDisplayed()));
    }
    //"Авторизация пользователя с валидным логином и паролем"//
    public void validLoginAndPasswordAuthorization(DataHelper.AuthInfo info) {
        getLoginField().perform(typeText(info.getLogin()));
        getPasswordField().perform(typeText(info.getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }


}

