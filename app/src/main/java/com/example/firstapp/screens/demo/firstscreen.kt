package com.example.firstapp.screens.demo

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.firstapp.R

@Composable
fun firstscreen(){
    Column(
        modifier = Modifier.fillMaxSize()
            .background(Color.Gray)
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Welcome to my app",
            fontFamily = FontFamily.Monospace,
            fontSize = 32.sp,
        )
        Spacer(modifier = Modifier.height(24.dp))
        Image(
            painter = painterResource(id=R.drawable.logo),
            contentDescription = "company logo",
            modifier = Modifier.height(200.dp)
                .fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(24.dp))
        //row with buttons
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(onClick = {}) {
                Text("Login")
            }
            Button(onClick ={}) {
                Text("Register")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun firstscreenpreview(){
    firstscreen()
}