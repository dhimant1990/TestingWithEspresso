package com.dhimant.testingwithespresso

import android.content.Context

/**
 * Created by Dhimant Desai on 14/01/19.
 * Copyright 2019. All rights reserved.
 */
class ClassUnderTest constructor(val context: Context) {

    fun getAppName(): String {
        return context.getString(R.string.app_name)
    }

}