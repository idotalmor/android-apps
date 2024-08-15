package com.example.vybs.features.appList.components

import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import coil.compose.AsyncImage
import com.example.vybs.core.data.db.appEntity.AppEntity
import com.example.vybs.core.data.db.appEntity.mockAppEntity1
import com.example.vybs.core.usecase.toDrawable

@Composable
fun AppListTile(app: AppEntity) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {

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
            Spacer(modifier = Modifier.height(4.dp))

            Row {
                Spacer(modifier = Modifier.weight(1f))

                if (app.installed) {
                    Text(text = "installed")
                }
            }
        }

    }
}

@Preview
@Composable
fun PreviewAppListItem(){
    AppListTile(mockAppEntity1)
}