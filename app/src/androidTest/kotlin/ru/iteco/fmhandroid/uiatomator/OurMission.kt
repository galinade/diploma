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
class OurMissionTest {

    private lateinit var device: UiDevice
    private val textToSet = "Love is all"
    private val text1 = "our_mission_item_material_card_view"


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


    @Test
    fun testOurMissionText() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        Thread.sleep(5000)

        device.findObject(By.res(packageName, "our_mission_image_button")).click()


        val result = device.findObject(By.res(packageName, "our_mission_title_text_view")).text
        assertEquals(result, textToSet)

    }

    @Test
    fun testOurMissionExpand() {
        val packageName = MODEL_PACKAGE
        waitForPackage(packageName)
        Thread.sleep(5000)

        device.findObject(By.res(packageName, "our_mission_image_button")).click()
        device.findObject(By.res(packageName, "our_mission_item_list_recycler_view")).click()

        val result = device.findObject(By.res(packageName, "our_mission_item_description_text_view")).text
        Thread.sleep(10000)
        assertEquals(result, text1)

    }
}