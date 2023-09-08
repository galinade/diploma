package ru.iteco.fmhandroid.ui.test;

import androidx.test.filters.LargeTest;

import org.junit.Test;

import io.qameta.allure.kotlin.junit4.DisplayName;

import ru.iteco.fmhandroid.ui.custom.BaseAndroidTest;
import ru.iteco.fmhandroid.ui.pageObject.ClaimsScreen;
import ru.iteco.fmhandroid.ui.pageObject.MainScreen;

@LargeTest
public class ClaimsTest extends BaseAndroidTest {

    MainScreen mainScreen = new MainScreen();
    ClaimsScreen claimsScreen = new ClaimsScreen();

    @Test
    @DisplayName("При нажатии на кнопку Плюс (создать заявки) видна Форма Заявки")
    public void visibleFormCreatingClaimsScreen() {
        mainScreen.clickOnAllClaimsButton();
        claimsScreen.checkClaimsScreenIsDisplayed();

        claimsScreen.clickButtonCreateClaim();
        claimsScreen.checkCreateClaimScreenIsDisplayed();


    }

    @Test
    @DisplayName("Переход к экрану детального описания заявки в статусе \"В работе\"")
    public void shouldReturnToClaimsScreenFromScreenOfDetailedDescriptionClaimInProgress() {
        mainScreen.clickOnAllClaimsButton();
        claimsScreen.checkClaimsScreenIsDisplayed();

        claimsScreen.goToFilterClaimsScreen();
        claimsScreen.checkFilterClaimsScreenIsDisplayed();
        claimsScreen.filterClaimsInProgress();

        claimsScreen.clickOnClaim();
        claimsScreen.checkScreenOfDetailedDescriptionClaimIsDisplayed();
        claimsScreen.checkStatusInProgress();


    }

    @Test
    @DisplayName("Переход к экрану детального описания заявки в статусе \"Открыта\"")
    public void shouldReturnToClaimsScreenFromScreenOfDetailedDescriptionClaimOpened() {
        mainScreen.clickOnAllClaimsButton();
        claimsScreen.checkClaimsScreenIsDisplayed();

        claimsScreen.goToFilterClaimsScreen();
        claimsScreen.checkFilterClaimsScreenIsDisplayed();
        claimsScreen.filterClaimsOpened();

        claimsScreen.clickOnClaim();
        claimsScreen.checkScreenOfDetailedDescriptionClaimIsDisplayed();
        claimsScreen.checkStatusOpened();

    }

}

