package com.nirwashh.android.myshoplist.presentation

import android.text.Editable
import android.text.TextWatcher

interface MainTextWatcher : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

    override fun afterTextChanged(s: Editable?) {}
}