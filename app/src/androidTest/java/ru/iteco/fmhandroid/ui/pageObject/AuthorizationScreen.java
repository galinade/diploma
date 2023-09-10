package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;
import static ru.iteco.fmhandroid.ui.data.DataHelper.emptyLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.emptyPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.invalidLogin;
import static ru.iteco.fmhandroid.ui.data.DataHelper.invalidPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.loginWithWhitespace;
import static ru.iteco.fmhandroid.ui.data.DataHelper.passwordWithWhitespace;

import androidx.annotation.NonNull;
import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.data.DataHelper;


public class AuthorizationScreen {
    private final ViewInteraction loginField = onView(withHint("Login"));
    private final ViewInteraction passwordField = onView(withHint("Password"));
    private final ViewInteraction loginButton = onView(withId(R.id.enter_button));
    private final ViewInteraction authorizationHeader = onView(withText("Authorization"));

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

    //"Авторизация пользователя с невалидным логином"
    public void invalidLoginAuthorization() {
        getLoginField().perform(typeText(invalidLogin().getLogin()));
        getPasswordField().perform(typeText(invalidLogin().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

    //"Авторизация пользователя с невалидным паролем")
    public void invalidPasswordAuthorization() {
        getLoginField().perform(typeText(invalidPassword().getLogin()));
        getPasswordField().perform(typeText(invalidPassword().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

    //"Проверка появления снэка с ошибкой"
    public void checkSnackIsVisible(@NonNull AppActivity activity, String text) {
        onView(withText(text)).inRoot(withDecorView(not(is(activity.getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    //"Авторизация пользователя с пробелом в поле логин"
    public void loginWithWhitespaceAuthorization() {
        getLoginField().perform(typeText(loginWithWhitespace().getLogin()));
        getPasswordField().perform(typeText(loginWithWhitespace().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

    //"Авторизация пользователя с пробелом в поле пароль"
    public void passwordWithWhitespaceAuthorization() {
        getLoginField().perform(typeText(passwordWithWhitespace().getLogin()));
        getPasswordField().perform(typeText(passwordWithWhitespace().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

    //"Авторизация пользователя с пустым полем логин"
    public void emptyLoginFieldAuthorization() {
        getLoginField().perform(typeText(emptyLogin().getLogin()));
        getPasswordField().perform(typeText(emptyLogin().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

    //"Авторизация пользователя с пустым полем пароль"
    public void emptyPasswordFieldAuthorization() {
        getLoginField().perform(typeText(emptyPassword().getLogin()));
        getPasswordField().perform(typeText(emptyPassword().getPassword())).perform(closeSoftKeyboard());
        getLoginButton().perform(click());
    }

}


