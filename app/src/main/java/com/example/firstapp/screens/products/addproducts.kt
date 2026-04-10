package com.example.firstapp.screens.products

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/*
create addproduct screen
scaffold top bar
add product text
textfields - name, price, description, image
save product button
 */

@Composable
fun AddProduct(navController: NavHostController){
    Column(
        modifier = Modifier
            .background(Color.LightGray)
            .fillMaxWidth()
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        Text(
            text = "ADD PRODUCT",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
        )
        var productname by remember { mutableStateOf("") }
        var price by remember { mutableStateOf("") }
        var desc by remember { mutableStateOf("") }
        var img by remember { mutableStateOf("") }

        OutlinedTextField(
            value = productname,
            onValueChange = { productname = it },
            label = {Text("Product Name")}
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = price,
            onValueChange = {price = it},
            label = {Text("Price")},
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = desc,
            onValueChange = {desc = it},
            label = {Text("Description")},
        )
        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = img,
            onValueChange = {img = it},
            label = {Text("Product Image")},
        )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = {},
            modifier = Modifier.fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Blue
            )
        ) {
            Text("Add Product",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,)
        }
    }

}

@Preview(showBackground = true)
@Composable
fun AddProductpreview(){
    AddProduct(rememberNavController())
}