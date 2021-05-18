package com.antoinelzch.twitterclone

import android.content.Intent
import android.content.Intent.EXTRA_USER
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.antoinelzch.twitterclone.models.User
import com.antoinelzch.twitterclone.utils.ApiClient
import com.antoinelzch.twitterclone.utils.Validator
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.Exception

const val EXTRA_MESSAGE = "Connected. Welcome on TwitterClone."

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val user = User(emailLoginInput, passwordLoginInput)

        checkForFilledEmailOrPassword(user)
    }

    private fun checkForFilledEmailOrPassword(user: User) {
        loginButton.setOnClickListener {
            if(!Validator.validate(user)) {
                Toast.makeText(this, "Email ou mot de passe vide", Toast.LENGTH_LONG).show()
            } else executeCall(user._email?.text.toString())
        }
    }


    private fun executeCall(email: String) {
        val response = ApiClient.apiService.login()
        response.enqueue(object: Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if(response.isSuccessful) {
                    Log.d("MainActivityApiCall", "SUCCESS")
                    val intent = Intent(this@MainActivity, FeedActivity::class.java).apply {
                        putExtra(EXTRA_USER, email)
                    }
                    startActivity(intent)
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(this@MainActivity, "${t.message}", Toast.LENGTH_LONG).show()
            }
        })
    }
}