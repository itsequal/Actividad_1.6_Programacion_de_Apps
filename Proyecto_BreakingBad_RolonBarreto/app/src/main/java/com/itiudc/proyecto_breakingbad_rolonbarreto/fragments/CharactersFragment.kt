package com.itiudc.proyecto_breakingbad_rolonbarreto.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.itiudc.proyecto_breakingbad_rolonbarreto.adapters.CharacterListFragmentAdapter
import com.itiudc.proyecto_breakingbad_rolonbarreto.databinding.FragmentCharactersBinding
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import com.itiudc.proyecto_breakingbad_rolonbarreto.viewModels.charactersViewModel
import java.lang.ClassCastException


class CharactersFragment : Fragment() {

    public interface CharacterSelectListener{
        fun onCharacterSelected(character: character)
    }

    private lateinit var characterSelectListener: CharacterSelectListener

    override fun onAttach(context: Context){
        super.onAttach(context)
        characterSelectListener = try{
            context as CharacterSelectListener
        }catch (error: ClassCastException){
            throw ClassCastException("$context Must implement CharacterSelectListener")
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val characterssViewModel = ViewModelProvider(this).get(charactersViewModel::class.java)
        val binding = FragmentCharactersBinding.inflate(inflater, container, false)

        characterssViewModel.characters.observe(viewLifecycleOwner, Observer<MutableList<character>>{
            characterss ->
            val adapter = CharacterListFragmentAdapter(characterss)

            adapter.onClickItem = {
                characterSelectListener.onCharacterSelected(it)
            }

            binding.recyclerCharacterList.layoutManager = LinearLayoutManager(requireActivity())
            binding.recyclerCharacterList.adapter = adapter
        })

        return binding.root
    }
}