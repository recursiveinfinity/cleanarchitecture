package com.cleanarchitecture.presentation.common.extensions

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import com.cleanarchitecture.presentation.common.consume


fun EditText.onActionDone(actionDone: (View) -> Unit = {}) {
    setOnEditorActionListener { v, actionId, _ ->
        when (actionId) {
            EditorInfo.IME_ACTION_DONE -> consume { actionDone(v) }
            else -> false
        }
    }
}

fun View.onFocusChange(f: (View, Boolean) -> Unit) {
    setOnFocusChangeListener(f)
}

fun EditText.afterTextChanged(afterTextChanged: (String) -> Unit) {
    addTextChangedListener(object : TextWatcher {
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
        }

        override fun afterTextChanged(editable: Editable?) {
            afterTextChanged.invoke(editable.toString())
        }
    })
}