/*
 * Copyright (C) 2017 TOYAMA Sumio <jun.nama@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package jp.jun_nama.espresso.commons.sample;


import android.support.test.espresso.ViewInteraction;
import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.isChecked;
import static android.support.test.espresso.matcher.ViewMatchers.isDescendantOfA;
import static android.support.test.espresso.matcher.ViewMatchers.isNotChecked;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static jp.jun_nama.espresso.commons.RecyclerViewUtils.clickDescendantViewWithId;
import static jp.jun_nama.espresso.commons.RecyclerViewUtils.withItemViewAtPosition;
import static org.hamcrest.Matchers.allOf;

@RunWith(AndroidJUnit4.class)
public class RecyclerViewFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testCheckBoxInViewItemCanBeChecked() {
        toggleCheckBox(3);
        toggleCheckBox(18);

        assertIsNotChecked(4);
        assertIsChecked(3);
        assertIsChecked(18);
        assertIsNotChecked(19);
    }

    private void assertIsNotChecked(int position) {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(position));
        onView(allOf(isDescendantOfA(withItemViewAtPosition(withId(R.id.recyclerView), position)),
                withId(R.id.checkBox))).check(matches(isNotChecked()));
    }

    private void assertIsChecked(int position) {
        onView(withId(R.id.recyclerView)).perform(RecyclerViewActions.scrollToPosition(position));
        onView(allOf(isDescendantOfA(withItemViewAtPosition(withId(R.id.recyclerView), position)),
                withId(R.id.checkBox))).check(matches(isChecked()));
    }

    private void toggleCheckBox(int position) {
        ViewInteraction recyclerView = onView(withId(R.id.recyclerView));
        recyclerView.perform(actionOnItemAtPosition(position, clickDescendantViewWithId(R.id.checkBox)));
    }

}
