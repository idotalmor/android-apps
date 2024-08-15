package com.example.vybs.features.intro.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.example.vybs.features.intro.viewModels.IntroScreenViewModel
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController

@Composable
fun IntroScreen(modifier: Modifier = Modifier,
                navController: NavController,
                viewModel: IntroScreenViewModel = hiltViewModel()) {

    var age: Int? by remember { mutableStateOf(null) }

    val navigateToNextScreen by viewModel.navigateToNextScreen.collectAsState()

    LaunchedEffect(navigateToNextScreen) {
        if (navigateToNextScreen) {
            navController.navigate("next_screen_route")
        }
    }

    Scaffold(modifier = modifier) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding).padding(all=20.dp)

        ) {
            Text("Welcome",
                style = TextStyle(
                fontSize = 45.sp,
                fontWeight = FontWeight.Medium,
                color = Color.DarkGray
            ),)
            Spacer(modifier = Modifier.height(16.dp))

            Text("Before we begin, we need you to fill some information and give us access",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Light,
                    color = Color.Gray,
                    lineHeight = 1.2.em
                ),)

            Spacer(modifier = Modifier.height(50.dp))

            TextField(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                value = age?.toString() ?: "",
                onValueChange = {
                    age = it.toIntOrNull()
                },
                label = { Text("Enter your age") },
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                singleLine = true,
                colors = TextFieldDefaults.colors(
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                ),
                shape = RoundedCornerShape(8.dp)
            )

            Spacer(modifier = Modifier.height(10.dp))

            Button(
                modifier = Modifier.fillMaxWidth().padding(horizontal = 20.dp),
                onClick = {age?.let { viewModel.next(it)} },
                shape = RoundedCornerShape(8.dp),
                enabled = age!=null
            ) { Text("Next") }
        }

    }
}

@Preview
@Composable
fun PreviewIntroScreen(){
    IntroScreen(navController = rememberNavController())
}
