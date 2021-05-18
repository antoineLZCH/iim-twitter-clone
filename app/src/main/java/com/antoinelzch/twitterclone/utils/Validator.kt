package com.antoinelzch.twitterclone.utils

import com.antoinelzch.twitterclone.models.User

object Validator {
    fun validate(user: User): Boolean {
        var isValid = true

        val email = user._email?.text.toString()
        val password = user._password?.text.toString()

        if(email.isEmpty() || !android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            user._email?.error = "Enter a valid email address"
            isValid = false
        } else {
            user._email?.error = null
        }

        if(password.isEmpty() || password.length < 4 || password.length > 12) {
            user._password?.error = "Enter a password between 4 and 10 characters"
            isValid = false
        } else {
            user._password?.error = null
        }

        return isValid
    }
}