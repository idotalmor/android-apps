package com.example.vybs.features.appList.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vybs.core.data.db.appEntity.AppEntityRepository
import com.example.vybs.core.data.db.appEntity.AppEntity
import com.example.vybs.core.data.db.appEntity.mockAppEntityList
import com.example.vybs.features.appList.usecase.OpenAppIntentUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AppListViewModel @Inject constructor(
    private val appEntityRepository: AppEntityRepository,
    private val openAppIntentUseCase: OpenAppIntentUseCase
) : ViewModel() {

    private val _apps = MutableStateFlow<List<AppEntity>>(emptyList())
    val apps: StateFlow<List<AppEntity>> = _apps

    init {
        viewModelScope.launch {
            _apps.value = mockAppEntityList+ appEntityRepository.getAllApps()
        }
    }

    fun onAppClicked(app: AppEntity) {
        openAppIntentUseCase.execute(app)
    }
}
