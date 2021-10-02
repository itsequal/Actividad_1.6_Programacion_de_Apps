package com.itiudc.proyecto_breakingbad_rolonbarreto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.adapters.ViewpageAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.CharactersFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Thread.sleep(2000)//Segundos en los que se muestra la splash screen para la splash screen

        setTheme(R.style.SplashTheme)//Llama el tema de la splashscreen

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Llama e inicializa la función de validación
        login_validation()

    }


    public fun login_validation() {
        var login: Intent = Intent(applicationContext, LoginActivity::class.java)
        startActivity(login)
    }
}

