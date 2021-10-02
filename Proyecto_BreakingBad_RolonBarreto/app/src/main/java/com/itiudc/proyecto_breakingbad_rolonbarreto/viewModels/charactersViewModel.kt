package com.itiudc.proyecto_breakingbad_rolonbarreto.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.character
import com.itiudc.proyecto_breakingbad_rolonbarreto.services.characterServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class charactersViewModel : ViewModel() {
    private var _characters = MutableLiveData<MutableList<character>>()
    val characters: LiveData<MutableList<character>>
        get() = _characters

    init {
        viewModelScope.launch {
            _characters.value = fetch()
        }
    }
    private suspend fun fetch(): MutableList<character>{
        return withContext(Dispatchers.IO){
            val character: MutableList<character> = characterServices.getCharacters()
            character
        }
    }
}
