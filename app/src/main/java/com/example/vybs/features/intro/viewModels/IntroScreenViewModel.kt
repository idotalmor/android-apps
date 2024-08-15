package com.example.vybs.features.intro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vybs.features.intro.usecase.GetAndSaveAppsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModel @Inject constructor(
    private val getAndSaveAppsUseCase: GetAndSaveAppsUseCase
) : ViewModel() {

    init {
        viewModelScope.launch {
            try {
                getAndSaveAppsUseCase.execute()
            } catch (e: Exception) {
                //TODO: note: not sure how product-wise I need to handle this error
                println("Error saving apps: ${e.message}")
            }
        }
    }

    fun next(age:Int){
        //save age
        //navigate

    }

}