package ru.iteco.fmhandroid.ui.test;

import androidx.test.filters.LargeTest;

import org.junit.Test;

import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.ControlPanelScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;
import ru.iteco.fmhandroid.ui.pageObject.NewsScreen;
import ru.iteco.fmhandroid.ui.pageObject.WatchScreen;

@LargeTest
public class NewsTest extends BaseAndroidTest {
    MainScreen mainScreen = new MainScreen();
    NewsScreen newsScreen = new NewsScreen();
    ControlPanelScreen controlPanelScreen = new ControlPanelScreen();



   // @Test
    //Просмотр описания новости в разделе Панель управления новостей
   // public void shouldCollapseAndExpandNewsDescriptionOnControlPanelScreen() {
      //  mainScreen.clickOnAllNewsButton();
      //  newsScreen.checkNewsScreenIsDisplayed();
       // newsScreen.goToControlPanelScreen();
       // controlPanelScreen.checkControlPanelScreenIsDisplayed();

       // controlPanelScreen.clickOnNewsItem(0);
       // controlPanelScreen.checkTextOfNewsDescriptionIsVisible(0);
   // }
   // @Test
    //"Просмотр описания новости в разделе Панель управления новостей"
   // public void shouldCollapseAndExpandNewsDescriptionOnControlPanelScreen() {
      //  mainScreen.clickOnAllNewsButton();
       // newsScreen.checkNewsScreenIsDisplayed();
       // newsScreen.goToControlPanelScreen();
      //  controlPanelScreen.checkControlPanelScreenIsDisplayed();

       // controlPanelScreen.clickOnNewsItem(0);
     //   controlPanelScreen.checkTextOfNewsDescriptionIsVisible(0);
  //  }

}
