package com.itiudc.proyecto_breakingbad_rolonbarreto.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.CharactersFragment
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.PhraseFragment
import com.itiudc.proyecto_breakingbad_rolonbarreto.fragments.SettingsFragment

class ViewpageAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount(): Int {
        return 3
    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                CharactersFragment()
            }
            1 -> {
                PhraseFragment()
            }
            2 -> {
                SettingsFragment()
            }
            else ->{
                Fragment()
            }
        }
    }
}