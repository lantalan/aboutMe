package com.example.android.aboutme

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.done_button).setOnClickListener {
            addNickname(it);
        }
    }

    private fun addNickname(view: View) { // view that called the function
        val editText = findViewById<EditText>(R.id.nickname_edit)           // name entered
        val nicknameTextView = findViewById<TextView>(R.id.nickname_text)   // display name

        nicknameTextView.text = editText.text
        editText.visibility = View.GONE         // hide editText
        view.visibility = View.GONE             // hide view that triggered the function call (button)
        nicknameTextView.visibility = View.VISIBLE  // show the entered name

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)

    }
}