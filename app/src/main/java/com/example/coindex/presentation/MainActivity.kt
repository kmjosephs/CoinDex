package com.example.coindex.presentation

import androidx.activity.ComponentActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coindex.presentation.coin_info.CoinInfoScreen
import com.example.coindex.presentation.coin_list.CoinListScreen
import com.example.coindex.presentation.ui.theme.CoinDexTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoinDexTheme {
                Surface(color = MaterialTheme.colors.background) {
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = Screen.CoinListScreen.route
                    ) {
                        composable(
                            route = Screen.CoinListScreen.route
                        ) {
                            CoinListScreen(navController)
                        }
                        composable(
                            route = Screen.CoinInfoScreen.route + "/{coinId}"
                        ) {
                            CoinInfoScreen()
                        }
                    }
                }
            }
        }
    }
}