package com.dhimant.testingwithespresso

import android.support.test.espresso.Espresso
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Created by Dhimant Desai on 12/01/19.
 * Copyright 2019. All rights reserved.
 */
@RunWith(AndroidJUnit4::class)
class MainActivityInstrumentedTest {

    private val correct_email = "dhimant1990@gmail.com"
    private val wrong_email = "dhimant1990gmail.com"
    private val email_typed = "dhimant1990@gmail.com"
    private val correct_password = "password"
    private val wrong_password = "passme"

    private var mActivity: MainActivity? = null

    @Rule
    @JvmField
    var mActivityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        mActivity = mActivityRule.activity
    }

    @Test
    fun login_success() {
        Espresso.onView((ViewMatchers.withId(R.id.edtEmail))).perform(ViewActions.typeText(correct_email))
        Espresso.onView((ViewMatchers.withId(R.id.edtPassword))).perform(ViewActions.typeText(correct_password))
        Espresso.closeSoftKeyboard()
        Espresso.onView((ViewMatchers.withId(R.id.btnLogin))).perform(ViewActions.click())
    }

    @Test
    fun login_failure() {
        Espresso.onView((ViewMatchers.withId(R.id.edtEmail))).perform(ViewActions.typeText(correct_email))
        Espresso.onView((ViewMatchers.withId(R.id.edtPassword))).perform(ViewActions.typeText(wrong_password))
        Espresso.closeSoftKeyboard()
        Espresso.onView((ViewMatchers.withId(R.id.btnLogin))).perform(ViewActions.click())
    }

    @After
    fun tearDown() {
        mActivity = null
    }

}