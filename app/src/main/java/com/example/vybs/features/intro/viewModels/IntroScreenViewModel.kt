package com.example.vybs.features.intro.viewModels

import com.example.vybs.features.intro.usecase.GetInstalledAppsUseCase
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class IntroScreenViewModel @Inject constructor(
    private val getInstalledAppsUseCase: GetInstalledAppsUseCase
) : ViewModel() {

    init {
        val appList = getInstalledAppsUseCase.execute()

    }

    fun next(age:Int){

    }

}