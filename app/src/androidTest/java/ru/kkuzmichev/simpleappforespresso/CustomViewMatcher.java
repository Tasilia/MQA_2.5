package ru.kkuzmichev.simpleappforespresso;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;
import androidx.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

public class CustomViewMatcher {
    public static Matcher<View> recyclerViewSizeMatcher(int matcherSize) {
        return new BoundedMatcher<View, RecyclerView>(RecyclerView.class) {
            @Override
            public void describeTo(Description description) { // Доп. описание ошибки
                description.appendText("Item count: " + matcherSize);
            }
            @Override
            protected boolean matchesSafely(RecyclerView recyclerView) { // Проверка
                return matcherSize == recyclerView.getAdapter().getItemCount();
            }
        };
    }
}