package ru.iteco.fmhandroid.ui.test;
import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;
import ru.iteco.fmhandroid.ui.pageObject.QuotesScreen;

public class QuotesTest extends BaseAndroidTest {
    MainScreen mainScreen = new MainScreen();
    QuotesScreen quotesScreen = new QuotesScreen();

    @Test
    @DisplayName("Открытие описания цитаты через тап на цитату")
    public void shouldCollapseAndExpandQuoteDescription() {
        mainScreen.goToSectionQuotesFromAppBar();
        quotesScreen.checkQuotesScreenIsDisplayed();
        quotesScreen.expandQuoteDescription();

        String title = "«Хоспис для меня - это то, каким должен быть мир.";
        String description = "Ну, идеальное устройство мира в моих глазах. Где никто не оценивает, " +
                "никто не осудит, где говоришь, и тебя слышат, где, если страшно, тебя обнимут и возьмут за руку, " +
                "а если холодно тебя согреют.” Юля Капис, волонтер";

        quotesScreen.checkTitleAndDescriptionOfQuote(title, description);
    }
}
