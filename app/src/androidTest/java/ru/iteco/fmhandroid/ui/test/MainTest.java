package ru.iteco.fmhandroid.ui.test;


import androidx.test.filters.LargeTest;

import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.AuthorizationScreen;
import ru.iteco.fmhandroid.ui.pageObject.ClaimsScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;
import ru.iteco.fmhandroid.ui.pageObject.NewsScreen;


@LargeTest

public class MainTest extends BaseAndroidTest {

    AuthorizationScreen authorizationScreen = new AuthorizationScreen();
    MainScreen mainScreen = new MainScreen();
    ClaimsScreen claimsScreen = new ClaimsScreen();
    NewsScreen newsScreen = new NewsScreen();

    @Test
    //"Выход из аккаунта"
    public void shouldLogout() {
        mainScreen.logout();
        authorizationScreen.checkAuthorizationScreenIsDisplayed();
    }

    @Test
    //Отображение раздела Новости на экране Главная через тап на кнопку свернуть/развернуть\"
    public void shouldCollapseAndExpandNewsFeed() {
        mainScreen.expandNewsFeed();
        mainScreen.checkNameAllNewsIsNotVisible();
        mainScreen.expandNewsFeed();
        mainScreen.checkNameAllNewsIsVisible();
    }

    @Test
    //"Открытие описания новости через тап на новость из раздела Новости"
    public void shouldCollapseAndExpandNewsDescription() {
        mainScreen.expandNewsDescription(0);
        mainScreen.checkTextOfNewsDescriptionIsVisible(0);
    }

    @Test
    //"Отображение раздела Заявки на экране Главная через тап на кнопку свернуть/развернуть\"
    public void shouldCollapseAndExpandClaimsFeed() {
        mainScreen.expandClaimsFeed();
        mainScreen.checkNameAllClaimsIsNotVisible();
        mainScreen.expandClaimsFeed();
        mainScreen.checkNameAllClaimsIsVisible();
    }

    @Test
    //"Открытие детального описания заявки через тап на заявку из раздела Заявки\"
    public void shouldGoToClaimDescriptionWhenClickOnClaim() {
        mainScreen.clickOnClaim(0);
        claimsScreen.checkScreenOfDetailedDescriptionClaimIsDisplayed();
    }

    @Test
    //Возврат к экрану Главная через меню-гамбургер"
    public void shouldGoToSectionMainFromMainMenu() {
        mainScreen.goToSectionNewsFromMainMenu();
        newsScreen.checkNewsScreenIsDisplayed();
        mainScreen.goToSectionMainFromMainMenu();
        mainScreen.checkMainScreenIsDisplayed();
    }
}
