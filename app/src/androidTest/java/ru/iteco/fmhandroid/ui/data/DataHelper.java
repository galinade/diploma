package ru.iteco.fmhandroid.ui.data;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isRoot;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;

import android.app.Instrumentation;
import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.test.espresso.PerformException;
import androidx.test.espresso.UiController;
import androidx.test.espresso.ViewAction;
import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.contrib.PickerActions;
import androidx.test.espresso.util.HumanReadables;
import androidx.test.espresso.util.TreeIterables;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.TimeoutException;

public class DataHelper {

    private DataHelper() {
    }

    public static class AuthInfo {
        private final String login;
        private final String password;

        public AuthInfo(String login, String password) {
            this.login = login;
            this.password = password;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }
    }

    public static AuthInfo validLoginAndPassword() {
        String login = "login2";
        String password = "password2";
        return new AuthInfo(login, password);
    }





    public static Matcher<View> withIndex(final Matcher<View> matcher, final int index) {
        return new TypeSafeMatcher<View>() {
            int currentIndex = 0;

            @Override
            protected boolean matchesSafely(View view) {
                return matcher.matches(view) && currentIndex++ == index;
            }

            @Override
            public void describeTo(Description description) {
                description.appendText("with index: ");
                description.appendValue(index);
                matcher.describeTo(description);
            }
        };
    }

    public static Matcher<View> childAtPosition(Matcher<View> matcher, final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }


    public static class Text {

        public static String textWithCyrillicSymbols(int numberOfLetters) {
            Random random = new Random();
            String text;
            String[] symbols = {
                    "а", "б", "в", "г", "д", "е", "ё", "ж", "з", "и", "й", "к", "л", "м", "н", "о",
                    "п", "р", "с", "т", "у", "ф", "х", "ц", "ч", "ш", "щ", "ъ", "ы", "ь", "э", "ю", "я"
            };
            text = symbols[random.nextInt(symbols.length)];
            for (int i = 1; i < numberOfLetters; i++) {
                text = text.concat(symbols[random.nextInt(symbols.length)]);
            }
            return text;
        }

        public static String textWithLatinSymbols(int numberOfLetters) {
            Random random = new Random();
            String text;
            String[] symbols = {
                    "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
                    "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
            };
            text = symbols[random.nextInt(symbols.length)];
            for (int i = 1; i < numberOfLetters; i++) {
                text = text.concat(symbols[random.nextInt(symbols.length)]);
            }
            return text;
        }

        public static String textWithSpecialSymbolsAndNumbers(int numberOfLetters) {
            Random random = new Random();
            String text;
            String[] symbols = {
                    "1", "2", "3", "4", "5", "6", "7", "8", "9", "~", "`", "!", "@", "\"", "#", "№", "$",
                    ";", "%", ":", "^", "&", "?", "*", "(", ")", "_", "=", "+", "{", "}", "[", "]", "/",
                    "|", "\\", "'", "<", ">", ",", "."
            };
            text = symbols[random.nextInt(symbols.length)];
            for (int i = 1; i < numberOfLetters; i++) {
                text = text.concat(symbols[random.nextInt(symbols.length)]);
            }
            return text;
        }

        public static String getText(ViewInteraction matcher) {
            final String[] text = new String[1];
            ViewAction viewAction = new ViewAction() {
                @Override
                public String getDescription() {
                    return "Text of the view";
                }

                @Override
                public Matcher<View> getConstraints() {
                    return isAssignableFrom(TextView.class);
                }

                @Override
                public void perform(UiController uiController, View view) {
                    TextView textView = (TextView) view;
                    text[0] = textView.getText().toString();
                }
            };
            matcher.perform(viewAction);
            return text[0];
        }
    }




    public static class Swipe {

        static void swiper(int start, int end, int delay) {
            long downTime = SystemClock.uptimeMillis();
            long eventTime = SystemClock.uptimeMillis();
            Instrumentation inst = getInstrumentation();

            MotionEvent event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_DOWN, 500, start, 0);
            inst.sendPointerSync(event);
            eventTime = SystemClock.uptimeMillis() + delay;
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_MOVE, 500, end, 0);
            inst.sendPointerSync(event);
            event = MotionEvent.obtain(downTime, eventTime, MotionEvent.ACTION_UP, 500, end, 0);
            inst.sendPointerSync(event);
            SystemClock.sleep(2000); //The wait is important to scroll
        }

        public static void swipeToBottom() {
            swiper(1000, 10, 0);
        }

        public static void swipeToTop() {
            swiper(550, 1000, 0);
        }

        public static void swipeToBottomClaimScreen() {
            swipeToBottom();
            swipeToBottom();
        }

        public static void swipeToTopClaimScreen() {
            swipeToTop();
            swipeToTop();
        }

        public static void swipeToBottomNewsScreen() {
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            SystemClock.sleep(3000);
        }

        public static void swipeToTopNewsScreen() {
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            SystemClock.sleep(3000);
        }

        public static void swipeToBottomControlPanelScreen() {
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            swipeToBottom();
            SystemClock.sleep(3000);
        }

        public static void swipeToTopControlPanelScreen() {
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            swipeToTop();
            SystemClock.sleep(3000);
        }
    }


    public static class Rand {

        private static final Random rand = new Random();

        public static String randomExecutor() {
            String[] executor = {
                    "Ivanov Ivan Ivanovich",
            };
            return executor[rand.nextInt(executor.length)];
        }

        public static String randomInvalidHour() {
            int min = 24;
            int max = 99;
            max -= min;
            int hour = (int) ((Math.random() * ++max) + min);
            return String.valueOf(hour);
        }

        public static String randomInvalidMinute() {
            int min = 60;
            int max = 99;
            max -= min;
            int minute = (int) ((Math.random() * ++max) + min);
            return String.valueOf(minute);
        }

        public static String randomNewsCategory() {
            String[] category = {
                    "Объявление",
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            return category[rand.nextInt(category.length)];
        }

        public static String randomNewsCategoryExceptAnnouncement() {
            String[] category = {
                    "День рождения",
                    "Зарплата",
                    "Профсоюз",
                    "Праздник",
                    "Массаж",
                    "Благодарность",
                    "Нужна помощь"
            };
            return category[rand.nextInt(category.length)];
        }
    }


    public static class DateTime {

        public static String localDate() {
            return LocalDate.now().format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static void settingDate(int year, int month, int day) {
            onView(withClassName(Matchers.equalTo(DatePicker.class.getName()))).perform(PickerActions.setDate(year, month, day)).perform(click());
        }

        public static int currentYear() {
            return LocalDate.now().getYear();
        }

        public static int currentYearPlusOneYear() {
            return LocalDate.now().plusYears(1).getYear();
        }

        public static int currentYearMinusOneYear() {
            return LocalDate.now().plusYears(-1).getYear();
        }

        public static int currentMonth() {
            return LocalDate.now().getMonthValue();
        }

        public static int currentMonthPlusOneMonth() {
            return LocalDate.now().plusMonths(1).getMonthValue();
        }

        public static int todayDay() {
            return LocalDate.now().getDayOfMonth();
        }

        public static int tomorrowDay() {
            return LocalDate.now().plusDays(1).getDayOfMonth();
        }

        public static int yesterdayDay() {
            return LocalDate.now().plusDays(-1).getDayOfMonth();
        }

        public static String currentHour() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);

            return String.valueOf(hour);
        }

        public static String currentMinute() {
            Calendar calendar = Calendar.getInstance();
            int minute = calendar.get(Calendar.MINUTE);

            return String.valueOf(minute);
        }

        public static String currentTimePlusOneHour() {
            Calendar calendar = Calendar.getInstance();
            int hourPlusOneHour;
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            if (hour == 23) {
                hourPlusOneHour = 00;
            } else {
                hourPlusOneHour = hour + 1;
            }

            return String.valueOf(hourPlusOneHour);
        }

        public static String currentTimeMinusOneHour() {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int hourMinusOneHour = hour - 1;

            return String.valueOf(hourMinusOneHour);
        }

        public static String dateTomorrow() {
            LocalDate date = LocalDate.now().plusDays(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateYesterday() {
            LocalDate date = LocalDate.now().plusDays(-1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneWeek() {
            LocalDate date = LocalDate.now().plusWeeks(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneMonth() {
            LocalDate date = LocalDate.now().plusMonths(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateAYearAgo() {
            LocalDate date = LocalDate.now().plusYears(-1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }

        public static String dateInOneYear() {
            LocalDate date = LocalDate.now().plusYears(1);
            return date.format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        }
    }

    public static ViewAction waitUntilShown(final int viewId, final long millis) {
        return new ViewAction() {
            @Override
            public Matcher<View> getConstraints() {
                return isRoot();
            }

            @Override
            public String getDescription() {
                return "wait for a specific view with id <" + viewId + "> is shown during " + millis + " millis.";
            }

            @Override
            public void perform(final UiController uiController, final View view) {
                uiController.loopMainThreadUntilIdle();
                final long startTime = System.currentTimeMillis();
                final long endTime = startTime + millis;
                final Matcher<View> viewMatcher = withId(viewId);

                do {
                    for (View child : TreeIterables.breadthFirstViewTraversal(view)) {
                        // found view with required ID
                        if (viewMatcher.matches(child) && child.isShown()) {
                            return;
                        }
                    }

                    uiController.loopMainThreadForAtLeast(50);
                }
                while (System.currentTimeMillis() < endTime);

                // timeout happens
                throw new PerformException.Builder()
                        .withActionDescription(this.getDescription())
                        .withViewDescription(HumanReadables.describe(view))
                        .withCause(new TimeoutException())
                        .build();
            }
        };
    }
}