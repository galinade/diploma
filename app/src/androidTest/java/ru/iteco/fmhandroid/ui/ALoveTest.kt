package ru.iteco.fmhandroid.ui


import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.*
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.hamcrest.Description
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.allOf
import org.hamcrest.TypeSafeMatcher
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import ru.iteco.fmhandroid.R
import ru.iteco.fmhandroid.ui.AppActivity

@LargeTest
@RunWith(AndroidJUnit4::class)
class ALoveTest {

    @Rule
    @JvmField
    var mActivityScenarioRule = ActivityScenarioRule(AppActivity::class.java)

    @Test
    fun aLoveTest() {
        val textInputEditText = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.login_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText.perform(replaceText("login2"), closeSoftKeyboard())

        val textInputEditText2 = onView(
            allOf(
                childAtPosition(
                    childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText2.perform(replaceText("password2"), closeSoftKeyboard())

        val textInputEditText3 = onView(
            allOf(
                withText("password2"),
                childAtPosition(
                    childAtPosition(
                        withId(R.id.password_text_input_layout),
                        0
                    ),
                    0
                ),
                isDisplayed()
            )
        )
        textInputEditText3.perform(pressImeActionButton())

        val materialButton = onView(
            allOf(
                withId(R.id.enter_button), withText("Sign in"), withContentDescription("Save"),
                childAtPosition(
                    childAtPosition(
                        withClassName(`is`("android.widget.RelativeLayout")),
                        1
                    ),
                    2
                ),
                isDisplayed()
            )
        )
        materialButton.perform(click())

        val appCompatImageButton = onView(
            allOf(
                withId(R.id.our_mission_image_button), withContentDescription("Our Mission"),
                childAtPosition(
                    allOf(
                        withId(R.id.container_custom_app_bar_include_on_fragment_main),
                        childAtPosition(
                            withClassName(`is`("android.widget.LinearLayout")),
                            0
                        )
                    ),
                    6
                ),
                isDisplayed()
            )
        )
        appCompatImageButton.perform(click())

        val recyclerView = onView(
            allOf(
                withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView.perform(actionOnItemAtPosition<ViewHolder>(0, click()))

        val recyclerView2 = onView(
            allOf(
                withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView2.perform(actionOnItemAtPosition<ViewHolder>(1, click()))

        val recyclerView3 = onView(
            allOf(
                withId(R.id.our_mission_item_list_recycler_view),
                childAtPosition(
                    withClassName(`is`("androidx.constraintlayout.widget.ConstraintLayout")),
                    0
                )
            )
        )
        recyclerView3.perform(actionOnItemAtPosition<ViewHolder>(2, click()))

        val textView = onView(
            allOf(
                withId(R.id.our_mission_item_description_text_view),
                withText("\"��, ��������� ���������� ���� � ���� ������. ��� ����� �� ���������, ����� �� ������, ��� ��������, � ���� ������, ���, ���� �������, ���� ������� � ������� �� ����, � ���� ������� ���� �������.� ��� �����, ��������"),
                withParent(withParent(withId(R.id.our_mission_item_material_card_view))),
                isDisplayed()
            )
        )
        textView.check(matches(withText("\"��, ��������� ���������� ���� � ���� ������. ��� ����� �� ���������, ����� �� ������, ��� ��������, � ���� ������, ���, ���� �������, ���� ������� � ������� �� ����, � ���� ������� ���� �������.� ��� �����, ��������")))
    }

    private fun childAtPosition(
        parentMatcher: Matcher<View>, position: Int
    ): Matcher<View> {

        return object : TypeSafeMatcher<View>() {
            override fun describeTo(description: Description) {
                description.appendText("Child at position $position in parent ")
                parentMatcher.describeTo(description)
            }

            public override fun matchesSafely(view: View): Boolean {
                val parent = view.parent
                return parent is ViewGroup && parentMatcher.matches(parent)
                        && view == parent.getChildAt(position)
            }
        }
    }
}
