package ru.iteco.fmhandroid.uiatomator

import android.R
import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.uiautomator.By
import androidx.test.uiautomator.UiDevice
import androidx.test.uiautomator.UiSelector
import androidx.test.uiautomator.Until
import io.qameta.allure.android.runners.AllureAndroidJUnit4
import org.hamcrest.Matchers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith





//@RunWith(AndroidJUnit4::class)
@RunWith(AllureAndroidJUnit4::class)
class AboutTest {

    private lateinit var device: UiDevice
    private val textToSet = "© I-Teco, 2022"
    private val text1 = "ALL NEWS"



    private fun waitForPackage(packageName: String) {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val intent = context.packageManager.getLaunchIntentForPackage(packageName)
        context.startActivity(intent)
        device.wait(Until.hasObject(By.pkg(packageName)), TIMEOUT)
    }


    @Before
    fun beforeEachTest() {
        // Press home
        device = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
        device.pressHome()

        // Wait for launcher
        val launcherPackage = device.launcherPackageName
        device.wait(Until.hasObject(By.pkg(launcherPackage)), TIMEOUT)


    }

    // - Загрузилось приложение, открылась Главная страница
    // - Нажать кнопку Главное меню
    // - Нажать кнопку About
    // - Открылась строница About
    @Test
    fun testAboutText() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        Thread.sleep(5000)

        device.findObject(By.res(packageName, "main_menu_image_button")).click()
        device.findObject(UiSelector().resourceId("android:id/title").instance(3)).click()
        Thread.sleep(1000)

        val result = device.findObject(By.res(packageName, "about_company_info_label_text_view")).text
        assertEquals(result,textToSet)

    }

    // - Загрузилось приложение, открылась Главная страница
    // - Нажать кнопку Главное меню
    // - Нажать кнопку About
    // - Открылась строница About
    // - Нажать кнопку Назад
    // - Открылясь Главная страница
    @Test
    fun testWorkButtonBackText() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        Thread.sleep(5000)

        device.findObject(By.res(packageName, "main_menu_image_button")).click()
        device.findObject(UiSelector().resourceId("android:id/title").instance(3)).click()
        device.findObject(By.res(packageName, "about_back_image_button")).click()
        Thread.sleep(1000)

       val result = device.findObject(By.res(packageName, "all_news_text_view")).text
       assertEquals(result,text1)

    }
}
