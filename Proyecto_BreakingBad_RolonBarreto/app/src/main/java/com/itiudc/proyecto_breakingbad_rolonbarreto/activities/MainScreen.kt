package com.itiudc.proyecto_breakingbad_rolonbarreto.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.itiudc.proyecto_breakingbad_rolonbarreto.R
import com.itiudc.proyecto_breakingbad_rolonbarreto.adapters.ViewpageAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.CharactersFragment
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.quote

class MainScreen : AppCompatActivity(), CharactersFragment.CharacterSelectListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        val tabLayout = findViewById<TabLayout>(R.id.tab_layout)
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager_2)

        val adapter = ViewpageAdapter(supportFragmentManager, lifecycle)

        viewPager2.adapter=adapter
        TabLayoutMediator(tabLayout, viewPager2){tab, position->
            when(position){
                0->{
                    tab.text = "CHARACTERS"
                }
                1->{
                    tab.text = "PHRASE"
                }
                2->{
                    tab.text = "SETTINGS"
                }
            }
        }.attach()

    }


    override fun onCharacterSelected(it: character){
        var intent = Intent(this, DetailCharacterActivity::class.java).apply {
            putExtra(DetailCharacterActivity.CHARACTER_KEY, it)
        }
        startActivity(intent)
    }

}