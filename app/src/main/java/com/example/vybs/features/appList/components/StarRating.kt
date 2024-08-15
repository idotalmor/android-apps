package com.example.vybs.features.appList.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun StarRating(rating: Float) {
    Row {
        for (i in 1..5) {
            val icon = if (i <= rating) Icons.Filled.Star else Icons.Outlined.Star
            Icon(
                imageVector = icon,
                contentDescription = null,
                tint = if (i <= rating) Color.Yellow else Color.Gray,
                modifier = Modifier.size(16.dp)
            )
        }
    }
}

@Preview
@Composable
fun PreviewStarRating(){
    StarRating(2f)
}
