package com.example.firstapp.screens.demo

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.R

data class Product(
    val name: String,
    val price: String,
    @DrawableRes val image: Int
)

val productlist = listOf(
    Product("Car","2000000",R.drawable.car),
    Product("Scooter","450000",R.drawable.scooter),
    Product("Flower","2000",R.drawable.flower),
    Product("Fruits","1300",R.drawable.fruits)
)

@Composable
fun Democarousel(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text(
            text = "Demo Carousel",
            color = Color.Blue,
            fontSize = 38.sp,
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Featured Products",
            style = MaterialTheme.typography.headlineMedium
        )
        Spacer(modifier = Modifier.height(10.dp))
        //Carousel
        LazyRow(
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(productlist){product -> //loop through each item
                ProductCard(product) //displays each product
            }
        }
    }
}

@Composable
fun ProductCard(product: Product){
    Card(
        modifier = Modifier
            .width(200.dp)
            .height(250.dp),
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column() {
            Image(
                painter = painterResource(product.image),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(150.dp),
                contentScale = ContentScale.Fit
            )
            Spacer(modifier = Modifier.height(10.dp))
            //Name
            Text(text = product.name)
            //Price
            Text(text = "Ksh ${product.price}")
            //add cart button
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Add to Cart")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Democarouselpreview(){
    Democarousel(rememberNavController())
}