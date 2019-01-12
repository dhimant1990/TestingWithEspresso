package com.dhimant.testingwithespresso

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Patterns
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

/**
 * Created by Dhimant Desai on 12/01/19.
 * Copyright 2019. All rights reserved.
 */
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        btnLogin.setOnClickListener {
            if (!Patterns.EMAIL_ADDRESS.matcher(edtEmail.text.toString()).matches()) {
                Toast.makeText(this, "Enter valid email address.", Toast.LENGTH_LONG).show()
            } else if (edtPassword.text.length < 8) {
                Toast.makeText(this, "Enter valid password.", Toast.LENGTH_LONG).show()
            } else {
                Toast.makeText(this, "Login Successfully!", Toast.LENGTH_LONG).show()
            }
        }
    }

}
