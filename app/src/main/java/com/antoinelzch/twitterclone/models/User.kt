package com.antoinelzch.twitterclone.models

import android.widget.EditText
import java.util.*

data class User(
    val _email: EditText? = null,
    val _password: EditText? = null,
    val _id: UUID? = null,
    val _name: String? = null,
    )
