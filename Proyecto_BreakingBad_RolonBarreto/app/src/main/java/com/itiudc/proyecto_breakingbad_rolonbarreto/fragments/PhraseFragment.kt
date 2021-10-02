package com.itiudc.proyecto_breakingbad_rolonbarreto.fragments


import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.itiudc.proyecto_breakingbad_rolonbarreto.databinding.FragmentPhraseBinding
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.quote
import com.itiudc.proyecto_breakingbad_rolonbarreto.viewModels.quoteViewModel

class PhraseFragment : Fragment() {

    override fun onCreateView(

        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val quoteViewModel = ViewModelProvider(this).get(quoteViewModel::class.java)
        var binding = FragmentPhraseBinding.inflate(inflater, container, false)

        quoteViewModel.quote.observe(viewLifecycleOwner, Observer<MutableList<quote>>{
            quote ->

            binding.phrase.text = quote[0].quote
            binding.phraseAutor.text = quote[0].author
        })

        binding.root.setOnClickListener(){
            quoteViewModel.Act()
        }

        return binding.root
    }

    override fun onPause() {
        super.onPause()
        val quoteViewModel = ViewModelProvider(this).get(quoteViewModel::class.java)
        quoteViewModel.Act()
    }
}
