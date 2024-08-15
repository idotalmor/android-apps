package com.example.vybs.features.intro.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vybs.features.intro.usecase.GetAndSaveAppsUseCase
import com.example.vybs.features.intro.usecase.SaveUserUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModel @Inject constructor(
    private val getAndSaveAppsUseCase: GetAndSaveAppsUseCase,
    private val saveUserUseCase: SaveUserUseCase
) : ViewModel() {

    private val _navigateToNextScreen = MutableStateFlow(false)
    val navigateToNextScreen: StateFlow<Boolean> = _navigateToNextScreen

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
        viewModelScope.launch {
            try {
                saveUserUseCase.execute(age)
                _navigateToNextScreen.value = true
            } catch (e: Exception) {
                //TODO: note: not sure how product-wise I need to handle this error
                println("Error saving apps: ${e.message}")
            }
        }
    }

}