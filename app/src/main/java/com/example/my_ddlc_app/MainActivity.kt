package com.example.my_ddlc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.my_ddlc_app.ui.theme.My_ddlc_appTheme

sealed class Destination(val route: String){
    object Home: Destination("home")
    object Sayori: Destination("sayori")
    object Yuri: Destination("yuri")
    object Natsuki: Destination("natsuki")
    object Monika: Destination("monika")
    object Other: Destination("other")
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            My_ddlc_appTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
                    val navController = rememberNavController()
                    NavigationAppHost(navController = navController)
                    
                }
            }
        }
    }
}
@Composable
fun NavigationAppHost(navController: NavHostController){
    NavHost(navController = navController, startDestination = "home" ){
        composable(Destination.Home.route) { HomeScreen(navController) }
        composable(Destination.Sayori.route) { Sayori(navController) }
        composable(Destination.Yuri.route) { Yuri(navController) }
        composable(Destination.Natsuki.route) { Natsuki(navController) }
        composable(Destination.Monika.route) { Monika(navController) }
        composable(Destination.Other.route) { Other(navController) }

    }
}


