package com.example.firstapp.navigation

import android.graphics.pdf.content.PdfPageGotoLinkContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.firstapp.screens.login.LoginScreen
import com.example.firstapp.screens.register.RegisterScreen


//main function called when opening the app
@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(), //NavHostController= rememberNavController()
    startDestination: String=ROUTE_LOGIN
){
    NavHost(
        navController=navController,
        modifier=modifier,
        startDestination = startDestination
    ){
        composable (ROUTE_LOGIN){
            LoginScreen(navController)
        }
        composable(ROUTE_REGISTER){
            RegisterScreen(navController)
        }
    }
}


