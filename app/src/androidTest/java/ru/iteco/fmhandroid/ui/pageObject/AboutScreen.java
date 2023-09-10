package ru.iteco.fmhandroid.ui.pageObject;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static ru.iteco.fmhandroid.ui.data.DataHelper.waitUntilShown;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutScreen {
    private final ViewInteraction version = onView(withId(R.id.about_version_title_text_view));
    private final ViewInteraction numberVersion = onView(withId(R.id.about_version_value_text_view));
    private final ViewInteraction privacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    private final ViewInteraction termsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    private final ViewInteraction backButton = onView(withId(R.id.about_back_image_button));

    public ViewInteraction getVersion() {
        return version;
    }

    public ViewInteraction getNumberVersion() {
        return numberVersion;
    }

    public ViewInteraction getPrivacyPolicyLink() {
        return privacyPolicyLink;
    }

    public ViewInteraction getTermsOfUseLink() {
        return termsOfUseLink;
    }

    public ViewInteraction getBackButton() {
        return backButton;
    }

    //"Проверка отображения экрана О приложении"
    public void checkAboutScreenIsDisplayed() {
        onView(isRoot()).perform(waitUntilShown(R.id.about_company_info_label_text_view, 3000));
        getVersion().check(matches(isDisplayed()));
        getNumberVersion().check(matches(isDisplayed()));
    }

    //"Проверка кликабельности ссылки Политика конфиденциальности"
    public void checkPrivacyPolicyLinkIsClickable() {
        getPrivacyPolicyLink().check(matches(isClickable()));
    }

    //"Проверка кликабельности ссылки Пользовательское соглашение"
    public void checkTermsOfUseLinkIsClickable() {
        getTermsOfUseLink().check(matches(isClickable()));
    }

    //"Нажатие на кнопку Назад"
    public void clickOnBackButton() {
        getBackButton().perform(click());
    }

}
