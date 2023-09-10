package ru.iteco.fmhandroid.ui.test;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static ru.iteco.fmhandroid.ui.data.DataHelper.snackEmptyLoginOrPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.snackWrongLoginOrPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.validLoginAndPassword;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.filters.LargeTest;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.pageObject.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;

@LargeTest
@RunWith(AllureAndroidJUnit4.class)
public class AuthorizationTest {
    @Rule
    public androidx.test.rule.ActivityTestRule<AppActivity> ActivityTestRule = new ActivityTestRule<>(AppActivity.class);

    AuthorizationScreen authorizationScreen = new AuthorizationScreen();
    MainScreen mainScreen = new MainScreen();


    @Before
    public void checkLogout() {
        onView(isRoot()).perform(waitUntilShown(R.id.container_custom_app_bar_include_on_fragment_main, 8000));
        try {
            authorizationScreen.checkAuthorizationScreenIsDisplayed();
            authorizationScreen.checkLoginAndPasswordFieldsAreDisplayed();
        } catch (NoMatchingViewException e) {
            mainScreen.logout();
        }
    }

    @Test
    @DisplayName("Авторизация пользователя с валидными данными")
    public void shouldLoginWithValidData() {
        authorizationScreen.validLoginAndPasswordAuthorization(validLoginAndPassword());
        mainScreen.checkMainScreenIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация незарегистрированного пользователя")
    public void shouldNotLoginWithInvalidLogin() {
        authorizationScreen.invalidLoginAuthorization();
        authorizationScreen.checkSnackIsVisible(ActivityTestRule.getActivity(), snackWrongLoginOrPassword);
    }

    @Test
    @DisplayName("Авторизация пользователя с невалидным паролем")
    public void shouldNotLoginWithInvalidPassword() {
        authorizationScreen.invalidPasswordAuthorization();
        authorizationScreen.checkSnackIsVisible(ActivityTestRule.getActivity(), snackWrongLoginOrPassword);
    }

    @Test
    @DisplayName("Авторизация пользователя при введеном пробеле в поле логин")
    public void shouldLoginWithLoginWithWhitespace() {
        authorizationScreen.loginWithWhitespaceAuthorization();
        mainScreen.checkMainScreenIsDisplayed();
    }

    @Test
    @DisplayName("Авторизация пользователя при введеном пробеле в поле пароль")
    public void shouldNotLoginWithPasswordWithWhitespace() {
        authorizationScreen.passwordWithWhitespaceAuthorization();
        authorizationScreen.checkSnackIsVisible(ActivityTestRule.getActivity(), snackWrongLoginOrPassword);
    }

    @Test
    @DisplayName("Авторизация пользователя с пустым полем логин")
    public void shouldNotLoginWithEmptyLoginField() {
        authorizationScreen.emptyLoginFieldAuthorization();
        authorizationScreen.checkSnackIsVisible(ActivityTestRule.getActivity(), snackEmptyLoginOrPassword);
    }

    @Test
    @DisplayName("Авторизация пользователя с пустым полем пароль")
    public void shouldNotLoginWithEmptyPasswordField() {
        authorizationScreen.emptyPasswordFieldAuthorization();
        authorizationScreen.checkSnackIsVisible(ActivityTestRule.getActivity(), snackEmptyLoginOrPassword);
    }
}



