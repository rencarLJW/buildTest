package com.test.buildtest

import android.content.Intent
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.rule.ActivityTestRule
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SampleActivityTest {
    private lateinit var activity: SampleActivity

    @get:Rule
    var mActivityRule = ActivityTestRule(SampleActivity::class.java)

    @Before
    fun setUp() {
        this.activity = mActivityRule.activity
    }

    ////////////////////////////////////////////////////////////////////////////////////

    @Test
    fun `체크박스_클릭_동작확인`() {
        onView(withId(R.id.inputCb)).check(matches(isNotChecked())).perform(click())
        onView(withId(R.id.inputCb)).check(matches(isChecked()))
    }

    @Test
    fun `에딧텍스트_힌트_확인`() {
        onView(withId(R.id.inputEt)).check(matches(withHint("텍스트 입력")))
    }

    @Test
    fun `intent로_넘어온_데이터확인_empty`() {
        mActivityRule.launchActivity(Intent())
        this.activity = mActivityRule.activity

        onView(withId(R.id.intentTv)).check(matches(withText("intent text")))
    }

    @Test
    fun `intent로_넘어온_데이터확인`() {
        mActivityRule.launchActivity(Intent().putExtra("screenText", "caro"))
        this.activity = mActivityRule.activity

        onView(withId(R.id.intentTv)).check(matches(withText("caro")))
    }
}