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
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;
import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;


public class ControlPanelScreen {
    private final ViewInteraction controlPanel = onView(withText(containsString("Control panel")));
    private final ViewInteraction sortNewsButton = onView(withId(R.id.sort_news_material_button));
    private final ViewInteraction filterNewsButton = onView(withId(R.id.filter_news_material_button));
    private final ViewInteraction createNewsButton = onView(withId(R.id.add_news_image_view));

    private final ViewInteraction listOfNews = onView(
            allOf(withId(R.id.news_list_recycler_view),
                    childAtPosition(withClassName(is("android.widget.LinearLayout")), withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                            0)));

    private final ViewInteraction okDeleteNewsButton = onView(
            allOf(withId(android.R.id.button1), withText("OK"),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")), childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.ScrollView")),
                                    0),
                            3)));

    private final ViewInteraction cancelDeleteNewsButton = onView(
            allOf(withId(android.R.id.button2), withText("ОТМЕНА"),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")), childAtPosition(
                                    withClassName(is("android.widget.LinearLayout")), withClassName(is("android.widget.ScrollView")),
                                    0),
                            2)));

    public ViewInteraction getControlPanel() {
        return controlPanel;
    }

    public ViewInteraction getSortNewsButton() {
        return sortNewsButton;
    }

    public ViewInteraction getFilterNewsButton() {
        return filterNewsButton;
    }

    public ViewInteraction getCreateNewsButton() {
        return createNewsButton;
    }

    public ViewInteraction getListOfNews() {
        return listOfNews;
    }

    public ViewInteraction getOkDeleteNewsButton() {
        return okDeleteNewsButton;
    }

    public ViewInteraction getCancelDeleteNewsButton() {
        return cancelDeleteNewsButton;
    }


    //"Проверка отображения экрана Панель управления новостей"
    public void checkControlPanelScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.news_list_recycler_view, 3000));
        getControlPanel().check(matches(isDisplayed()));
    }

    //"Нажатие на кнопку Сортировка"
    public void clickButtonSortNews() {
        onView(isRoot()).perform(waitUntilShown(R.id.sort_news_material_button, 3000));
        getSortNewsButton().perform(click());
    }

    //"Нажатие на кнопку Фильтр"
    public void goToAdvancedFilterNewsScreen() {
        onView(isRoot()).perform(waitUntilShown(R.id.filter_news_material_button, 3000));
        getFilterNewsButton().perform(click());
    }

    //"Нажатие на кнопку Плюс (создать новость)"
    public void clickButtonCreateNews() {
        onView(isRoot()).perform(waitUntilShown(R.id.add_news_image_view, 3000));
        getCreateNewsButton().perform(click());
    }

    //"Нажатие на новость в списке"
    public void clickOnNewsItem(int position) {
        onView(isRoot()).perform(waitUntilShown(R.id.news_item_material_card_view, 3000));
        getListOfNews().perform(actionOnItemAtPosition(position, click()));
    }

    //"Проверка, что видно описание новости"
    public void checkTextOfNewsDescriptionIsVisible(int position) {
        onView(withIndex(withId(R.id.news_item_description_text_view), position)).check(matches(isDisplayed()));
    }


}

