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
import org.hamcrest.Matchers
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith





@RunWith(AndroidJUnit4::class)
class LogOutTest {

    private lateinit var device: UiDevice
    private val textToSet = "SIGN IN"


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

    //Выход из приложения
    @Test
    fun testExitText() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        Thread.sleep(5000)

        device.findObject(By.res(packageName, "authorization_image_button")).click()
        device.findObject(UiSelector().resourceId("android:id/title").instance(0)).click()

        val result = device.findObject(By.res(packageName, "enter_button")).text
        assertEquals(result, textToSet)

    }
}