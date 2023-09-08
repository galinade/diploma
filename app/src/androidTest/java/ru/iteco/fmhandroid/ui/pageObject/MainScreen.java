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
import static org.hamcrest.core.Is.is;


import static ru.iteco.fmhandroid.ui.data.DataHelper.childAtPosition;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;
import static ru.iteco.fmhandroid.ui.data.DataHelper.withIndex;



import static org.hamcrest.Matchers.not;



public class MainScreen {

    private final ViewInteraction avatarImageButton = onView(withId(R.id.authorization_image_button));
    private final ViewInteraction exitButton = onView(withText("Log out"));
    private final ViewInteraction mainMenuButton = onView(withId(R.id.main_menu_image_button));
    private final ViewInteraction sectionMain = onView(withText("Main"));
    private final ViewInteraction sectionClaims = onView(withText("Claims"));
    private final ViewInteraction sectionNews = onView(withText("News"));
    private final ViewInteraction sectionAbout = onView(withText("About"));
    private final ViewInteraction allNewsButton = onView(withId(R.id.all_news_text_view));
    private final ViewInteraction expandNewsFeedButton = onView(allOf(withId(R.id.expand_material_button),
           childAtPosition(withClassName(is("android.widget.LinearLayout")), childAtPosition(
                           withClassName(is("android.widget.LinearLayout")), withId(R.id.container_list_news_include_on_fragment_main),
                           0),
                    4),
            isDisplayed()));

    private final ViewInteraction expandNewsDescriptionButton = onView(allOf(withId(R.id.news_list_recycler_view),
            childAtPosition(
                    withClassName(is("android.widget.LinearLayout")), withId(R.id.all_news_cards_block_constraint_layout),
                    0)));

    private final ViewInteraction allClaimsButton = onView(withId(R.id.all_claims_text_view));

    private final ViewInteraction expandClaimsFeedButton = onView(allOf(withId(R.id.expand_material_button),
            childAtPosition(withClassName(is("android.widget.LinearLayout")), childAtPosition(
                            withClassName(is("android.widget.LinearLayout")), withId(R.id.container_list_claim_include_on_fragment_main),
                            0),
                    3)));

    private final ViewInteraction createClaimButton = onView(withId(R.id.add_new_claim_material_button));

    private final ViewInteraction listOfClaims = onView(
            allOf(withId(R.id.claim_list_recycler_view),
                    childAtPosition(
                            withClassName(is("android.widget.LinearLayout")), withId(R.id.all_claims_cards_block_constraint_layout),
                            4)));

    private final ViewInteraction quotesButton = onView(withId(R.id.our_mission_image_button));

    public ViewInteraction getAvatarImageButton() {
        return avatarImageButton;
    }
    public ViewInteraction getExitButton() {
        return exitButton;
    }
    public ViewInteraction getMainMenuButton() {
        return mainMenuButton;
    }
    public ViewInteraction getSectionMain() {
        return sectionMain;
    }
    public ViewInteraction getSectionClaims() {
        return sectionClaims;
    }
    public ViewInteraction getSectionNews() {
        return sectionNews;
    }
    public ViewInteraction getSectionAbout() {
        return sectionAbout;
    }
    public ViewInteraction getAllNewsButton() { return allNewsButton; }
    public ViewInteraction getExpandNewsFeedButton() {
        return expandNewsFeedButton;
    }
    public ViewInteraction getExpandNewsDescriptionButton() {
        return expandNewsDescriptionButton;
    }
    public ViewInteraction getAllClaimsButton() {
        return allClaimsButton;
    }
    public ViewInteraction getExpandClaimsFeedButton() {
        return expandClaimsFeedButton;
    }
    public ViewInteraction getCreateClaimButton() {
        return createClaimButton;
    }
    public ViewInteraction getListOfClaims() {
        return listOfClaims;
    }
    public ViewInteraction getQuotesButton() {
        return quotesButton;
    }


    //"Проверка отображения экрана Главная"
    public void checkMainScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.authorization_image_button, 5000));
        getAllNewsButton().check(matches(isDisplayed()));
        getAllClaimsButton().check(matches(isDisplayed()));
    }

    //"Выход из аккаунта через нажатие на кнопку аватара в AppBar"
    public void logout() {
        onView(isRoot()).perform(waitUntilShown(R.id.authorization_image_button, 3000));
        getAvatarImageButton().perform(click());
        getExitButton().perform(click());
    }

    //"Нажатие на кнопку свернуть/развернуть в разделе новости"
    public void expandNewsFeed() {
        onView(isRoot()).perform(waitUntilShown(R.id.expand_material_button, 3000));
        getExpandNewsFeedButton().perform(click());
    }



    //"Переход к экрану О приложении через меню-гамбургер"//
    public void goToSectionAboutFromMainMenu() {
        onView(isRoot()).perform(waitUntilShown(R.id.main_menu_image_button, 3000));
        getMainMenuButton().perform(click());
        getSectionAbout().perform(click());
    }

    //"Нажатие на кнопку бабочки в AppBar"
    public void goToSectionQuotesFromAppBar() {
        onView(isRoot()).perform(waitUntilShown(R.id.our_mission_image_button, 3000));
        getQuotesButton().perform(click());
    }


    //"Нажатие на кнопку Все новости в разделе заявки"
    public void clickOnAllNewsButton() {
        getAllNewsButton().perform(click());
    }

    //"Проверка, что название \"Все новости\" видно"
    public void checkNameAllNewsIsVisible() {
        getAllNewsButton().check(matches(isDisplayed()));
    }

    //"Проверка, что название \"Все новости\" не видно")
    public void checkNameAllNewsIsNotVisible() {
        getAllNewsButton().check(matches(not(isDisplayed())));
    }

    //"Нажатие на кнопку свернуть/развернуть рядом с новостью")
    public void expandNewsDescription(int position) {
        onView(isRoot()).perform(waitUntilShown(R.id.view_news_item_image_view, 3000));
        getExpandNewsDescriptionButton().perform(actionOnItemAtPosition(position, click()));
    }

    //"Проверка, что видно описание новости"
    public void checkTextOfNewsDescriptionIsVisible(int position) {
        onView(withIndex(withId(R.id.news_item_description_text_view), position)).check(matches(isDisplayed()));
    }

    //"Нажатие на кнопку свернуть/развернуть в разделе заявки"
    public void expandClaimsFeed() {
        onView(isRoot()).perform(waitUntilShown(R.id.expand_material_button, 3000));
        getExpandClaimsFeedButton().perform(click());
    }

    //"Нажатие на кнопку Все заявки в разделе заявки"
    public void clickOnAllClaimsButton() {
        onView(isRoot()).perform(waitUntilShown(R.id.all_claims_text_view, 3000));
        getAllClaimsButton().perform(click());
    }

    //"Проверка, что название \"Все заявки\" видно"
    public void checkNameAllClaimsIsVisible() {
        getAllClaimsButton().check(matches(isDisplayed()));
    }

    //"Провекрка, что название \"Все заявки\" не видно"
    public void checkNameAllClaimsIsNotVisible() {
        getAllClaimsButton().check(matches(not(isDisplayed())));
    }

    //"Нажатие претензию в разделе заявки"
    public void clickOnClaim(int position) {
        onView(isRoot()).perform(waitUntilShown(R.id.title_material_text_view, 3000));
        getListOfClaims().perform(actionOnItemAtPosition(position, click()));
    }

    //"Нажатие на кнопку Плюс в разделе заявки"
    public void clickOnCreateClaimButton() {
        onView(isRoot()).perform(waitUntilShown(R.id.add_new_claim_material_button, 3000));
        getCreateClaimButton().perform(click());
    }

    //"Переход к экрану Новости через меню-гамбургер"
    public void goToSectionNewsFromMainMenu() {
        onView(isRoot()).perform(waitUntilShown(R.id.main_menu_image_button, 3000));
        getMainMenuButton().perform(click());
        getSectionNews().perform(click());
    }

    //"Переход к экрану Заявки через меню-гамбургер"
    public void goToSectionClaimsFromMainMenu() {
        onView(isRoot()).perform(waitUntilShown(R.id.main_menu_image_button, 3000));
        getMainMenuButton().perform(click());
        getSectionClaims().perform(click());
    }

    //"Переход к экрану Главная через меню-гамбургер"
    public void goToSectionMainFromMainMenu() {
        onView(isRoot()).perform(waitUntilShown(R.id.main_menu_image_button, 3000));
        getMainMenuButton().perform(click());
        getSectionMain().perform(click());
    }





}

