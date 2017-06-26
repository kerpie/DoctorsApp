package co.herovitamin.doctorsapp.matcher;

import android.support.design.widget.TextInputLayout;
import android.support.test.espresso.matcher.BoundedMatcher;

import org.hamcrest.Description;
import org.hamcrest.Matcher;

import static android.support.test.internal.util.Checks.checkNotNull;

/**
 * Created by kerry on 25/06/17.
 */

public class ErrorMatcher {

    public static class TextInputLayoutErrorMatcher extends BoundedMatcher<Object, TextInputLayout> {

        private final Matcher<String> itemTextMatcher;

        public TextInputLayoutErrorMatcher(final Matcher<String> itemTextMatcher){
            super(TextInputLayout.class);
            this.itemTextMatcher = itemTextMatcher;
        }

        @Override
        public void describeTo(Description description) {
            description.appendText("with error  content: ");
            itemTextMatcher.describeTo(description);
        }

        @Override
        protected boolean matchesSafely(TextInputLayout til) {
            if (til == null) {
                return false;
            }
            return itemTextMatcher.matches(til.getError());
        }

        public static Matcher<Object> withErrorName(final Matcher<String> itemTextMatcher) {
            checkNotNull(itemTextMatcher);
            return new TextInputLayoutErrorMatcher(itemTextMatcher);
        }
    }
}
