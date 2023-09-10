package ru.iteco.fmhandroid.ui.test;

import androidx.test.filters.LargeTest;

import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;
import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;
import ru.iteco.fmhandroid.ui.pageObject.NewsScreen;


@LargeTest
public class NewsTest extends BaseAndroidTest {
    MainScreen mainScreen = new MainScreen();
    NewsScreen newsScreen = new NewsScreen();
    ControlPanelScreen controlPanelScreen = new ControlPanelScreen();

    @Test
    @DisplayName("При нажатии на кнопку Редактировать видна Панель управления новостей")
    public void visibleControlPanelScreen() {
        mainScreen.clickOnAllNewsButton();
        newsScreen.checkNewsScreenIsDisplayed();
        newsScreen.goToControlPanelScreen();
        controlPanelScreen.checkControlPanelScreenIsDisplayed();
    }

    @Test
    @DisplayName("Просмотр описания новости в разделе Панель управления новостей")
    public void shouldCollapseAndExpandNewsDescriptionOnControlPanelScreen() {
        mainScreen.clickOnAllNewsButton();
        newsScreen.checkNewsScreenIsDisplayed();
        newsScreen.goToControlPanelScreen();
        controlPanelScreen.checkControlPanelScreenIsDisplayed();

        controlPanelScreen.clickOnNewsItem(0);
        controlPanelScreen.checkTextOfNewsDescriptionIsVisible(0);
    }


    @Test
    @DisplayName("Просмотр описания новости на экране Новости")
    public void shouldCollapseAndExpandNewsDescription() {
        mainScreen.clickOnAllNewsButton();
        newsScreen.checkNewsScreenIsDisplayed();

        newsScreen.expandNewsDescription(0);
        newsScreen.checkTextOfNewsDescriptionIsVisible(0);
    }

    @Test
    @DisplayName("При нажатии на кнопку Фильтр видна Форма фильтрации Новости")
    public void visibleFormFilterNewsScreen() {
        mainScreen.clickOnAllNewsButton();
        newsScreen.checkNewsScreenIsDisplayed();
        newsScreen.goToControlPanelScreen();
        controlPanelScreen.checkControlPanelScreenIsDisplayed();

        newsScreen.goToFilterNewsScreen();
        newsScreen.checkFilterNewsScreenIsDisplayed();
    }

    @Test
    @DisplayName("При нажатии на кнопку Плюс (создать новость) видна Форма Новости")
    public void visibleFormCreatingNewsScreen() {
        mainScreen.clickOnAllNewsButton();
        newsScreen.checkNewsScreenIsDisplayed();
        newsScreen.goToControlPanelScreen();
        controlPanelScreen.checkControlPanelScreenIsDisplayed();

        controlPanelScreen.clickButtonCreateNews();
        newsScreen.checkCreateNewsScreenIsDisplayed();
    }

}
