package com.example.vybs.features.appList.screens
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.vybs.features.appList.viewModels.AppListViewModel
import com.example.vybs.features.appList.components.AppListTile

@Composable
fun AppListScreen(viewModel: AppListViewModel = hiltViewModel()) {
    val apps = viewModel.apps.collectAsState().value

    Scaffold { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
        ) {
            items(apps) { app ->
                AppListTile(app = app, onAppClicked = { viewModel.onAppClicked(it) })
            }
        }
    }

}



