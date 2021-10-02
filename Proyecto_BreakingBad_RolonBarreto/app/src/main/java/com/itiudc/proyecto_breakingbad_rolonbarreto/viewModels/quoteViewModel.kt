package com.itiudc.proyecto_breakingbad_rolonbarreto.viewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.itiudc.proyecto_breakingbad_rolonbarreto.models.quote
import com.itiudc.proyecto_breakingbad_rolonbarreto.services.quoteServices
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class quoteViewModel : ViewModel() {
    private var _quote = MutableLiveData<MutableList<quote>>()
    val quote: LiveData<MutableList<quote>>
        get() = _quote

    init {
        viewModelScope.launch {
            _quote.value = fetch()
        }
    }

    private suspend fun fetch(): MutableList<quote>{
        return withContext(Dispatchers.IO){
            val quotes: MutableList<quote> = quoteServices.getQuotes()
            quotes
        }
    }

    fun Act(){
        viewModelScope.launch {
            _quote.value = fetch()
        }
    }
}