package com.example.listapersonagens.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.listapersonagens.model.response.DisneyCharactersResult
import com.example.listapersonagens.repository.DisneyRepository

class DisneyViewModel(private val repository: DisneyRepository) : ViewModel() {
    val mutableLiveData: MutableLiveData<DisneyCharactersResult> = MutableLiveData()

    suspend fun getDisneyCharacter() {
        mutableLiveData.postValue(repository.returnDisney().getCharacters())
    }

    class Factory(private val repo: DisneyRepository) : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DisneyViewModel(repo) as T
        }
    }
}

