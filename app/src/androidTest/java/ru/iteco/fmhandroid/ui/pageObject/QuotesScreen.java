package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.data.DataHelper;


public class QuotesScreen {
    private final ViewInteraction quotesSectionTitle = onView(withId(R.id.our_mission_title_text_view));
    private final ViewInteraction expandQuoteDescriptionButton = onView(withIndex(withId(R.id.our_mission_item_open_card_image_button), 0));
    private final ViewInteraction quoteTitle = onView(withIndex(withId(R.id.our_mission_item_title_text_view), 0));
    private final ViewInteraction quoteDescription = onView(withIndex(withId(R.id.our_mission_item_description_text_view), 0));

    public ViewInteraction getQuotesSectionTitle() {
        return quotesSectionTitle;
    }

    public ViewInteraction getExpandQuoteDescriptionButton() {
        return expandQuoteDescriptionButton;
    }

    public ViewInteraction getQuoteTitle() {
        return quoteTitle;
    }

    public ViewInteraction getQuoteDescription() {
        return quoteDescription;
    }

    public String titleText(int position) {
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.our_mission_item_title_text_view), position))).replaceAll("^\"|\"$", "");
    }

    public String descriptionText(int position) {
        return DataHelper.Text.getText(onView(withIndex(withId(R.id.our_mission_item_description_text_view), position))).replaceAll("^\"|\"$", "");
    }

    //"Проверка отображения экрана Цитаты"
    public void checkQuotesScreenIsDisplayed() {
        getQuotesSectionTitle().check(matches(isDisplayed()));
    }

    //"Нажатие на кнопку свернуть/развернуть рядом с цитатой"
    public void expandQuoteDescription() {
        getExpandQuoteDescriptionButton().perform(click());
    }

    //"Проверка текста в названии и описании цитаты")
    public void checkTitleAndDescriptionOfQuote(String title, String description) {
        String titleActual = titleText(0);
        assertEquals(title, titleActual);
        getQuoteTitle().check(matches(isDisplayed()));
        String descriptionActual = descriptionText(0);
        assertEquals(description, descriptionActual);
        getQuoteDescription().check(matches(isDisplayed()));
    }
}

