package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class NewsScreen {
    private final ViewInteraction newsSectionTitle = onView(withText("News"));
    private final ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction editNewsButton = onView(withId(R.id.edit_news_material_button));
    private final ViewInteraction listOfNews = onView(withId(R.id.news_list_recycler_view));

    private final ViewInteraction expandNewsDescriptionButton = onView(
            allOf(withId(R.id.news_list_recycler_view), childAtPosition(
                    withClassName(is("android.widget.LinearLayout")), withId(R.id.all_news_cards_block_constraint_layout),
                    0)));

    private final ViewInteraction filterTitle = onView(withId(R.id.filter_news_title_text_view));

    private final ViewInteraction createTitle = onView(withId(R.id.custom_app_bar_title_text_view));
    private final ViewInteraction newsTitle = onView(withId(R.id.custom_app_bar_sub_title_text_view));

    public ViewInteraction getNewsSectionTitle() {
        return newsSectionTitle;
    }

    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    public ViewInteraction getEditNewsButton() {
        return editNewsButton;
    }

    public ViewInteraction getListOfNews() {
        return listOfNews;
    }

    public ViewInteraction getExpandNewsDescriptionButton() {
        return expandNewsDescriptionButton;
    }

    public ViewInteraction getFilterTitle() {
        return filterTitle;
    }

    public ViewInteraction getCreateTitle() {
        return createTitle;
    }

    public ViewInteraction getNewsTitle() {
        return newsTitle;
    }

    //"Проверка отображения экрана Новости"
    public void checkNewsScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.news_list_recycler_view, 3000));
        getNewsSectionTitle().check(matches(isDisplayed()));
    }

    //"Нажатие на кнопку Сортировка"
    public void clickButtonSortNews() {
        onView(isRoot()).perform(waitUntilShown(R.id.sort_news_material_button, 3000));
        getSortNewsButton().perform(click());
    }

    //"Нажатие на кнопку Фильтр"
    public void goToFilterNewsScreen() {
        onView(isRoot()).perform(waitUntilShown(R.id.filter_news_material_button, 3000));
        getFilterNewsButton().perform(click());
    }

    //"Нажатие на кнопку Редактировать новости"
    public void goToControlPanelScreen() {
        onView(isRoot()).perform(waitUntilShown(R.id.edit_news_material_button, 3000));
        getEditNewsButton().perform(click());
    }

    //"Нажатие на кнопку свернуть/развернуть рядом с новостью"
    public void expandNewsDescription(int position) {
        onView(isRoot()).perform(waitUntilShown(R.id.view_news_item_image_view, 3000));
        getExpandNewsDescriptionButton().perform(actionOnItemAtPosition(position, click()));
    }

    //"Проверка, что видно описание новости"
    public void checkTextOfNewsDescriptionIsVisible(int position) {
        onView(withIndex(withId(R.id.news_item_description_text_view), position)).check(matches(isDisplayed()));
    }

    //"Проверка отображения экрана Фильтрация новостей"
    public void checkFilterNewsScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.filter_news_title_text_view, 3000));
        getFilterTitle().check(matches(isDisplayed()));
    }

    //"Проверка отображения экрана создания новости"
    public void checkCreateNewsScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.save_button, 3000));
        getCreateTitle().check(matches(isDisplayed()));
        getNewsTitle().check(matches(isDisplayed()));
    }
}

