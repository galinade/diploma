package ru.iteco.fmhandroid.ui.test;


// Эти тесты необходимо выполнять на устройстве с Android 10 (API 29)

import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.AboutScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;

public class AboutTest extends BaseAndroidTest {
    MainScreen mainScreen = new MainScreen();
    AboutScreen aboutScreen = new AboutScreen();

    @Test
    @DisplayName("Переход по ссылке на Политику конфиденциальности из раздела О приложении")
    public void shouldFollowTheLinkToPrivacyPolicy() {
        mainScreen.goToSectionAboutFromMainMenu();
        aboutScreen.checkAboutScreenIsDisplayed();
        aboutScreen.checkPrivacyPolicyLinkIsClickable();
    }

    @Test
    @DisplayName("Переход по ссылке на Пользовательское соглашение из раздела О приложении")
    public void shouldFollowTheLinkToTermsOfUse() {
        mainScreen.goToSectionAboutFromMainMenu();
        aboutScreen.checkAboutScreenIsDisplayed();
        aboutScreen.checkTermsOfUseLinkIsClickable();
    }

    @Test
    @DisplayName("Переход к разделу Главная из раздела О приложении через стрелку Назад")
    public void shouldGoToSectionMainFromSectionAbout() {
        mainScreen.goToSectionAboutFromMainMenu();
        aboutScreen.checkAboutScreenIsDisplayed();
        aboutScreen.clickOnBackButton();
        mainScreen.checkMainScreenIsDisplayed();
    }
}

