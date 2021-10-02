package com.itiudc.proyecto_breakingbad_rolonbarreto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.adapters.ViewpageAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.CharactersFragment

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val LoginEmail = findViewById<EditText>(R.id.login_email)
        val LoginPassword = findViewById<EditText>(R.id.login_password)
        val LoginButton = findViewById<Button>(R.id.login_button)

        LoginButton.setOnClickListener() {
            if (LoginEmail.text.isEmpty() || LoginPassword.text.isEmpty()) {
                Toast.makeText(this, "Make sure to fill in all the fields!", Toast.LENGTH_SHORT)
                    .show()
            } else if(LoginEmail.text.contains("@")){
                Toast.makeText(this, "Welcome!", Toast.LENGTH_SHORT)
                    .show()

                //Se va a la actividad con el contenido principal
                toMain()
            }else{

                Toast.makeText(this, "Invalid email", Toast.LENGTH_SHORT).show()
            }
        }

    }

    fun toMain(){
        val tempGen: Intent = Intent(applicationContext, MainScreen::class.java)
        startActivity(tempGen)
    }
}