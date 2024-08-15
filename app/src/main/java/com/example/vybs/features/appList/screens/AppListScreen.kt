package com.example.vybs.features.appList.screens

import android.content.Context
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.vybs.features.appList.viewModels.AppListViewModel
import com.example.vybs.core.data.db.appEntity.AppEntity
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun AppListScreen(viewModel: AppListViewModel = hiltViewModel()) {
    val apps = viewModel.apps.collectAsState().value

    Scaffold { innerPadding->
        LazyColumn(modifier = Modifier.padding(innerPadding)
        .fillMaxSize().padding(horizontal = 16.dp)) {
        items(apps) { app ->
            AppListItem(app = app)
        }
    }

    }

}

@Composable
fun AppListItem(app: AppEntity) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 8.dp)) {

        if (app.imageUrl != null) {
            AsyncImage(
                model = app.imageUrl,
                contentDescription = app.name,
                modifier = Modifier.size(64.dp),
                contentScale = ContentScale.Crop
            )
        } else {
            app.icon?.let {
                    AndroidView(
                        modifier = Modifier.size(64.dp),
                        factory = { ctx ->
                            ImageView(ctx).apply {
                                setImageDrawable(it.toDrawable(ctx))
                            }
                        }
                    )
            } ?: run {
                Box(
                    modifier = Modifier
                        .size(64.dp)
                        .background(Color.Gray)
                )
            }
        }

        Spacer(modifier = Modifier.width(16.dp))

        Column {
            Text(text = app.name, fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Text(text = app.category, fontSize = 14.sp, color = Color.Gray)
        }
    }
}

fun ByteArray.toDrawable(context: Context): Drawable {
    val bitmap = BitmapFactory.decodeByteArray(this, 0, this.size)
    return BitmapDrawable(context.resources, bitmap)
}
