package com.dhimant.testingwithespresso

import android.content.Context
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

/**
 * Created by Dhimant Desai on 14/01/19.
 * Copyright 2019. All rights reserved.
 */
@RunWith(MockitoJUnitRunner::class)
class MainActivityUnitTest {

    private val correct_name = "TestingWithEspresso"
    private val wrong_name = "Testing"

    @Mock
    private lateinit var mMockContext: Context

    @Test
    fun read_app_name_from_context_success() {
        Mockito.`when`(mMockContext.getString(R.string.app_name)).thenReturn(correct_name)
        val objectUnderTest = ClassUnderTest(mMockContext)
        val result = objectUnderTest.getAppName()
        assertThat(result, `is`(correct_name))
    }

    @Test
    fun read_app_name_from_context_failure() {
        Mockito.`when`(mMockContext.getString(R.string.app_name)).thenReturn(wrong_name)
        val objectUnderTest = ClassUnderTest(mMockContext)
        val result = objectUnderTest.getAppName()
        assertThat(result, `is`(correct_name))
    }

}